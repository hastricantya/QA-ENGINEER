public class TrianglePatternHastri {
    public static void main(String[] args) {
        int n = 5; // Jumlah baris maksimum di tengah segitiga

        // Bagian atas segitiga
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Bagian bawah segitiga
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
