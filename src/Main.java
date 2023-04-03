import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

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
        if(special.equals("y") && numbers.equals("y") && letters.equals("y")) {
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
        } else if(special.equals("y") && numbers.equals("y") && letters.equals("n")) {
            character = random.nextInt(length - 1) + 1;
            number = length - character;
            for (int i = 0; i < character; i++) {
                password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));
            }

            for (int i = 0; i < number; i++) {
                password.append(numbersCharacters.charAt(random.nextInt(numbersCharacters.length())));
            }
        } else if(special.equals("y") && numbers.equals("n") && letters.equals("y")) {
            character = random.nextInt(length - 1) + 1;
            letter = length - character;
            for (int i = 0; i < character; i++) {
                password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));
            }

            for (int i = 0; i < letter; i++) {
                password.append(characters.charAt(random.nextInt(characters.length())));
            }
        } else if(special.equals("y") && numbers.equals("n") && letters.equals("n")) {
            character = random.nextInt(length - 1) + 1;
            for (int i = 0; i < character; i++) {
                password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));
            }
        } else if(special.equals("n") && numbers.equals("y") && letters.equals("y")) {
            number = random.nextInt(length - 1) + 1;
            letter = length - number;
            for (int i = 0; i < number; i++) {
                password.append(numbersCharacters.charAt(random.nextInt(numbersCharacters.length())));
            }

            for (int i = 0; i < letter; i++) {
                password.append(characters.charAt(random.nextInt(characters.length())));
            }
        } else if(special.equals("n") && numbers.equals("y") && letters.equals("n")) {
            number = random.nextInt(length) + 1;
            for (int i = 0; i < number; i++) {
                password.append(numbersCharacters.charAt(random.nextInt(numbersCharacters.length())));
            }
        } else if(special.equals("n") && numbers.equals("n") && letters.equals("y")) {
            letter = random.nextInt(length) + 1;
            for (int i = 0; i < letter; i++) {
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
    public static String shuffleString(String inputString) {
        List<Character> characters = new ArrayList<>();
        for(char c : inputString.toCharArray()) {
            characters.add(c);
        }
        StringBuilder outputString = new StringBuilder(inputString.length());
        while(characters.size() != 0) {
            int randPicker = new SecureRandom().nextInt(characters.size());
            outputString.append(characters.remove(randPicker));
        }
        return outputString.toString();
    }
}