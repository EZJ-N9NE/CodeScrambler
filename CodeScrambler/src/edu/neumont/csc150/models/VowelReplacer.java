package edu.neumont.csc150.models;

public class VowelReplacer implements StringEncryptable{
    @Override
    public String encrypt(String phraseToEncrypt) {
        char[] vowelsLower = {'a', 'e', 'i', 'o', 'u'};
        char[] vowelsUpper = {'A', 'E', 'I', 'O', 'U'};

        char[] encryptedChars = phraseToEncrypt.toCharArray();

        for (int i = 0; i < encryptedChars.length; i++) {
            char ch = encryptedChars[i];

            for (int j = 0; j < vowelsLower.length; j++) {
                if (ch == vowelsLower[j]) {
                    encryptedChars[i] = vowelsLower[(j + 1) % vowelsLower.length];
                    break;
                }
            }

            for (int j = 0; j < vowelsUpper.length; j++) {
                if (ch == vowelsUpper[j]) {
                    encryptedChars[i] = vowelsUpper[(j + 1) % vowelsUpper.length];
                    break;
                }
            }
        }

        return new String(encryptedChars);
    }

    @Override
    public String decrypt(String phraseToDecrypt) {
        char[] vowelsLower = {'a', 'e', 'i', 'o', 'u'};
        char[] vowelsUpper = {'A', 'E', 'I', 'O', 'U'};

        char[] decryptedChars = phraseToDecrypt.toCharArray();

        for (int i = 0; i < decryptedChars.length; i++) {
            char ch = decryptedChars[i];

            for (int j = 0; j < vowelsLower.length; j++) {
                if (ch == vowelsLower[j]) {
                    decryptedChars[i] = vowelsLower[(j + vowelsLower.length - 1) % vowelsLower.length];
                    break;
                }
            }

            for (int j = 0; j < vowelsUpper.length; j++) {
                if (ch == vowelsUpper[j]) {
                    decryptedChars[i] = vowelsUpper[(j + vowelsUpper.length - 1) % vowelsUpper.length];
                    break;
                }
            }
        }

        return new String(decryptedChars);
    }

}
