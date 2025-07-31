package edu.neumont.csc150.models;

public class Cutter implements StringEncryptable{
    @Override
    public String encrypt(String phraseToEncrypt) {
        int num = phraseToEncrypt.length();
        int numToCut = num / 2;
        int frontLength = num - numToCut;
        char[] result = new char[num];

        for (int i = 0; i < numToCut; i++) {
            result[i] = phraseToEncrypt.charAt(frontLength + i);
        }

        for (int i = 0; i < frontLength; i++) {
            result[numToCut + i] = phraseToEncrypt.charAt(i);
        }

        return new String(result);
    }

    @Override
    public String decrypt(String phraseToDecrypt) {
        int num = phraseToDecrypt.length();
        int numToCut = num / 2;
        int frontLen = num - numToCut;
        char[] result = new char[num];

        for (int i = 0; i < frontLen; i++) {
            result[i] = phraseToDecrypt.charAt(numToCut + i);
        }

        for (int i = 0; i < numToCut; i++) {
            result[frontLen + i] = phraseToDecrypt.charAt(i);
        }

        return new String(result);
    }
}
