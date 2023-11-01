package Lesson4.Model;

import java.util.ArrayList;

public class Employee {
    private int id;
    private ArrayList<String> phoneNumber = new ArrayList<>();
    private String name;
    private String lastName;
    private int periodOfWorkInMonth;

    public Employee(){
        id = Getters.getInteger("Введите id нового работника");
        name = Getters.getString("Введите имя нового сотрудника");
        lastName = Getters.getString("Введите фамилию нового сотрудника");
        phoneNumber = new ArrayList<>();
        phoneNumber.add(Getters.getString("Введите номер телефона сотрудника"));
        periodOfWorkInMonth = 0;
    }

    public Employee(int id,String name, String lastName, String phoneNumber, int periodOfWorkInMonth) {
        this.id = id;
        this.phoneNumber.add(phoneNumber);
        this.name = name;
        this.lastName = lastName;
        this.periodOfWorkInMonth = periodOfWorkInMonth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return printPhoneNumber();
    }
    public void addPhoneNumber(String number){
        phoneNumber.add(number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPeriodOfWorkInMonth() {
        return periodOfWorkInMonth;
    }

    public void setPeriodOfWorkInMonth(int periodOfWorkInMonth) {
        this.periodOfWorkInMonth = periodOfWorkInMonth;
    }

    @Override
    public String toString() {
        return "id=" + id + ": " + lastName + " " + name +
                ", phoneNumber:'" + printPhoneNumber() +
                ", periodOfWork:" + periodOfWorkInMonth / 12 + " years " + periodOfWorkInMonth % 12 + " months";
    }

    private String printPhoneNumber(){
        StringBuilder sb = new StringBuilder();
        for (String phone : phoneNumber) {
            sb.append(phone + ", ");
        }
        return sb.toString();
    }

}
