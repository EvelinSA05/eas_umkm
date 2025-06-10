package jerukperaspragita;

public class cNota {

    private String kode;
    private cPembeli pembeli;
    private cMinuman[] minuman;
    private cKasir kasir;
    private int idx, size;
    private int[] jumlah;
    private double[] total;
    private double totalKeseluruhan;  // Tambahan field baru

    cNota(int s) {
        size = s;
        minuman = new cMinuman[size];
        jumlah = new int[size];
        total = new double[size];
        idx = 0;
        totalKeseluruhan = 0;  // Inisialisasi
    }

    // Tambahkan method baru untuk kebutuhan transaksi
    public void tambahBarang(cMinuman m, int j) {
        if (idx < size) {
            minuman[idx] = m;
            jumlah[idx] = j;
            total[idx] = m.getHarga() * j;
            totalKeseluruhan += total[idx];  // Update total keseluruhan
            idx++;
        } else {
            System.out.println("Nota penuh, tidak bisa menambah barang lagi");
        }
    }

    // Tambahkan method baru untuk menghapus barang
    public cMinuman hapusBarang(int index) {
        if (index < 0 || index >= idx) {
            return null;
        }

        cMinuman removed = minuman[index];

        // Geser elemen array
        for (int i = index; i < idx - 1; i++) {
            minuman[i] = minuman[i + 1];
            jumlah[i] = jumlah[i + 1];
            total[i] = total[i + 1];
        }

        idx--;
        return removed;
    }

    // Method tambahan untuk hitung total
    public double hitungTotal() {
        double total = 0;
        for (int i = 0; i < idx; i++) {
            total += this.total[i];
        }
        return total;
    }

    // Method tambahan untuk cek kosong
    public boolean isEmpty() {
        return idx == 0;
    }

    // Method getter tambahan
    public int getJumlahBarang() {
        return idx;
    }

    // Method getter untuk jumlah spesifik
    public int getJumlah(int index) {
        if (index >= 0 && index < idx) {
            return jumlah[index];
        }
        return 0;
    }

    public cMinuman getMinuman(int index) {
        if (index >= 0 && index < idx) {
            return minuman[index];
        }
        return null;
    }

    // Tetap pertahankan method utama yang sudah ada
    void setKode(String k) {
        kode = k;
    }

    void setPembeli(cPembeli p) {
        pembeli = p;
    }

    void setKasir(cKasir k) {
        kasir = k;
    }

    void setMinuman(cMinuman m, int j) {
        if (idx < size) {
            minuman[idx] = m;
            setJumlah(j);
            total[idx] = m.getHarga() * jumlah[idx];
            totalKeseluruhan += total[idx];  // Update total
            idx++;
        }
    }

    void setJumlah(int j) {
        jumlah[idx] = j;
    }

    String getKode() {
        return kode;
    }

    cMinuman[] getMinuman() {
        return minuman;
    }

    cPembeli getPembeli() {
        return pembeli;
    }

    cKasir getKasir() {
        return kasir;
    }

    // Perbaikan method ToString()
    public String[] ToString() {
        String[] daftar = new String[idx + 1];
        int totalKeseluruhan = 0;

        for (int i = 0; i < idx; i++) {
            // Format yang benar untuk menampilkan harga dan total
            daftar[i] = String.format("%-30s %3d x Rp%-,7d = Rp%-,7d",
                    minuman[i].getNama(),
                    jumlah[i],
                    minuman[i].getHarga(),
                    (int) total[i]); // Cast ke int jika harga sudah bulat
            totalKeseluruhan += total[i];
        }

        daftar[idx] = String.format("TOTAL: Rp%-,7d", totalKeseluruhan);
        return daftar;
    }
}
