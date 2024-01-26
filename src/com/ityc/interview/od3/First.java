package com.ityc.interview.od3;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        if (str.length() == 0) {
            System.out.println(0);
            return;
        }

        String[] split = str.split(",");
        int[] cars = new int[split.length];
        for(int i = 0; i < split.length; i++) {
            cars[i] = Integer.parseInt(split[i]);
        }

        int car = 0, carSize = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == 0) {
                // 计算
                car += minCar(carSize);
                carSize = 0;
            } else {
                carSize++;
            }
        }
        // 最后一次计算
        car += minCar(carSize);

        System.out.println(car);

    }

    public static int minCar(int carSize) {
        int result = 0;
        if (carSize >= 3) {
            result = carSize / 3;
            carSize %= 3;
        }

        if (carSize >= 2) {
            result += carSize / 2;
            carSize %= 2;
        }

        if (carSize == 1) {
            result++;
        }
        return result;
    }


}
