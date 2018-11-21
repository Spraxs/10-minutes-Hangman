package nl.spraxs.hangman.game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public Game() {
        setup();

        start();
    }

    private ArrayList<String> guessed;

    private String word;

    private int lives;

    private void setup() {
        word = "";
        ArrayList<String> words = new ArrayList<>();
        words.add("pindakaas");
        guessed = new ArrayList<>();

        lives = 3;

        int i = new Random().nextInt(words.size());

        word = words.get(i);
    }

    private void start() {

        while (true) {

            System.out.println("Type een letter!");

            System.out.println("Word: " + getWord());

            Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            if (input.length() < 2 && input.length() > 0) {

                if (guessed.contains(input)) {
                    System.out.println("Al geraden");
                } else {
                    guessed.add(input);

                    if (word.contains(input)) {
                        System.out.println("Goed geraden!");
                    } else {
                        lives--;
                        System.out.println("Niet goed!");
                    }
                }

            } else {
                System.out.println("niet goede input");
            }

            if (lives == 0) {
                System.out.println("Je hebt verloren");

                break;
            }

            if (!getWord().contains("_")) {
                System.out.println("Je hebt gewonnen");
                break;
            }

        }

    }

    private String getWord() {
        StringBuilder returnWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            String letter = Character.toString(word.charAt(i));

            if (guessed.contains(letter)) {
                returnWord.append(letter);
            } else {
                returnWord.append("_");
            }
        }

        return returnWord.toString();
    }

}
