import java.util.ArrayList;
import java.util.Scanner;

public class JadwalKunjungan {
    static class Pasien {
        String nama;
        int umur;
        String alamat;
        String keluhan;
        String tipeKamar;
        String dokterPilihan;

        public Pasien(String nama, int umur, String alamat, String keluhan, String tipeKamar, String dokterPilihan) {
            this.nama = nama;
            this.umur = umur;
            this.alamat = alamat;
            this.keluhan = keluhan;
            this.tipeKamar = tipeKamar;
            this.dokterPilihan = dokterPilihan;
        }

        @Override
        public String toString() {
            return "Nama: " + nama + ", Umur: " + umur + ", Alamat: " + alamat +
                    ", Keluhan: " + keluhan + ", Tipe Kamar: " + tipeKamar +
                    ", Dokter: " + dokterPilihan;
        }
    }

    static ArrayList<Pasien> daftarPasien = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int totalRuangan = 10;
    static int ruanganTerpakai = 0;

    // Daftar Dokter
    static String[] daftarDokter = {
            "Dr. Siburian (Poli Gigi)", "Dr. Lupita (Poli Gigi)", "Dr. Oji (Radiologi)",
            "Dr. Yohanes (Poli Mata)", "Dr. Artha (Jantung)", "Dr. Delon (THT)",
            "Dr. Arthur (Penyakit Dalam)", "Dr. Samuel (Dokter Umum)"
    };

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

            // Panggil fitur pilih tipe kamar
            String tipeKamar = pilihTipeKamar();

            // Panggil fitur pilih dokter
            String dokter = pilihDokter();

            // Tambahkan pasien ke daftar
            daftarPasien.add(new Pasien(nama, umur, alamat, keluhan, tipeKamar, dokter));
            ruanganTerpakai++;
            System.out.println("Pasien berhasil didaftarkan dengan tipe kamar: " + tipeKamar +
                    " dan dokter: " + dokter);
        } else {
            System.out.println("Maaf, semua ruangan sudah penuh.");
        }
    }

    // Fitur 2: Menampilkan daftar pasien
    public static void tampilkanDaftarPasien() {
        if (daftarPasien.isEmpty()) {
            System.out.println("Belum ada pasien yang terdaftar.");
        } else {
            System.out.println("Daftar Pasien:");
            for (Pasien pasien : daftarPasien) {
                System.out.println(pasien);
            }
        }
    }

    // Fitur 3: Mencari pasien berdasarkan nama
    public static void cariPasien() {
        System.out.print("Masukkan nama pasien yang dicari: ");
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
            System.out.println("Pasien dengan nama tersebut tidak ditemukan.");
        }
    }

    // Fitur 4: Mengedit data pasien
    public static void editDataPasien() {
        System.out.print("Masukkan nama pasien yang ingin diedit: ");
        String nama = scanner.nextLine();
        Pasien pasienDitemukan = null;

        for (Pasien pasien : daftarPasien) {
            if (pasien.nama.equalsIgnoreCase(nama)) {
                pasienDitemukan = pasien;
                break;
            }
        }

        if (pasienDitemukan != null) {
            System.out.print("Masukkan nama baru (tekan Enter untuk melewati): ");
            String namaBaru = scanner.nextLine();
            if (!namaBaru.isEmpty()) {
                pasienDitemukan.nama = namaBaru;
            }

            System.out.print("Masukkan umur baru (0 jika tidak ingin mengubah): ");
            int umurBaru = scanner.nextInt();
            if (umurBaru != 0) {
                pasienDitemukan.umur = umurBaru;
            }
            scanner.nextLine();

            System.out.print("Masukkan alamat baru (tekan Enter untuk melewati): ");
            String alamatBaru = scanner.nextLine();
            if (!alamatBaru.isEmpty()) {
                pasienDitemukan.alamat = alamatBaru;
            }

            System.out.print("Masukkan keluhan baru (tekan Enter untuk melewati): ");
            String keluhanBaru = scanner.nextLine();
            if (!keluhanBaru.isEmpty()) {
                pasienDitemukan.keluhan = keluhanBaru;
            }

            System.out.println("Data pasien berhasil diubah.");
        } else {
            System.out.println("Pasien dengan nama " + nama + " tidak ditemukan.");
        }
    }

    // Fitur 5: Menghapus data pasien
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
            System.out.println("Pasien dengan nama tersebut tidak ditemukan.");
        }
    }

    // Fitur 6: Menampilkan jumlah pasien
    public static void jumlahPasien() {
        System.out.println("Jumlah pasien terdaftar: " + daftarPasien.size());
    }

    // Fitur 7: Mengecek ketersediaan ruangan
    public static void cekKetersediaanRuangan() {
        int ruanganTersedia = totalRuangan - ruanganTerpakai;
        if (ruanganTersedia > 0) {
            System.out.println("Tersedia " + ruanganTersedia + " ruangan.");
        } else {
            System.out.println("Tidak ada ruangan tersedia.");
        }
    }

    // Fitur 8: Menampilkan tipe kamar
    public static void lihatTipeKamar() {
        System.out.println("\nTipe Kamar yang Tersedia:");
        System.out.println("1. Sederhana");
        System.out.println("2. Standar");
        System.out.println("3. VIP");
    }

    // Fitur 9: memilih tipe kamar
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

    // Fitur 10: melihat daftar dokter
    public static void lihatDaftarDokter() {
        System.out.println("\nDaftar Dokter yang Tersedia:");
        for (int i = 0; i < daftarDokter.length; i++) {
            System.out.println((i + 1) + ". " + daftarDokter[i]);
        }
    }

    public static String pilihDokter() {
        String dokter = null;
        while (true) {
            lihatDaftarDokter(); // Tampilkan daftar dokter
            System.out.print("Masukkan nomor dokter yang ingin dipilih: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            if (pilihan >= 1 && pilihan <= daftarDokter.length) {
                dokter = daftarDokter[pilihan - 1];
                break;
            } else {
                System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
        return dokter;
    }

    // Fitur 11: Menampilkan jadwal kunjungan
    public static void jadwalKunjungan() {
        System.out.println("Jadwal kunjungan rumah sakit:");
        System.out.println("Senin - Minggu: 10:00 - 18:00");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n****** PENDAFTARAN PASIEN RUMAH SAKIT ******");
            System.out.println("\nPilih opsi :");
            System.out.println("1. Pendaftaran Pasien Baru");
            System.out.println("2. Lihat Daftar Pasien");
            System.out.println("3. Cari Pasien");
            System.out.println("4. Edit Data Pasien");
            System.out.println("5. Hapus Data Pasien");
            System.out.println("6. Jumlah Pasien Terdaftar");
            System.out.println("7. Cek Ketersediaan Ruangan");
            System.out.println("8. Lihat Tipe Kamar");
            System.out.println("9. Lihat Kapasitas Kamar");
            System.out.println("10. Lihat Daftar Dokter");
            System.out.println("11. Lihat Jadwal Kunjungan");
            System.out.println("12. Keluar Dari Program");
            System.out.print("Masukkan opsi ke-: ");

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
                    cekKetersediaanRuangan();
                    break;
                case 10:
                    lihatDaftarDokter();
                    break;
                case 11:
                    jadwalKunjungan();
                    break;
                case 12:
                    System.out.println("Keluar dari program.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
    }
}
