import java.util.ArrayList;
import java.util.Scanner;

public class ClearScreen {
    static class Pasien {
        String nama;
        int umur;
        String alamat;
        String keluhan;
        String lihatTipeKamar;

        public Pasien(String nama, int umur, String alamat, String keluhan, String tipeKamar) {
            this.nama = nama;
            this.umur = umur;
            this.alamat = alamat;
            this.keluhan = keluhan;
            this.lihatTipeKamar = tipeKamar;
        }

        @Override
        public String toString() { 
            return "Nama: " + nama + ", Umur: " + umur + ", Alamat: " + alamat + ", Keluhan: " + keluhan + ", Tipe Kamar: " + lihatTipeKamar;
        }
    }

    static ArrayList<Pasien> daftarPasien = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int totalRuangan = 10;
    static int ruanganTerpakai = 0;

    // Fitur 1: Pendaftaran Pasien Baru
    public static void pendaftaranPasienBaru() {
        if (ruanganTerpakai < totalRuangan) {
            System.out.print("Masukkan nama pasien: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan umur pasien: ");
            int umur = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Masukkan alamat pasien: ");
            String alamat = scanner.nextLine();
            System.out.print("Masukkan keluhan pasien: ");
            String keluhan = scanner.nextLine();
            System.out.print("Masukkan pilihan Tipe Kamar (1/2/3): ");

            // Panggil fitur pilih tipe kamar
            String tipeKamar = pilihTipeKamar(); // Menggunakan pilihTipeKamar untuk memilih tipe kamar

            daftarPasien.add(new Pasien(nama, umur, alamat, keluhan, tipeKamar));
            ruanganTerpakai++;
            System.out.println("Pasien berhasil didaftarkan dengan tipe kamar: " + tipeKamar);
        } else {
            System.out.println("Maaf, semua ruangan sudah penuh.");
        }
    }

    // Fitur 2: Menampilkan daftar pasien
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

    // Fitur 3: Cari pasien berdasarkan nama
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

    // Fitur 4: Edit data pasien
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
                scanner.nextLine();
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

    // Fitur 5: Hapus data pasien
    public static void hapusDataPasien() {
        System.out.print("Masukkan nama pasien yang ingin dihapus: ");
        String nama = scanner.nextLine();
        boolean ditemukan = false;
        for (int i = 0; i < daftarPasien.size(); i++) {
            if (daftarPasien.get(i).nama.equalsIgnoreCase(nama)) {
                daftarPasien.remove(i);
                ruanganTerpakai--;
                System.out.println("Pasien dengan nama " + nama + " berhasil dihapus.");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Pasien dengan nama " + nama + " tidak ditemukan.");
        }
    }

    // Fitur 6: Jumlah pasien terdaftar
    public static void jumlahPasien() {
        System.out.println("Jumlah pasien terdaftar: " + daftarPasien.size());
    }

    // Fitur 7: Cek ketersediaan ruangan
    public static void cekKetersediaanRuangan() {
        int ruanganTersedia = totalRuangan - ruanganTerpakai;
        if (ruanganTersedia > 0) {
            System.out.println("Tersedia " + ruanganTersedia + " ruangan.");
        } else {
            System.out.println("Tidak ada ruangan tersedia.");
        }
    }

    // Fitur 8: Lihat tipe kamar (untuk menampilkan pilihan kamar)
    public static void lihatTipeKamar() {
        System.out.println("\nTipe Kamar yang Tersedia:");
        System.out.println("1. Sederhana");
        System.out.println("2. Standar");
        System.out.println("3. VIP");
    }

    // Fitur memilih tipe kamar (untuk memilih saat pendaftaran pasien)
    public static String pilihTipeKamar() {
        String tipeKamar = null;
        while (true) {
            lihatTipeKamar(); // Tampilkan tipe kamar
            System.out.print("Masukkan pilihan tipe kamar: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            switch (pilihan) {
                case 1:
                    tipeKamar = "Sederhana";
                    break;
                case 2:
                    tipeKamar = "Standar";
                    break;
                case 3:
                    tipeKamar = "VIP";
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
                    continue;
            }
            break;
        }
        return tipeKamar;
    }

    // Fitur 9: Lihat kapasitas kamar
    public static void lihatKapasitasKamar() {
        int kapasitasSederhana = 4;
        int kapasitasStandar = 4;
        int kapasitasVIP = 2;

        System.out.println("\nKapasitas Kamar:");
        System.out.println("Sederhana: " + kapasitasSederhana + " kamar");
        System.out.println("Standar: " + kapasitasStandar + " kamar");
        System.out.println("VIP: " + kapasitasVIP + " kamar");
    }

    // Fitur 10: Clear screen
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                // Clear screen for Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Clear screen for Linux/MacOS
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Gagal membersihkan layar.");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nPilih opsi:");
            System.out.println("1. Pendaftaran Pasien Baru");
            System.out.println("2. Lihat Daftar Pasien");
            System.out.println("3. Cari Pasien");
            System.out.println("4. Edit Data Pasien");
            System.out.println("5. Hapus Data Pasien");
            System.out.println("6. Jumlah Pasien Terdaftar");
            System.out.println("7. Cek Ketersediaan Ruangan");
            System.out.println("8. Lihat Tipe Kamar");
            System.out.println("9. Lihat Kapasitas Kamar");
            System.out.println("10. Clear Screen");
            System.out.println("11. Keluar");

            System.out.print("Masukkan pilihan: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    pendaftaranPasienBaru();
                    break;
                case 2:
                    tampilkanDaftarPasien();
                    break;
                case 3:
                    cariPasien();
                    break;
                case 4:
                    editDataPasien();
                    break;
                case 5:
                    hapusDataPasien();
                    break;
                case 6:
                    jumlahPasien();
                    break;
                case 7:
                    cekKetersediaanRuangan();
                    break;
                case 8:
                    lihatTipeKamar();
                    break;
                case 9:
                    lihatKapasitasKamar();
                    break;
                case 10:
                    clearScreen();
                    break;
                case 11:
                    System.out.println("Program keluar.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }
}
