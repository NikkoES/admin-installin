package com.example.fadil.admininstallin.api;

import com.example.fadil.admininstallin.model.response.ResponseListExtras;
import com.example.fadil.admininstallin.model.response.ResponseListOrder;
import com.example.fadil.admininstallin.model.response.ResponsePost;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BaseApiService {

    @FormUrlEncoded
    @POST("login/")
    Call<ResponsePost> login(@Field("email") String email, @Field("password") String password);

    @GET("order_product/")
    Call<ResponseListOrder> getAllOrder();

    @GET("order_product_history/")
    Call<ResponseListOrder> getAllOrderHistory();

    @GET("order_extras/{id_order}")
    Call<ResponseListExtras> getDataOrderExtrasById(@Path("id_order") String idOrder);

    @FormUrlEncoded
    @POST("onprogress/")
    Call<ResponsePost> actionProgress(@Field("id_order") String idOrder, @Field("id_kurir") String idKurir);

    @FormUrlEncoded
    @POST("done/")
    Call<ResponsePost> actionDone(@Field("id_order") String idOrder, @Field("tgl_pengantaran") String tanggalPengantaran,
                                  @Field("waktu_pengantaran") String waktuPengantaran, @Field("tempat_pengantaran") String tempatPengantaran);

}
