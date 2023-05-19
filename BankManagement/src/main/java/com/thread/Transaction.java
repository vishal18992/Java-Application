//package com.thread;
//
//import com.models.Employee;
//
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingQueue;
//
//public class Transaction {
//    private final BlockingQueue<Employee> queue = new ArrayBlockingQueue<Employee>(10);
//    private final int maxSize;
//    private final Object FULL_QUEUE = new Object();
//    private final Object EMPTY_QUEUE = new Object();
//    public boolean runFlag = true;
//
//    public boolean isEmpty(){
//        return this.queue.isEmpty();
//    }
//
//    public boolean isFull() {
//        Integer len = this.queue.size();
//        return len.equals(maxSize);
//    }
//    public Transaction(int maxSize) {
//        this.maxSize = maxSize;
//    }
//    public void waitOnFull() throws InterruptedException {
//        synchronized (FULL_QUEUE) {
//            FULL_QUEUE.wait();
//        }
//    }
//    public void notifyAllForFull() {
//        synchronized (FULL_QUEUE) {
//            FULL_QUEUE.notifyAll();
//        }
//    }
//
//    public void waitOnEmpty() throws InterruptedException {
//        synchronized (EMPTY_QUEUE) {
//            EMPTY_QUEUE.wait();
//        }
//    }
//
//    public void notifyAllForEmpty() {
//        synchronized (EMPTY_QUEUE) {
//            EMPTY_QUEUE.notify();
//        }
//    }
//
//    public void add(Employee employee) {
//        synchronized (queue) {
//            queue.add(employee);
//        }
//    }
//
//    public Employee remove() {
//        synchronized (queue) {
//            return queue.poll();
//        }
//    }
//}
