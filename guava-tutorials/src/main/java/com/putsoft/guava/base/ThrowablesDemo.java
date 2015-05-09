package com.putsoft.guava.base;

import java.io.IOException;
import java.sql.SQLException;

import com.google.common.base.Throwables;

public class ThrowablesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			new ThrowablesDemo().test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void handle(MyException e){
		
		System.out.println(e.getMessage());
		
	}
	
	public void test() throws Exception{
		
		 try {
		      System.out.println("eee");
		      throw new MyException("自身异常");
		   } catch (MyException e) {
		     handle(e);
		   } catch (Throwable t) {
		    
			   //如果是此异常，即抛出
			   Throwables.propagateIfInstanceOf(t, IOException.class);
		     Throwables.propagateIfInstanceOf(t, SQLException.class);
		     
		     //获取异常链
		     //Throwables.getCausalChain(throwable);
		     
		     //获取最出的异常
		     //Throwables.getRootCause(throwable);
		     
		     //返回堆栈的字符串格式
		    // Throwables.getStackTraceAsString();
		     
		     //抛出运行时异常
		     throw Throwables.propagate(t);
		   }
		
	}

}

class MyException extends Exception{
	
	private String message;
	
	public MyException(String _message){
		message=_message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
	
	
	
	
	
	
}
