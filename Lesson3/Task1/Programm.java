package Lesson3.Task1;

public class Programm {
    public static void main(String[] args) {
        System.out.println("Сложение: ");
        System.out.println("Результат сложения чисел 1 и 5.5 равен: " + Calculator.sum(1,5.5));
        System.out.println("Результат сложения чисел 1 и 5 равен: " + Calculator.sum(1,5));
        System.out.println("Результат сложения чисел 1.7 и 5.5 равен: " + Calculator.sum(1.7,5.5));
        System.out.println("Результат сложения чисел 1.8 и 5 равен: " + Calculator.sum(1.8,5));
        System.out.println("Вычитание: ");
        System.out.println("Разность чисел 1 и 5.5 равен: " + Calculator.subtract(1,5.5));
        System.out.println("Разность чисел 1 и 5 равен: " + Calculator.subtract(1,5));
        System.out.println("Разность чисел 1.7 и 5.5 равен: " + Calculator.subtract(1.7,5.5));
        System.out.println("Разность чисел 1.8 и 5 равен: " + Calculator.subtract(1.8,5));
        System.out.println("Умножение: ");
        System.out.println("Произведение чисел 1 и 5.5 равен: " + Calculator.multiply(1,5.5));
        System.out.println("Произведение чисел 1 и 5 равен: " + Calculator.multiply(1,5));
        System.out.println("Произведение чисел 1.7 и 5.5 равен: " + Calculator.multiply(1.7,5.5));
        System.out.println("Произведение чисел 1.8 и 5 равен: " + Calculator.multiply(1.8,5));
        System.out.println("Деление: ");
        System.out.println("Результат деления чисел 1 и 5.5 равен: " + Calculator.divide(1,5.5));
        System.out.println("Результат деления чисел 2 и 6 равен: " + Calculator.divide(2,6));
        System.out.println("Результат деления чисел 1.7 и 5.5 равен: " + Calculator.divide(1.7,5.5));
        System.out.println("Результат деления чисел 1.8 и 5 равен: " + Calculator.divide(1.8,5));

    }
}
