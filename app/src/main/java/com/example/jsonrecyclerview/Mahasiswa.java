package com.example.jsonrecyclerview;

public class Mahasiswa {
    private String nama;
    private String jurusan;

    public Mahasiswa(String nama, String jurusan) {
        this.nama = nama;
        this.jurusan = jurusan;
    }

    public String getNama() {
        return nama;
    }

    public String getJurusan() {
        return jurusan;
    }
}
