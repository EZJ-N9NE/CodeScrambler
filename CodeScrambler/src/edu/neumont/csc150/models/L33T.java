package edu.neumont.csc150.models;

public class L33T implements StringEncryptable{
    @Override
    public String encrypt(String phraseToEncrypt) {
        char[] chars = phraseToEncrypt.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            switch (Character.toLowerCase(chars[i])) {
                case 'a':
                    chars[i] = '4';
                    break;
                case 'e':
                    chars[i] = '[';
                    break;
                case 'g':
                    chars[i] = '6';
                    break;
                case 'i':
                    chars[i] = '|';
                    break;
                case 'o':
                    chars[i] = '0';
                    break;
                default:
                    break;
            }
        }

        return new String(chars);
    }

    @Override
    public String decrypt(String phraseToDecrypt) {
        char[] chars = phraseToDecrypt.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '4':
                    chars[i] = 'a';
                    break;
                case '[':
                    chars[i] = 'e';
                    break;
                case '6':
                    chars[i] = 'g';
                    break;
                case '|':
                    chars[i] = 'i';
                    break;
                case '0':
                    chars[i] = 'o';
                    break;
                default:
                    break;
            }
        }

        return new String(chars);
    }

}
