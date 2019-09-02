package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        printMassivProstyh(1000);
        System.out.println();
        long [] timeFound = timeFoundProstyhChisel(10000, 1000);
        System.out.println("Массив с временем нахождения простых чисел");
        for (int i = 0; i < timeFound.length; i ++) {
            System.out.print(timeFound[i] + " ");
        }

        int n = 10_000;
        int step = 1000;
        PrintStream printer = new PrintStream(new File("timings.csv"));
        printer.println("число" + ";" + "время");
        for (int i = 0; i < timeFound.length; i ++) {
            Time time = new Time(( i * step) + 2, timeFound[i]);
            writeLine(time, printer);
        }
        printer.println();
    }
    public static void writeLine (Time time, PrintStream printer) {
        printer.println(time.chislo + ";" + time.time);
    }
    public static long[] timeFoundProstyhChisel (int chislo, int step) {
        int count = 0;
        long[] massivTime = new long[chislo];
        for (int i = 0; i < massivTime.length; i++) {
            massivTime[i] = -1;
        }
        for (int i = 0; i < chislo; i += step) {
            long timeStart = System.currentTimeMillis();
            massivProstyh(i);
            long timeFinish = System.currentTimeMillis();
//            System.out.println("Время работы программы " + (timeFinish - timeStart));
            massivTime[i] = timeFinish - timeStart;
            count = count + 1;
        }
        long[] newMassiveTime = new long[count];
        int b = 0;
        for (int i = 0; i < chislo; i++) {
            if (massivTime[i] != -1) {
                newMassiveTime[b] = massivTime[i];
                b = b + 1;
            }
        }
        return newMassiveTime;
    }

        public static void printMassivProstyh(int chislo) {
        int [] a = massivProstyh(chislo);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static int[] massivProstyh (int n) {
        int massivProstyh[] = new int[n];
        for (int i = 2; i < n; i++) {
            massivProstyh[i] = i;
        }
        for (int b = 2; b < n; b++) {
                for (int a = b * b; a < n; a += b) {
                    massivProstyh[a] = 0;
                }
        }
        int count = 0;
        for (int b = 2; b < n; b++) {
            if (massivProstyh[b] > 0) {
                count = count + 1;
            }
        }
//        System.out.println("Количество простых чисел от 1 до " + n + " равно " + count);
        int[] massivProstyhChisel = new int[count];
        int b = 0;
        for (int i = 0; i < n; i++) {
           if (massivProstyh[i] > 0) {
               massivProstyhChisel[b] = massivProstyh[i];
               b = b + 1;
           }
        }
        return massivProstyhChisel;
    }
}
