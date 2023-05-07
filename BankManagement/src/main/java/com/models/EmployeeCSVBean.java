package com.models;

import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeCSVBean {
    @CsvBindByPosition(position = 0)
    private String id;

    @CsvBindByPosition(position = 1)
    private String description;

    @CsvBindByPosition(position = 2)
    private String amount;

    @CsvBindByPosition(position = 3)
    private String type;

    @CsvBindByPosition(position = 4)
    private String category;

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public Object clone(EmployeeCSVBean emp)throws CloneNotSupportedException{
        return new Employee(emp);
    }
}
