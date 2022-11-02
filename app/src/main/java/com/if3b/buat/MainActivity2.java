package com.if3b.buat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView tvnama;
TextView tvnomor;
TextView tvjalur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvnama = findViewById(R.id.tv_nama);
        tvnomor = findViewById(R.id.tv_nomor);
        tvjalur = findViewById(R.id.tv_jalur);

        Intent terima = getIntent();
        String yNama = terima.getStringExtra("xNama");
        tvnama.setText(yNama);
        String yNomor = terima.getStringExtra("xNomor");
        tvnomor.setText(yNomor);
        String yJalur = terima.getStringExtra("xJalur");
        tvjalur.setText(yJalur);


    }
}