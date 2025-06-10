package jerukperaspragita;

import java.util.Scanner;
import java.util.ArrayList;

public class JerukPerasPragita {

    // Data structures
    private static ArrayList<cAdmin> daftarAdmin = new ArrayList<>();
    private static ArrayList<cKasir> daftarKasir = new ArrayList<>();
    private static ArrayList<cMinuman> daftarMinuman = new ArrayList<>();
    private static ArrayList<cPembeli> daftarPembeli = new ArrayList<>();
    private static ArrayList<cOwner> daftarOwner = new ArrayList<>();
    private static ArrayList<cJerukPerasOri> daftarJerukOri = new ArrayList<>();
    private static ArrayList<cJerukPerasMadu> daftarJerukMadu = new ArrayList<>();
    private static ArrayList<cJerukPerasSusu> daftarJerukSusu = new ArrayList<>();
    private static ArrayList<cJerukPerasKelapa> daftarJerukKelapa = new ArrayList<>();
    private static ArrayList<cJerukPerasSirup> daftarJerukSirup = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    // Service classes
    static class AdminService {

        public static void crudAdmin() {
            int pilih;
            do {
                System.out.println("\nCRUD Admin");
                System.out.println("1.Daftar Admin\n2.Update Admin\n3.Hapus Admin\n4.Exit");
                System.out.print("Pilih = ");
                pilih = sc.nextInt();
                sc.nextLine();

                switch (pilih) {
                    case 1 ->
                        tampilkanAdmin();
                    case 2 ->
                        updateAdmin();
                    case 3 ->
                        hapusAdmin();
                }
            } while (pilih != 4);
        }

        private static void tampilkanAdmin() {
            System.out.println("\n== Lihat Data Admin ==");
            System.out.println("Ukuran daftarAdmin: " + daftarAdmin.size());
            if (daftarAdmin.isEmpty()) {
                System.out.println("Belum ada Admin yang terdaftar.");
            } else {
                for (cAdmin admin : daftarAdmin) {
                    System.out.println("---------------------------------");
                    admin.tampilkanInfo();
                }
            }

            System.out.print("\nCari data 1 admin berdasarkan ID? (y/n): ");
            String lanjut = sc.nextLine();
            if (lanjut.equalsIgnoreCase("y")) {
                cariAdminById();
            }
        }

        private static void cariAdminById() {
            System.out.println("== Lihat Admin Berdasarkan ID ==");
            System.out.print("Masukkan ID Admin: ");
            String idAdmin = sc.nextLine();

            cAdmin adminFind = null;
            for (cAdmin admin : daftarAdmin) {
                if (admin.getId().equalsIgnoreCase(idAdmin)) {
                    adminFind = admin;
                    break;
                }
            }

            if (adminFind != null) {
                System.out.println("\nAdmin ditemukan:");
                adminFind.tampilkanInfo();
            } else {
                System.out.println("Admin dengan ID " + idAdmin + " tidak ditemukan.");
            }
        }

        private static void updateAdmin() {
            System.out.println("== Update Admin ==");
            System.out.print("Masukkan ID Admin = ");
            String id = sc.nextLine();

            cAdmin adminDitemukan = null;
            for (cAdmin admin : daftarAdmin) {
                if (admin.getId().equalsIgnoreCase(id)) {
                    adminDitemukan = admin;
                    break;
                }
            }

            if (adminDitemukan != null) {
                System.out.print("Email Admin Baru = ");
                String emailBaru = sc.nextLine();
                System.out.print("Hak Akses Baru = ");
                String hakAksesBaru = sc.nextLine();

                System.out.println("Update? 1.Ya, 2.Tidak");
                System.out.print("Pilih = ");
                int pilih = sc.nextInt();
                sc.nextLine();

                if (pilih == 1) {
                    adminDitemukan.setEmail(emailBaru);
                    adminDitemukan.setHakAkses(hakAksesBaru);
                    System.out.println("Update Sukses!");
                }
            } else {
                System.out.println("Admin Tidak Ditemukan!");
            }
        }

        private static void hapusAdmin() {
            System.out.println("== Hapus Admin ==");
            System.out.print("Masukkan ID Admin = ");
            String id = sc.nextLine();

            cAdmin adminHapus = null;
            for (cAdmin admin : daftarAdmin) {
                if (admin.getId().equalsIgnoreCase(id)) {
                    adminHapus = admin;
                    break;
                }
            }

            if (adminHapus != null) {
                System.out.println("Hapus? 1.Ya, 2.Tidak");
                System.out.print("Pilih = ");
                int pilih = sc.nextInt();
                sc.nextLine();

                if (pilih == 1) {
                    daftarAdmin.remove(adminHapus);
                    System.out.println("Berhasil dihapus...");
                } else {
                    System.out.println("Batal dihapus...");
                }
            } else {
                System.out.println("Admin Tidak Ada!");
            }
        }
    }

    static class KasirService {

        public static void crudKasir() {
            int pilih;
            do {
                System.out.println("\nCRUD Kasir");
                System.out.println("1.Tambah Kasir\n2.Tampilkan Kasir\n3.Update Kasir\n4.Hapus Kasir\n5.Exit");
                System.out.print("Pilih = ");
                pilih = sc.nextInt();
                sc.nextLine();

                switch (pilih) {
                    case 1 ->
                        tambahKasir();
                    case 2 ->
                        tampilkanKasir();
                    case 3 ->
                        updateKasir();
                    case 4 ->
                        hapusKasir();
                }
            } while (pilih != 5);
        }

        private static void tambahKasir() {
            while (true) {
                System.out.println("\n== Tambah Kasir ==");
                System.out.print("ID Kasir          : ");
                String id = sc.nextLine();
                System.out.print("Nama Kasir        : ");
                String nama = sc.nextLine();
                System.out.print("Email Kasir       : ");
                String email = sc.nextLine();
                System.out.print("Password Kasir    : ");
                String p = sc.nextLine();
                System.out.print("Shift             : ");
                String shift = sc.nextLine();
                System.out.print("Total Pendapatan  : ");
                double tp = sc.nextDouble();
                sc.nextLine();
                System.out.print("History Pesanan   : ");
                String hp = sc.nextLine();

                cKasir pegawai = new cKasir(id, nama, email, p, shift, tp, hp);
                daftarKasir.add(pegawai);

                System.out.println("Ukuran daftarKasir: " + daftarKasir.size());
                System.out.print("\nTambah Kasir lagi? (y/n): ");
                String lanjut = sc.nextLine();
                if (!lanjut.equalsIgnoreCase("y")) {
                    break;
                }
            }
            System.out.println("\n== Daftar Kasir ==");
            for (cKasir kasir : daftarKasir) {
                kasir.tampilkanInfo();
            }
        }

        private static void tampilkanKasir() {
            System.out.println("\n== Lihat Data Kasir ==");
            System.out.println("Ukuran daftarKasir: " + daftarKasir.size());
            if (daftarKasir.isEmpty()) {
                System.out.println("Belum ada Kasir yang terdaftar.");
            } else {
                for (cKasir kasir : daftarKasir) {
                    System.out.println("---------------------------------");
                    kasir.tampilkanInfo();
                }
            }

            System.out.print("\nCari data 1 kasir berdasarkan ID? (y/n): ");
            String lanjut = sc.nextLine();
            if (lanjut.equalsIgnoreCase("y")) {
                cariKasirById();
            }
        }

        private static void cariKasirById() {
            System.out.println("== Lihat Kasir Berdasarkan ID ==");
            System.out.print("Masukkan ID Kasir: ");
            String idKasir = sc.nextLine();

            cKasir kasirFind = null;
            for (cKasir kasir : daftarKasir) {
                if (kasir.getId().equalsIgnoreCase(idKasir)) {
                    kasirFind = kasir;
                    break;
                }
            }

            if (kasirFind != null) {
                System.out.println("\nKasir ditemukan:");
                kasirFind.tampilkanInfo();
            } else {
                System.out.println("Kasir dengan ID " + idKasir + " tidak ditemukan.");
            }
        }

        private static void updateKasir() {
            System.out.println("== Update Kasir ==");
            System.out.print("Masukkan ID Kasir = ");
            String id = sc.nextLine();

            cKasir kasirDitemukan = null;
            for (cKasir kasir : daftarKasir) {
                if (kasir.getId().equalsIgnoreCase(id)) {
                    kasirDitemukan = kasir;
                    break;
                }
            }

            if (kasirDitemukan != null) {
                System.out.print("Email Kasir Baru = ");
                String email = sc.nextLine();
                System.out.print("Shift Kasir Baru = ");
                String shift = sc.nextLine();
                System.out.println("Update? 1.Ya, 2.Tidak");
                System.out.print("Pilih = ");
                int pilih = sc.nextInt();
                sc.nextLine();

                if (pilih == 1) {
                    kasirDitemukan.setEmail(email);
                    kasirDitemukan.setShift(shift);
                    System.out.println("Update Sukses!");
                }
            } else {
                System.out.println("Kasir Tidak Ditemukan!");
            }
        }

        private static void hapusKasir() {
            System.out.println("== Hapus Kasir ==");
            System.out.print("Masukkan ID Kasir = ");
            String id = sc.nextLine();

            cKasir kasirHapus = null;
            for (cKasir kasir : daftarKasir) {
                if (kasir.getId().equalsIgnoreCase(id)) {
                    kasirHapus = kasir;
                    break;
                }
            }

            if (kasirHapus != null) {
                System.out.println("Hapus? 1.Ya, 2.Tidak");
                System.out.print("Pilih = ");
                int pilih = sc.nextInt();
                sc.nextLine();

                if (pilih == 1) {
                    daftarKasir.remove(kasirHapus);
                    System.out.println("Berhasil dihapus...");
                } else {
                    System.out.println("Batal dihapus...");
                }
            } else {
                System.out.println("Kasir Tidak Ada!");
            }
        }
    }

    static class MinumanService {

        public static void crudMinuman() {
            int pilih;
            do {
                System.out.println("\nCRUD Minuman");
                System.out.println("1.Tambah Minuman\n2.Tampilkan Minuman\n3.Update Minuman\n4.Hapus Minuman\n5.Exit");
                System.out.print("Pilih = ");
                pilih = sc.nextInt();
                sc.nextLine();

                switch (pilih) {
                    case 1 ->
                        tambahMinuman();
                    case 2 ->
                        tampilkanMinuman();
                    case 3 ->
                        updateMinuman();
                    case 4 ->
                        hapusMinuman();
                }
            } while (pilih != 5);
        }

        private static void tambahMinuman() {
            while (true) {
                System.out.println("\n== Tambah Minuman ==");
                System.out.print("Nama Minuman      : ");
                String n = sc.nextLine();
                System.out.print("Harga Minuman     : ");
                int h = sc.nextInt();
                System.out.print("Stok              : ");
                int s = sc.nextInt();
                sc.nextLine();

                cMinuman es = new cMinuman(n, h, s);
                daftarMinuman.add(es);

                System.out.println("Ukuran daftarMinuman: " + daftarMinuman.size());
                System.out.print("\nTambah Minuman lagi? (y/n): ");
                String lanjut = sc.nextLine();

                if (!lanjut.equalsIgnoreCase("y")) {
                    break;
                }
            }
            System.out.println("\n== Daftar Minuman ==");
            for (cMinuman minuman : daftarMinuman) {
                minuman.tampilkanInfo();
            }
        }

        private static void tampilkanMinuman() {
            System.out.println("\n=== DAFTAR SEMUA MINUMAN ===");

            // Gabungkan semua daftar minuman
            ArrayList<cMinuman> semuaMinuman = new ArrayList<>();
            semuaMinuman.addAll(daftarMinuman);
            semuaMinuman.addAll(daftarJerukOri);    // Jeruk Original
            semuaMinuman.addAll(daftarJerukMadu);   // Jeruk Madu
            semuaMinuman.addAll(daftarJerukSusu);   // Jeruk Susu

            if (semuaMinuman.isEmpty()) {
                System.out.println("\nBelum ada minuman yang terdaftar.");
            } else {
                // Tampilkan semua minuman
                System.out.println("\nDaftar Lengkap:");
                for (cMinuman minuman : semuaMinuman) {
                    System.out.println("---------------------------------");
                    minuman.tampilkanInfo();  // Asumsi semua class punya method ini
                }
            }

            System.out.print("\n🔍 Cari minuman berdasarkan nama? (y/n): ");
            if (sc.nextLine().equalsIgnoreCase("y")) {
                System.out.print("Masukkan nama minuman: ");
                String keyword = sc.nextLine();

                semuaMinuman.stream()
                        .filter(m -> m.getNama().toLowerCase().contains(keyword.toLowerCase()))
                        .findFirst()
                        .ifPresentOrElse(
                                m -> {
                                    System.out.println("\nHasil ditemukan:");
                                    m.tampilkanInfo();
                                },
                                () -> System.out.println("\nMinuman tidak ditemukan!")
                        );
            }
        }

        public static void updateMinuman() {
            Scanner sc = new Scanner(System.in);

            // 1. Gabungkan semua daftar minuman
            ArrayList<cMinuman> semuaMinuman = new ArrayList<>();
            semuaMinuman.addAll(daftarMinuman);
            semuaMinuman.addAll(daftarJerukOri);
            semuaMinuman.addAll(daftarJerukMadu);
            semuaMinuman.addAll(daftarJerukSusu);

            // 2. Tampilkan daftar minuman
            System.out.println("\n=== DAFTAR MINUMAN ===");
            for (int i = 0; i < semuaMinuman.size(); i++) {
                cMinuman m = semuaMinuman.get(i);
                System.out.printf("%d. %-20s | Rp%,d | Stok: %d\n",
                        i + 1, m.getNama(), m.getHarga(), m.getStok());
            }

            // 3. Pilih minuman
            cMinuman minumanDipilih = null;
            while (true) {
                System.out.print("\nPilih nomor minuman (0 untuk batal): ");
                if (!sc.hasNextInt()) {
                    System.out.println("Input harus angka!");
                    sc.nextLine();
                    continue;
                }

                int pilihan = sc.nextInt();
                sc.nextLine();

                if (pilihan == 0) {
                    System.out.println("Update dibatalkan");
                    return;
                }

                if (pilihan < 1 || pilihan > semuaMinuman.size()) {
                    System.out.println("Nomor tidak valid!");
                    continue;
                }

                minumanDipilih = semuaMinuman.get(pilihan - 1);
                break;
            }

            // 4. Simpan nilai asli
            String namaAsli = minumanDipilih.getNama();
            int hargaAsli = minumanDipilih.getHarga();
            int stokAsli = minumanDipilih.getStok();

            // 5. Pilih field yang akan diupdate
            int field = 0;
            while (true) {
                System.out.println("\nMinuman: " + minumanDipilih.getNama());
                System.out.println("1. Update Nama");
                System.out.println("2. Update Harga");
                System.out.println("3. Update Stok");
                System.out.println("0. Batal");
                System.out.print("Pilih menu: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Input harus angka!");
                    sc.nextLine();
                    continue;
                }

                field = sc.nextInt();
                sc.nextLine();

                if (field >= 0 && field <= 3) {
                    break;
                }
                System.out.println("Pilihan tidak valid!");
            }

            if (field == 0) {
                System.out.println("Update dibatalkan");
                return;
            }

            // 6. Input nilai baru
            String namaBaru = namaAsli;
            int hargaBaru = hargaAsli;
            int stokBaru = stokAsli;

            switch (field) {
                case 1:
                    while (true) {
                        System.out.print("Masukkan nama baru: ");
                        namaBaru = sc.nextLine();
                        if (!namaBaru.trim().isEmpty()) {
                            break;
                        }
                        System.out.println("Nama tidak boleh kosong!");
                    }
                    break;

                case 2:
                    while (true) {
                        System.out.print("Masukkan harga baru: Rp");
                        if (!sc.hasNextInt()) {
                            System.out.println("Input harus angka!");
                            sc.nextLine();
                            continue;
                        }
                        hargaBaru = sc.nextInt();
                        sc.nextLine();
                        if (hargaBaru > 0) {
                            break;
                        }
                        System.out.println("Harga harus > 0!");
                    }
                    break;

                case 3:
                    while (true) {
                        System.out.print("Masukkan stok baru: ");
                        if (!sc.hasNextInt()) {
                            System.out.println("Input harus angka!");
                            sc.nextLine();
                            continue;
                        }
                        stokBaru = sc.nextInt();
                        sc.nextLine();
                        if (stokBaru >= 0) {
                            break;
                        }
                        System.out.println("Stok tidak boleh negatif!");
                    }
                    break;
            }

            // 7. Tampilkan preview
            System.out.println("\n=== PREVIEW PERUBAHAN ===");
            if (field == 1) {
                System.out.println("Nama: " + namaAsli + " → " + namaBaru);
            }
            if (field == 2) {
                System.out.println("Harga: Rp" + hargaAsli + " → Rp" + hargaBaru);
            }
            if (field == 3) {
                System.out.println("Stok: " + stokAsli + " → " + stokBaru);
            }

            // 8. Konfirmasi final
            System.out.print("\nSimpan perubahan? (y/n): ");
            String konfirmasi = sc.nextLine();

            if (konfirmasi.equalsIgnoreCase("y")) {
                // Apply changes
                if (field == 1) {
                    minumanDipilih.setNama(namaBaru);
                }
                if (field == 2) {
                    minumanDipilih.setHarga(hargaBaru);
                }
                if (field == 3) {
                    minumanDipilih.setStok(stokBaru);
                }

                System.out.println("✅ Update berhasil!");
                System.out.println("\nData terbaru:");
                minumanDipilih.tampilkanInfo();
            } else {
                System.out.println("❌ Update dibatalkan");
            }
        }

        private static void hapusMinuman() {
            Scanner sc = new Scanner(System.in);

            // 1. Gabungkan semua daftar minuman
            ArrayList<cMinuman> semuaMinuman = new ArrayList<>();
            semuaMinuman.addAll(daftarMinuman);
            semuaMinuman.addAll(daftarJerukOri);
            semuaMinuman.addAll(daftarJerukMadu);
            semuaMinuman.addAll(daftarJerukSusu);

            // 2. Tampilkan daftar minuman yang bisa dihapus
            System.out.println("\n=== DAFTAR MINUMAN ===");
            for (int i = 0; i < semuaMinuman.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, semuaMinuman.get(i).getNama());
            }

            // 3. Pilihan pencarian
            System.out.println("\n1. Hapus berdasarkan nomor");
            System.out.println("2. Hapus berdasarkan nama");
            System.out.print("Pilih metode: ");
            int metode = sc.nextInt();
            sc.nextLine();

            cMinuman minumanHapus = null;

            // 4. Proses pencarian
            if (metode == 1) {
                // Hapus berdasarkan nomor
                System.out.print("Masukkan nomor minuman: ");
                int nomor = sc.nextInt();
                sc.nextLine();

                if (nomor > 0 && nomor <= semuaMinuman.size()) {
                    minumanHapus = semuaMinuman.get(nomor - 1);
                }
            } else if (metode == 2) {
                // Hapus berdasarkan nama
                System.out.print("Masukkan nama minuman: ");
                String nama = sc.nextLine();

                for (cMinuman m : semuaMinuman) {
                    if (m.getNama().equalsIgnoreCase(nama)) {
                        minumanHapus = m;
                        break;
                    }
                }
            }

            // 5. Proses penghapusan
            if (minumanHapus != null) {
                System.out.println("\nMinuman yang akan dihapus:");
                minumanHapus.tampilkanInfo();

                System.out.print("\nYakin ingin menghapus? (y/n): ");
                String konfirmasi = sc.nextLine();

                if (konfirmasi.equalsIgnoreCase("y")) {
                    // Hapus dari daftar yang sesuai
                    if (daftarMinuman.contains(minumanHapus)) {
                        daftarMinuman.remove(minumanHapus);
                    } else if (daftarJerukOri.contains(minumanHapus)) {
                        daftarJerukOri.remove(minumanHapus);
                    } else if (daftarJerukMadu.contains(minumanHapus)) {
                        daftarJerukMadu.remove(minumanHapus);
                    } else if (daftarJerukSusu.contains(minumanHapus)) {
                        daftarJerukSusu.remove(minumanHapus);
                    }
                    System.out.println("✅ Minuman berhasil dihapus");
                } else {
                    System.out.println("❌ Penghapusan dibatalkan");
                }
            } else {
                System.out.println("Minuman tidak ditemukan!");
            }
        }
    }

    static class PembeliService {

        public static void crudPembeli() {
            int pilih;
            do {
                System.out.println("\nCRUD Pembeli");
                System.out.println("1.Tambah Pembeli\n2.Tampilkan Pembeli\n3.Update Pembeli\n4.Hapus Pembeli\n5.Exit");
                System.out.print("Pilih = ");
                pilih = sc.nextInt();
                sc.nextLine();

                switch (pilih) {
                    case 1 ->
                        tambahPembeli();
                    case 2 ->
                        tampilkanPembeli();
                    case 3 ->
                        updatePembeli();
                    case 4 ->
                        hapusPembeli();
                }
            } while (pilih != 5);
        }

        private static void tambahPembeli() {
            while (true) {
                System.out.println("\n== Tambah Pembeli ==");
                System.out.print("Nama Pembeli      : ");
                String n = sc.nextLine();
                System.out.print("Telp Pembeli      : ");
                String t = sc.nextLine();
                System.out.print("Kode Pembeli      : ");
                String a = sc.nextLine();

                cPembeli buyer = new cPembeli(n, t, a);
                daftarPembeli.add(buyer);

                System.out.println("Ukuran daftarPembeli: " + daftarPembeli.size());
                System.out.print("\nTambah Pembeli lagi? (y/n): ");
                String lanjut = sc.nextLine();
                if (!lanjut.equalsIgnoreCase("y")) {
                    break;
                }
            }
            System.out.println("\n== Daftar Pembeli ==");
            for (cPembeli pembeli : daftarPembeli) {
                pembeli.tampilkanInfo();
            }
        }

        private static void tampilkanPembeli() {
            System.out.println("\n== Lihat Data Pembeli ==");
            System.out.println("Ukuran daftarPembeli: " + daftarPembeli.size());
            if (daftarPembeli.isEmpty()) {
                System.out.println("Belum ada Pembeli yang terdaftar.");
            } else {
                for (cPembeli pembeli : daftarPembeli) {
                    System.out.println("---------------------------------");
                    pembeli.tampilkanInfo();
                }
            }

            System.out.print("\nCari data 1 pembeli berdasarkan Nama? (y/n): ");
            String lanjut = sc.nextLine();
            if (lanjut.equalsIgnoreCase("y")) {
                cariPembeliByNama();
            }
        }

        private static void cariPembeliByNama() {
            System.out.println("== Lihat Pembeli Berdasarkan Nama ==");
            System.out.print("Masukkan Nama Pembeli: ");
            String n = sc.nextLine();

            cPembeli pembeliFind = null;
            for (cPembeli pembeli : daftarPembeli) {
                if (pembeli.getNama().equalsIgnoreCase(n)) {
                    pembeliFind = pembeli;
                    break;
                }
            }

            if (pembeliFind != null) {
                System.out.println("\nPembeli ditemukan:");
                pembeliFind.tampilkanInfo();
            } else {
                System.out.println("Pembeli dengan nama " + n + " tidak ditemukan.");
            }
        }

        private static void updatePembeli() {
            System.out.println("== Update Pembeli ==");
            System.out.print("Masukkan Nama Pembeli Lama = ");
            String n = sc.nextLine();

            cPembeli pembeliDitemukan = null;
            for (cPembeli pembeli : daftarPembeli) {
                if (pembeli.getNama().equalsIgnoreCase(n)) {
                    pembeliDitemukan = pembeli;
                    break;
                }
            }

            if (pembeliDitemukan != null) {
                System.out.print("Nama Pembeli Baru = ");
                n = sc.nextLine();
                System.out.print("Telp Pembeli Baru = ");
                String t = sc.nextLine();

                System.out.println("Update? 1.Ya, 2.Tidak");
                System.out.print("Pilih = ");
                int pilih = sc.nextInt();
                sc.nextLine();

                if (pilih == 1) {
                    pembeliDitemukan.setNama(n);
                    pembeliDitemukan.setTelp(t);
                    System.out.println("Update Sukses!");
                }
            } else {
                System.out.println("Pembeli Tidak Ditemukan!");
            }
        }

        private static void hapusPembeli() {
            System.out.println("== Hapus Pembeli ==");
            System.out.print("Masukkan Nama Pembeli = ");
            String n = sc.nextLine();

            cPembeli pembeliHapus = null;
            for (cPembeli pembeli : daftarPembeli) {
                if (pembeli.getNama().equalsIgnoreCase(n)) {
                    pembeliHapus = pembeli;
                    break;
                }
            }

            if (pembeliHapus != null) {
                System.out.println("Hapus? 1.Ya, 2.Tidak");
                System.out.print("Pilih = ");
                int pilih = sc.nextInt();
                sc.nextLine();

                if (pilih == 1) {
                    daftarPembeli.remove(pembeliHapus);
                    System.out.println("Berhasil dihapus...");
                } else {
                    System.out.println("Batal dihapus...");
                }
            } else {
                System.out.println("Pembeli Tidak Ada!");
            }
        }
    }


    static class MenuPembeli {

        public static void menuPembeli() {
            int pilihCase4;
            do {
                System.out.println("\nMenu Pembeli");
                System.out.println("1.Beli Minuman");
                System.out.println("----------------");
                System.out.println("2.Exit");
                System.out.println("----------------");
                System.out.print("Pilih = ");
                pilihCase4 = sc.nextInt();
                sc.nextLine();

                switch (pilihCase4) {
                    case 1 ->
                        lihatMinuman();
                }
            } while (pilihCase4 != 2);
        }

        private static void lihatMinuman() {
            System.out.println("\n=== DAFTAR SEMUA MINUMAN ===");

            // Gabungkan semua daftar minuman
            ArrayList<cMinuman> semuaMinuman = new ArrayList<>();
            semuaMinuman.addAll(daftarMinuman);
            semuaMinuman.addAll(daftarJerukOri);    // Jeruk Original
            semuaMinuman.addAll(daftarJerukMadu);   // Jeruk Madu
            semuaMinuman.addAll(daftarJerukSusu);   // Jeruk Susu

            if (semuaMinuman.isEmpty()) {
                System.out.println("\nBelum ada minuman yang terdaftar.");
            } else {
                // Tampilkan semua minuman
                System.out.println("\nDaftar Lengkap:");
                for (cMinuman minuman : semuaMinuman) {
                    System.out.println("---------------------------------");
                    minuman.tampilkanInfo();  // Asumsi semua class punya method ini
                }
            }

            System.out.print("\n🔍 Cari minuman berdasarkan nama? (y/n): ");
            if (sc.nextLine().equalsIgnoreCase("y")) {
                System.out.print("Masukkan nama minuman: ");
                String keyword = sc.nextLine();

                semuaMinuman.stream()
                        .filter(m -> m.getNama().toLowerCase().contains(keyword.toLowerCase()))
                        .findFirst()
                        .ifPresentOrElse(
                                m -> {
                                    System.out.println("\nHasil ditemukan:");
                                    m.tampilkanInfo();
                                },
                                () -> System.out.println("\nMinuman tidak ditemukan!")
                        );
            }
        }
        private static void lihatPembeli() {
            System.out.println("\n== Lihat Data Pembeli ==");
            System.out.println("Ukuran daftarPembeli: " + daftarPembeli.size());
            if (daftarPembeli.isEmpty()) {
                System.out.println("Belum ada Pembeli yang terdaftar.");
            } else {
                for (cPembeli pembeli : daftarPembeli) {
                    System.out.println("---------------------------------");
                    pembeli.tampilkanInfo();
                }
            }

            System.out.print("\nCari data 1 pembeli berdasarkan Nama? (y/n): ");
            String lanjut = sc.nextLine();
            if (lanjut.equalsIgnoreCase("y")) {
                System.out.println("== Lihat Pembeli Berdasarkan Nama ==");
                System.out.print("Masukkan Nama Pembeli: ");
                String n = sc.nextLine();

                cPembeli pembeliFind = null;
                for (cPembeli pembeli : daftarPembeli) {
                    if (pembeli.getNama().equalsIgnoreCase(n)) {
                        pembeliFind = pembeli;
                        break;
                    }
                }

                if (pembeliFind != null) {
                    System.out.println("\nPembeli ditemukan:");
                    pembeliFind.tampilkanInfo();
                } else {
                    System.out.println("Pembeli dengan nama " + n + " tidak ditemukan.");
                }
            }
        }
    }

    public static void main(String[] args) {
        // Inisialisasi data
        String[][] dataMember = {
            {"M001", "passmember1"},
            {"M002", "passmember2"},
            {"M003", "passmember3"}
        };

        cAdmin pemilik = new cAdmin("A01", "Admin Satu", "admin1@gmail.com", "admin111", "manager 1");
        daftarAdmin.add(pemilik);
        pemilik = new cAdmin("A02", "Admin Dua", "admin2@gmail.com", "admin222", "manager 2");
        daftarAdmin.add(pemilik);
        pemilik = new cAdmin("A03", "Admin Tiga", "admin3@gmail.com", "admin333", "manager 3");
        daftarAdmin.add(pemilik);
        
        cOwner owner = new cOwner("01", "Owner Budi", "owner1@gmail.com", "owner111");
        daftarOwner.add(owner);
        owner = new cOwner("02", "Owner Tari", "owner2@gmail.com", "owner222");
        daftarOwner.add(owner);
        owner = new cOwner("03", "Owner Doni", "owner3@gmail.com", "owner333");
        daftarOwner.add(owner);

        cKasir pegawai = new cKasir("K01", "Kasir Satu", "kasir1@gmail.com", "kasir111", "pagi", 1000000, "es jeruk original");
        daftarKasir.add(pegawai);
        pegawai = new cKasir("K02", "Kasir Dua", "kasir2@gmail.com", "kasir222", "siang", 1500000, "es jeruk madu");
        daftarKasir.add(pegawai);
        pegawai = new cKasir("K03", "Kasir Tiga", "kasir3@gmail.com", "kasir333", "malam", 2000000, "es jeruk susu");
        daftarKasir.add(pegawai);

        cPembeli buyer = new cPembeli("Fida", "082333212", "P01");
        daftarPembeli.add(buyer);
        buyer = new cPembeli("Najwa", "034534535", "P02");
        daftarPembeli.add(buyer);
        buyer = new cPembeli("Evelin", "028989435", "P03");
        daftarPembeli.add(buyer);

        cJerukPerasOri jerukOri = new cJerukPerasOri("Es Jeruk Peras Original (Uk Kecil)", 5000, 20);
        daftarJerukOri.add(jerukOri);
        jerukOri = new cJerukPerasOri("Es Jeruk Peras Original (Uk Sedang)", 7000, 20);
        daftarJerukOri.add(jerukOri);
        jerukOri = new cJerukPerasOri("Es Jeruk Peras Original (Uk Jumbo)", 9000, 20);
        daftarJerukOri.add(jerukOri);

        cJerukPerasMadu jerukMadu = new cJerukPerasMadu("Es Jeruk Peras Madu (Uk Kecil)", 7000, 20);
        daftarJerukMadu.add(jerukMadu);
        jerukMadu = new cJerukPerasMadu("Es Jeruk Peras Madu (Uk Sedang)", 9000, 20);
        daftarJerukMadu.add(jerukMadu);
        jerukMadu = new cJerukPerasMadu("Es Jeruk Peras Madu (Uk Jumbo)", 11000, 20);
        daftarJerukMadu.add(jerukMadu);

        cJerukPerasSusu jerukSusu = new cJerukPerasSusu("Es Jeruk Peras Susu (Uk Kecil)", 9000, 20);
        daftarJerukSusu.add(jerukSusu);
        jerukSusu = new cJerukPerasSusu("Es Jeruk Peras Susu (Uk Sedang)", 11000, 20);
        daftarJerukSusu.add(jerukSusu);
        jerukSusu = new cJerukPerasSusu("Es Jeruk Peras Susu (Uk Jumbo)", 13000, 20);
        daftarJerukSusu.add(jerukSusu);

        // Main loop
        int pilih;
//        do {
//            System.out.println("\nAplikasi Jeruk Peras Pragita");
//            System.out.println("--------Menu Login--------");
//            System.out.println("Masukkan Email dan Password Anda: ");
//            System.out.print("Email : ");
//            String emailLogin = sc.nextLine();
//            System.out.print("Password : ");
//            String passwordLogin = sc.nextLine();
//
//            boolean loginBerhasil = false;
//
//            // Cek admin
//            for (cAdmin adm : daftarAdmin) {
//                if (adm.cocokLogin(emailLogin, passwordLogin)) {
//                    System.out.println("Anda Berhasil Login Sebagai " + adm.getNama());
//                    loginBerhasil = true;
//                    menuAdmin();
//                    break;
//                }
//            }
//
//            // Cek kasir
//            if (!loginBerhasil) {
//                for (cKasir kasir : daftarKasir) {
//                    if (kasir.cocokLogin(emailLogin, passwordLogin)) {
//                        System.out.println("Anda Berhasil Login Sebagai Kasir!");
//                        loginBerhasil = true;
//                        MenuKasir.menuKasir();
//                        break;
//                    }
//                }
//            }
//
//            if (!loginBerhasil) {
//                System.out.println("Login gagal! Email atau password salah.");
//            }
//        } while (true);
        while (true) {
            System.out.println("\n=== Aplikasi Jeruk Peras Pragita ===");
            System.out.println("Pilih Level Pengguna:");
            System.out.println("1. Pembeli");
            System.out.println("2. Member");
            System.out.println("3. Admin");
            System.out.println("4. Pemilik");
            System.out.println("5. Keluar");
            System.out.print("Pilihan Anda: ");
            String pilihan = sc.nextLine();

            switch (pilihan) {
                case "1": // Pembeli
                    System.out.print("Masukkan nama Anda: ");
                    String namaPembeli = sc.nextLine();
                    System.out.println("Selamat datang, " + namaPembeli + "!");
                    // Simpan namaPembeli ke variabel lokal, bisa digunakan lanjut ke menuPembeli()
                    MenuPembeli.menuPembeli();
                    break;

                case "2": // Member
                    System.out.print("Masukkan ID Member: ");
                    String idMember = sc.nextLine();
                    System.out.print("Masukkan Password: ");
                    String pwMember = sc.nextLine();

                    boolean loginMember = false;
                    for (String[] m : dataMember) {
                        if (m[0].equals(idMember) && m[1].equals(pwMember)) {
                            loginMember = true;
                            break;
                        }
                    }

                    if (loginMember) {
                        System.out.println("Login berhasil sebagai Member!");
                        // lanjut ke menuMember(idMember);
                    } else {
                        System.out.println("Login Gagal! ID atau Password salah.");
                    }
                    break;

                case "3": // Admin
                    System.out.print("Masukkan Email: ");
                    String emailAdmin = sc.nextLine();
                    System.out.print("Masukkan Password: ");
                    String pwAdmin = sc.nextLine();

                    boolean loginAdmin = false;
                    for (cAdmin adm : daftarAdmin) {
                        if (adm.cocokLogin(emailAdmin, pwAdmin)) {
                            System.out.println("Login berhasil sebagai Admin: " + adm.getNama());
                            loginAdmin = true;
                            // menuAdmin();
                            break;
                        }
                    }

                    if (!loginAdmin) {
                        System.out.println("Login Admin Gagal! Email atau Password salah.");
                    }
                    break;

                case "4": // Pemilik
                    System.out.print("Masukkan Email: ");
                    String emailPemilik = sc.nextLine();
                    System.out.print("Masukkan Password: ");
                    String pwPemilik = sc.nextLine();

                    boolean loginPemilik = false;
                    for (cOwner own : daftarOwner) {
                        if (own.getEmail().equals(emailPemilik) && own.getPassword().equals(pwPemilik)) {
                                System.out.println("Login berhasil sebagai Pemilik: " + own.getNama());
                                loginPemilik = true;
                                // menuPemilik();
                                break;
                        }
                    }

                    if (!loginPemilik) {
                        System.out.println("Login Pemilik Gagal! Email atau Password salah.");
                    }
                    break;

                case "5":
                    System.out.println("Terima kasih telah menggunakan aplikasi.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }

    private static void menuAdmin() {
        int pilihCase4;
        do {
            System.out.println("\nMenu Admin");
            System.out.println("1.CRUD Admin");
            System.out.println("----------------");
            System.out.println("2.CRUD Kasir");
            System.out.println("----------------");
            System.out.println("3.CRUD Minuman");
            System.out.println("----------------");
            System.out.println("4.CRUD Pembeli");
            System.out.println("----------------");
            System.out.println("5.Kembali ke menu utama");
            System.out.println("----------------");
            System.out.print("Pilih = ");
            pilihCase4 = sc.nextInt();
            sc.nextLine();

            switch (pilihCase4) {
                case 1 ->
                    AdminService.crudAdmin();
                case 2 ->
                    KasirService.crudKasir();
                case 3 ->
                    MinumanService.crudMinuman();
                case 4 ->
                    PembeliService.crudPembeli();
                case 5 -> {
                    return;
                }
            }
        } while (true);
    }
}
