import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataPraktikan {
    private Map<String, String> tabelData;

    public DataPraktikan() {
        tabelData = new HashMap<>();
    }

    public boolean tambahData(String nimPraktikan, String namaAsisten) {
        if (!nimPraktikan.startsWith("IF")) {
            System.out.println("\n!!! NIM praktikan harus dimulai dengan 'IF' !!!");
            return false;
        }
        if (tabelData.containsKey(nimPraktikan)) {
            System.out.println("\n!!! NIM praktikan sudah terdaftar !!!");
            return false;
        }
        tabelData.put(nimPraktikan, namaAsisten);
        System.out.println("\n!!! Data berhasil ditambahkan !!!");
        return true;
    }

    public void tampil() {
        System.out.println("==========================================");
        System.out.println("Daftar NIM praktikan beserta nama asisten:");
        System.out.println("==========================================");
        for (String nimPraktikan : tabelData.keySet()) {
            String namaAsisten = tabelData.get(nimPraktikan);
            System.out.println(nimPraktikan + " - " + namaAsisten);
        }
    }

    public void listNimPraktikan() {
        System.out.println("\n=====================");
        System.out.println("Daftar NIM praktikan:");
        System.out.println("=====================");
        for (String nimPraktikan : tabelData.keySet()) {
            System.out.println(nimPraktikan);
        }
    }

    public void listNamaAsisten() {
        System.out.println("\n====================");
        System.out.println("Daftar nama asisten:");
        System.out.println("====================");
        for (String namaAsisten : tabelData.values()) {
            System.out.println(namaAsisten);
        }
    }

    public int totalEmail() {
        return tabelData.size();
    }

    public boolean hapusData(String nimPraktikan, String namaAsisten) {
        if (!tabelData.containsKey(nimPraktikan)) {
            System.out.println("\n!!! NIM praktikan tidak ditemukan !!!");
            return false;
        }
        if (!tabelData.get(nimPraktikan).equals(namaAsisten)) {
            System.out.println("\n!!! Nama asisten yang dimasukkan tidak cocok !!!");
            return false;
        }
        tabelData.remove(nimPraktikan);
        System.out.println("\n!!! Data berhasil dihapus !!!");
        return true;
    }

    public void editData(String nimPraktikan, String namaAsisten) {
        if (!tabelData.containsKey(nimPraktikan)) {
            System.out.println("\n!!! NIM praktikan tidak ditemukan !!!");
            return;
        }
        tabelData.put(nimPraktikan, namaAsisten);
        System.out.println("\n!!! Data berhasil diedit !!!");
    }

    public void menu (){
        Scanner input = new Scanner(System.in);

        boolean menu = false;
        while(!menu){
            System.out.println("\n--------------------------");
            System.out.println("Pilih opsi:");
            System.out.println("--------------------------");
            System.out.println("1. Tambah/input Data");
            System.out.println("2. Tampilkan data");
            System.out.println("3. Tampilkan NIM praktikan");
            System.out.println("4. Tampilkan nama asisten");
            System.out.println("5. Hapus data");
            System.out.println("6. Edit data");
            System.out.println("7. Keluar");
            System.out.println("--------------------------");
            System.out.println("--------------------------");

            System.out.print("\nPilih : ");
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan NIM praktikan: ");
                    String nimPraktikan = input.nextLine();
                    System.out.print("Masukkan Asisten Lab praktikan: ");
                    String namaAsisten = input.nextLine();
                    tambahData(nimPraktikan, namaAsisten);
                    break;
                case 2:
                    System.out.println("\nTotal Data yang tersimpan : "+ totalEmail());
                    tampil();
                    break;
                case 3:
                    listNimPraktikan();
                    break;
                case 4:
                    listNamaAsisten();
                    break;
                case 5:
                    System.out.print("Masukkan NIM praktikan yang akan dihapus: ");
                    nimPraktikan = input.nextLine();
                    System.out.print("Masukkan nama asisten: ");
                    namaAsisten = input.nextLine();
                    hapusData(nimPraktikan, namaAsisten);
                    break;
                case 6:
                    System.out.print("Masukkan NIM praktikan yang akan diedit: ");
                    nimPraktikan = input.nextLine();
                    System.out.print("Masukkan nama asisten baru: ");
                    namaAsisten = input.nextLine();
                    editData(nimPraktikan, namaAsisten);
                    break;
                case 7:
                    menu = true;
                    break;
                default:
                    System.out.println("!!! Pilihan tidak valid !!!");
                    break;
            }
        }


    }

    public static void main(String[] args) {
        DataPraktikan data = new DataPraktikan();
        data.menu();
    }
}