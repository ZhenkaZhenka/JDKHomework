package Lesson4.Model;

import java.util.ArrayList;

public class ListOfEmployees implements Readable, Editable{
    private ArrayList<Employee> list = new ArrayList<Employee>();

    public ArrayList<Employee> getList() {
        return list;
    }

    @Override
    public void print() {
        for (Employee e: list) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void addEmployee(Employee e) {
        list.add(e);
    }
}
