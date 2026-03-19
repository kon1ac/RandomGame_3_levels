package org.example;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            printMenu();
            choice = scanner.nextInt();
            handleChoice(choice);

        } while (choice != 0);

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nГЛАВНОЕ МЕНЮ");
        System.out.println("1 - Игра 'Угадай число' (легкий уровень)");
        System.out.println("2 - Игра 'Угадай число' (средний уровень)");
        System.out.println("3 - Игра 'Угадай число' (сложный уровень)");
        System.out.println("4 - Игра 'Угадай число' (пользовательский уровень)");
        System.out.println("5 - Игра 'Угадай слово'");
        System.out.println("0 - Выход");
        System.out.print("Твой выбор: ");
    }

    private static void handleChoice(int choice) {
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
            case 4:
                CustomLevel.playGame();
                break;
            case 5:
                WordGame.playGame();
                break;
            case 0:
                System.out.println("Спасибо за игру! До свидания!");
                break;
            default:
                System.out.println("Неверный выбор! Попробуй снова.");
        }
    }
}