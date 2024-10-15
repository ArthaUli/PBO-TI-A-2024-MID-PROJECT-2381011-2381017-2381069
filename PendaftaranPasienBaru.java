import java.util.ArrayList;
import java.util.Scanner;

public class PendaftaranPasienBaru {

    // Make Pasien a static class so it can be used in static methods
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
            scanner.nextLine(); // Membersihkan buffer
            System.out.print("Masukkan alamat pasien: ");
            String alamat = scanner.nextLine();
            System.out.print("Masukkan keluhan pasien: ");
            String keluhan = scanner.nextLine();

            daftarPasien.add(new Pasien(nama, umur, alamat, keluhan));
            System.out.println("Pasien berhasil didaftarkan!");
        }

        // Method to display registered patients
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
    }

    public static void main(String[] args) {
        // Example of how to use the system
        PendaftaranPasienRumahsakit.pendaftaranPasienBaru();
        PendaftaranPasienRumahsakit.tampilkanDaftarPasien();
    }
}
