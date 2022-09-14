import java.util.Scanner;
public class Penjumlahan {
    public static void main(String[] arrgs) {
        int x;
        int y;
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan nilai x = ");
        x = scan.nextInt();
        System.out.print("Masukkan nilai y = ");
        y = scan.nextInt();
        int hasil = x + y;
        System.out.println("hasil penjumlahan x + y = "+hasil);
    }
}
