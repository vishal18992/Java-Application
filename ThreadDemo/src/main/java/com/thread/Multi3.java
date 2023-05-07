package com.thread;

public class Multi3 implements Runnable{
	public void run(){  
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread Multi3 is running...");  
	}  
}
