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
        TransactionFileWriter creditTran = new TransactionFileWriter("/home/shiv/", "credit.csv");
        String[] record = employee.getEmployeeDetails();
        creditTran.create(creditTran.getFilePath(), creditTran.getFileName(), record);
    }

    private void writeDebitTransaction(Employee employee) {
        TransactionFileWriter debitTran = new TransactionFileWriter("/home/shiv/", "debit.csv");
        String[] record = employee.getEmployeeDetails();
        debitTran.create(debitTran.getFilePath(), debitTran.getFileName(), record);
    }

    private void writeErrorTransaction(Employee employee) {
        TransactionFileWriter errorTran = new TransactionFileWriter("/home/shiv/", "error.csv");
        String[] record = employee.getEmployeeDetails();
        errorTran.create(errorTran.getFilePath(), errorTran.getFileName(), record);
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
        while(true){
            try {
                Employee emp = this.blockingQueue.take();
                System.out.println("Write Queue" + this.blockingQueue);
                this.doSperateTransaction(emp);
                try{Thread.sleep(100);}catch(InterruptedException e){System.out.println(e);}
                if(this.blockingQueue.isEmpty()){
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
