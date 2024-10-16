import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    String name;
    int age;
    String gender;

    public Patient(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Gender: " + gender;
    }
}

class Room {
    String type;
    int capacity;
    int available;

    public Room(String type, int capacity, int available) {
        this.type = type;
        this.capacity = capacity;
        this.available = available;
    }

    public String toString() {
        return "Type: " + type + ", Capacity: " + capacity + ", Available: " + available;
    }
}

public class Helloword {
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeRooms();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Pendaftaran Pasien Baru");
            System.out.println("2. Lihat Daftar Pasien");
            System.out.println("3. Cari Pasien Berdasarkan Nama");
            System.out.println("4. Edit Data Pasien");
            System.out.println("5. Hapus Pasien");
            System.out.println("6. Jumlah Pasien Terdaftar");
            System.out.println("7. Cek Ketersediaan Ruangan");
            System.out.println("8. Pilih Tipe Kamar");
            System.out.println("9. Lihat Kapasitas Kamar");
            System.out.println("10. Clear Screen");
            System.out.println("11. Jadwal Kunjungan");
            System.out.println("12. Keluar dari Program");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    registerPatient(scanner);
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    searchPatient(scanner);
                    break;
                case 4:
                    editPatient(scanner);
                    break;
                case 5:
                    deletePatient(scanner);
                    break;
                case 6:
                    countPatients();
                    break;
                case 7:
                    checkRoomAvailability();
                    break;
                case 8:
                    selectRoomType(scanner);
                    break;
                case 9:
                    viewRoomCapacity();
                    break;
                case 10:
                    clearScreen();
                    break;
                case 11:
                    viewVisitingSchedule();
                    break;
                case 12:
                    System.out.println("Keluar dari program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    public static void initializeRooms() {
        rooms.add(new Room("VIP", 2, 1));
        rooms.add(new Room("Standard", 4, 2));
        rooms.add(new Room("Economy", 6, 3));
    }

    public static void registerPatient(Scanner scanner) {
        System.out.print("Masukkan nama pasien: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan umur pasien: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Masukkan jenis kelamin pasien (M/F): ");
        String gender = scanner.nextLine();
        patients.add(new Patient(name, age, gender));
        System.out.println("Pasien berhasil didaftarkan!");
    }

    public static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("Tidak ada pasien terdaftar.");
        } else {
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }

    public static void searchPatient(Scanner scanner) {
        System.out.print("Masukkan nama pasien: ");
        String name = scanner.nextLine();
        for (Patient patient : patients) {
            if (patient.name.equalsIgnoreCase(name)) {
                System.out.println(patient);
                return;
            }
        }
        System.out.println("Pasien tidak ditemukan.");
    }

    public static void editPatient(Scanner scanner) {
        System.out.print("Masukkan nama pasien yang akan diedit: ");
        String name = scanner.nextLine();
        for (Patient patient : patients) {
            if (patient.name.equalsIgnoreCase(name)) {
                System.out.print("Masukkan nama baru: ");
                patient.name = scanner.nextLine();
                System.out.print("Masukkan umur baru: ");
                patient.age = scanner.nextInt();
                scanner.nextLine(); // consume newline
                System.out.print("Masukkan jenis kelamin baru (M/F): ");
                patient.gender = scanner.nextLine();
                System.out.println("Data pasien berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Pasien tidak ditemukan.");
    }

    public static void deletePatient(Scanner scanner) {
        System.out.print("Masukkan nama pasien yang akan dihapus: ");
        String name = scanner.nextLine();
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).name.equalsIgnoreCase(name)) {
                patients.remove(i);
                System.out.println("Pasien berhasil dihapus!");
                return;
            }
        }
        System.out.println("Pasien tidak ditemukan.");
    }

    public static void countPatients() {
        System.out.println("Jumlah pasien terdaftar: " + patients.size());
    }

    public static void checkRoomAvailability() {
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    public static void selectRoomType(Scanner scanner) {
        System.out.print("Masukkan tipe kamar yang dipilih (VIP/Standard/Economy): ");
        String type = scanner.nextLine();
        for (Room room : rooms) {
            if (room.type.equalsIgnoreCase(type)) {
                if (room.available > 0) {
                    room.available--;
                    System.out.println("Kamar berhasil dipilih.");
                } else {
                    System.out.println("Kamar penuh.");
                }
                return;
            }
        }
        System.out.println("Tipe kamar tidak ditemukan.");
    }

    public static void viewRoomCapacity() {
        for (Room room : rooms) {
            System.out.println(room.type + " kapasitas: " + room.capacity);
        }
    }

    public static void clearScreen() {
        // This will just simulate clear screen by printing multiple new lines.
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void viewVisitingSchedule() {
        System.out.println("Jadwal kunjungan adalah setiap hari pukul 10:00 hingga 18:00.");
    }
}
