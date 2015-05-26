package putsoft.com.server;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class UserClient {
	
	
		public static String root="/group";
		
		public static final String ZK_LIST="172.17.0.1:2181,172.17.0.2:2181,172.17.0.3:2181,172.17.0.4:2181,172.17.0.5:2181";
		
		public static ZooKeeper zookeeper;
		
		public Watcher wacher=new NodeWatcher();
		
		private static Stat stat=new Stat();
		
		private static List<String> hostList=new ArrayList<String>();
		
		
		public   UserClient() throws IOException, KeeperException, InterruptedException{
			
			zookeeper=new ZooKeeper(UserClient.ZK_LIST, 5000,new Watcher(){
					public void process(WatchedEvent event) {
						
					}
			   });
			   
			zookeeper.getChildren(root,wacher);
		}
		
		
	public static void updateHostConfig(WatchedEvent event) throws Exception{
		
		hostList.clear();
		 
		 if(event.getType()==Watcher.Event.EventType.NodeChildrenChanged
				 &&event.getPath().equals(root)){
			 
			 List<String> nodes=zookeeper.getChildren(root,true);
			 
			 String value=null;
			 
			 for(String str:nodes){
				 
				 byte[] data = zookeeper.getData(root + "/" + str, false, stat);  
				 
				 value=new String(data,"utf-8");
				 
				 hostList.add(value);
			 }
             print(hostList);
		 }
	}
		
	
	public static void print(List<String> list){
			System.out.print("[");
			for(String str:list){
				System.out.print(str+",");
			}
			System.out.println("]");
	}
	

	public static void main(String[] args) throws Exception {
		new UserClient();
		Thread.sleep(Long.MAX_VALUE);
	}
	
	
	
	class NodeWatcher implements Watcher{

		public void process(WatchedEvent event) {
			 try {
				 UserClient.updateHostConfig(event);
				 zookeeper.getChildren(root,wacher);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
   }
	

}


