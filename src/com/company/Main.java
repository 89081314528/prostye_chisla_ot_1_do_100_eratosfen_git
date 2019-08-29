package com.company;

public class Main {

    public static void main(String[] args) {
        int n = 50000;
        int step = 10000;
        long[] timeWork = new long[n];
        for (int i = 1; i < n; i += step) {
            long timeStart = System.currentTimeMillis();
            massivProstyh(i);
            long timeFinish = System.currentTimeMillis();
            timeWork[i] = timeFinish - timeStart;
            System.out.println("Время работы программы " + timeWork[i]);
        }
        System.out.println("Массив с временем нахождения простых чисел от 1 до " + n + " с шагом " + step);
        for (int i = 1; i < n; i += step) {
            System.out.print(timeWork[i] + " ");
        }

    }
    public static void massivProstyh (int n) {
        int massivProstyh[] = new int[n];
        for (int i = 2; i < n; i++) {
            massivProstyh[i] = i;
//            System.out.print(i + " ");
        }
        for (int b = 2; b < n; b++) {
            if (massivProstyh[b] > 0) {
                for (int a = b * b; a < n; a += b) {
                    massivProstyh[a] = 0;
                }
            }
        }
        int count = 0;
        for (int b = 2; b < n; b++) {
            if (massivProstyh[b] > 0) {
                count = count + 1;
            }
//            System.out.print(massivProstyh[b] + " ");
        }
//        System.out.println();
        System.out.println("Количество простых чисел от 1 до " + n + " равно " + count);
        int[] massivProstyhChisel = new int[count];
        int b = 0;
        for (int i = 0; i < n; i++) {
           if (massivProstyh[i] > 0) {
               massivProstyhChisel[b] = massivProstyh[i];
               b = b + 1;
           }
        }
        for (int i = 0; i < count; i ++) {
            System.out.print(massivProstyhChisel[i] + " ");
        }
        System.out.println();
    }
}
