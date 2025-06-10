package jerukperaspragita;

import java.util.ArrayList;

/**
 *
 * @author EVELIN
 */
public class cJerukPerasSusu extends cMinuman {

    // Konstruktor tanpa parameter (default)
    public cJerukPerasSusu() {
        super("", 0, 0); // Memanggil konstruktor parent dengan nilai default
    }

    public cJerukPerasSusu(String nama, int harga, int stok) { //parameter rized
        super(nama, harga, stok);
    }

    //setter
    public void tampilkanInfo() {
        System.out.println("Nama Minuman 3   : " + getNama());
        System.out.println("Harga            : " + getHarga());
        System.out.println("Stok             : " + getStok());
        System.out.println("------------------------------");
    }
}
