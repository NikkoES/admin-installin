package com.example.fadil.admininstallin.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.fadil.admininstallin.R;
import com.example.fadil.admininstallin.adapter.ExtrasAdapter;
import com.example.fadil.admininstallin.api.BaseApiService;
import com.example.fadil.admininstallin.api.UtilsApi;
import com.example.fadil.admininstallin.model.Extras;
import com.example.fadil.admininstallin.model.response.ResponseListExtras;
import com.example.fadil.admininstallin.model.response.ResponsePost;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.text.TextUtils.concat;

public class DetailPemesananActivity extends AppCompatActivity implements View.OnClickListener {

    private CircularImageView imageProfile;
    private TextView txtIdOrder;
    private TextView tvNamaOs;
    private TextView tvTipeOs;
    private TextView tvHargaOs;
    private ImageView imageOs;
    private TextView txtStatusTransaksi;
    private TextView txtNamaPemesan;
    private TextView txtAlamatPengambilan;
    private TextView txtTanggalPengembalian;
    private TextView txtWaktuPengembalian;
    private TextView txtNoPemesan;
    private TextView totalBiaya;
    private Button btnDone, btnCancel;

    String idOrder, idUser, idProduct, idKurir;
    String imageKurir, namaKurir, ktpKurir, noHpKurir;
    String status, totalHarga, alamatPengambilan, tanggalPengambilan, waktuPengambilan;
    String namaPemesan, noHpPemesan;
    String namaOs, hargaOs, tipeOs, imgOs;

    List<Extras> listExtras = new ArrayList<>();

    BaseApiService apiService;

    private ExtrasAdapter adapter;

    RecyclerView rvExtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pemesanan);

        initView();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail Pesanan");

        apiService = UtilsApi.getAPIService();

        rvExtras = (RecyclerView) findViewById(R.id.rv_extras);

        adapter = new ExtrasAdapter(getApplicationContext(), listExtras);

        rvExtras.setHasFixedSize(true);
        rvExtras.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvExtras.setAdapter(adapter);

        idOrder = getIntent().getStringExtra("id_order");
        idUser = getIntent().getStringExtra("id_user");
        idProduct = getIntent().getStringExtra("id_product");
        idKurir = getIntent().getStringExtra("id_kurir");
        imageKurir = getIntent().getStringExtra("image_kurir");
        namaKurir = getIntent().getStringExtra("nama_kurir");
        ktpKurir = getIntent().getStringExtra("no_ktp_kurir");
        noHpKurir = getIntent().getStringExtra("no_hp_kurir");
        status = getIntent().getStringExtra("status");
        totalHarga = getIntent().getStringExtra("total_harga");
        namaPemesan = getIntent().getStringExtra("nama_user");
        noHpPemesan = getIntent().getStringExtra("no_hp_user");
        alamatPengambilan = getIntent().getStringExtra("alamat_pengambilan");
        tanggalPengambilan = getIntent().getStringExtra("tanggal_pengambilan");
        waktuPengambilan = getIntent().getStringExtra("waktu_pengambilan");
        namaOs = getIntent().getStringExtra("nama_os");
        hargaOs = getIntent().getStringExtra("harga_os");
        tipeOs = getIntent().getStringExtra("tipe_os");
        imgOs = getIntent().getStringExtra("image_os");

        setExtras(idOrder);

        txtIdOrder.setText("#"+idOrder);

//        txtKtpKurir.setText(ktpKurir);
//        txtNamaKurir.setText(namaKurir);
//        txtNoHpKurir.setText(noHpKurir);
        txtStatusTransaksi.setText("Menunggu konfirmasi");
        txtNamaPemesan.setText(namaPemesan);
        txtNoPemesan.setText(noHpPemesan);
        txtAlamatPengambilan.setText(alamatPengambilan);
        txtTanggalPengembalian.setText(tanggalPengambilan);
        txtWaktuPengembalian.setText(waktuPengambilan);
        totalBiaya.setText(concat(currencyFormatter(Integer.parseInt(totalHarga))));
        tvNamaOs.setText(namaOs);
        tvHargaOs.setText(concat(currencyFormatter(Integer.parseInt(hargaOs))));
        tvTipeOs.setText(tipeOs);
        Glide.with(getApplicationContext())
                .load(imgOs)
                .placeholder(R.drawable.no_image)
                .into(imageOs);
    }

    private void setExtras(String idOrder) {
        apiService.getDataOrderExtrasById(idOrder).enqueue(new Callback<ResponseListExtras>() {
            @Override
            public void onResponse(Call<ResponseListExtras> call, Response<ResponseListExtras> response) {
                if (response.body().getStatus().equals("success")){
                    listExtras = response.body().getData();

                    rvExtras.setAdapter(new ExtrasAdapter(getApplicationContext(), listExtras));
                    adapter.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Gagal mendapatkan data !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseListExtras> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Koneksi Internet Bermasalah (extras)", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String currencyFormatter(int number){
        DecimalFormat kursIndo = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator('.');
        formatRp.setGroupingSeparator('.');

        kursIndo.setDecimalFormatSymbols(formatRp);
        return kursIndo.format(number);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        txtIdOrder = (TextView) findViewById(R.id.txt_id_order);
        imageProfile = (CircularImageView) findViewById(R.id.image_profile);
//        txtKtpKurir = (TextView) findViewById(R.id.txt_ktp_kurir);
//        txtNamaKurir = (TextView) findViewById(R.id.txt_nama_kurir);
//        txtNoHpKurir = (TextView) findViewById(R.id.txt_no_hp_kurir);
        txtStatusTransaksi = (TextView) findViewById(R.id.txt_status_transaksi);
        tvNamaOs = (TextView) findViewById(R.id.tv_nama_os);
        tvTipeOs = (TextView) findViewById(R.id.tv_tipe_os);
        tvHargaOs = (TextView) findViewById(R.id.tv_harga_os);
        imageOs = (ImageView) findViewById(R.id.image_os);
        txtNamaPemesan = (TextView) findViewById(R.id.txt_nama_pemesan);
        txtAlamatPengambilan = (TextView) findViewById(R.id.txt_alamat_pengambilan);
        txtTanggalPengembalian = (TextView) findViewById(R.id.txt_tanggal_pengembalian);
        txtWaktuPengembalian = (TextView) findViewById(R.id.txt_waktu_pengembalian);
        txtNoPemesan = (TextView) findViewById(R.id.txt_no_pemesan);
        totalBiaya = (TextView) findViewById(R.id.total_biaya);
        btnDone = (Button) findViewById(R.id.btn_done);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
        btnDone.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_done: {
                apiService.actionProgress(idOrder, "1").enqueue(new Callback<ResponsePost>() {
                    @Override
                    public void onResponse(Call<ResponsePost> call, Response<ResponsePost> response) {
                        if (response.body().getStatus().equals("success")){
                            Toast.makeText(getApplicationContext(), "Behasil diproses..", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Gagal mendapatkan data !", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponsePost> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Koneksi Internet Bermasalah (extras)", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            }
            case R.id.btn_cancel: {

                break;
            }

        }
    }
}
