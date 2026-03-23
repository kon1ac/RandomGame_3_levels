package org.example;

import java.util.Random;
import java.util.Scanner;

public class CustomLevel {
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void playGame() {
        System.out.println("\nПОЛЬЗОВАТЕЛЬСКИЙ УРОВЕНЬ");

        int maxRange = askMaxRange();
        int maxAttempts = askAttempts();

        printGameSettings(maxRange, maxAttempts);

        int repeatGame;
        do {
            playOneRound(maxRange, maxAttempts);
            System.out.print("\nЕще раз? 1 – да / 0 – нет: ");
            repeatGame = scanner.nextInt();
        } while (repeatGame == 1);
    }

    private static int askMaxRange() {
        System.out.print("Введи максимальное число (например, 50): ");
        return scanner.nextInt();
    }

    private static int askAttempts() {
        System.out.print("Сколько попыток дать? ");
        return scanner.nextInt();
    }

    private static void printGameSettings(int maxRange, int maxAttempts) {
        System.out.println("Загадано число от 0 до " + maxRange);
        System.out.println("Попыток: " + maxAttempts);
    }

    private static void playOneRound(int maxRange, int maxAttempts) {
        int secretNumber = random.nextInt(maxRange + 1);

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            int userNumber = askUserNumber(attempt);

            if (isGuessCorrect(userNumber, secretNumber)) {
                System.out.println("Ты угадал число " + secretNumber + "!");
                return;
            }

            giveHint(userNumber, secretNumber);

            if (isLastAttempt(attempt, maxAttempts)) {
                System.out.println("Ты не угадал. Было загадано " + secretNumber);
            }
        }
    }

    private static int askUserNumber(int attempt) {
        System.out.print("Попытка " + attempt + ". Твой вариант: ");
        return scanner.nextInt();
    }

    private static boolean isGuessCorrect(int userNumber, int secretNumber) {
        return userNumber == secretNumber;
    }

    private static void giveHint(int userNumber, int secretNumber) {
        if (userNumber < secretNumber) {
            System.out.println("Загаданное число больше");
        } else {
            System.out.println("Загаданное число меньше");
        }
    }

    private static boolean isLastAttempt(int attempt, int maxAttempts) {
        return attempt == maxAttempts;
    }
}