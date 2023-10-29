package Lesson3.Task3;

public class Pair<T extends Number>{
    private T firstNum;
    private T secondNum;

    public T getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(T firstNum) {
        this.firstNum = firstNum;
    }

    public T getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(T secondNum) {
        this.secondNum = secondNum;
    }

    @Override
    public String toString() {
        return "firstNum = " + firstNum +
                ", secondNum = " + secondNum;
    }
}
