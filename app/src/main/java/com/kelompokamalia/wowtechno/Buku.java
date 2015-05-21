package com.kelompokamalia.wowtechno;

import java.util.ArrayList;

public class Buku {
    public String judulBuku;
    public String namaPengarang;
    public String jumlahHalaman;

    public Buku(String judulBuku, String namaPengarang, String jumlahHalaman) {
        this.judulBuku = judulBuku;
        this.namaPengarang = namaPengarang;
        this.jumlahHalaman = jumlahHalaman;
    }

    public static ArrayList<Buku> getBukus() {
        ArrayList<Buku> bukus = new ArrayList<Buku>();
        bukus.add(new Buku("Laskar Pelangi", "namaPengarang", "111"));
        bukus.add(new Buku("5 cm", "namaPengarang", "111"));
        bukus.add(new Buku("Ayat ayat cinta", "namaPengarang", "111"));
        bukus.add(new Buku("Lima Menara", "namaPengarang", "111"));
        bukus.add(new Buku("Tutorial Pemrograman Android", "namaPengarang", "111"));
        return bukus;
    }
}
