package com.main;

import com.base.Model;
import com.models.Employee;
import com.models.EmployeeCategory;

import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {
        String name = "Jigar";
        float salary = 5000.00F;
        char type = 'S';
        EmployeeCategory category = EmployeeCategory.SAVING;
        Employee emp = new Employee(category, name, salary, type);
        Model mod = new Model("jdbc:mysql://localhost:3306", "test_java",
                "root", "Password123#@!");
        String query = String.format(
                "INSERT INTO employee (description, amount, type) " +
                        "VALUES ('%s', %f, '%c')",name, salary, type);
        System.out.println(query);
        mod.create(query);
        ArrayList arr = mod.read("SELECT id,description,amount,type FROM employee");
        System.out.println(arr);

        int result = mod.write("UPDATE employee set description = 'Tushar' where id = 100");
        System.out.println("Write" + result);

        int res = mod.unlink("DELETE FROM employee WHERE id = 2");
        System.out.println("Delete " + res);
    }
}
