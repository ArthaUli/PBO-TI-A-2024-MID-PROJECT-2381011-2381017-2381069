import java.util.ArrayList;
import java.util.Scanner;

public class CariPasienBerdasarkanNama {

    // Static class Pasien
    static class Pasien {
        String nama;
        int umur;
        String alamat;
        String keluhan;

        public Pasien(String nama, int umur, String alamat, String keluhan) {
            this.nama = nama;
            this.umur = umur;
            this.alamat = alamat;
            this.keluhan = keluhan;
        }

        @Override
        public String toString() {
            return "Nama: " + nama + ", Umur: " + umur + ", Alamat: " + alamat + ", Keluhan: " + keluhan;
        }
    }

    public static class PendaftaranPasienRumahsakit {
        static ArrayList<Pasien> daftarPasien = new ArrayList<>();
        static String[] tipeKamar = {"Kamar Standard", "Kamar VIP", "Kamar VVIP"};
        static int[] kapasitasKamar = {10, 5, 2}; // kapasitas tiap tipe kamar
        static Scanner scanner = new Scanner(System.in);

        public static void pendaftaranPasienBaru() {
            System.out.print("Masukkan nama pasien: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan umur pasien: ");
            int umur = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Masukkan alamat pasien: ");
            String alamat = scanner.nextLine();
            System.out.print("Masukkan keluhan pasien: ");
            String keluhan = scanner.nextLine();

            daftarPasien.add(new Pasien(nama, umur, alamat, keluhan));
            System.out.println("Pasien berhasil didaftarkan!");
        }

        public static void tampilkanDaftarPasien() {
            if (daftarPasien.isEmpty()) {
                System.out.println("Belum ada pasien yang terdaftar.");
            } else {
                System.out.println("Daftar Pasien Terdaftar:");
                for (Pasien pasien : daftarPasien) {
                    System.out.println(pasien);
                }
            }
        }

        public static void cariPasien() {
            System.out.print("Masukkan nama pasien yang ingin dicari: ");
            String nama = scanner.nextLine();
            for (Pasien pasien : daftarPasien) {
                if (pasien.nama.equalsIgnoreCase(nama)) {
                    System.out.println(pasien);
                    return;
                }
            }
            System.out.println("Pasien tidak ditemukan.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Pilih opsi:");
            System.out.println("1. Pendaftaran Pasien Baru");
            System.out.println("2. Lihat Daftar Pasien");
            System.out.println("3. Cari Pasien");
            System.out.println("4. Keluar");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    PendaftaranPasienRumahsakit.pendaftaranPasienBaru();
                    break;
                case 2:
                    PendaftaranPasienRumahsakit.tampilkanDaftarPasien();
                    break;
                case 3:
                    PendaftaranPasienRumahsakit.cariPasien();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
    }
}
