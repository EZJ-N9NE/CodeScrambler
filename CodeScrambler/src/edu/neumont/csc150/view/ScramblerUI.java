package edu.neumont.csc150.view;

import edu.neumont.csc150.models.StringEncryptable;

import java.util.List;

public class ScramblerUI {
    public static int displayMainMenu(){
        return edu.neumont.csc150.views.Console.getIntInput("""
                1. Enter a String
                2. Add Encrypter to the list
                3. Display Current Encrypter
                4. Encrypt the String
                5. Decrypt the String
                6. View Current String
                7. Start Over
                8. Exit
                """, 1, 8);
    }

    public static String askForString() {
        return edu.neumont.csc150.views.Console.getStringInput("Enter a string to encrypt: ");
    }

    public static int askForEncrypterChoice() {
        String prompt = """
            Choose an encrypter to add:
            1. Reverser
            2. Cutter
            3. VowelReplacer
            4. L33T
            """;
        return edu.neumont.csc150.views.Console.getIntInput(prompt, 1, 4);
    }

    public static void showMessage(String message) {
        System.out.println(message);
    }

    public static void displayEncrypters(List<StringEncryptable> encrypters) {
        if(encrypters.isEmpty()){
            showMessage("No encrypters have been added.");
        } else {
            showMessage("Current encrypters:");
            for(StringEncryptable enc : encrypters) {
                showMessage(" - " + enc.getClass().getSimpleName());
            }
        }
    }

    public static void showEncrypterAlreadyAdded() {
        showMessage("That encrypter has already been added.");
    }

    public static void showAddedEncrypter(String encrypterName) {
        showMessage(encrypterName + " added.");
    }

    public static void showNoStringEnteredToEncrypt() {
        showMessage("No string entered to encrypt.");
    }

    public static void showNoStringEnteredToDecrypt() {
        showMessage("No string entered to decrypt.");
    }

    public static void showAfterEncryption(String encrypterName, String result) {
        showMessage("After " + encrypterName + " encryption: " + result);
    }

    public static void showAfterDecryption(String encrypterName, String result) {
        showMessage("After " + encrypterName + " decryption: " + result);
    }

    public static void showNoStringEnteredYet() {
        showMessage("No string has been entered yet.");
    }

    public static void showCurrentString(String current) {
        showMessage("Current string: " + current);
    }

    public static void showResetComplete() {
        showMessage("Reset complete. The string and encrypter list have been cleared.");
    }

    public static void showInvalidSelection() {
        showMessage("Invalid selection. Please try again.");
    }
}
