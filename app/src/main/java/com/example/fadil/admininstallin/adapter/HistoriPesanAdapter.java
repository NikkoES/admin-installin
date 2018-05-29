package com.example.fadil.admininstallin.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fadil.admininstallin.R;
import com.example.fadil.admininstallin.activity.DetailPemesananActivity;
import com.example.fadil.admininstallin.activity.InformasiOrderActivity;
import com.example.fadil.admininstallin.model.HistoriPesanan;
import com.example.fadil.admininstallin.model.Order;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;

import butterknife.BindView;

import static android.text.TextUtils.concat;

public class HistoriPesanAdapter extends RecyclerView.Adapter<HistoriPesanAdapter.ViewHolder> {


    CardView cvDaftarHistory;
    private Context context;
    private List<Order> listHistori;

    public HistoriPesanAdapter(Context context, List<Order> listHistori) {
        this.context = context;
        this.listHistori = listHistori;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_history_transaksi, null, false);

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
        final Order pesan = listHistori.get(position);
        Glide.with(context)
                .load(pesan.getImgOs()) //ganti sama Model image
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.tivImageOsHistory);
        holder.tvKurirHistori.setText(pesan.getNamaKurir());
        holder.tvNamaHistori.setText(pesan.getNamaUser());
        holder.tvHargaOsHistory.setText(concat(currencyFormatter(Integer.parseInt(pesan.getHargaTotal()))));
        holder.tvAlamatHistori.setText(pesan.getTempatPengambilan());
        String status = "";
        switch (pesan.getStatus()){
            case "0" : {
                status = "On Confirming";
                break;
            }
            case "1" : {
                status = "On Progress";
                break;
            }
            case "2" : {
                status = "Done";
                break;
            }
            case "3" : {
                status = "Cancelled";
                break;
            }
            case "4" : {
                status = "Rejected";
                break;
            }
        }
        holder.tvProgressHistori.setText(status);
        holder.tvNamaOsHistory.setText(pesan.getNamaOs());
        holder.tvTipeOsHistory.setText(pesan.getTipeOs());
        holder.tvTanggalSekarangHistory.setText(pesan.getTanggalOrder());
        holder.cvPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, InformasiOrderActivity.class);
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
                i.putExtra("alamat_pengantaran", pesan.getTempatPengantaran());
                i.putExtra("tanggal_pengantaran", pesan.getTempatPengantaran());
                i.putExtra("waktu_pengantaran", pesan.getWaktuPengantaran());
                i.putExtra("total_harga", pesan.getHargaTotal());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHistori.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cvPesan;
        private TextView tvNamaOsHistory,tvTipeOsHistory,tvHargaOsHistory,tvAlamatHistori,tvNamaHistori,tvProgressHistori,tvKurirHistori,tvTanggalSekarangHistory;
        private ImageView tivImageOsHistory;

        public ViewHolder(View itemView) {
            super(itemView);

            cvPesan = itemView.findViewById(R.id.cv_daftar_history);
            tvNamaOsHistory =itemView.findViewById(R.id.tv_nama_os_history);
            tvTipeOsHistory = itemView.findViewById(R.id.tv_tipe_os_history);
            tvHargaOsHistory = itemView.findViewById(R.id.tv_harga_os_history);
            tvAlamatHistori = itemView.findViewById(R.id.tv_alamat_histori);
            tvNamaHistori = itemView.findViewById(R.id.tv_nama_histori);
            tvProgressHistori = itemView.findViewById(R.id.tv_progress_histori);
            tvKurirHistori = itemView.findViewById(R.id.tv_kurir_histori);
            tvTanggalSekarangHistory = itemView.findViewById(R.id.tv_tanggal_sekarang_history);
            tivImageOsHistory = itemView.findViewById(R.id.iv_image_os_history);

        }
    }
}