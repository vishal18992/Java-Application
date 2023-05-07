package com.main;

import com.thread.*;

public class ThreadDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Multi t1 = new Multi("SMS");
		Multi3 mobj = new Multi3();
		Thread t2 = new Thread(mobj, "Email");
//		t1.start();
//
////		t1.join(500);
////		Thread.sleep(500);
//
//		t2.start();

		TestSleepMethod1 t3 = new TestSleepMethod1("T4");
		TestSleepMethod1 t4 = new TestSleepMethod1("T5");
		TestSleepMethod1 t10 = new TestSleepMethod1("T5");
		t3.start();
		t3.join();
		t4.start();
		t10.start();

		TestThreadTwice1 t6 = new TestThreadTwice1();
//		t6.run();
//		t6.run();

	}

}
