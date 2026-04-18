import java.util.*;

public class MonoAlphabeticCipher {
    // Encryption
    public static String encrypt(String text, String key) {
        String result = "";

        for (char c : text.toCharArray()) {
            if (Character.isLowerCase(c)) {
                int index = c - 'a';
                result += key.charAt(index);
            } else if (Character.isUpperCase(c)) {
                int index = c - 'A';
                result += Character.toUpperCase(key.charAt(index));
            } else {
                result += c; // keep spaces/symbols
            }
        }
        return result;
    }
    // Decryption
    public static String decrypt(String text, String key) {
        String result = "";

        for (char c : text.toCharArray()) {
            if (Character.isLowerCase(c)) {
                int index = key.indexOf(c);
                result += (char) ('a' + index);
            } else if (Character.isUpperCase(c)) {
                int index = key.indexOf(Character.toLowerCase(c));
                result += (char) ('A' + index);
            } else {
                result += c;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Example key (must be 26 unique letters)
        String key = "qwertyuiopasdfghjklzxcvbnm";

        System.out.println("Enter text:");
        String text = sc.nextLine();

        String encrypted = encrypt(text, key);
        String decrypted = decrypt(encrypted, key);

        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}