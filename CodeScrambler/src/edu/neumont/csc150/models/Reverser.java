package edu.neumont.csc150.models;

public class Reverser implements StringEncryptable {

    @Override
    public String encrypt(String phraseToEncrypt) {
        if (phraseToEncrypt == null || phraseToEncrypt.isEmpty()) {
            return phraseToEncrypt;
        }
        char[] arr = phraseToEncrypt.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }

    @Override
    public String decrypt(String phraseToDecrypt) {
        return encrypt(phraseToDecrypt);
    }
}