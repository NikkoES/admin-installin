package com.example.fadil.admininstallin.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fadil.admininstallin.R;
import com.mikhaellopez.circularimageview.CircularImageView;

public class TambahKurirActivity extends AppCompatActivity implements View.OnClickListener {

    private CircularImageView imageProfile;
    private EditText etNamaKurir;
    private EditText etKtpKurir;
    private EditText etNomorTelepon;
    private Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_kurir);
        initView();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tambah Kurir");
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
        imageProfile = (CircularImageView) findViewById(R.id.image_profile);
        etNamaKurir = (EditText) findViewById(R.id.et_nama_kurir);
        etKtpKurir = (EditText) findViewById(R.id.et_ktp_kurir);
        etNomorTelepon = (EditText) findViewById(R.id.et_nomor_telepon);
        btnSimpan = (Button) findViewById(R.id.btn_login);
        btnSimpan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_login:
                break;
        }
    }
}
