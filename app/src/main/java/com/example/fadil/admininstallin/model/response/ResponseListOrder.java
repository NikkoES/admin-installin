package com.example.fadil.admininstallin.model.response;

import com.example.fadil.admininstallin.model.Order;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseListOrder {

    @SerializedName("status")
    @Expose
    String status;
    @SerializedName("data")
    @Expose
    List<Order> data;

    public ResponseListOrder(String status, List<Order> data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public List<Order> getData() {
        return data;
    }

}
