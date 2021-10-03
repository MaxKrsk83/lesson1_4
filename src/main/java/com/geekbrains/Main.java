package com.geekbrains;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 2, 1};
        boolean value = homework(array);
        System.out.println(value);
    }

    public static boolean homework(int[] array) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < array.length; i++) {
            right += array[i];
        }

        for (int i = 0; i < array.length; i++) {
            if (left == right) {
                return true;
            }

            left += array[i];
            right -= array[i];
        }

        return false;
    }
}
