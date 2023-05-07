package com.thread;

public class Multi extends Thread{
	
	public Multi(String name){
		super(name);
	}
	
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.getName());
	}

}
