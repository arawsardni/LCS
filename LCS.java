import java.util.Scanner;

public class LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan string pertama: ");
        String X1 = sc.nextLine();
        System.out.print("Masukkan string kedua: ");
        String X2 = sc.nextLine();

        int m = X1.length();
        int n = X2.length();

        // Sudah diinisialisasi dengan 0 semua
        int[][] c = new int[m + 1][n + 1];
        char[][] b = new char[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X1.charAt(i - 1) == X2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = '\\';
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = '^';
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = '<';
                }
            }
        }

        System.out.println("Matriks c:");
        printMatrix(c, X1, X2);

        System.out.println("Matriks b:");
        printMatrix(b, X1, X2);

        System.out.print("LCS = ");
        printLCS(b, X1, m, n);
    }

    private static void printMatrix(int[][] matrix, String X1, String X2) {
        System.out.print("    ");
        for (int j = 0; j < X2.length(); j++) {
            System.out.print(X2.charAt(j) + " ");
        }
        System.out.println();
        for (int i = 0; i <= X1.length(); i++) {
            if (i == 0) {
                System.out.print("  ");
            } else {
                System.out.print(X1.charAt(i - 1) + " ");
            }
            for (int j = 0; j <= X2.length(); j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printMatrix(char[][] matrix, String X1, String X2) {
        System.out.print("    ");
        for (int j = 0; j < X2.length(); j++) {
            System.out.print(X2.charAt(j) + " ");
        }
        System.out.println();
        for (int i = 0; i <= X1.length(); i++) {
            if (i == 0) {
                System.out.print("  ");
            } else {
                System.out.print(X1.charAt(i - 1) + " ");
            }
            for (int j = 0; j <= X2.length(); j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printLCS(char[][] b, String X1, int i, int j) {
        if (i == 0 || j == 0)
            return;
        if (b[i][j] == '\\') {
            printLCS(b, X1, i - 1, j - 1);
            System.out.print(X1.charAt(i - 1));
        } else if (b[i][j] == '^') {
            printLCS(b, X1, i - 1, j);
        } else {
            printLCS(b, X1, i, j - 1);
        }
    }
}
