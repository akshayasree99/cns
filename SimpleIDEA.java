
import java.util.*;
public class SimpleIDEA {
    // Simple encryption (conceptual IDEA)
    public static int[] encrypt(int[] data, int key) {
        int x1 = data[0];
        int x2 = data[1];
        int x3 = data[2];
        int x4 = data[3];
        // 3 simple rounds (instead of 8)
        for (int i = 0; i < 3; i++) {
            x1 = (x1 * key) % 65536;
            x2 = (x2 + key) % 65536;
            x3 = (x3 + key) % 65536;
            x4 = (x4 * key) % 65536;

            int t1 = x1 ^ x3;
            int t2 = x2 ^ x4;

            x1 = x1 ^ t2;
            x4 = x4 ^ t1;

            // swap
            int temp = x2;
            x2 = x3;
            x3 = temp;
        }
        return new int[]{x1, x2, x3, x4};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 4 numbers (plaintext block):");
        int[] data = new int[4];
        for (int i = 0; i < 4; i++) {
            data[i] = sc.nextInt();
        }

        System.out.println("Enter key:");
        int key = sc.nextInt();

        int[] cipher = encrypt(data, key);

        System.out.println("Encrypted Output:");
        for (int i : cipher) {
            System.out.print(i + " ");
        }
    }
}