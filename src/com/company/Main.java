package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    static void task1() {
        System.out.println("Задание 1.");
        int n = 3;
        int[] mas = new int[20];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = new Random().nextInt(20) + 1;
        }

        printMas(mas);

        int maxJ = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = i + 1; j < mas.length; j++) {
                if (mas[maxJ] <= mas[j]) {
                    maxJ = j;
                }
            }
            if (maxJ != i) {
                mas[i] += mas[maxJ];
                mas[maxJ] = mas[i] - mas[maxJ];
                mas[i] -= mas[maxJ];
            }
            if (i > 0) {
                if (mas[i] < mas[i - 1]) {
                    n--;
                }
            }
            maxJ = i + 1;
            if (n == 1) break;
        }

        if (n == 1) {
            System.out.println("Третье по величине число: " + mas[maxJ - 1] + "\n");
        }
        else System.out.println("Нет третьего по величине числа!\n");
    }
    static void printMas(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.println();
    }

    static void task2() {
        System.out.println("Задание 2.");
        int a = new Random().nextInt(100) + 1;
        int b = new Random().nextInt(100) + 1;

        System.out.println("Было:\na = " + a);
        System.out.println("b = " + b + "\n");

        a += b;
        b = a - b;
        a -= b;

        System.out.println("Стало:\na = " + a);
        System.out.println("b = " + b + "\n");
    }

    static void task3() {
        System.out.println("Задание 3.");
        String str = "Тестовая строка";
        char[] ch = str.toCharArray();
        boolean b = true;

        System.out.println("Дана строка: " + str);

        int minJ = 0;
        for (int i = 0; i < ch.length; i++) {
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[minJ] >= ch[j]) {
                    minJ = j;
                }
            }
            if (minJ != i) {
                ch[i] += ch[minJ];
                ch[minJ] = (char)(ch[i] - ch[minJ]);
                ch[i] -= ch[minJ];
            }
            minJ = i + 1;
        }
        System.out.print("Повторяющиеся символы: ");
        for (int i = 0; i < ch.length - 1; i++) {
            if (ch[i] == ch[i + 1]) {
                if (b == true) {
                    System.out.print(ch[i] + " ");
                    b = false;
                }
            }
            else {
                if (i == ch.length - 2) b = false;
                else b = true;

            }
        }
        if (b == true) System.out.print("нет повторяющихся символов!");
    }
}