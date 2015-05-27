package putsoft.com.lock;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import putsoft.com.server.UserClient;

public class DistributeLock implements Runnable{
	
	public static String root="/group";
	
	public static final String ZK_LIST="172.17.0.1:2181,172.17.0.2:2181,172.17.0.3:2181,172.17.0.4:2181,172.17.0.5:2181";
	
	public static ZooKeeper zookeeper;
	
	private String currentZnode;
	
	private String clientName;
	
	
	public static boolean flag=true;
	
   private String path;
   

   public static Lock lock=new ReentrantLock();
	
	 public DistributeLock(String name) throws Exception{
		 
		 this.clientName=name;
		 
		 zookeeper=new ZooKeeper(UserClient.ZK_LIST, 5000,new Watcher(){
				public void process(WatchedEvent event) {
					
					if(Event.KeeperState.SyncConnected==event.getState()){
						
						if(event.getType()==Watcher.Event.EventType.None){
							
							System.out.println(" zookeeper server is connected!");
							
						}else if(event.getType()==Watcher.Event.EventType.NodeChildrenChanged){
							System.out.println(" node changed!");
							flag=false;
						}
					}
				}
		   });
	 }
	 
	 public String getClientName(){
		 return this.clientName;
	 }
	 
	 public void getLock() throws Exception{
		 
		if(path==null){
		  currentZnode=getClientName();
		  path=zookeeper.create(root+"/"+currentZnode, currentZnode.getBytes(),Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
		  clientName=path;
		}
		
		List<String> listnodes=zookeeper.getChildren(root, true);
		
		//print(listnodes);
		
		Collections.sort(listnodes);

		 if(path.equals(root+"/"+listnodes.get(0))){ 
	            System.out.println(this.getClientName()+" get lock  success! do something for 3s ...");
	            Thread.sleep(3000);
	            releaseLock();
	        } 
		 else{ 
				  waitLock(listnodes.get(0)); 
		   } 
		 
	 }
	 
	 public void waitLock(String lower) throws Exception {
	        Stat stat = zookeeper.exists(root + "/" + lower,true); 
	        if(stat != null){ 
	        	         flag=true;
	        				System.out.println(this.getClientName()+" thread wait for lock");
	        	           while(flag){
				        	   Thread.sleep(100);
	        	           		}
	        	       	System.out.println(this.getClientName()+" notify");
					}
		         this.getLock(); 
	    }
	
	 public void releaseLock() throws Exception{
         zookeeper.delete(path, -1);
         path=null;
 		System.out.println(getClientName()+" end ");
	 }
	 
	 
/*	 public void print(List<String> list){
		 System.out.println();
			 System.out.print(this.getClientName()+"： ");

			 for(String str:list){
				 System.out.print(str+",");
			 }
		 System.out.println();
	 }*/
	
	public static void main(String[] args) throws Exception{
		
		String c1="client-";
		String c2="client-";
		String c3="client-";
		
		Thread t1=new Thread(new DistributeLock(c1));
		Thread t2=new Thread(new DistributeLock(c2));
		Thread t3=new Thread(new DistributeLock(c3));
		
		t3.start();
		t1.start();
		t2.start();


	}

	public void run() {
		try {
			 this.getLock();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
