package com.example.fadil.admininstallin.fragment;


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

import com.example.fadil.admininstallin.R;
import com.example.fadil.admininstallin.adapter.DaftarPesanAdapter;
import com.example.fadil.admininstallin.adapter.HistoriPesanAdapter;
import com.example.fadil.admininstallin.adapter.KurirAdapter;
import com.example.fadil.admininstallin.api.BaseApiService;
import com.example.fadil.admininstallin.model.DaftarPesanan;
import com.example.fadil.admininstallin.model.HistoriPesanan;
import com.example.fadil.admininstallin.model.response.ResponseKurir;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class KurirFragment extends Fragment {
    /*private SliderPagerAdapter mAdapter;
     private SliderIndicator mIndicator;

     private SliderView sliderView;*/
    private LinearLayout mLinearLayout;

    private FragmentActivity myContext;

    private RecyclerView rvHome;
    private KurirAdapter adapter;
    List<ResponseKurir> listKurir = new ArrayList<>();

    ProgressDialog loading;

    BaseApiService apiService;


    public KurirFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_kurir, container, false);

        //sliderView = (SliderView) v.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) v.findViewById(R.id.pagesContainer);
        //setupSlider();

        rvHome = (RecyclerView) v.findViewById(R.id.rv_list_kurir);

        adapter = new KurirAdapter(getContext(), listKurir);

//        apiService = UtilsApi.getAPIService();

        rvHome.setHasFixedSize(true);
        rvHome.setLayoutManager(new LinearLayoutManager(getContext()));
        rvHome.setAdapter(adapter);

        refresh();

        return v;
    }

    public void refresh() {
        loading = ProgressDialog.show(getContext(), null, "Harap Tunggu...", true, false);

        listKurir.add(new ResponseKurir("Fiki", "323435345456", "967867867860980"));
        listKurir.add(new ResponseKurir("Fiki", "323435345456", "967867867860980"));
        listKurir.add(new ResponseKurir("Fiki", "323435345456", "967867867860980"));
        listKurir.add(new ResponseKurir("Fiki", "323435345456", "967867867860980"));
        listKurir.add(new ResponseKurir("Fiki", "323435345456", "967867867860980"));
        adapter.notifyDataSetChanged();
        loading.dismiss();
    }

    /*private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/zYFQM9G5j9cRsMNMuZAX64nmUMf.jpg"));
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/rXBB8F6XpHAwci2dihBCcixIHrK.jpg"));
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/biN2sqExViEh8IYSJrXlNKjpjxx.jpg"));
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/o9OKe3M06QMLOzTl3l6GStYtnE9.jpg"));

        mAdapter = new SliderPagerAdapter(myContext.getSupportFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(getContext(), mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }*/
}
