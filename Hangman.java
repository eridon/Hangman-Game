import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = { "hello", "world", "java", "python" };
        String word = words[(int) (Math.random() * words.length)];
        StringBuilder display = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            display.append("_");
        }
        int lives = 6;
        int tries = 0;
        String guess;

        System.out.println("Welcome to Hangman!");
        System.out.println("You have 6 lives to guess the word.");
        System.out.println("The word is: " + display);

        while (lives > 0 && display.indexOf("_") != -1) {
            System.out.print("Enter your guess: ");
            guess = sc.nextLine();

            if (word.indexOf(guess) != -1) {
                System.out.println("Correct!");
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess.charAt(0)) {
                        display.setCharAt(i, guess.charAt(0));
                    }
                }
            } else {
                System.out.println("Incorrect!");
                lives--;
                tries++;
            }

            System.out.println("The word is: " + display);
            System.out.println("You have " + lives + " lives left.");

            if (tries == 4) {
                System.out.println("Here's a hint: the word is related to programming.");
            }
        }

        if (display.indexOf("_") == -1) {
            System.out.println("You won! The word was " + word + ".");
        } else {
            System.out.println("You lost! The word was " + word + ".");
        }
    }
}
