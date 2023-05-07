package com.main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static int id = 1;
    public static void main(String[] args) throws IOException {
        Main.generateCsvFile();
    }
    public static void generateCsvFile() throws IOException {
        FileWriter csvWriter = new FileWriter("/home/shiv/transaction/transaction.csv");
        TimerTask StopApp = new TimerTask() {
            @Override
            public void run() {
                System.exit(0);
            }
        };
        new Timer().schedule(StopApp, new Date(System.currentTimeMillis() + 20000));
        int i = 10;
        while (i > 0) {
            csvWriter.append(String.valueOf(Main.id));
            csvWriter.append(",");
            csvWriter.append("Dyann Patel");
            csvWriter.append(",");
            csvWriter.append("91443.95");
            csvWriter.append(",");
            csvWriter.append("C");
            csvWriter.append(",");
            csvWriter.append("Saving");
            csvWriter.append("\n");
            Main.id++;
        }

        csvWriter.flush();
        csvWriter.close();
    }
}