import java.util.ArrayList;
import java.util.Scanner;

public class EditDataPasien {

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
        static Scanner scanner = new Scanner(System.in);

        // Pendaftaran pasien baru
        public static void pendaftaranPasienBaru() {
            System.out.print("Masukkan nama pasien: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan umur pasien: ");
            int umur = scanner.nextInt();
            scanner.nextLine(); // Bersihkan buffer
            System.out.print("Masukkan alamat pasien: ");
            String alamat = scanner.nextLine();
            System.out.print("Masukkan keluhan pasien: ");
            String keluhan = scanner.nextLine();

            daftarPasien.add(new Pasien(nama, umur, alamat, keluhan));
            System.out.println("Pasien berhasil didaftarkan!");
        }

        // Edit data pasien
        public static void editDataPasien() {
            System.out.print("Masukkan nama pasien yang ingin diedit: ");
            String nama = scanner.nextLine();
            boolean ditemukan = false;

            for (Pasien pasien : daftarPasien) {
                if (pasien.nama.equalsIgnoreCase(nama)) {
                    System.out.print("Masukkan nama baru (tekan Enter jika tidak ingin mengubah): ");
                    String namaBaru = scanner.nextLine();
                    if (!namaBaru.isEmpty()) {
                        pasien.nama = namaBaru;
                    }

                    System.out.print("Masukkan umur baru (atau 0 jika tidak ingin mengubah): ");
                    int umurBaru = scanner.nextInt();
                    if (umurBaru != 0) {
                        pasien.umur = umurBaru;
                    }
                    scanner.nextLine(); // Bersihkan buffer

                    System.out.print("Masukkan alamat baru (tekan Enter jika tidak ingin mengubah): ");
                    String alamatBaru = scanner.nextLine();
                    if (!alamatBaru.isEmpty()) {
                        pasien.alamat = alamatBaru;
                    }

                    System.out.print("Masukkan keluhan baru (tekan Enter jika tidak ingin mengubah): ");
                    String keluhanBaru = scanner.nextLine();
                    if (!keluhanBaru.isEmpty()) {
                        pasien.keluhan = keluhanBaru;
                    }

                    System.out.println("Data pasien berhasil diubah.");
                    ditemukan = true;
                    break;
                }
            }

            if (!ditemukan) {
                System.out.println("Pasien dengan nama " + nama + " tidak ditemukan.");
            }
        }

        // Menampilkan daftar pasien
        public static void tampilkanDaftarPasien() {
            if (daftarPasien.isEmpty()) {
                System.out.println("Belum ada pasien.");
            } else {
                System.out.println("Daftar Pasien:");
                for (Pasien pasien : daftarPasien) {
                    System.out.println(pasien);
                }
            }
        }

        // Cari pasien berdasarkan nama
        public static void cariPasien() {
            System.out.print("Masukkan nama pasien yang ingin dicari: ");
            String nama = scanner.nextLine();
            boolean ditemukan = false;

            for (Pasien pasien : daftarPasien) {
                if (pasien.nama.equalsIgnoreCase(nama)) {
                    System.out.println("Data Pasien Ditemukan: " + pasien);
                    ditemukan = true;
                    break;
                }
            }

            if (!ditemukan) {
                System.out.println("Pasien dengan nama " + nama + " tidak ditemukan.");
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Pilih opsi:");
            System.out.println("1. Pendaftaran Pasien Baru");
            System.out.println("2. Lihat Daftar Pasien");
            System.out.println("3. Cari Pasien");
            System.out.println("4. Edit Data Pasien");
            System.out.println("5. Keluar");

            int pilihan = PendaftaranPasienRumahsakit.scanner.nextInt();
            PendaftaranPasienRumahsakit.scanner.nextLine(); // Bersihkan buffer

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
                    PendaftaranPasienRumahsakit.editDataPasien();
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
    }
}
