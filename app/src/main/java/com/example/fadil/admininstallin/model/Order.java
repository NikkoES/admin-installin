package com.example.fadil.admininstallin.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Order implements Serializable {

    @SerializedName("ID_ORDER")
    String idOrder;
    @SerializedName("ID_KURIR")
    String idKurir;
    @SerializedName("ID")
    String idUser;
    @SerializedName("id_product")
    String idProduct;
    @SerializedName("TGL_ORDER")
    String tanggalOrder;
    @SerializedName("tgl_pengambilan")
    String tanggalPengambilan;
    @SerializedName("waktu_pengambilan")
    String waktuPengambilan;
    @SerializedName("tempat_pengambilan")
    String tempatPengambilan;
    @SerializedName("tgl_pengantaran")
    String tanggalPengantaran;
    @SerializedName("waktu_pengantaran")
    String waktuPengantaran;
    @SerializedName("tempat_pengantaran")
    String tempatPengantaran;
    @SerializedName("status")
    String status;
    @SerializedName("harga_total")
    String hargaTotal;
    @SerializedName("NAMA_PRODUCT")
    String namaOs;
    @SerializedName("HARGA")
    String hargaOs;
    @SerializedName("atribut")
    String tipeOs;
    @SerializedName("img_product")
    String imgOs;
    @SerializedName("NAMA")
    String namaUser;
    @SerializedName("NO_HP_USER")
    String noHpUser;
    @SerializedName("EMAIL")
    String emailUser;
    @SerializedName("ALAMAT")
    String alamatUser;
    @SerializedName("NAMA_KURIR")
    String namaKurir;
    @SerializedName("NO_KTP")
    String noKtpKurir;
    @SerializedName("NO_HP")
    String noHpKurir;
    @SerializedName("FOTO")
    String fotoKurir;

    public Order(String idOrder, String idKurir, String idUser, String idProduct, String tanggalOrder, String tanggalPengambilan, String waktuPengambilan, String tempatPengambilan, String tanggalPengantaran, String waktuPengantaran, String tempatPengantaran, String status, String hargaTotal, String namaOs, String hargaOs, String tipeOs, String imgOs, String namaUser, String noHpUser, String emailUser, String alamatUser, String namaKurir, String noKtpKurir, String noHpKurir, String fotoKurir) {
        this.idOrder = idOrder;
        this.idKurir = idKurir;
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.tanggalOrder = tanggalOrder;
        this.tanggalPengambilan = tanggalPengambilan;
        this.waktuPengambilan = waktuPengambilan;
        this.tempatPengambilan = tempatPengambilan;
        this.tanggalPengantaran = tanggalPengantaran;
        this.waktuPengantaran = waktuPengantaran;
        this.tempatPengantaran = tempatPengantaran;
        this.status = status;
        this.hargaTotal = hargaTotal;
        this.namaOs = namaOs;
        this.hargaOs = hargaOs;
        this.tipeOs = tipeOs;
        this.imgOs = imgOs;
        this.namaUser = namaUser;
        this.noHpUser = noHpUser;
        this.emailUser = emailUser;
        this.alamatUser = alamatUser;
        this.namaKurir = namaKurir;
        this.noKtpKurir = noKtpKurir;
        this.noHpKurir = noHpKurir;
        this.fotoKurir = fotoKurir;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public String getIdKurir() {
        return idKurir;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public String getTanggalOrder() {
        return tanggalOrder;
    }

    public String getTanggalPengambilan() {
        return tanggalPengambilan;
    }

    public String getWaktuPengambilan() {
        return waktuPengambilan;
    }

    public String getTempatPengambilan() {
        return tempatPengambilan;
    }

    public String getTanggalPengantaran() {
        return tanggalPengantaran;
    }

    public String getWaktuPengantaran() {
        return waktuPengantaran;
    }

    public String getTempatPengantaran() {
        return tempatPengantaran;
    }

    public String getStatus() {
        return status;
    }

    public String getHargaTotal() {
        return hargaTotal;
    }

    public String getNamaOs() {
        return namaOs;
    }

    public String getHargaOs() {
        return hargaOs;
    }

    public String getTipeOs() {
        return tipeOs;
    }

    public String getImgOs() {
        return imgOs;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public String getNoHpUser() {
        return noHpUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public String getAlamatUser() {
        return alamatUser;
    }

    public String getNamaKurir() {
        return namaKurir;
    }

    public String getNoKtpKurir() {
        return noKtpKurir;
    }

    public String getNoHpKurir() {
        return noHpKurir;
    }

    public String getFotoKurir() {
        return fotoKurir;
    }
}