package model;

public class Akun {
    private String nama;
    private String email;
    private String alamat;

    public String getNama() {
        return this.nama;
    }

    public Akun setNama(String nama) {
        this.nama = nama;
        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public Akun setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public Akun setAlamat(String alamat) {
        this.alamat = alamat;
        return this;
    }

}
