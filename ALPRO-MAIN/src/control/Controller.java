package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Buku;
import model.DetilPeminjaman;
import model.Customer;
import model.Librarian;
import model.Peminjaman;

public class Controller {
    HashMap<String, Buku> bukus = new HashMap();
    ArrayList<Peminjaman> peminjamans = new ArrayList<>();
    HashMap<String, Customer> customers = new HashMap();
    HashMap<String, Librarian> librarians = new HashMap();

    public void setUp() {
        Buku buku1 = new Buku();
        Buku buku2 = new Buku();
        Buku buku3 = new Buku();
        buku1.setISBN("0419965661").setTitle("Tanah Para Bandit").setAuthor("Teere Liye").setAvailability(true).setIdBUku("01");
        buku2.setISBN("0688384692").setTitle("Pulang Pergi").setAuthor("Tere Liye").setAvailability(true).setIdBUku("02");
        buku3.setISBN("0401730794").setTitle("Negeri Para Bedebah").setAuthor("Tere Liye").setAvailability(true).setIdBUku("03");

        bukus.put(buku1.getIdBUku(), buku1);
        bukus.put(buku2.getIdBUku(), buku2);
        bukus.put(buku3.getIdBUku(), buku3);

        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        customer1.setidCustomer("01").setNama("Aziz").setAlamat("Bandung").setEmail("Jeff2014@gmail.com");
        customer2.setidCustomer("02").setNama("Ariel").setAlamat("Bandung").setEmail("Will1606@gmail.com");
        customers.put(customer1.getidCustomer(),customer1);
        customers.put(customer2.getidCustomer(),customer2);

        Librarian librarian1 = new Librarian();
        Librarian librarian2 = new Librarian();
        librarian1.setIdLibrarian("01").setNama("James").setAlamat("Bandung").setEmail("Roxanne1954@gmail.com");
        librarian2.setIdLibrarian("02").setNama("Abdul").setAlamat("Bandung").setEmail("Carlson1920@gmail.com");
        librarians.put(librarian1.getIdLibrarian(),librarian1);
        librarians.put(librarian2.getIdLibrarian(),librarian2);
    }

    public void DaftarBuku() {
        System.out.println("\n=====|Daftar Buku|=====");
        for (Map.Entry<String,Buku> buku : bukus.entrySet()) {
            String key = buku.getKey();
            Buku tBuku = buku.getValue();
            if (tBuku.isAvailability()) {
                System.out.println("ID Buku \t : "+key);
                System.out.println("ISBN \t\t : "+tBuku.getISBN());
                System.out.println("Judul \t\t : "+tBuku.getTitle());
                System.out.println("Penulis \t : "+tBuku.getAuthor());
                System.out.println("");
            }
        }
    }

    public Buku getBuku(String idBuku){
        return bukus.get(idBuku);
    }
    
    public Librarian getLibrarian(String idLibrarian){
        return librarians.get(idLibrarian);
    }

    public Customer getCustomer(String idCustomer){
        return customers.get(idCustomer);
    }

    public void Pinjam(){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<DetilPeminjaman> tDetilPeminjamans = new ArrayList<>();
        int increment = 0;
        String cont = "";
        try{
            do {
                increment++;
                System.out.println("\nSilahkan masukan ID Buku :");
                String kodeBuku = input.readLine();
                System.out.println("Jumlah dipinjam \t : ");
                int jumlah = Integer.valueOf(input.readLine());
                System.out.println("Kembali meminjam(Y/N)? \t :");
                cont = input.readLine();

                DetilPeminjaman dp = new DetilPeminjaman();
                Buku tBuku = getBuku(kodeBuku);
                dp.setIdDetilPeminjaman("dp"+increment);
                dp.setBuku(tBuku);
                dp.setJumlahPeminjaman(jumlah);
                tDetilPeminjamans.add(dp);
            } while (cont.equalsIgnoreCase("Y"));
            System.out.println("\n=====|Daftar Peminjaman|=====");
            tmplknDaftarPeminjaman(tDetilPeminjamans);
            BufferedReader inputConfirmation = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Konfirmasi peminjaman (Y/N)?");
            String confirm = "n";
            confirm = inputConfirmation.readLine();
            if (confirm.equalsIgnoreCase("y")) {
                Peminjaman peminjaman = new Peminjaman();
                peminjaman.setDetilPeminjamans(tDetilPeminjamans).setIdPeminjaman("L"+peminjamans.size()+1).setCustomer(getCustomer("02")).setLibrarian(getLibrarian("01")).setTanggal(LocalDate.now()).setTotal(TotalPeminjaman(tDetilPeminjamans));
                peminjamans.add(peminjaman);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            }
    }

    public void tmplknDaftarPeminjaman(ArrayList<DetilPeminjaman> dp){
        for (DetilPeminjaman detilPeminjaman : dp) {
            System.out.println("Judul Buku : "+detilPeminjaman.getBuku().getTitle());
            System.out.println("Jumlah \t\t : "+detilPeminjaman.getJumlahPeminjaman()+"\n");
        }
    }

    public int TotalPeminjaman(ArrayList<DetilPeminjaman> dp){
        int total = 0;
        for (DetilPeminjaman detilPeminjaman : dp) {
            total += detilPeminjaman.getJumlahPeminjaman();
        }
        return total;
    }

    public void LaporanPeminjaman(){
        for (Peminjaman peminjaman : peminjamans) {
            System.out.println("\nKode Peminjaman \t : "+peminjaman.getIdPeminjaman());
            System.out.println("Tanggal peminjaman \t : "+peminjaman.getTanggal());
            System.out.println("Pustakawan \t\t : "+peminjaman.getLibrarian().getNama());
            System.out.println("Peminjam \t\t : "+peminjaman.getCustomer().getNama());
            System.out.println("||=====||=====||=====||=====||");
            ArrayList<DetilPeminjaman> detilPeminjamans = peminjaman.getDetilPeminjamans();
            for (DetilPeminjaman dp : detilPeminjamans) {
                System.out.println("Judul Buku \t\t : "+dp.getBuku().getTitle());
                System.out.println("Penulis \t\t : "+dp.getBuku().getAuthor());
                System.out.println("Jumlah PInjam \t\t : "+dp.getJumlahPeminjaman());
            }
            System.out.println("||=====||=====||=====||=====||");
            System.out.println("Total Peminjaman \t : "+peminjaman.getTotal()+"\n");
        }
    }
}  