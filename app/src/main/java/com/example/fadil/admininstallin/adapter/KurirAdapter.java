package com.example.fadil.admininstallin.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fadil.admininstallin.R;
import com.example.fadil.admininstallin.model.response.ResponseKurir;

import java.util.List;

import butterknife.BindView;

public class KurirAdapter extends RecyclerView.Adapter<KurirAdapter.ViewHolder> {


    CardView cvDaftarPesanan;
    private Context context;
    private List<ResponseKurir> listKurir;

    public KurirAdapter(Context context, List<ResponseKurir> listKurir) {
        this.context = context;
        this.listKurir = listKurir;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_kurir, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ResponseKurir kurir = listKurir.get(position);

        holder.namaKurir.setText(kurir.getNamaKurir());
        holder.ktpKurir.setText(kurir.getKtpKurir());
        holder.hpKurir.setText(kurir.getNoHp());

    }

    @Override
    public int getItemCount() {
        return listKurir.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView namaKurir,ktpKurir,hpKurir;
        private  Button edit,hapus;

        public ViewHolder(View itemView) {
            super(itemView);
            namaKurir = itemView.findViewById(R.id.tv_nama_kurir);
            ktpKurir = itemView.findViewById(R.id.tv_no_ktp_kurir);
            hpKurir = itemView.findViewById(R.id.tv_no_hp_kurir);
            edit = itemView.findViewById(R.id.btn_edit_kurir);
            hapus = itemView.findViewById(R.id.btn_hapus_kurir);
            }
    }
}
