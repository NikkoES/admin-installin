package com.example.fadil.admininstallin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.fadil.admininstallin.R;
import com.example.fadil.admininstallin.model.Extras;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;

import static android.text.TextUtils.concat;

public class ExtrasAdapter extends RecyclerView.Adapter<ExtrasAdapter.ViewHolder> {

    private Context context;
    private List<Extras> listExtras;

    public ExtrasAdapter(Context context, List<Extras> listExtras){
        this.context = context;
        this.listExtras = listExtras;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_extras, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Extras extras = listExtras.get(position);
        holder.txtNamaExtras.setText(extras.getNamaExtras());
        holder.txtKeterangan.setText(extras.getRincian());
        holder.txtHargaExtras.setText(concat(currencyFormatter(Integer.parseInt(extras.getHargaExtras()))));
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
    public int getItemCount() {
        return listExtras.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNamaExtras, txtKeterangan, txtHargaExtras;

        public ViewHolder(View itemView) {
            super(itemView);

            txtNamaExtras = (TextView) itemView.findViewById(R.id.txt_nama_extras);
            txtKeterangan = (TextView) itemView.findViewById(R.id.txt_info_extras);
            txtHargaExtras = (TextView) itemView.findViewById(R.id.txt_harga_extras);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            itemView.setOnClickListener(onClickListener);
        }
    }
}