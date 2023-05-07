//package com.stream;
//import com.services.Bank;
//import lombok.Getter;
//
//import com.opencsv.CSVWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.Writer;
//
//public class AccountCSVWriter extends CSVWriter {
//    protected static String fileName = "bank-application.csv";
//    protected static String filePath = "/tmp/";
//    private @Getter Object fileOut = null;
//
//    AccountCSVWriter(Writer writer){
//        super(writer);
//        this.fileName = fileName;
//        this.path = path;
//    }
//    public void createFile(String path, String fileName) throws IOException {
//        String str  = String.format("%s%s", path, fileName);
//        if(this.fileOut == null){
//            this.fileOut = new CSVWriter(new FileWriter(str));
//        }
//    }
//
//    public void create(){
//        String str  = String.format("%s%s", this.filePath, this.fileName);
//        try{
//            CSVWriter writer = new CSVWriter(new FileWriter(str, true));
//            String[] record = String.format("%s,%s,%s,%s,%s", Bank.id,this.getAccountNumber(),
//                    this.getFirstName(), this.getMiddleName() ,this.getLastName()).split(",");
//            writer.writeNext(record, false);
//            writer.close();
//        }catch (IOException ex){
//            System.out.println("Exception " + ex);
//        }
//    }
//}
