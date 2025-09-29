package service;

import java.util.ArrayList;
import java.util.Scanner;
import models.*;

public class JadwalService {
    private ArrayList<JadwalPenerbangan> daftarJadwal = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    // Overloading → cari berdasarkan nama
    public void cariJadwal(String nama) {
        boolean ditemukan = false;
        for (JadwalPenerbangan jp : daftarJadwal) {
            if (jp.getNama().equalsIgnoreCase(nama)) {
                jp.tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("⚠ Jadwal dengan nama " + nama + " tidak ditemukan.");
        }
    }

    // Overloading → cari berdasarkan ID
    public void cariJadwal(int id) {
        boolean ditemukan = false;
        for (JadwalPenerbangan jp : daftarJadwal) {
            if (jp.getId() == id) {
                jp.tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("⚠ Jadwal dengan ID " + id + " tidak ditemukan.");
        }
    }
    
    public void tambahJadwal() {
        System.out.println("\n===== Tambah Jadwal Penerbangan =====");
        System.out.println("Pilih jenis jadwal yang ingin ditambahkan:");
        System.out.println("[1] Roket");
        System.out.println("[2]️ Satelit");
        System.out.print("Masukkan pilihan: ");
        int jenis = input.nextInt(); 
        input.nextLine();

        System.out.print("Masukkan ID: ");
        int id = input.nextInt(); 
        input.nextLine();

        // Validasi ID unik
        for (JadwalPenerbangan jp : daftarJadwal) {
            if (jp.getId() == id) {
                System.out.println("⚠ ID sudah digunakan, silakan coba lagi!");
                return;
            }
        }

        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan Tujuan: ");
        String tujuan = input.nextLine();
        System.out.print("Masukkan Tanggal (dd-mm-yyyy): ");
        String tanggal = input.nextLine();
        System.out.print("Masukkan Status (Terjadwal/Ditunda/Selesai): ");
        String status = input.nextLine();

        if (jenis == 1) {
            System.out.println("=== Detail Roket ===");
            System.out.print("Masukkan Jenis Bahan Bakar: ");
            String bahanBakar = input.nextLine();
            daftarJadwal.add(new JadwalRoket(id, nama, tujuan, tanggal, status, bahanBakar));
            System.out.println("✅ Jadwal Roket berhasil ditambahkan!");
        } else if (jenis == 2) {
            System.out.println("=== Detail Satelit ===");
            System.out.print("Masukkan Jenis Satelit: ");
            String jenisSatelit = input.nextLine();
            daftarJadwal.add(new JadwalSatelit(id, nama, tujuan, tanggal, status, jenisSatelit));
            System.out.println("✅ Jadwal Satelit berhasil ditambahkan!");
        } else {
            System.out.println("⚠ Pilihan tidak valid! Jadwal gagal ditambahkan.");
        }
    }

    public void lihatJadwal() {
        if (daftarJadwal.isEmpty()) {
            System.out.println("⚠ Belum ada jadwal penerbangan!");
        } else {
            System.out.println("\n----- Daftar Jadwal Roket -----");
            for (JadwalPenerbangan jr : daftarJadwal) {
                jr.tampilkanInfo();
            }
        }
    }

    public void updateJadwal() {
        lihatJadwal();
        if (daftarJadwal.isEmpty()) return;

        System.out.print("Masukkan ID yang ingin diupdate: ");
        int updateId = input.nextInt(); input.nextLine();

        for (JadwalPenerbangan jr : daftarJadwal) {
            if (jr.getId() == updateId) {
                System.out.println("Pilih yang ingin diubah:");
                System.out.println("[1] Nama");
                System.out.println("[2] Tujuan");
                System.out.println("[3] Tanggal");
                System.out.println("[4] Status");
                System.out.println("[5] Jenis Bahan Bakar");
                System.out.print("Pilihan: ");
                int pilih = input.nextInt(); input.nextLine();

                switch (pilih) {
                    case 1 -> { System.out.print("Nama baru: "); jr.setNama(input.nextLine()); }
                    case 2 -> { System.out.print("Tujuan baru: "); jr.setTujuan(input.nextLine()); }
                    case 3 -> { System.out.print("Tanggal baru: "); jr.setTanggal(input.nextLine()); }
                    case 4 -> { System.out.print("Status baru: "); jr.setStatus(input.nextLine()); }
                    case 5 -> { if (jr instanceof JadwalRoket roket) {
                                    System.out.print("Bahan bakar baru: ");
                                    roket.setBahanBakar(input.nextLine());
                                } else if (jr instanceof JadwalSatelit satelit) {
                                    System.out.print("Jenis Satelit baru: ");
                                    satelit.setJenisSatelit(input.nextLine());
                                } else {
                                    System.out.println("⚠ Atribut khusus tidak tersedia untuk jenis ini!");
                                } 
                    }
                    default -> { System.out.println("⚠ Pilihan tidak valid!"); return; }
                }
                System.out.println("✅ Jadwal berhasil diperbarui!");
                return;
            }
        }
        System.out.println("⚠ ID tidak ditemukan!");
    }

    public void hapusJadwal() {
        lihatJadwal();
        if (daftarJadwal.isEmpty()) return;

        System.out.print("Masukkan ID yang ingin dihapus: ");
        int hapusId = input.nextInt(); input.nextLine();

        for (int i = 0; i < daftarJadwal.size(); i++) {
            if (daftarJadwal.get(i).getId() == hapusId) {
                daftarJadwal.remove(i);
                System.out.println("✅ Jadwal berhasil dihapus!");
                return;
            }
        }
        System.out.println("⚠ Jadwal tidak ditemukan!");
    }

    public void cariJadwal() {
        System.out.print("Masukkan nama roket untuk dicari: ");
        String keyword = input.nextLine().toLowerCase();

        boolean ditemukan = false;
        for (JadwalPenerbangan jr : daftarJadwal) {
            if (jr.getNama().toLowerCase().contains(keyword)) {
                jr.tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("⚠ Tidak ditemukan!");
        }
    }
}
  