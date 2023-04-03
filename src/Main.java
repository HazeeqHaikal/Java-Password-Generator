import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        System.out.print("Do you want to check the strength of a password (1) or generate a password (2)?\nEnter your choice (1-2): ");
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.println("Welcome to password health checker!");
            System.out.print("Please enter the password you want to check: ");
            String password = input.next();
            int length = password.length();
            if (length < 8) {
                System.out.println("Your password is too short!");
            } else if (password.matches(".*[a-z].*") && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*()_+].*")) {
                System.out.println("Your password is strong!");
            } else if (password.matches(".*[a-z].*") && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*")) {
                System.out.println("Your password is medium!");
            } else if (password.matches(".*[a-z].*") && password.matches(".*[A-Z].*")) {
                System.out.println("Your password is weak!");
            } else {
                System.out.println("Your password is very weak!");
            }


        } else if (choice == 2) {

            System.out.println("Welcome to password generator!");
            System.out.print("Please enter the length of the password you want to generate: ");
            int length = input.nextInt();

            System.out.print("Do you want to include letters? (y/n): ");
            String letters = input.next();
            letters = letters.toLowerCase();

            System.out.print("Do you want to include numbers? (y/n): ");
            String numbers = input.next();
            numbers = numbers.toLowerCase();

            System.out.print("Do you want to include special characters? (y/n): ");
            String special = input.next();
            special = special.toLowerCase();

            StringBuilder password = new StringBuilder();
            String specialCharacters = "!@#$%^&*()_+";
            String numbersCharacters = "1234567890";
            String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            int character, number, letter;

            // generate password
            if (special.equals("y") && numbers.equals("y") && letters.equals("y")) {
                character = random.nextInt(length - 2) + 1;
                number = random.nextInt(length - character - 1) + 1;
                letter = length - character - number;
                for (int i = 0; i < character; i++) {
                    password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));
                }

                for (int i = 0; i < number; i++) {
                    password.append(numbersCharacters.charAt(random.nextInt(numbersCharacters.length())));
                }

                for (int i = 0; i < letter; i++) {
                    password.append(characters.charAt(random.nextInt(characters.length())));
                }
            } else if (special.equals("y") && numbers.equals("y") && letters.equals("n")) {
                character = random.nextInt(length - 1) + 1;
                number = length - character;
                for (int i = 0; i < character; i++) {
                    password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));
                }

                for (int i = 0; i < number; i++) {
                    password.append(numbersCharacters.charAt(random.nextInt(numbersCharacters.length())));
                }
            } else if (special.equals("y") && numbers.equals("n") && letters.equals("y")) {
                character = random.nextInt(length - 1) + 1;
                letter = length - character;
                for (int i = 0; i < character; i++) {
                    password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));
                }

                for (int i = 0; i < letter; i++) {
                    password.append(characters.charAt(random.nextInt(characters.length())));
                }
            } else if (special.equals("y") && numbers.equals("n") && letters.equals("n")) {
                for (int i = 0; i < length; i++) {
                    password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));
                }
            } else if (special.equals("n") && numbers.equals("y") && letters.equals("y")) {
                number = random.nextInt(length - 1) + 1;
                letter = length - number;
                for (int i = 0; i < number; i++) {
                    password.append(numbersCharacters.charAt(random.nextInt(numbersCharacters.length())));
                }

                for (int i = 0; i < letter; i++) {
                    password.append(characters.charAt(random.nextInt(characters.length())));
                }
            } else if (special.equals("n") && numbers.equals("y") && letters.equals("n")) {
                for (int i = 0; i < length; i++) {
                    password.append(numbersCharacters.charAt(random.nextInt(numbersCharacters.length())));
                }
            } else if (special.equals("n") && numbers.equals("n") && letters.equals("y")) {
                for (int i = 0; i < length; i++) {
                    password.append(characters.charAt(random.nextInt(characters.length())));
                }
            } else {
                System.out.println("You must select at least one option!");
                System.exit(0);
            }

            // shuffle password
            password = new StringBuilder(shuffleString(password.toString()));
            System.out.println("Your password is: " + password);
        }

    }

    public static String shuffleString(String inputString) {
        List<Character> characters = new ArrayList<>();
        for (char c : inputString.toCharArray()) {
            characters.add(c);
        }
        StringBuilder outputString = new StringBuilder(inputString.length());
        while (characters.size() != 0) {
            int randPicker = new SecureRandom().nextInt(characters.size());
            outputString.append(characters.remove(randPicker));
        }
        return outputString.toString();
    }
}