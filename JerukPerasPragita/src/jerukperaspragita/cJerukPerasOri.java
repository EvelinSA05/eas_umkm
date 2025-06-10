package jerukperaspragita;

import java.util.ArrayList;

/**
 *
 * @author EVELIN
 */
public class cJerukPerasOri extends cMinuman {

    // Konstruktor tanpa parameter (default)
    public cJerukPerasOri() {
        super("", 0, 0); // Memanggil konstruktor parent dengan nilai default
    }

    public cJerukPerasOri(String nama, int harga, int stok) { //parameter rized
        super(nama, harga, stok);
    }

    //setter
    public void tampilkanInfo() {
        System.out.println("Nama Minuman 1 : " + getNama());
        System.out.println("Harga          : " + getHarga());
        System.out.println("Stok           : " + getStok());
        System.out.println("------------------------------");
    }
}
