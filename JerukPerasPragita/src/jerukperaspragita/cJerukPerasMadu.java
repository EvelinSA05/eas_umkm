package jerukperaspragita;

import java.util.ArrayList;

/**
 *
 * @author EVELIN
 */
public class cJerukPerasMadu extends cMinuman {

    // Konstruktor tanpa parameter (default)
    public cJerukPerasMadu() {
        super("", 0, 0); // Memanggil konstruktor parent dengan nilai default
    }

    public cJerukPerasMadu(String nama, int harga, int stok) { //parameter rized
        super(nama, harga, stok);
    }

    //setter
    public void tampilkanInfo() {
        System.out.println("Nama Minuman 2 : " + getNama());
        System.out.println("Harga          : " + getHarga());
        System.out.println("Stok           : " + getStok());
        System.out.println("------------------------------");
    }
}
