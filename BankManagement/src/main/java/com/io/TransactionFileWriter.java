package com.io;

import com.base.Model;

public class TransactionFileWriter extends Model {
    private String fileName;
    private String filePath;

    public  String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public TransactionFileWriter(String filePath, String fileName){
        this.filePath = filePath;
        this.fileName = fileName;
    }
}
