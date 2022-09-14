import java.util.Scanner;
public class progLulus {
    public static void main(String[] args) {
        String nama;
        int nilai;
        String hasil;
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan nama : ");
        nama = scan.nextLine();
        System.out.print("Masukkan nilai : ");
        nilai = scan.nextInt();

        if(nilai>=60){
            hasil="Lulus";
        }
        else{
            hasil="Tidak Lulus";
        }

        System.out.println("\n" +nama+" Hasil Kelulusan : "+hasil);
    }
}
