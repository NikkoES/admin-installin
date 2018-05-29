package com.example.fadil.admininstallin.fragment;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.fadil.admininstallin.R;
import com.example.fadil.admininstallin.adapter.DaftarPesanAdapter;
import com.example.fadil.admininstallin.api.BaseApiService;
import com.example.fadil.admininstallin.api.UtilsApi;
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
public class HomeFragment extends Fragment {

    /*private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private SliderView sliderView;*/
    private LinearLayout mLinearLayout;

    private FragmentActivity myContext;

    private RecyclerView rvHome;
    private DaftarPesanAdapter adapter;
    List<Order> listPesan = new ArrayList<>();

    ProgressDialog loading;

    BaseApiService apiService;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        myContext = (FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        //sliderView = (SliderView) v.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) v.findViewById(R.id.pagesContainer);
        //setupSlider();

        rvHome = (RecyclerView) v.findViewById(R.id.rv_daftar_pesanan);

        adapter = new DaftarPesanAdapter(getContext(), listPesan);

        apiService = UtilsApi.getAPIService();

        rvHome.setHasFixedSize(true);
        rvHome.setLayoutManager(new LinearLayoutManager(getContext()));
        rvHome.setAdapter(adapter);

        refresh();

        return v;
    }

    public void refresh() {
        loading = ProgressDialog.show(getContext(), null, "Harap Tunggu...", true, false);

        apiService.getAllOrder().enqueue(new Callback<ResponseListOrder>() {
            @Override
            public void onResponse(Call<ResponseListOrder> call, Response<ResponseListOrder> response) {
                if (response.isSuccessful()){
                    loading.dismiss();

                    listPesan = response.body().getData();

                    rvHome.setAdapter(new DaftarPesanAdapter(getContext(), listPesan));
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
