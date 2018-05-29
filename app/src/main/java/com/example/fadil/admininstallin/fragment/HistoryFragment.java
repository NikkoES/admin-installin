package com.example.fadil.admininstallin.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fadil.admininstallin.R;
import com.example.fadil.admininstallin.adapter.DaftarPesanAdapter;
import com.example.fadil.admininstallin.adapter.HistoriPesanAdapter;
import com.example.fadil.admininstallin.api.BaseApiService;
import com.example.fadil.admininstallin.api.UtilsApi;
import com.example.fadil.admininstallin.model.HistoriPesanan;
import com.example.fadil.admininstallin.model.Order;
import com.example.fadil.admininstallin.model.response.ResponseListOrder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {

    private RecyclerView rvHistory;

    private HistoriPesanAdapter adapter;

    List<Order> listHistory = new ArrayList<>();

    ProgressDialog loading;

    BaseApiService apiService;

    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_history, container, false);

        rvHistory = (RecyclerView) v.findViewById(R.id.rv_history);

        adapter = new HistoriPesanAdapter(getContext(), listHistory);

        apiService = UtilsApi.getAPIService();

        rvHistory.setHasFixedSize(true);
        rvHistory.setLayoutManager(new LinearLayoutManager(getContext()));
        rvHistory.setAdapter(adapter);

        refresh();

        return v;
    }

    public void refresh() {
        loading = ProgressDialog.show(getContext(), null, "Harap Tunggu...", true, false);

        apiService.getAllOrderHistory().enqueue(new Callback<ResponseListOrder>() {
            @Override
            public void onResponse(Call<ResponseListOrder> call, Response<ResponseListOrder> response) {
                if (response.isSuccessful()){
                    loading.dismiss();

                    listHistory = response.body().getData();

                    rvHistory.setAdapter(new HistoriPesanAdapter(getContext(), listHistory));
                    adapter.notifyDataSetChanged();
                }
                else {
                    loading.dismiss();
                    Toast.makeText(getContext(), "Failed to Fetch Data !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseListOrder> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(getContext(), "Failed to Connect Internet !", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
