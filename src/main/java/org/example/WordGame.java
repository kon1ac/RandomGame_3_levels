package org.example;

import java.util.Random;
import java.util.Scanner;

public class WordGame {
    private static String[] wordsArr;
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    private static String secretWord;
    private static int repeatGame;

    static {
        initializeWordsArray();
    }

    private static void initializeWordsArray() {
        wordsArr = new String[]{
                "apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
                "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"
        };
    }

    public static void playGame() {
        do {
            playSingleGame();
            System.out.print("\nПовторить игру еще раз? 1 – да / 0 – нет: ");
            repeatGame = scanner.nextInt();
        } while (repeatGame == 1);
    }

    private static void playSingleGame() {
        int randomIndex = random.nextInt(wordsArr.length);
        secretWord = wordsArr[randomIndex];
        System.out.println("\n=== ИГРА 'УГАДАЙ СЛОВО' ===");
        System.out.println("Загадано слово. Угадывай.");

        boolean isGuessed = false;

        do {
            System.out.print("Введи слово: ");
            String userWord = scanner.next().toLowerCase();

            if (userWord.equals(secretWord)) {
                System.out.println("Ты угадал слово: " + secretWord);
                isGuessed = true;
            } else {
                String mask = "";

                int minLength = Math.min(secretWord.length(), userWord.length());

                for (int i = 0; i < minLength; i++) {
                    char secretChar = secretWord.charAt(i);
                    char userChar = userWord.charAt(i);

                    if (secretChar == userChar) {
                        mask = mask + secretChar;
                    } else {
                        mask = mask + "#";
                    }
                }

                for (int i = mask.length(); i < 15; i++) {
                    mask = mask + "#";
                }

                System.out.println("Подсказка: " + mask);
            }
        } while (!isGuessed);
    }
}