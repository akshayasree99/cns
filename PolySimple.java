import java.util.*;

public class PolySimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Text: ");
        String text = sc.nextLine();

        System.out.print("Key: ");
        String key = sc.nextLine().toLowerCase();

        String enc = "", dec = "";
        int j = 0;

        // Encryption
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetter(c)) {
                int k = key.charAt(j % key.length()) - 'a';
                enc += (char) ((Character.toLowerCase(c) - 'a' + k) % 26 + 'a');
                j++;
            } else {
                enc += c;
            }
        }

        j = 0;

        // Decryption
        for (int i = 0; i < enc.length(); i++) {
            char c = enc.charAt(i);

            if (Character.isLetter(c)) {
                int k = key.charAt(j % key.length()) - 'a';
                dec += (char) ((c - 'a' - k + 26) % 26 + 'a');
                j++;
            } else {
                dec += c;
            }
        }

        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + dec);
    }
}