package models;

public class JadwalRoket extends JadwalPenerbangan implements Deskripsi {
    private String bahanBakar;

    public JadwalRoket(int id, String nama, String tujuan, String tanggal, String status, String bahanBakar) {
        super(id, nama, tujuan, tanggal, status);
        this.bahanBakar = bahanBakar;
    }

    public String getBahanBakar() { return bahanBakar; }
    public void setBahanBakar(String bahanBakar) { this.bahanBakar = bahanBakar; }

    @Override
    public void tampilkanInfo() {
        System.out.println("[ROKET] " + getId() + " | " + getNama() + " | " + getTujuan() +
                " | " + getTanggal() + " | " + getStatus() + " | Bahan Bakar: " + bahanBakar);
    }

    @Override
    public void tampilkanDeskripsi() {
        System.out.println("Deskripsi Roket: Roket digunakan untuk mengirim muatan ke luar angkasa.");
    }
}
