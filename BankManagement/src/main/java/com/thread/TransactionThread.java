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
        }
    }


    private void readTransactionCSV() throws IOException, CloneNotSupportedException {
        File file = new File("/home/shiv/transaction/transaction.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Integer counter = 0;
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] columns = line.split(",");
            EmployeeCSVBean empBean = new EmployeeCSVBean(columns[0], columns[1], columns[2], columns[3], columns[4]);
            Employee employee = (Employee) empBean.clone(empBean);
            System.out.println("Read Counter " + counter);
            try {
                this.blockingQueue.put(employee);
            }catch (InterruptedException ex) {
                System.out.println("Blocking Queue Exception" + ex);
            }
//            counter++;

//            if(counter.equals(2)){
//                try {
//                    Thread.sleep(1000);
//                }catch (InterruptedException ex) {
//                    System.out.println("Read Transaction" + ex);
//                }
//                counter = 0;
//            }
        }
    }
}