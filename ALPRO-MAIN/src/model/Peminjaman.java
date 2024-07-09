package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Peminjaman {
    private String idPeminjaman;
    private Customer customer;
    private Librarian librarian;
    private LocalDate tanggal;
    private ArrayList<DetilPeminjaman> detilPeminjamans;
    private int total;

    public int getTotal() {
        return this.total;
    }

    public Peminjaman setTotal(int total) {
        this.total = total;
        return this;
    }

    public String getIdPeminjaman() {
        return this.idPeminjaman;
    }

    public Peminjaman setIdPeminjaman(String idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
        return this;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Peminjaman setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Librarian getLibrarian() {
        return this.librarian;
    }

    public Peminjaman setLibrarian(Librarian librarian) {
        this.librarian = librarian;
        return this;
    }

    public LocalDate getTanggal() {
        return this.tanggal;
    }

    public Peminjaman setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
        return this;
    }

    public ArrayList<DetilPeminjaman> getDetilPeminjamans() {
        return this.detilPeminjamans;
    }

    public Peminjaman setDetilPeminjamans(ArrayList<DetilPeminjaman> detilPeminjamans) {
        this.detilPeminjamans = detilPeminjamans;
        return this;
    }

}
