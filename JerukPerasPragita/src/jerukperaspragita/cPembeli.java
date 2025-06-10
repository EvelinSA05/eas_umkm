package jerukperaspragita;

/**
 *
 * @author EVELIN
 */
public class cPembeli extends cOrang {

    private String telp;
    private String kode;
    private double totalBelanja;

    public cPembeli() {  //default konstruktor
        super("Nama Tidak Diketahui");
        this.telp = "Belum Diketahui";
        this.kode = "Belum Diketahui";
    }

    cPembeli(String nama, String t, String k) { //parameter rized
        super(nama);
        this.telp = t;
        this.kode = k;
        this.totalBelanja = 0;
    }

    //setter
    public void tampilkanInfo() {
        System.out.println("\nNama          : " + getNama());
        System.out.println("Telp          : " + telp);
        System.out.println("Kode          : " + kode);
    }

    public void tambahTotalBelanja(double jumlah) {
        this.totalBelanja += jumlah;
    }

    public double getTotalBelanja() {
        return totalBelanja;
    }

    void setTelp(String t) {
        telp = t;
    }

    void setKode(String k) {
        kode = k;
    }

    //getter
    String getTelp() {
        return telp;
    }

    String getKode() {
        return kode;
    }

    @Override
    public String toString() {
        return "Nama Pembeli : " + nama
                + "\nTelepon      : " + telp
                + "\nKode Pembeli      : " + kode;
    }

}
