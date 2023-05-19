package com.thread;

import com.io.TransactionFileWriter;
import com.models.Employee;

import java.util.concurrent.BlockingQueue;

public class TransactionWriterThread implements Runnable{

    protected BlockingQueue<Employee> blockingQueue = null;

    public TransactionWriterThread(BlockingQueue<Employee> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    private void writeCreditTransaction(Employee employee) {
        TransactionFileWriter creditTran = new TransactionFileWriter("/home/vishal/", "credit.csv");
        String[] record = employee.getEmployeeDetails();
        creditTran.createInFile(creditTran.getFilePath(), creditTran.getFileName(), record);
    }

    private void writeDebitTransaction(Employee employee) {
        TransactionFileWriter debitTran = new TransactionFileWriter("/home/vishal/", "debit.csv");
        String[] record = employee.getEmployeeDetails();
        debitTran.createInFile(debitTran.getFilePath(), debitTran.getFileName(), record);
    }

    private void writeErrorTransaction(Employee employee) {
        TransactionFileWriter errorTran = new TransactionFileWriter("/home/vishal/", "error.csv");
        String[] record = employee.getEmployeeDetails();
        errorTran.createInFile(errorTran.getFilePath(), errorTran.getFileName(), record);
    }

    private void doSperateTransaction(Employee employee) {
        if (Character.compare(employee.getType(), 'D') == 0) {
            this.writeDebitTransaction(employee);
        } else if (Character.compare(employee.getType(), 'C') == 0) {
            this.writeCreditTransaction(employee);
        } else {
            this.writeErrorTransaction(employee);
        }
    }
    @Override
    public void run() {
        synchronized(blockingQueue) {
            while (true) {
                try {
                    Employee emp = this.blockingQueue.take();
                    System.out.println("Write Queue" + this.blockingQueue);
                    this.doSperateTransaction(emp);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
