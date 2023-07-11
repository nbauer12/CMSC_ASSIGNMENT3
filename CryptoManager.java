package crypto;

public class CryptoManager {
  
    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

    public static boolean isStringInBounds(String plainText) {
        for (char ch : plainText.toCharArray()) {
            if (ch < LOWER_RANGE || ch > UPPER_RANGE) {
                return false;
            }
        }
        return true;
    }

    public static String caesarEncryption(String plainText, int key) {
        if (!isStringInBounds(plainText)) {
            return "The selected string is not in bounds, Try again.";
        }
        StringBuilder encryptedText = new StringBuilder();
        key %= RANGE;
        for (char ch : plainText.toCharArray()) {
            ch = (char) (ch + key);
            if (ch > UPPER_RANGE) {
                ch = (char) (ch - RANGE);
            }
            encryptedText.append(ch);
        }
        return encryptedText.toString();
    }

    public static String bellasoEncryption(String plainText, String bellasoStr) {
        if (!isStringInBounds(plainText)) {
            return "The selected string is not in bounds, Try again.";
        }
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            int shift = bellasoStr.charAt(i % bellasoStr.length());
            ch = (char) (ch + shift);
            while (ch > UPPER_RANGE) {
                ch = (char) (ch - RANGE);
            }
            encryptedText.append(ch);
        }
        return encryptedText.toString();
    }

    public static String caesarDecryption(String encryptedText, int key) {
        StringBuilder plainText = new StringBuilder();
        key %= RANGE;
        for (char ch : encryptedText.toCharArray()) {
            ch = (char) (ch - key);
            if (ch < LOWER_RANGE) {
                ch = (char) (ch + RANGE);
            }
            plainText.append(ch);
        }
        return plainText.toString();
    }

    public static String bellasoDecryption(String encryptedText, String bellasoStr) {
        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            char ch = encryptedText.charAt(i);
            ch = (char) (ch - bellasoStr.charAt(i % bellasoStr.length()));
            while (ch < LOWER_RANGE) {
                ch += RANGE;
            }
            while (ch > UPPER_RANGE) {
                ch -= RANGE;
            }
            plainText.append(ch);
        }
        return plainText.toString();
    }
}