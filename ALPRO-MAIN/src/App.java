import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import control.Controller;
import model.Buku;
import model.Customer;
import model.Librarian;

public class App {
    public static void main(String[] args) throws Exception {
        Controller LibControl = new Controller();
        LibControl.setUp();
        boolean cont = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (cont) {
            Menu();
            System.out.println("Pilih Menu");
            String pilihan = reader.readLine();
            switch (pilihan) {
                case "1":
                    LibControl.DaftarBuku();
                    break;
                case "2":
                    LibControl.Pinjam();
                    break;
                case "3":
                    LibControl.LaporanPeminjaman();
                    break;
                default:
                    cont = false;
                    break;
            }
        }

        System.out.println("Sampai Jumpa");

    }

    public static void Menu() {
        System.out.println("1. Daftar Buku");
        System.out.println("2. Pinjam");
        System.out.println("3. Laporan Peminjaman");
        System.out.println("4. Exit");
    }
}
