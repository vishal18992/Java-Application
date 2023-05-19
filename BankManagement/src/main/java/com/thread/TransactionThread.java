package com.thread;

import com.io.TransactionFileWriter;
import com.models.Employee;
import com.models.EmployeeCSVBean;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class TransactionThread implements Runnable {
    private float numline=0;
    protected transient BufferedReader bufferedReader;
    protected transient FileReader fileReader;

    private BlockingQueue<Employee> blockingQueue;

    public TransactionThread(BlockingQueue<Employee> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            this.readTransactionCSV();
        } catch (Exception ex) {
            System.out.println("Read Transaction File Exception" + ex);
        }finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    private void readTransactionCSV() throws IOException, CloneNotSupportedException {
        File file = new File("/home/vishal/transaction/transaction.csv");
       fileReader = new FileReader(file);
       bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] columns = line.split(",");
            EmployeeCSVBean empBean = new EmployeeCSVBean(columns[0], columns[1], columns[2], columns[3], columns[4]);
            Employee employee = (Employee) empBean.clone(empBean);
            numline++;
            try {
                this.blockingQueue.put(employee);
            }catch (InterruptedException ex) {
                System.out.println("Blocking Queue Exception" + ex);
            }
            System.out.println("Read Counter " + numline);
        }
    }
}