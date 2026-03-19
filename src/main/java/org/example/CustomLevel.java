package org.example;

import java.util.Random;
import java.util.Scanner;

public class CustomLevel {
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    private static int repeatGame;

    public static void playGame() {
        // Запрашиваем настройки у пользователя
        System.out.println("\nПОЛЬЗОВАТЕЛЬСКИЙ УРОВЕНЬ");

        System.out.print("Введи максимальное число (например, 50): ");
        int maxRange = scanner.nextInt();

        System.out.print("Сколько попыток дать? ");
        int maxAttempts = scanner.nextInt();

        System.out.println("Загадано число от 0 до " + maxRange);
        System.out.println("Попыток: " + maxAttempts);

        do {
            int secretNumber = random.nextInt(maxRange + 1);

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.print("Попытка " + attempt + ". Твой вариант: ");
                int userNumber = scanner.nextInt();

                if (userNumber == secretNumber) {
                    System.out.println("Ты угадал число " + secretNumber + "!");
                    break;
                } else if (userNumber < secretNumber) {
                    System.out.println("Загаданное число больше");
                } else {
                    System.out.println("Загаданное число меньше");
                }

                if (attempt == maxAttempts) {
                    System.out.println("Ты не угадал. Было загадано " + secretNumber);
                }
            }

            System.out.print("\nЕще раз? 1 – да / 0 – нет: ");
            repeatGame = scanner.nextInt();

        } while (repeatGame == 1);
    }
}