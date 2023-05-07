package com.thread;

public class TestSleepMethod1 extends Thread{
	 public TestSleepMethod1(String name) {
		 super(name);
		// TODO Auto-generated constructor stub
	}

	public void run(){
		 for(int i=1;i<11;i++){
			 
			 try {
				Thread.sleep(500, 100);    
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				e.printStackTrace();
			}
			System.out.println(i + this.getName());
		 }
	 }
}
