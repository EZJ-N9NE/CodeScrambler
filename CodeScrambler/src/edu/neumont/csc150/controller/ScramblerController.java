package edu.neumont.csc150.controller;

import edu.neumont.csc150.models.*;
import edu.neumont.csc150.view.ScramblerUI;
import java.util.ArrayList;
import java.util.List;

public class ScramblerController {

    private boolean exit = false;
    private String stringToEncrypt;
    private List<StringEncryptable> encrypters = new ArrayList<>();

    public void scramble() {
        do {
            int selection = ScramblerUI.displayMainMenu();
            switch (selection) {
                case 1:
                    enterString();
                    break;
                case 2:
                    addEncrypter();
                    break;
                case 3:
                    displayEncrypters();
                    break;
                case 4:
                    encryptString();
                    break;
                case 5:
                    decryptString();
                    break;
                case 6:
                    viewCurrentString();
                    break;
                case 7:
                    startOver();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    ScramblerUI.showInvalidSelection();
                    break;
            }
        } while (!exit);
    }

    private void enterString() {
        stringToEncrypt = ScramblerUI.askForString();
    }

    private void addEncrypter() {
        int choice = ScramblerUI.askForEncrypterChoice();
        StringEncryptable newEncrypter = null;
        switch (choice) {
            case 1:
                newEncrypter = new Reverser();
                break;
            case 2:
                newEncrypter = new Cutter();
                break;
            case 3:
                newEncrypter = new VowelReplacer();
                break;
            case 4:
                newEncrypter = new L33T();
                break;
        }
        StringEncryptable finalNewEncrypter = newEncrypter;
        boolean exists = encrypters.stream()
                .anyMatch(enc -> enc.getClass().equals(finalNewEncrypter.getClass()));
        if (exists) {
            ScramblerUI.showEncrypterAlreadyAdded();
        } else {
            encrypters.add(newEncrypter);
            ScramblerUI.showAddedEncrypter(newEncrypter.getClass().getSimpleName());
        }
    }

    private void displayEncrypters() {
        ScramblerUI.displayEncrypters(encrypters);
    }

    private void encryptString() {
        if (stringToEncrypt == null || stringToEncrypt.isEmpty()) {
            ScramblerUI.showNoStringEnteredToEncrypt();
            return;
        }
        String result = stringToEncrypt;
        for (StringEncryptable enc : encrypters) {
            result = enc.encrypt(result);
            ScramblerUI.showAfterEncryption(enc.getClass().getSimpleName(), result);
        }
        stringToEncrypt = result;
    }

    private void decryptString() {
        if (stringToEncrypt == null || stringToEncrypt.isEmpty()) {
            ScramblerUI.showNoStringEnteredToDecrypt();
            return;
        }
        String result = stringToEncrypt;
        for (int i = encrypters.size() - 1; i >= 0; i--) {
            StringEncryptable enc = encrypters.get(i);
            result = enc.decrypt(result);
            ScramblerUI.showAfterDecryption(enc.getClass().getSimpleName(), result);
        }
        stringToEncrypt = result;
    }

    private void viewCurrentString() {
        if (stringToEncrypt == null) {
            ScramblerUI.showNoStringEnteredYet();
        } else {
            ScramblerUI.showCurrentString(stringToEncrypt);
        }
    }

    private void startOver() {
        stringToEncrypt = null;
        encrypters.clear();
        ScramblerUI.showResetComplete();
    }
}