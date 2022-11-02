package com.if3b.buat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etnama, etnomor;
    private Spinner spjalur;
    private CheckBox cbkonfirmasi;
    private Button btndaftar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btndaftar = findViewById(R.id.btn_daftar);
        etnama = findViewById(R.id.et_nama);
        etnomor = findViewById(R.id.et_nomor);
        spjalur = findViewById(R.id.sp_jalur);
        cbkonfirmasi = findViewById(R.id.cb_konfirmasi);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.arr_jalur, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spjalur.setAdapter(adapter);

        spjalur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), adapter.getItem(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        cbkonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!cbkonfirmasi.isChecked()){
                    Toast.makeText(MainActivity.this, "Konfirmasi Pendaftaran Harus Dipilih", Toast.LENGTH_SHORT).show();
                    cbkonfirmasi.setChecked(true);
                }
                else{
                    btndaftar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            String nama = etnama.getText().toString();
                            String nomor = etnomor.getText().toString();
                            String jalur = spjalur.getSelectedItem().toString();


                            if(nama.trim().equals("")){
                                etnama.setError("Nama Harus Diisi");
                            }
                            else if(nomor.trim().equals("")){
                                etnomor.setError("Nomor Harus Diisi");
                            }
                            else{
                                Intent pindah = new Intent(MainActivity.this, MainActivity2.class);
                                pindah.putExtra("xNama", nama);
                                pindah.putExtra("xNomor", nomor);
                                pindah.putExtra("xJalur", jalur);
                                startActivity(pindah);
                            }

                        }
                    });

                }
            }
        });



    }
}