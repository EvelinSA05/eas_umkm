package jerukperaspragita;

import java.util.*;

public class JerukPerasPragitaNota {

    private static int counterTransaksi = 1;
    private static ArrayList<cPembeli> daftarPembeli = new ArrayList<>();
    private static int totalPendapatanHarian = 0;
    private static Map<String, Integer> pemasukanPerBarang = new HashMap<>();
    private static double totalNonPelanggan = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Data awal pelanggan
        daftarPembeli.add(new cPembeli("Budi", "0812345678", "P001"));
        daftarPembeli.add(new cPembeli("Ani", "0812987654", "P002"));
        daftarPembeli.add(new cPembeli("Tina", "0812987654", "P003"));

        pemasukanPerBarang.put("Es Jeruk Original Kecil", 0);
        pemasukanPerBarang.put("Es Jeruk Original Sedang", 0);

        // Inisialisasi menu minuman
        cJerukPerasOri kecilOri = new cJerukPerasOri("Es Jeruk Original Kecil", 5000, 20);
        cJerukPerasOri sedangOri = new cJerukPerasOri("Es Jeruk Original Sedang", 7000, 20);
        cJerukPerasOri besarOri = new cJerukPerasOri("Es Jeruk Original Besar", 9000, 20);

        cJerukPerasMadu kecilMadu = new cJerukPerasMadu("Es Jeruk Madu Kecil", 7000, 20);
        cJerukPerasMadu sedangMadu = new cJerukPerasMadu("Es Jeruk Madu Sedang", 9000, 20);
        cJerukPerasMadu besarMadu = new cJerukPerasMadu("Es Jeruk Madu Besar", 11000, 20);

        cJerukPerasSusu kecilSusu = new cJerukPerasSusu("Es Jeruk Susu Kecil", 9000, 20);
        cJerukPerasSusu sedangSusu = new cJerukPerasSusu("Es Jeruk Susu Sedang", 11000, 20);
        cJerukPerasSusu besarSusu = new cJerukPerasSusu("Es Jeruk Susu Besar", 13000, 20);

        pemasukanPerBarang.put("Es Jeruk Original Kecil", 0);
        pemasukanPerBarang.put("Es Jeruk Original Sedang", 0);
        pemasukanPerBarang.put("Es Jeruk Original Besar", 0);
        pemasukanPerBarang.put("Es Jeruk Madu Kecil", 0);
        pemasukanPerBarang.put("Es Jeruk Madu Sedang", 0);
        pemasukanPerBarang.put("Es Jeruk Madu Besar", 0);
        pemasukanPerBarang.put("Es Jeruk Susu Kecil", 0);
        pemasukanPerBarang.put("Es Jeruk Susu Sedang", 0);
        pemasukanPerBarang.put("Es Jeruk Susu Besar", 0);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Transaksi Baru");
            System.out.println("2. Master Pembeli");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    // Buat transaksi baru
                    String noTransaksi = "TRX-" + String.format("%03d", counterTransaksi++);
                    System.out.println("\nNomor Transaksi: " + noTransaksi);

                    // Input nama pelanggan
                    System.out.print("Masukkan Nama Pelanggan (kosongkan jika non-pelanggan): ");
                    String namaPelanggan = sc.nextLine().trim();

                    cPembeli pembeli = null;
                    if (!namaPelanggan.isEmpty()) {
                        for (cPembeli p : daftarPembeli) {
                            if (p.getNama().equalsIgnoreCase(namaPelanggan)) {
                                pembeli = p;
                                break;
                            }
                        }
                        if (pembeli == null) {
                            System.out.println("Nama pelanggan tidak ditemukan! (Dianggap non-pelanggan)");
                        }
                    }

                    // Jika tidak ada nama pelanggan, buat pembeli baru (non-pelanggan)
                    if (pembeli == null) {
                        System.out.print("Masukkan Nama Pembeli: ");
                        String namaPembeli = sc.nextLine();
                        pembeli = new cPembeli(namaPembeli, "-", "-" + counterTransaksi);
                    }

                    cNota nota = new cNota(10);
                    nota.setKode(noTransaksi);
                    nota.setPembeli(pembeli);

                    prosesTransaksi(nota, sc, kecilOri, sedangOri, besarOri,
                            kecilMadu, sedangMadu, besarMadu,
                            kecilSusu, sedangSusu, besarSusu);
                    break;
                case 2:
                    menuMasterPembeli(sc);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
        System.out.println("Terima kasih telah menggunakan sistem!");
    }

    private static void menuMasterPembeli(Scanner sc) {
        boolean kembali = false;
        while (!kembali) {
            System.out.println("\n=== MASTER PEMBELI ===");
            System.out.println("1. Tambah Pembeli");
            System.out.println("2. Ubah Pembeli");
            System.out.println("3. Hapus Pembeli");
            System.out.println("4. Lihat Data Pembeli");
            System.out.println("5. Kembali");
            System.out.print("Pilih menu: ");
            int pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    tambahPembeli(sc);
                    break;
                case 2:
                    ubahPembeli(sc);
                    break;
                case 3:
                    hapusPembeli(sc);
                    break;
                case 4:
                    lihatPembeli();
                    break;
                case 5:
                    kembali = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void tambahPembeli(Scanner sc) {
        System.out.println("\n--- Tambah Pembeli Baru ---");
        System.out.print("Nama: ");
        String nama = sc.nextLine();
        System.out.print("No. Telepon: ");
        String telepon = sc.nextLine();
        System.out.print("Kode Pembeli: ");
        String kode = sc.nextLine();

        daftarPembeli.add(new cPembeli(nama, telepon, kode));
        System.out.println("Data pembeli berhasil ditambahkan!");
    }

    private static void ubahPembeli(Scanner sc) {
        lihatPembeli();
        System.out.print("\nMasukkan nomor pembeli yang akan diubah: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < daftarPembeli.size()) {
            cPembeli p = daftarPembeli.get(index);
            System.out.print("Nama baru [" + p.getNama() + "]: ");
            String nama = sc.nextLine();
            if (!nama.isEmpty()) {
                p.setNama(nama);
            }

            System.out.print("Telepon baru [" + p.getTelp() + "]: ");
            String telepon = sc.nextLine();
            if (!telepon.isEmpty()) {
                p.setTelp(telepon);
            }

            System.out.print("Kode baru [" + p.getKode() + "]: ");
            String kode = sc.nextLine();
            if (!kode.isEmpty()) {
                p.setNama(kode);
            }

            System.out.println("Data berhasil diupdate!");
        } else {
            System.out.println("Nomor tidak valid!");
        }
    }

    private static void hapusPembeli(Scanner sc) {
        lihatPembeli();
        System.out.print("\nMasukkan nomor pembeli yang akan dihapus: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < daftarPembeli.size()) {
            System.out.print("Yakin hapus " + daftarPembeli.get(index).getNama() + "? (Y/T): ");
            if (sc.nextLine().equalsIgnoreCase("Y")) {
                daftarPembeli.remove(index);
                System.out.println("Data berhasil dihapus!");
            }
        } else {
            System.out.println("Nomor tidak valid!");
        }
    }

    private static void lihatPembeli() {
        System.out.println("\n--- Daftar Pembeli ---");
        System.out.println("No. | Kode\t| Nama\t\t| Telepon");
        for (int i = 0; i < daftarPembeli.size(); i++) {
            cPembeli p = daftarPembeli.get(i);
            System.out.printf("%2d. | %s\t| %-10s\t| %s\n",
                    i + 1, p.getKode(), p.getNama(), p.getTelp());
        }
    }

    private static void prosesTransaksi(cNota nota, Scanner sc,
            cJerukPerasOri kecilOri, cJerukPerasOri sedangOri, cJerukPerasOri besarOri,
            cJerukPerasMadu kecilMadu, cJerukPerasMadu sedangMadu, cJerukPerasMadu besarMadu,
            cJerukPerasSusu kecilSusu, cJerukPerasSusu sedangSusu, cJerukPerasSusu besarSusu) {
        boolean selesai = false;
        while (!selesai) {
            System.out.println("\n=== MENU TRANSAKSI ===");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Hapus Barang");
            System.out.println("3. Lihat Nota");
            System.out.println("4. Bayar");
            System.out.println("5. Lihat Laporan");
            System.out.println("6. Lihat Daftar Total Biaya");
            System.out.println("7. Kembali");
            System.out.print("Pilih menu: ");
            int pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    tambahBarang(nota, sc, kecilOri, sedangOri, besarOri,
                            kecilMadu, sedangMadu, besarMadu,
                            kecilSusu, sedangSusu, besarSusu);
                    break;
                case 2:
                    hapusBarang(nota, sc);
                    break;
                case 3:
                    lihatNota(nota);
                    break;
                case 4:
                    bayar(nota, sc);
                    selesai = true;
                    break;
                case 5:
                    tampilkanLaporan();
                    break;
                case 6:
                    tampilkanLaporan2();
                    break;
                case 7:
                    //batalkanTransaksi(nota);
                    selesai = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void tambahBarang(cNota nota, Scanner sc,
            cJerukPerasOri kecilOri, cJerukPerasOri sedangOri, cJerukPerasOri besarOri,
            cJerukPerasMadu kecilMadu, cJerukPerasMadu sedangMadu, cJerukPerasMadu besarMadu,
            cJerukPerasSusu kecilSusu, cJerukPerasSusu sedangSusu, cJerukPerasSusu besarSusu) {
        boolean tambahLagi = true;
        while (tambahLagi) {
            System.out.println("\n=== DAFTAR MENU ===");
            System.out.println("1. " + kecilOri.getNama() + " - Rp" + kecilOri.getHarga());
            System.out.println("2. " + sedangOri.getNama() + " - Rp" + sedangOri.getHarga());
            System.out.println("3. " + besarOri.getNama() + " - Rp" + besarOri.getHarga());
            System.out.println("4. " + kecilMadu.getNama() + " - Rp" + kecilMadu.getHarga());
            System.out.println("5. " + sedangMadu.getNama() + " - Rp" + sedangMadu.getHarga());
            System.out.println("6. " + besarMadu.getNama() + " - Rp" + besarMadu.getHarga());
            System.out.println("7. " + kecilSusu.getNama() + " - Rp" + kecilSusu.getHarga());
            System.out.println("8. " + sedangSusu.getNama() + " - Rp" + sedangSusu.getHarga());
            System.out.println("9. " + besarSusu.getNama() + " - Rp" + besarSusu.getHarga());
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

            int pilih = sc.nextInt();
            if (pilih == 0) {
                tambahLagi = false;
                continue;
            }

            cMinuman selected = null;
            switch (pilih) {
                case 1:
                    selected = kecilOri;
                    break;
                case 2:
                    selected = sedangOri;
                    break;
                case 3:
                    selected = besarOri;
                    break;
                case 4:
                    selected = kecilMadu;
                    break;
                case 5:
                    selected = sedangMadu;
                    break;
                case 6:
                    selected = besarMadu;
                    break;
                case 7:
                    selected = kecilSusu;
                    break;
                case 8:
                    selected = sedangSusu;
                    break;
                case 9:
                    selected = besarSusu;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    continue;
            }

            System.out.print("Masukkan jumlah: ");
            int jumlah = sc.nextInt();

            if (jumlah > 0 && jumlah <= selected.getStok()) {
                nota.setMinuman(selected, jumlah);
                selected.setStok(selected.getStok() - jumlah);
                System.out.println("Berhasil ditambahkan!");
                lihatNota(nota);
            } else {
                System.out.println("Jumlah tidak valid atau stok tidak cukup!");
            }

            System.out.print("Tambah barang lagi? (Y/T): ");
            String lanjut = sc.next();
            tambahLagi = lanjut.equalsIgnoreCase("Y");
        }
    }

    private static void hapusBarang(cNota nota, Scanner sc) {
        if (nota.getJumlahBarang() == 0) {
            System.out.println("Nota kosong!");
            return;
        }

        lihatNota(nota);
        System.out.print("Masukkan nomor barang yang akan dihapus: ");
        int nomor = sc.nextInt() - 1;
        sc.nextLine();  // Consume newline

        if (nomor >= 0 && nomor < nota.getJumlahBarang()) {
            System.out.print("Yakin ingin menghapus? (Y/T): ");
            String confirm = sc.nextLine();

            if (confirm.equalsIgnoreCase("Y")) {
                cMinuman removed = nota.hapusBarang(nomor);
                if (removed != null) {
                    removed.setStok(removed.getStok() + nota.getJumlah(nomor));
                    System.out.println("Barang berhasil dihapus");
                }
            } else {
                System.out.println("Penghapusan dibatalkan");
            }
        } else {
            System.out.println("Nomor barang tidak valid!");
        }
    }

    private static void lihatNota(cNota nota) {
        System.out.println("\n=== NOTA PEMBELIAN ===");
        System.out.println("No. Transaksi: " + nota.getKode());
        System.out.println("Nama Pembeli: " + nota.getPembeli().getNama());

        // Tampilkan status pelanggan
        boolean isPelanggan = false;
        for (cPembeli p : daftarPembeli) {
            if (p.getNama().equals(nota.getPembeli().getNama())) {
                isPelanggan = true;
                break;
            }
        }
        System.out.println("Status: " + (isPelanggan ? "Pelanggan (Diskon 10%)" : "Non-Pelanggan"));

        System.out.println("----------------------------------");

        String[] items = nota.ToString();
        for (String item : items) {
            System.out.println(item);
        }

        System.out.println("----------------------------------");
        System.out.printf("SUBTOTAL: Rp%,d%n", (int) nota.hitungTotal());
    }

    private static void tampilkanLaporan() {
        System.out.println("\n=== LAPORAN HARIAN ===");
        System.out.println("Total pendapatan: " + totalPendapatanHarian);

        pemasukanPerBarang.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                });
    }

    private static void bayar(cNota nota, Scanner sc) {
        if (nota == null || nota.getJumlahBarang() == 0) {
            System.out.println("Tidak ada barang yang dibeli!");
            return;
        }

        lihatNota(nota);
        double total = nota.hitungTotal();

        // 1. CEK PELANGGAN (HANYA YANG SUDAH TERDAFTAR DI AWAL)
        boolean isPelanggan = daftarPembeli.stream()
                .anyMatch(p -> p.getNama().equalsIgnoreCase(nota.getPembeli().getNama()));

        // 2. DISKON 10% JIKA TERDAFTAR
        if (isPelanggan) {
            double diskon = total * 0.1;
            System.out.printf("Diskon 10%%: -Rp%,d%n", (int) diskon);
            total -= diskon;
        }

        System.out.printf("TOTAL: Rp%,d%n", (int) total);
        System.out.print("Masukkan uang pembayaran: Rp");
        double bayar = sc.nextDouble();

        if (bayar >= total) {
            System.out.printf("Kembalian: Rp%,d%n", (int) (bayar - total));

            // 3. TIDAK MENYIMPAN PEMBELI BARU KE DAFTAR
            if (!isPelanggan) {
                totalNonPelanggan += total;
            } else {
                // Update total belanja pelanggan terdaftar
                final double finalTotal = total;
                daftarPembeli.stream()
                        .filter(p -> p.getNama().equalsIgnoreCase(nota.getPembeli().getNama()))
                        .findFirst()
                        .ifPresent(p -> p.tambahTotalBelanja(finalTotal));
            }

            // 4. UPDATE PEMASUKAN BARANG
            for (int i = 0; i < nota.getJumlahBarang(); i++) {
                cMinuman barang = nota.getMinuman(i);
                int subtotal = barang.getHarga() * nota.getJumlah(i);
                pemasukanPerBarang.put(barang.getNama(),
                        pemasukanPerBarang.getOrDefault(barang.getNama(), 0) + subtotal);
                totalPendapatanHarian += subtotal;
            }
        } else {
            System.out.println("Uang pembayaran kurang!");
            batalkanTransaksi(nota);
        }
    }

    private static void tampilkanLaporan2() {
        System.out.println("\n=== DAFTAR TOTAL BELANJA PELANGGAN ===");

        // 1. Hitung total belanja pelanggan terdaftar
        Map<String, Double> totalPelanggan = new HashMap<>();
        for (cPembeli p : daftarPembeli) {
            totalPelanggan.merge(
                    p.getNama(),
                    p.getTotalBelanja(),
                    Double::sum
            );
        }

        // 2. Urutkan dari nominal terbesar
        List<Map.Entry<String, Double>> pelangganTerurut = new ArrayList<>(totalPelanggan.entrySet());
        pelangganTerurut.sort(Map.Entry.<String, Double>comparingByValue().reversed());

        // 3. Tampilkan pelanggan terdaftar
        int no = 1;
        for (Map.Entry<String, Double> entry : pelangganTerurut) {
            System.out.printf("%d. %s : Rp%,d%n",
                    no++, entry.getKey(), entry.getValue().intValue());
        }

        // 4. Tampilkan total non-pelanggan
        System.out.printf("%d. [Non-pelanggan] : Rp%,d%n",
                no, (int) totalNonPelanggan);

    }

    private static void batalkanTransaksi(cNota nota) {
        for (int i = 0; i < nota.getJumlahBarang(); i++) {
            cMinuman m = nota.getMinuman(i);
            m.setStok(m.getStok() + nota.getJumlah(i));
        }
        System.out.println("Transaksi dibatalkan. Stok dikembalikan.");
    }
}
