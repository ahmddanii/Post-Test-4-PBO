
---

# Sistem Manajemen Jadwal Peluncuran Roket NASA 🚀

Nama    : **Ahmad Dani**

NIM     : **2409116074**

Kelas   : **B**

---

## 📌 Deskripsi Program

Program ini adalah sebuah sistem CRUD (**Create, Read, Update, Delete**) sederhana yang digunakan untuk memanajemen **jadwal peluncuran roket NASA** (National Aeronautics and Space Administration).

Program dibuat menggunakan **Java** dengan konsep:

* **Encapsulation** (getter & setter)
* **Inheritance** (superclass & subclass)
* **Overriding** (method `tampilkanInfo` di-override oleh subclass)

---

## 📂 Struktur Program

<img width="280" height="204" alt="image" src="https://github.com/user-attachments/assets/77c49251-8920-463b-913e-006f098ca8a0" />


---

## 🏗️ Penjelasan Class  

1. `main/Main.java`  
- Berisi **entry point** (`public static void main`).  
- Menyediakan menu utama untuk user agar bisa mengakses fitur CRUD jadwal.  

2. `model/JadwalPenerbangan.java`  
- **Abstract class (kelas induk)** untuk semua jenis jadwal.  
- Memiliki atribut umum: `id`, `nama`, `tujuan`, `tanggal`, `status`.  
- Dilengkapi dengan **getter dan setter** (encapsulation).  
- Memiliki **abstract method** `tampilkanInfo()` yang wajib dioverride oleh subclass.  

3. `model/Deskripsi.java`  
- Sebuah **interface**.  
- Berisi method abstrak `tampilkanDeskripsi()`.  
- Diimplementasikan oleh class `JadwalRoket` dan `JadwalSatelit`.  

4. `model/JadwalRoket.java`  
- **Subclass** dari `JadwalPenerbangan`, sekaligus **mengimplementasi interface Deskripsi**.  
- Menambahkan atribut khusus roket yaitu `bahanBakar`.  
- Melakukan **overriding** pada `tampilkanInfo()`.  
- Mengimplementasikan `tampilkanDeskripsi()`.  

5. `model/JadwalSatelit.java`  
- **Subclass** dari `JadwalPenerbangan`, sekaligus **mengimplementasi interface Deskripsi**.  
- Menambahkan atribut khusus satelit yaitu `jenisSatelit`.  
- Melakukan **overriding** pada `tampilkanInfo()`.  
- Mengimplementasikan `tampilkanDeskripsi()`.  

6. `service/JadwalService.java`  
- Menangani **CRUD (Create, Read, Update, Delete)** data jadwal.  
- Fitur yang tersedia: `tambahJadwal()`, `lihatJadwal()`, `updateJadwal()`, `hapusJadwal()`, dan `cariJadwal()`.  
- **Polymorphism overloading**: terdapat 2 method `cariJadwal()`  
  - `cariJadwal(String nama)`  
  - `cariJadwal(int id)`  
- **Polymorphism overriding**: pemanggilan `tampilkanInfo()` akan menyesuaikan apakah objek berupa `Roket` atau `Satelit`.  

---

## 🔹 Abstraction
Penerapan **Abstraction** pada program ini ada pada:  
1. `JadwalPenerbangan` → **abstract class** yang tidak dapat diinstansiasi langsung.  
   - Method abstrak `tampilkanInfo()` dipaksa untuk diimplementasikan oleh subclass.  
2. `Deskripsi` → **interface** yang berisi method `tampilkanDeskripsi()`.  
   - Diimplementasikan oleh `JadwalRoket` dan `JadwalSatelit`.  

Dengan abstraction, class turunan wajib melengkapi fungsi tertentu sesuai blueprint, sehingga program lebih terstruktur.

---

## 🔹 Polymorphism

### **1. Overriding**  
Terjadi pada method `tampilkanInfo()` di class `JadwalRoket` dan `JadwalSatelit`.  
Contoh:  

```java
// JadwalRoket
@Override
public void tampilkanInfo() {
    System.out.println("[ROKET] " + getId() + " | " + getNama() + " | " + getTujuan() +
            " | " + getTanggal() + " | " + getStatus() + " | Bahan Bakar: " + bahanBakar);
}
```
---

Namun pada subclass, method ini ditulis ulang (dioverride) agar bisa menampilkan data tambahan sesuai kebutuhan:
- `JadwalRoket`
```java
@Override
public void tampilkanInfo() {
    System.out.println("[ROKET] " + getId() + " | " + getNama() + " | " + getTujuan() +
            " | " + getTanggal() + " | " + getStatus() + " | Bahan Bakar: " + bahanBakar);
}
```
Menampilkan informasi roket dengan tambahan Jenis Bahan Bakar.

- `JadwalSatelit`
```java
@Override
public void tampilkanInfo() {
    System.out.println("[SATELIT] " + getId() + " | " + getNama() + " | " + getTujuan() +
            " | " + getTanggal() + " | " + getStatus() + " | Jenis: " + jenisSatelit);
}
```
Menampilkan informasi satelit dengan tambahan Jenis Satelit.
Dengan penerapan @Override, saat program memanggil:
```java
jp.tampilkanInfo();
```

### 2.Overloading
Terjadi pada method cariJadwal() di JadwalService.
```java
// Cari berdasarkan nama
public void cariJadwal(String nama) { ... }

// Cari berdasarkan ID
public void cariJadwal(int id) { ... }
```

---
## ⚙️ Alur Program

### 1. Menu Utama

<img width="670" height="428" alt="menu-utama" src="https://github.com/user-attachments/assets/aaa04c14-6800-46b9-9a71-3ee71596c3dc" />

program akan menampilkan daftar pilihan operasi yang bisa dilakukan, mulai dari menambah, melihat, memperbarui, menghapus, mencari jadwal roket, hingga keluar dari program. User hanya perlu memilih dengan memasukkan angka sesuai menu yang diinginkan.

---

### 2. Tambah Jadwal Penerbangan

**Tambah Jadwal Roket**

<img width="656" height="783" alt="image" src="https://github.com/user-attachments/assets/ff9880b1-8580-43e9-8e19-b1b452dbf440" />

**Tambah Jadwal Satelit**

<img width="657" height="794" alt="image" src="https://github.com/user-attachments/assets/80b7dc2e-5e8c-4f73-9936-7044070ef581" />


Menu ini digunakan untuk menambahkan data baru ke sistem. User bisa memilih menambahkan roket atau satelit, lalu mengisi detail seperti ID, nama, tujuan, tanggal, status, dan data tambahan sesuai jenis.

---

### 3. Lihat Jadwal Penerbangan

<img width="859" height="516" alt="image" src="https://github.com/user-attachments/assets/743156cb-0a1a-4b63-b0f5-d2b033930848" />


Menu Lihat Jadwal Penerbangan, seluruh data penerbangan yang sudah tersimpan akan ditampilkan. Informasi yang muncul meliputi ID, nama roket, tujuan, tanggal, dan status peluncuran. Jika belum ada data yang disimpan, sistem akan memberi tahu bahwa jadwal masih kosong.

---

### 4. Perbarui Jadwal Penerbangan

<img width="855" height="777" alt="image" src="https://github.com/user-attachments/assets/d89968f4-a2d5-4e73-9e77-df1ead715997" />


Menu Perbarui Jadwal Penerbangan, user harus memasukkan ID roket yang ingin diperbarui. Setelah itu, sistem memberikan pilihan untuk memperbarui nama, tujuan, tanggal, atau status roket. Perubahan yang dilakukan akan langsung tersimpan dan bisa dilihat kembali pada menu lihat jadwal.

---

### 5. Hapus Jadwal Penerbangan

<img width="824" height="569" alt="image" src="https://github.com/user-attachments/assets/945786e8-be69-4b0b-8103-5ec410dd4181" />

Selanjutnya, di Menu Hapus Jadwal Penerbangan, user dapat menghapus jadwal dengan memasukkan ID penerbangan tertentu. Jika ID tersebut ada dalam list, maka data akan dihapus, namun jika tidak ditemukan, sistem akan menampilkan pesan error.

---

### 6. Cari Jadwal Roket

<img width="832" height="471" alt="image" src="https://github.com/user-attachments/assets/e324e05f-d3b9-4a29-b26d-1e17d56c6980" />

Kemudian, Menu Cari Jadwal Roket memungkinkan user mencari jadwal tertentu berdasarkan ID. Jika ditemukan, detail informasi roket akan ditampilkan, tetapi jika tidak, sistem akan menampilkan pesan bahwa data tidak ditemukan.

---

### 7. Keluar

<img width="668" height="476" alt="keluar" src="https://github.com/user-attachments/assets/0bd7b9ef-0b05-4b19-acf8-f842609df16a" />

Terakhir, Menu Keluar digunakan untuk menutup program. Saat user memilih menu ini, sistem akan menghentikan proses dan menampilkan pesan terima kasih sebagai penutup.

---

