package Lesson3.Task1;

import java.text.DecimalFormat;

public class Calculator<T extends Number>{
    public static <T extends Number> Number sum(T num1, T num2){
        if(num1 instanceof Integer){
            if(num2 instanceof Integer) {
                return sum((int)num1, (int)num2);
            }
            else{
                return sum((int)num1, (double)num2);
            }
        }
        else {
            if(num2 instanceof Integer){
                return sum((double)num1, (int)num2);
            }
            else {
                return sum((double)num1, (double)num2);
            }
        }
    }
    private static int sum(int num1, int num2){
        return num1 + num2;
    }
    private static double sum(double num1, double num2){
        return num1 + num2;
    }
    private static double sum(double num1, int num2){
        return num1 + num2;
    }
    private static double sum(int num1, double num2){
        return num1 + num2;
    }

    public static <T extends Number>  Number subtract(T num1, T num2){
        if(num1 instanceof Integer){
            if(num2 instanceof Integer) {
                return subtract((int)num1, (int)num2);
            }
            else{
                return subtract((int)num1, (double)num2);
            }
        }
        else {
            if(num2 instanceof Integer){
                return subtract((double)num1, (int)num2);
            }
            else {
                return subtract((double)num1, (double)num2);
            }
        }
    }
    private static int subtract(int num1, int num2){
        return num1 - num2;
    }
    private static double subtract(double num1, double num2){
        return num1 - num2;
    }
    private static double subtract(double num1, int num2){
        return num1 - num2;
    }
    private static double subtract(int num1, double num2){
        return num1 - num2;
    }
    public static <T extends Number>  Number multiply(T num1, T num2){
        if(num1 instanceof Integer){
            if(num2 instanceof Integer) {
                return multiply((int)num1, (int)num2);
            }
            else{
                return multiply((int)num1, (double)num2);
            }
        }
        else {
            if(num2 instanceof Integer){
                return multiply((double)num1, (int)num2);
            }
            else {
                return multiply((double)num1, (double)num2);
            }
        }
    }
    private static int multiply(int num1, int num2){
        return num1 * num2;
    }
    private static double multiply(double num1, double num2){
        return num1 * num2;
    }
    private static double multiply(double num1, int num2){
        return num1 * num2;
    }
    private static double multiply(int num1, double num2){
        return num1 * num2;
    }
    public static <T extends Number>  Number divide(T num1, T num2){
        if(num1 instanceof Integer){
            if(num2 instanceof Integer) {
                return divide((int)num1, (int)num2);
            }
            else{
                return divide((int)num1, (double)num2);
            }
        }
        else {
            if(num2 instanceof Integer){
                return divide((double)num1, (int)num2);
            }
            else {
                return divide((double)num1, (double)num2);
            }
        }
    }
    private static double divide(int num1, int num2){
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        String result = decimalFormat.format((double)num1 / (double)num2);
        return Double.valueOf(result.replace(',', '.'));
    }
    private static double divide(double num1, double num2){
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        String result = decimalFormat.format(num1 / num2);
        return Double.valueOf(result.replace(',', '.'));
    }
    private static double divide(double num1, int num2){
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        String result = decimalFormat.format(num1 / num2);
        return Double.valueOf(result.replace(',', '.'));
    }
    private static double divide(int num1, double num2){
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        String result = decimalFormat.format((double)num1 / num2);
        return Double.valueOf(result.replace(',', '.'));
    }
}
