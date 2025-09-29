package models;

public class JadwalSatelit extends JadwalPenerbangan implements Deskripsi {
    private String jenisSatelit;

    public JadwalSatelit(int id, String nama, String tujuan, String tanggal, String status, String jenisSatelit) {
        super(id, nama, tujuan, tanggal, status);
        this.jenisSatelit = jenisSatelit;
    }

    public String getJenisSatelit() { return jenisSatelit; }
    public void setJenisSatelit(String jenisSatelit) { this.jenisSatelit = jenisSatelit; }

    @Override
    public void tampilkanInfo() {
        System.out.println("[SATELIT] " + getId() + " | " + getNama() + " | " + getTujuan() +
                " | " + getTanggal() + " | " + getStatus() + " | Jenis: " + jenisSatelit);
    }

    @Override
    public void tampilkanDeskripsi() {
        System.out.println("Deskripsi Satelit: Satelit digunakan untuk komunikasi, cuaca, atau penginderaan jauh.");
    }
}
