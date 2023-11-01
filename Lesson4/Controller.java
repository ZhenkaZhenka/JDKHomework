package Lesson4;

import Lesson4.Model.Employee;
import Lesson4.Model.Getters;
import Lesson4.Model.ListOfEmployees;

import java.util.Scanner;

public class Controller {
    public static void start(ListOfEmployees l){
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("Здравствуйте!\n" +
                    "1. Найти имя сотрудника по id\n" +
                    "2. Найти сотрудников с определенным стажем работы\n" +
                    "3. Посмотреть номер сотрудника\n" +
                    "4. Добавить сотрудника\n" +
                    "5. Посмотреть весь список работников\n" +
                    "6. Закончить работу");
            int choise = Getters.getInteger("Выберите один из вариантов:");
            switch(choise){
                case 1:
                    ListViewer.findName(l);
                    break;
                case 2:
                    ListViewer.findEmployeeByPeriodOfWork(l);
                    break;
                case 3:
                    ListViewer.findPhoneNumberOfEmployee(l);
                    break;
                case 4:
                    l.addEmployee(new Employee());
                case 5:
                    l.print();
                    break;
                default:
                    System.out.println("Всего наилучшего!");
                    s.close();
                    return;
            }
        }
    }
}
