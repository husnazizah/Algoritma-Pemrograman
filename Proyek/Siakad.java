import java.util.Scanner;

import javax.xml.transform.Templates;
public class Siakad {
    static int jumlahData = 0;
    static Mahasiswa[] mahasiswa = new Mahasiswa[1000];

    public static void tambahData() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n===Tambah Data===");
        System.out.println("Silahkan tambah data");
        System.out.print("Masukkan NIM = ");
        long nim = scan.nextLong();
        scan.nextLine();
        System.out.print("Masukkan Nama = ");
        String nama = scan.nextLine();
        mahasiswa[jumlahData] = new Mahasiswa();
        mahasiswa[jumlahData].setNim(nim);
        mahasiswa[jumlahData].setNama(nama);
        jumlahData = jumlahData + 1;
        System.out.println("==================\n");
    }

    public static void tampilData() {
        System.out.println("\n===Data Mahasiswa===");
        System.out.println("NIM" + "\t| " + "NAMA");
        System.out.println("--------------------------------");
        int i = 0;
        while (i<jumlahData) {
            System.out.println(mahasiswa[i].getNim()+"\t| "+mahasiswa[i].getNama());
            i++;
        }
        System.out.println("--------------------------------\n");
    }

    public static void urutkanData() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n===Algoritma Pengurutan===");
        System.out.println("1. EXCHANGE SORT");
        System.out.println("2. SELECTION SORT");
        System.out.println("3. BUBBLE SORT");
        System.out.println("4. QUICK SORT");
        System.out.println("5. SHELL SORT");
        System.out.print("Pilih algoritma = ");
        int algo = scan.nextInt();
        switch (algo) {
            case 1: {
                exchangeSort();
                break;
            }
            case 2: {
                selectionSort();
                break;
            }
            case 3: {
                bubbleSort();
                break;
            }
            case 4:{
                quickSort(mahasiswa, 0, jumlahData-1);
                break;
            }
            case 5:{
                shellSort();
                break;
            }
        }
        System.out.println("Data telah diurutkan. Silahkan tampilkan data\n");
    }

    //EXCHANGE SORT
    public static void exchangeSort() {
        for (int x = 0; x<jumlahData; x++) {
            for (int y = x+1; y<jumlahData; y++) {
                if (mahasiswa[x].getNim() > mahasiswa[y].getNim()) {
                    Mahasiswa temp = mahasiswa[x];
                    mahasiswa[x] = mahasiswa[y];
                    mahasiswa[y] = temp;
                }
            }
        }
    }

    //QUICK SORT
    public static void quickSort(Mahasiswa[] arr, int low, int high){
        if(low < high){
            int p = partition(arr, low, high);
            quickSort(arr, low, p-1);
            quickSort(arr, p+1, high);
        }
    }

    static int partition(Mahasiswa[] arr, int low, int high){
        int p = low, j;
        for(j=low+1; j <= high; j++)
            if(arr[j].getNim() < arr[low].getNim())
                swap(arr, ++p, j);
    
        swap(arr, low, p);
        return p;
    }

    static void swap(Mahasiswa[] arr, int low, int pivot){
        Mahasiswa temp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = temp;
    }

    //SELECTION SORT
    public static void selectionSort() {
        for(int i=0; i<jumlahData-1; i++){
            int index = i;
            for(int j=i+1; j<jumlahData; j++) {
                if(mahasiswa[j].getNim() < mahasiswa[index].getNim())
                    index = j;
                }
                Mahasiswa temp = mahasiswa[index];
                mahasiswa[index] = mahasiswa[i];
                mahasiswa[i] = temp;
            }
        }

    //BUBBLE SORT
    public static void bubbleSort() {
        for(int i = 0; i < jumlahData - 1; i++) {
            for(int j = 0; j < jumlahData - i - 1; j++) {
                if(mahasiswa[j].getNim() > mahasiswa[j + 1].getNim()) {
                    Mahasiswa temp = mahasiswa[j];
                    mahasiswa[j] = mahasiswa[j + 1];
                    mahasiswa[j + 1] = temp;
                }
            }
        }
    }

    //SHELL SORT
    public static void shellSort() {
        for(int gap = jumlahData/2; gap > 0; gap /= 2) {
            for(int i = gap; i < jumlahData; i += 1) {
                Mahasiswa temp = mahasiswa[i];
                int j;
                for(j = i; (j >= gap) && (mahasiswa[j - gap].getNim() > temp.getNim()); j -= gap) {
                    mahasiswa[j] = mahasiswa[j - gap];
                }
                mahasiswa[j] = temp;
            }
        }
    }
    
    public static void cariData() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\n===Cari Data===");
        System.out.println("1. LINEAR SEARCH");
        System.out.println("2. BINARY SEARCH");
        System.out.print("Pilih :");
        int cari = scan.nextInt();
        scan.nextLine();

        switch(cari) {
            case 1:{
                linearSearch();
                break;
            }
            case 2:{
                binarySearch();
                break;
            }
        }
    }

    public static void linearSearch() {
        Scanner scan = new Scanner(System.in);
        System.out.println("---Linear Search---");
        System.out.print("Masukkan NIM : ");
        long linear = scan.nextLong();
        
        for(int i = 0; i < jumlahData; i++) {
            if(mahasiswa[i].getNim()==linear) {
                System.out.println("\n--------------------------------");
                System.out.println("Data ditemukan pada indeks ke-" + (i+1));
                System.out.println("NIM : " +mahasiswa[i].getNim());
                System.out.println("Nama : "+mahasiswa[i].getNama());
                System.out.println("--------------------------------\n");
            }
        }
    }

    public static void binarySearch() {
        Scanner scan = new Scanner(System.in);
        System.out.println("---Binary Search---");
        System.out.print("Masukkan NIM : ");
        long binary = scan.nextLong();

        int l = 0, r = jumlahData-1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(mahasiswa[m].getNim()==binary) {
                System.out.println("\n--------------------------------");
                System.out.println("Data ditemukan pada indeks ke-" + (m+1));
                System.out.println("NIM : " +mahasiswa[m].getNim());
                System.out.println("Nama : "+mahasiswa[m].getNama());
                System.out.println("--------------------------------\n");
            }

            if(mahasiswa[m].getNim() < binary) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
    }

    public static void editData() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n===Edit Data===");
        System.out.println("Cari NIM dari data yang akan diubah : ");
        long edit = scan.nextLong();

        for(int i=0; i<jumlahData; i++) {
            if(mahasiswa[i].getNim()==edit) {
                System.out.println("Pilihan Edit");
                System.out.println("1. Edit NIM");
                System.out.println("2. Edit Nama");
                System.out.print("Pilih : ");
                int menuEdit = scan.nextInt();

                switch (menuEdit) {
                    case 1 :{
                        System.out.println("\n--------------------------------");
                        System.out.print("NIM baru : ");
                        long nimEdit = scan.nextLong();
                        scan.nextLine();

                        mahasiswa[i].setNim(nimEdit);
                        System.out.println("Data NIM berhasil dirubah");
                        System.out.println("--------------------------------\n");
                        break;
                    }
                    case 2:{
                        System.out.println("\n--------------------------------");
                        System.out.print("Nama baru : ");
                        String namaEdit = scan.next();
                        scan.nextLine();
                        mahasiswa[i].setNama(namaEdit);
                        System.out.println("Data Nama berhasil dirubah");
                        System.out.println("--------------------------------\n");
                        break;
                    }
                }
            } 
        }
    }

    public static void hapusData() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n===Hapus Data===");
        System.out.print("Cari NIM dari data yang akan dihapus : ");
        long delete = scan.nextLong();
        System.out.println("===============\n");

        for(int i=0; i<jumlahData; i++) {
            if(mahasiswa[i].getNim()==delete) {
                System.out.println("Nim : "+mahasiswa[i].getNim());
                System.out.println("Nama : "+mahasiswa[i].getNama()); 
                mahasiswa[i] = mahasiswa[i +1];
                }
            }
        jumlahData--;
        System.out.println("Data Terhapus!");
        System.out.println("==================\n");
    }

    public static void UAS() {
        if (jumlahData==0) {
            System.out.println("Tidak ada data");
        } else {
            int jarak = jumlahData;
            int susut = 13;
            int urut = 0;
            while(urut == 0) {
                jarak = (jarak*10) / susut;
                if(jarak <= 1) {
                    jarak = 1;
                    urut = 1;
                }
                for(int i=0; (i+jarak)<jumlahData; i++) {
                    if(mahasiswa[i].getNim() > mahasiswa[i+jarak].getNim()) {
                        Mahasiswa temp = mahasiswa[i];
                        mahasiswa[i] = mahasiswa[i+jarak];
                        mahasiswa[i+jarak] = temp;
                        urut = 0;
                    }
                }
            }
            System.out.println("Data telah diurutkan. Silahkan tampilkan data");  
        }
    }
    public static void main(String[] args) {
        int menu;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("===Menu Siakad===");
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Urutkan Data");
            System.out.println("4. Cari Data");
            System.out.println("5. Edit Data");
            System.out.println("6. Hapus Data");
            System.out.println("7. UAS");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu = ");
            menu = scan.nextInt();

            if (menu==1) {
                tambahData();
            } else if (menu==2) {
                tampilData();
            } else if (menu==3) {
                urutkanData();
            } else if (menu==4) {
                cariData();
            } else if (menu==5) {
                editData();
            } else if (menu==6) {
                hapusData();
            } else if (menu==7) {
                UAS();
            }
        } while (menu!=8);
    }
}
