package models;

public abstract class JadwalPenerbangan {
    private int id;
    private String nama;
    private String tujuan;
    private String tanggal;
    private String status;

    public JadwalPenerbangan(int id, String nama, String tujuan, String tanggal, String status) {
        this.id = id;
        this.nama = nama;
        this.tujuan = tujuan;
        this.tanggal = tanggal;
        this.status = status;
    }

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getTujuan() { return tujuan; }
    public void setTujuan(String tujuan) { this.tujuan = tujuan; }

    public String getTanggal() { return tanggal; }
    public void setTanggal(String tanggal) { this.tanggal = tanggal; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Abstract method → wajib dioverride
    public abstract void tampilkanInfo();
}
