import java.util.Scanner;
public class polaBintang {
    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan nilai n = ");
        n = scan.nextInt();
        int i = 1;
        while (i<=n) {
            int j = 1;
            while (j<=n) {
                if ((j<=i || j>=(n+1)-i) && (j>=i || j<=(n+1)-i)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                j = j + 1;
            }
            System.out.println("");
            i = i + 1;
        }
    }
}
