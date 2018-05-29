package com.example.fadil.admininstallin.model.response;

public class ResponseKurir {
    private String namaKurir;
    private String ktpKurir;
    private String noHp;

    public ResponseKurir(String namaKurir, String ktpKurir, String noHp) {
        this.namaKurir = namaKurir;
        this.ktpKurir = ktpKurir;
        this.noHp = noHp;
    }

    public String getNamaKurir() {
        return namaKurir;
    }

    public void setNamaKurir(String namaKurir) {
        this.namaKurir = namaKurir;
    }

    public String getKtpKurir() {
        return ktpKurir;
    }

    public void setKtpKurir(String ktpKurir) {
        this.ktpKurir = ktpKurir;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
}
