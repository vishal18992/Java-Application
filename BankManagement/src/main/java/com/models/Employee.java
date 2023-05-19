package com.models;
import com.base.Model;
import com.main.Main;
import com.models.EmployeeCategory;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class Employee extends Model implements Cloneable{
    private int id;
    private EmployeeCategory category;
    private String description;
    private float amount;
    private char type;

    Employee(int id, EmployeeCategory category, String description, float amount, char type){
        this.category = category;
        this.description = description;
        this.amount = amount;
        this.type = type;
    }

    public Employee(EmployeeCategory category, String description, float amount, char type){
        this.category = category;
        this.description = description;
        this.amount = amount;
        this.type = type;
        id++;
    }

    protected Employee(EmployeeCSVBean employee) {
        EmployeeCategory cat = null;
        this.id = Integer.parseInt(employee.getId());
        this.description = employee.getDescription();
        this.amount = Float.parseFloat(employee.getAmount());
        try{
            this.type = employee.getType().charAt(0);
        }catch (IndexOutOfBoundsException ex){
            this.type = '-';
        }

        if(employee.getCategory().equals("Current")){
            cat = EmployeeCategory.CURRENT;
        }else if(employee.getCategory().equals("Saving")){
            cat = EmployeeCategory.SAVING;
        }
        this.category = cat;
    }
    public  int getId() {
        return this.id;
    }

    public EmployeeCategory getCategory() {
        return category;
    }

    public void setCategory(EmployeeCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public String[] getEmployeeDetails() {
        String str = this.getId() + "," + this.getCategory() + ","
                + this.getDescription() + "," + this.getAmount() + "," + this.getType();
        String[] record =  str.split(",");
        return record;
    }

    public void printEmployeeDetails(){
        System.out.println("Id " + this.getId() + "   " + "Category " + this.getCategory() + "  "
                + "Description " + this.getDescription() + "  " + "Amount " + this.getAmount() + "  " + "Type " + this.getType());
    }
}
