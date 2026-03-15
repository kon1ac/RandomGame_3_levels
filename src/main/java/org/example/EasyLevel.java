package org.example;

import java.util.Random;
import java.util.Scanner;

public class EasyLevel {
    private static final int MAX_ATTEMPTS = 3;
    private static final int MAX_RANDOM = 10;
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void playGame() {
        int repeatChoice;

        System.out.println("\n=== ЛЕГКИЙ УРОВЕНЬ ===");

        System.out.println("У вас есть " + MAX_ATTEMPTS + " попытки");

        do {
            playSingleGame();

            System.out.print("\nПовторить игру еще раз? 1 – да / 0 – нет: ");
            repeatChoice = scanner.nextInt();

        } while (repeatChoice == 1);
    }

    private static void playSingleGame() {
        int secretNumber = random.nextInt(MAX_RANDOM);

        System.out.println("\nНовая игра");
        System.out.println("Загадано число от 0 до 9.");

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            System.out.print("Попытка " + attempt + ". Введи число: ");
            int userNumber = scanner.nextInt();

            if (userNumber == secretNumber) {
                System.out.println("Ты угадал число " + secretNumber);
                return;
            }

            provideHint(userNumber, secretNumber);
        }

        System.out.println("Ты не угадал. Было загадано число " + secretNumber);
    }

    private static void provideHint(int userNumber, int secretNumber) {
        if (userNumber < secretNumber) {
            System.out.println("Загаданное число больше");
        } else {
            System.out.println("Загаданное число меньше");
        }
    }
}