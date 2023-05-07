package com.base;

import com.main.Main;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public abstract class Model {
    public void create(String filePath, String fileName, String[] values){
        String str  = String.format("%s%s", filePath, fileName);
        try{
            CSVWriter writer = new CSVWriter(new FileWriter(str, true));
            writer.writeNext(values, false);
            writer.close();
        }catch (IOException ex){
            System.out.println("Exception " + ex);
        }
    }
}
