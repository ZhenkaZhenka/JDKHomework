package Lesson4;

import Lesson4.Controller;
import Lesson4.Model.Employee;
import Lesson4.Model.ListOfEmployees;

public class Programm {
    public static void main(String[] args) {
        ListOfEmployees list = new ListOfEmployees();
        list.addEmployee(new Employee(43, "Anton", "Gorbachev", "+7985512454", 88));
        list.addEmployee(new Employee(34, "Valeriya", "Grechkina", "+1524555888", 33));
        list.addEmployee(new Employee(23, "Evlampiya", "Romanova", "+49595959595", 2));
        list.addEmployee(new Employee(25, "Grigorii", "Ogurcov", "+858745124565", 65));
        list.addEmployee(new Employee(1, "Svetlana", "Klubnikova", "+7985512454", 23));
        Controller.start(list);
    }
}
