package org.example;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

//        int countCpu = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(10);

        for(int i = 0; i<10;i++){
            service.execute(new Task());
        }

//        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }
    static class Task implements Runnable {
        public void run(){
            System.out.println("Thread Name: " + Thread.currentThread().getName());
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}
