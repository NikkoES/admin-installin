package com.example.fadil.admininstallin.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.fadil.admininstallin.R;
import com.example.fadil.admininstallin.activity.DetailPemesananActivity;
import com.example.fadil.admininstallin.api.BaseApiService;
import com.example.fadil.admininstallin.api.UtilsApi;
import com.example.fadil.admininstallin.model.DaftarPesanan;
import com.example.fadil.admininstallin.model.Order;
import com.example.fadil.admininstallin.model.response.ResponseListExtras;
import com.example.fadil.admininstallin.model.response.ResponsePost;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.text.TextUtils.concat;


public class DaftarPesanAdapter extends RecyclerView.Adapter<DaftarPesanAdapter.ViewHolder> {


    private Context context;
    private List<Order> listPesan;

    BaseApiService apiService;

    public DaftarPesanAdapter(Context context, List<Order> listPesan) {
        this.context = context;
        this.listPesan = listPesan;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_daftar_pesanan, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);

        return new ViewHolder(v);
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
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Order pesan = listPesan.get(position);

        apiService = UtilsApi.getAPIService();

        Glide.with(context)
                .load(pesan.getImgOs())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imageOS);
        holder.namaKurir.setText(pesan.getNamaUser());
        holder.tglAmbil.setText(pesan.getTanggalOrder());
        holder.alamat.setText(pesan.getTempatPengambilan());
        holder.txtNamaOS.setText(pesan.getNamaOs());
        holder.txtTipeOS.setText(pesan.getTipeOs());
        holder.txtHargaOS.setText(concat(currencyFormatter(Integer.parseInt(pesan.getHargaTotal()))));
        holder.cvPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailPemesananActivity.class);
                i.putExtra("id_order", pesan.getIdOrder());
                i.putExtra("id_user", pesan.getIdUser());
                i.putExtra("id_product", pesan.getIdProduct());
                i.putExtra("id_kurir", pesan.getIdKurir());
                i.putExtra("image_kurir", pesan.getFotoKurir());
                i.putExtra("nama_kurir", pesan.getNamaKurir());
                i.putExtra("no_ktp_kurir", pesan.getNoKtpKurir());
                i.putExtra("no_hp_kurir", pesan.getNoHpKurir());
                i.putExtra("status", pesan.getStatus());
                i.putExtra("nama_os", pesan.getNamaOs());
                i.putExtra("tipe_os", pesan.getTipeOs());
                i.putExtra("harga_os", pesan.getHargaOs());
                i.putExtra("image_os", pesan.getImgOs());
                i.putExtra("nama_user", pesan.getNamaUser());
                i.putExtra("no_hp_user", pesan.getNoHpUser());
                i.putExtra("alamat_pengambilan", pesan.getTempatPengambilan());
                i.putExtra("tanggal_pengambilan", pesan.getTanggalPengambilan());
                i.putExtra("waktu_pengambilan", pesan.getWaktuPengambilan());
                i.putExtra("total_harga", pesan.getHargaTotal());
                context.startActivity(i);
            }
        });
        holder.terima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiService.actionProgress(pesan.getIdOrder(), "1").enqueue(new Callback<ResponsePost>() {
                    @Override
                    public void onResponse(Call<ResponsePost> call, Response<ResponsePost> response) {
                        if (response.body().getStatus().equals("success")){
                            Toast.makeText(context, "Behasil diproses..", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(context, "Gagal mendapatkan data !", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponsePost> call, Throwable t) {
                        Toast.makeText(context, "Koneksi Internet Bermasalah (extras)", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        holder.tolak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "tolak", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPesan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cvPesan;

        private TextView txtNamaOS, txtTipeOS, txtHargaOS, alamat, tglAmbil, namaKurir;
        private Button terima, tolak;
        private ImageView imageOS;

        public ViewHolder(View itemView) {
            super(itemView);

            alamat = itemView.findViewById(R.id.tv_alamat_kirim);
            tglAmbil = itemView.findViewById(R.id.tv_tgl_ambil);
            namaKurir = itemView.findViewById(R.id.tv_nama_kurir);
            terima = itemView.findViewById(R.id.btn_terima);
            tolak = itemView.findViewById(R.id.btn_tolak);
            cvPesan = itemView.findViewById(R.id.cv_daftar_pesanan);
            txtNamaOS = itemView.findViewById(R.id.tv_nama_os);
            txtTipeOS = itemView.findViewById(R.id.tv_tipe_os);
            txtHargaOS = itemView.findViewById(R.id.tv_harga_os);
            imageOS = itemView.findViewById(R.id.iv_image_os);
        }
    }
}
