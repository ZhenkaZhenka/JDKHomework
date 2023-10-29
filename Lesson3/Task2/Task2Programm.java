package Lesson3.Task2;

public class Task2Programm<T>{
    public static void main(String[] args) {
        String[] ar1 = {"65", "gfdg", "5345gg"};
        Integer[] ar2 = {34,54,234};
        System.out.println(compareArrays(ar1, ar2));
        Integer[] ar3 = {34,54,234};
        Integer[] ar4 = {34,54,234};
        System.out.println(compareArrays(ar3, ar4));
    }

    private static boolean compareArrays(Object[] ar1, Object[] ar2) {
        if (checkLengthOfArrays(ar1, ar2) && checkTypesOfArrays(ar1, ar2)) {
            for (int i = 0; i < ar1.length; i++) {
                if (!ar1[i].equals(ar2[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static boolean checkLengthOfArrays(Object[] ar1, Object[] ar2) {
        return ar1.length == ar2.length;
    }

    private static boolean checkTypesOfArrays(Object[] ar1, Object[] ar2) {
        return ar1[0].getClass().equals(ar2[0].getClass());
    }
}
