package main;

import java.util.Scanner;
import service.JadwalService;

public class Main {
    
  
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        JadwalService service = new JadwalService();

        int pilihan;
        do {
            System.out.println("-----------------------------------------------------------");
            System.out.println("|    .__   __.      ___           _______.     ___        |");
            System.out.println("|    |  \\ |  |     /   \\         /       |    /   \\       |");
            System.out.println("|    |   \\|  |    /  ^  \\       |   (----`   /  ^  \\      |");
            System.out.println("|    |  . `  |   /  /_\\  \\       \\   \\      /  /_\\  \\     |");
            System.out.println("|    |  |\\   |  /  _____  \\  .----)   |    /  _____  \\    |");
            System.out.println("|    |__| \\__| /__/     \\__\\ |_______/    /__/     \\__\\   |");
            System.out.println();
            System.out.println("|     NASA - Sistem Manajemen Jadwal Penerbangan Roket    |");
            System.out.println("-----------------------------------------------------------");
            System.out.println("[1] Tambah jadwal penerbangan");
            System.out.println("[2] Lihat jadwal penerbangan");
            System.out.println("[3] Perbarui jadwal penerbangan");
            System.out.println("[4] Hapus jadwal penerbangan");
            System.out.println("[5] Cari jadwal penerbangan");
            System.out.println("[6] Keluar");
            System.out.print("Pilih menu: ");

            while (!input.hasNextInt()) {
                System.out.println("⚠ Input harus angka!");
                input.next();
            }
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1 -> service.tambahJadwal();
                case 2 -> service.lihatJadwal();
                case 3 -> service.updateJadwal();
                case 4 -> service.hapusJadwal();
                case 5 -> service.cariJadwal();
                case 6 -> System.out.println("Terima kasih!");
                default -> System.out.println("⚠ Menu tidak tersedia!");
            }
        } while (pilihan != 6);

        input.close();
     }
}

