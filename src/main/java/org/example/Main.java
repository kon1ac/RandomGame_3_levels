package org.example;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\nВЫБЕРИ УРОВЕНЬ СЛОЖНОСТИ");
            System.out.println("1 - Легкий");
            System.out.println("2 - Средний");
            System.out.println("3 - Сложный");
            System.out.println("0 - Выход");
            System.out.print("Твой выбор: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    EasyLevel.playGame();
                    break;
                case 2:
                    MediumLevel.playGame();
                    break;
                case 3:
                    HardLevel.playGame();
                    break;
                case 0:
                    System.out.println("Спасибо за игру! До свидания!");
                    break;
                default:
                    System.out.println("Неверный выбор! Попробуй снова.");
            }

        } while (choice != 0);
    }
}