package com.example.fadil.admininstallin.model;

public class DaftarPesanan {
    private String idPesan;
    private String imageOs;
    private String namaOs;
    private String hargaOs;
    private String tipeOs;
    private String tglTransaksi;
    private String tglselesai;
    private String namaKurir;
    private String alamat;

    public DaftarPesanan(String idPesan, String imageOs, String namaOs, String hargaOs, String tipeOs, String tglTransaksi, String tglselesai, String namaKurir, String alamat) {
        this.idPesan = idPesan;
        this.imageOs = imageOs;
        this.namaOs = namaOs;
        this.hargaOs = hargaOs;
        this.tipeOs = tipeOs;
        this.tglTransaksi = tglTransaksi;
        this.tglselesai = tglselesai;
        this.namaKurir = namaKurir;
        this.alamat = alamat;
    }

    public String getIdPesan() {
        return idPesan;
    }

    public void setIdPesan(String idPesan) {
        this.idPesan = idPesan;
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

    public String getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(String tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    public String getTglselesai() {
        return tglselesai;
    }

    public void setTglselesai(String tglselesai) {
        this.tglselesai = tglselesai;
    }

    public String getNamaKurir() {
        return namaKurir;
    }

    public void setNamaKurir(String namaKurir) {
        this.namaKurir = namaKurir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
