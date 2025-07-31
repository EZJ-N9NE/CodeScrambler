package edu.neumont.csc150.models;

public interface StringEncryptable{
    String encrypt(String phraseToEncrypt);

    String decrypt(String phraseToDecrypt);
}
