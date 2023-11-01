package Lesson4;

import Lesson4.Model.Employee;
import Lesson4.Model.Getters;
import Lesson4.Model.ListOfEmployees;

import java.util.Scanner;

public class ListViewer {
    public static void findEmployeeByPeriodOfWork(ListOfEmployees l){
        boolean mark = false;
        int periodFrom = Getters.getInteger("Input min period of work in month");
        int periodTo = Getters.getInteger("Input max period of work in month");
        for (Employee em : l.getList()) {
            if(em.getPeriodOfWorkInMonth() >= periodFrom &&
                    em.getPeriodOfWorkInMonth() <= periodTo){
                mark = true;
                System.out.println(em.toString());
            }
        }
        if (!mark){
            System.out.println("Никого нет с таким стажем работы.");
        }
    }
    public static void findPhoneNumberOfEmployee(ListOfEmployees l){
        boolean mark = false;
        String name = Getters.getString("Input name of employee: ");
        String lastName = Getters.getString("Input last name of employee: ");
        for (Employee em : l.getList()) {
            if(name.equals(em.getName()) &&
                    lastName.equals(em.getLastName())){
                mark = true;
                System.out.println(em.getName() + " " + em.getLastName() + ": " + em.getPhoneNumber());
            }
        }
        if(!mark){
            System.out.println("Никого с таким именем нет в списке, возможно вы ошиблись");
        }
    }

    public static void findName(ListOfEmployees l){
        boolean mark = false;
        try{
            int id = Getters.getInteger("Input id of employee: ");
            for (Employee em : l.getList()) {
                if(id == em.getId()){
                    mark = true;
                    System.out.print(id + ": ");
                    System.out.println(em.getName() + " " + em.getLastName());
                }
            }
        }
        catch (Exception e){
            System.out.println("Вы ввели не корректный id");
        }
        if (!mark){
            System.out.println("Никого с таким id нет в списке");
        }
    }

}
