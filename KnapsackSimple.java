import java.util.*;

public class KnapsackSimple {

    // Encrypt
    static int encrypt(int[] w, int[] m, int n) {
        int c = 0;
        for (int i = 0; i < n; i++)
            c += w[i] * m[i];
        return c;
    }

    // Decrypt (greedy for superincreasing)
    static int[] decrypt(int[] w, int c, int n) {
        int[] m = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (c >= w[i]) {
                m[i] = 1;
                c -= w[i];
            } else {
                m[i] = 0;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 4;
        int[] w = {2, 3, 7, 14}; // superincreasing

        System.out.println("Enter 4-bit message (0/1):");
        int[] m = new int[n];
        for (int i = 0; i < n; i++)
            m[i] = sc.nextInt();

        int cipher = encrypt(w, m, n);
        System.out.println("Encrypted: " + cipher);

        int[] dec = decrypt(w, cipher, n);
        System.out.print("Decrypted: ");
        for (int i : dec)
            System.out.print(i + " ");
    }
}