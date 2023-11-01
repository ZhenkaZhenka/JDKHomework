package Lesson4.Model;

import java.util.Scanner;

public class Getters {
    public static int getInteger(String message){
        boolean mark = true;
        System.out.println(message);
        Scanner in = new Scanner(System.in);
        while(mark) {
            try {
                int number = in.nextInt();
                return number;
            } catch(Exception e){
                System.out.println("Вы ввели не число, попробуйте еще");
                return getInteger(message);
            }
        }
        return 0;
    }
    public static String getString(String message){
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        String string = in.nextLine();
        return string;
    }
}
