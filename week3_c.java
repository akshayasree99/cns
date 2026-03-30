import java.util.*;

public class week3_c {

    static int[][] msg = new int[3][1];
    static int[][] key = new int[3][3];
    static int[][] cipher = new int[3][1];
    static int[][] decrypt = new int[3][1];
    static int[][] inverse = new int[3][3];

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        getkeymes();

        // Encrypt
        multiplyMatrix(key, msg, cipher);

        System.out.print("\nEncrypted string is:");
        for (int i = 0; i < 3; i++)
            System.out.print((char) (cipher[i][0] + 65));

        // Decrypt
        inverse();
        multiplyMatrix(inverse, cipher, decrypt);

        System.out.print("\nDecrypted string is:");
        for (int i = 0; i < 3; i++)
            System.out.print((char) (decrypt[i][0] + 65));
    }

    public static void getkeymes() {
        System.out.println("Enter 3x3 matrix for key:");

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                key[i][j] = sc.nextInt();

        System.out.print("Enter a 3-letter string:");
        String msgStr = sc.next().toUpperCase();

        for (int i = 0; i < 3; i++)
            msg[i][0] = msgStr.charAt(i) - 'A';
    }

    public static void multiplyMatrix(int[][] A, int[][] B, int[][] res) {
        for (int i = 0; i < 3; i++) {
            res[i][0] = 0;
            for (int k = 0; k < 3; k++)
                res[i][0] += A[i][k] * B[k][0];

            res[i][0] = (res[i][0] % 26 + 26) % 26;
        }
    }

    public static void inverse() {
        int det = determinant(key);
        int invDet = modInverse(det, 26);

        if (invDet == -1) {
            System.out.println("Matrix not invertible!");
            System.exit(0);
        }

        int[][] adj = adjoint(key);

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                inverse[i][j] = (adj[i][j] * invDet) % 26;
    }

    public static int determinant(int[][] m) {
        int det = m[0][0] * (m[1][1]*m[2][2] - m[1][2]*m[2][1])
                - m[0][1] * (m[1][0]*m[2][2] - m[1][2]*m[2][0])
                + m[0][2] * (m[1][0]*m[2][1] - m[1][1]*m[2][0]);

        return (det % 26 + 26) % 26;
    }

    public static int modInverse(int det, int mod) {
        det = (det % mod + mod) % mod;

        for (int i = 1; i < mod; i++)
            if ((det * i) % mod == 1)
                return i;

        return -1;
    }

    public static int[][] adjoint(int[][] m) {
        int[][] adj = new int[3][3];

        adj[0][0] = m[1][1]*m[2][2] - m[1][2]*m[2][1];
        adj[0][1] = m[0][2]*m[2][1] - m[0][1]*m[2][2];
        adj[0][2] = m[0][1]*m[1][2] - m[0][2]*m[1][1];

        adj[1][0] = m[1][2]*m[2][0] - m[1][0]*m[2][2];
        adj[1][1] = m[0][0]*m[2][2] - m[0][2]*m[2][0];
        adj[1][2] = m[0][2]*m[1][0] - m[0][0]*m[1][2];

        adj[2][0] = m[1][0]*m[2][1] - m[1][1]*m[2][0];
        adj[2][1] = m[0][1]*m[2][0] - m[0][0]*m[2][1];
        adj[2][2] = m[0][0]*m[1][1] - m[0][1]*m[1][0];

        // transpose
        for (int i = 0; i < 3; i++)
            for (int j = i + 1; j < 3; j++) {
                int t = adj[i][j];
                adj[i][j] = adj[j][i];
                adj[j][i] = t;
            }

        // mod fix
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                adj[i][j] = (adj[i][j] % 26 + 26) % 26;

        return adj;
    }
}