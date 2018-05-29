package com.example.fadil.admininstallin.model;

public class HistoriPesanan {
    private String idHistori;
    private String imageOs;
    private String namaOs;
    private String hargaOs;
    private String tipeOs;
    private String tglselesai;
    private String tgTransaksi;
    private String namaKurir;
    private String namaPelanggan;
    private String alamat;
    private String status;

    public HistoriPesanan(String idHistori, String imageOs, String namaOs, String hargaOs, String tipeOs, String tglselesai, String tgTransaksi, String namaKurir, String namaPelanggan, String alamat, String status) {
        this.idHistori = idHistori;
        this.imageOs = imageOs;
        this.namaOs = namaOs;
        this.hargaOs = hargaOs;
        this.tipeOs = tipeOs;
        this.tglselesai = tglselesai;
        this.tgTransaksi = tgTransaksi;
        this.namaKurir = namaKurir;
        this.namaPelanggan = namaPelanggan;
        this.alamat = alamat;
        this.status = status;
    }

    public String getIdHistori() {
        return idHistori;
    }

    public void setIdHistori(String idHistori) {
        this.idHistori = idHistori;
    }

    public String getImageOs() {
        return imageOs;
    }

    public void setImageOs(String imageOs) {
        this.imageOs = imageOs;
    }

    public String getNamaOs() {
        return namaOs;
    }

    public void setNamaOs(String namaOs) {
        this.namaOs = namaOs;
    }

    public String getHargaOs() {
        return hargaOs;
    }

    public void setHargaOs(String hargaOs) {
        this.hargaOs = hargaOs;
    }

    public String getTipeOs() {
        return tipeOs;
    }

    public void setTipeOs(String tipeOs) {
        this.tipeOs = tipeOs;
    }

    public String getTglselesai() {
        return tglselesai;
    }

    public void setTglselesai(String tglselesai) {
        this.tglselesai = tglselesai;
    }

    public String getTgTransaksi() {
        return tgTransaksi;
    }

    public void setTgTransaksi(String tgTransaksi) {
        this.tgTransaksi = tgTransaksi;
    }

    public String getNamaKurir() {
        return namaKurir;
    }

    public void setNamaKurir(String namaKurir) {
        this.namaKurir = namaKurir;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
