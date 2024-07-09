package model;

public class DetilPeminjaman {
    private String idDetilPeminjaman;
    private Peminjaman peminjaman;
    private Buku buku;
    private int jumlahPeminjaman;

    public String getIdDetilPeminjaman() {
        return this.idDetilPeminjaman;
    }

    public void setIdDetilPeminjaman(String idDetilPeminjaman) {
        this.idDetilPeminjaman = idDetilPeminjaman;
    }

    public Peminjaman getPeminjaman() {
        return this.peminjaman;
    }

    public void setPeminjaman(Peminjaman peminjaman) {
        this.peminjaman = peminjaman;
    }

    public Buku getBuku() {
        return this.buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public int getJumlahPeminjaman() {
        return this.jumlahPeminjaman;
    }

    public void setJumlahPeminjaman(int jumlahPeminjaman) {
        this.jumlahPeminjaman = jumlahPeminjaman;
    }

}
