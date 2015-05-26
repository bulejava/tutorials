package putsoft.com.server;

import java.util.Calendar;

import java.util.Random;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;


public class UserServer {

	public static String root="/group";
	
	public static final String ZK_LIST="172.17.0.1:2181,172.17.0.2:2181,172.17.0.3:2181,172.17.0.4:2181,172.17.0.5:2181";
	
	private ZooKeeper zkeeper;
	
	public UserServer(){
		
		String address=UserServer.gethost();
		
		try{
		   zkeeper=new ZooKeeper(UserServer.ZK_LIST, 2000, new Watcher() {
			public void process(WatchedEvent event) {

			}
		});
		   zkeeper.create(root+"/"+address,address.getBytes("utf-8"), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static String gethost(){
		
		Calendar calendar=Calendar.getInstance();
		
		return "10.172."+calendar.get(Calendar.SECOND)+"."+new Random().nextInt(255);
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		 new UserServer();
		Thread.sleep(Long.MAX_VALUE);

	}

}
