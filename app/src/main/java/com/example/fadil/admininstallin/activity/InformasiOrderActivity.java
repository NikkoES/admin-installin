package com.example.fadil.admininstallin.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.text.TextUtils.concat;

public class InformasiOrderActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtIdOrder;
    private TextView txtStatusTransaksi;
    private TextView tvNamaOs;
    private TextView tvTipeOs;
    private TextView tvHargaOs;
    private ImageView imageOs;
    private RecyclerView rvExtrasInformasiOrder;
    private TextView txtNamaPemesan;
    private TextView txtAlamatPengambilan;
    private TextView txtTanggalPengembalian;
    private TextView txtWaktuPengembalian;
    private TextView txtAlamatPengantaran;
    private TextView txtTanggalPengantaran;
    private TextView txtWaktuPengantaran;
    private TextView txtNoPemesan;
    private TextView totalBiaya;
    private TextView txtNamaKurir;
    private TextView txtNoKtpKurir;
    private TextView txtNoHpKurir;
    private Button btnDone;

    LinearLayout layoutKurir, layoutPengambilan, layoutPengantaran;
    CardView layoutButton;

    String idOrder, idUser, idProduct, idKurir;
    String imageKurir, namaKurir, ktpKurir, noHpKurir;
    String status, totalHarga, alamatPengambilan, tanggalPengambilan, waktuPengambilan, alamatPengantaran, tanggalPengantaran, waktuPengantaran;
    String namaPemesan, noHpPemesan;
    String namaOs, hargaOs, tipeOs, imgOs;

    List<Extras> listExtras = new ArrayList<>();

    BaseApiService apiService;

    private ExtrasAdapter adapter;

    RecyclerView rvExtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi_order);

        initView();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Informasi Order");

        apiService = UtilsApi.getAPIService();

        rvExtras = (RecyclerView) findViewById(R.id.list_extras);

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
        alamatPengantaran = getIntent().getStringExtra("alamat_pengantaran");
        tanggalPengantaran = getIntent().getStringExtra("tanggal_pengantaran");
        waktuPengantaran = getIntent().getStringExtra("waktu_pengantaran");
        namaOs = getIntent().getStringExtra("nama_os");
        hargaOs = getIntent().getStringExtra("harga_os");
        tipeOs = getIntent().getStringExtra("tipe_os");
        imgOs = getIntent().getStringExtra("image_os");

        setExtras(idOrder);

        txtIdOrder.setText("#"+idOrder);

        txtNoKtpKurir.setText(ktpKurir);
        txtNamaKurir.setText(namaKurir);
        txtNoHpKurir.setText(noHpKurir);
        //on progress
        if(status.equalsIgnoreCase("1")){
            layoutKurir.setVisibility(View.VISIBLE);
            layoutButton.setVisibility(View.VISIBLE);
            status = "On Progress";
        }
        //done
        else if(status.equalsIgnoreCase("2")){
            layoutKurir.setVisibility(View.VISIBLE);
            layoutPengambilan.setVisibility(View.GONE);
            layoutPengantaran.setVisibility(View.VISIBLE);
            status = "Done";
        }
        else if(status.equalsIgnoreCase("3")){
            layoutKurir.setVisibility(View.GONE);
            status = "Canceled";
        }
        else if(status.equalsIgnoreCase("4")){
            layoutKurir.setVisibility(View.GONE);
            status = "Rejected";
        }
        txtStatusTransaksi.setText(status);
        txtNamaPemesan.setText(namaPemesan);
        txtNoPemesan.setText(noHpPemesan);
        txtAlamatPengambilan.setText(alamatPengambilan);
        txtTanggalPengembalian.setText(tanggalPengambilan);
        txtWaktuPengembalian.setText(waktuPengambilan);
        txtAlamatPengantaran.setText(alamatPengantaran);
        txtTanggalPengantaran.setText(tanggalPengantaran);
        txtWaktuPengantaran.setText(waktuPengantaran);
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
        layoutKurir = findViewById(R.id.layout_kurir);
        layoutPengambilan = findViewById(R.id.layout_pengambilan);
        layoutPengantaran = findViewById(R.id.layout_pengantaran);
        txtIdOrder = (TextView) findViewById(R.id.txt_id_order);
        txtStatusTransaksi = (TextView) findViewById(R.id.txt_status_transaksi);
        tvNamaOs = (TextView) findViewById(R.id.tv_nama_os);
        tvTipeOs = (TextView) findViewById(R.id.tv_tipe_os);
        tvHargaOs = (TextView) findViewById(R.id.tv_harga_os);
        imageOs = (ImageView) findViewById(R.id.image_os);
        rvExtrasInformasiOrder = (RecyclerView) findViewById(R.id.rv_extras);
        txtNamaPemesan = (TextView) findViewById(R.id.txt_nama_pemesan);
        txtAlamatPengambilan = (TextView) findViewById(R.id.txt_alamat_pengambilan);
        txtTanggalPengembalian = (TextView) findViewById(R.id.txt_tanggal_pengembalian);
        txtWaktuPengembalian = (TextView) findViewById(R.id.txt_waktu_pengambilan);
        txtAlamatPengantaran = (TextView) findViewById(R.id.txt_alamat_pengantaran);
        txtTanggalPengantaran = (TextView) findViewById(R.id.txt_tanggal_pengantaran);
        txtWaktuPengantaran = (TextView) findViewById(R.id.txt_waktu_pengantaran);
        txtNoPemesan = (TextView) findViewById(R.id.txt_no_pemesan);
        totalBiaya = (TextView) findViewById(R.id.total_biaya);
        txtNoKtpKurir = findViewById(R.id.txt_id_kurir);
        txtNamaKurir = findViewById(R.id.txt_nama_kurir);
        txtNoHpKurir = findViewById(R.id.txt_no_hp);
        btnDone = (Button) findViewById(R.id.btn_done);
        layoutButton = findViewById(R.id.layout_cancel);
        btnDone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_done: {
                apiService.actionDone(idOrder, "", "", "").enqueue(new Callback<ResponsePost>() {
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

        }
    }
}
