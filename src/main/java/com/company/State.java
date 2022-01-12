package com.company;

import java.util.Scanner;

public enum State {
    BASE,
    ROUTE,
    REPAIR;

    public static Car[] getStateOfCar(Car[] car) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение");
        int choose = scanner.nextInt();
        if (choose == 1) {
            for (Car value : car) {
                value.setState(BASE);
            }
        } else if (choose == 2) {
            for (Car value : car) {
                value.setState(ROUTE);
            }
        } else if(choose==3){
            for (Car value : car) {
                value.setState(REPAIR);
            }
        }else {
            System.out.println("Введите до 3!");
        }
        return car;
    }
}
