package com.example.fadil.admininstallin.model.response;

import com.example.fadil.admininstallin.model.Extras;
import com.example.fadil.admininstallin.model.Order;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseListExtras {

    @SerializedName("status")
    @Expose
    String status;
    @SerializedName("data")
    @Expose
    List<Extras> data;

    public ResponseListExtras(String status, List<Extras> data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public List<Extras> getData() {
        return data;
    }

}
