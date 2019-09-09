package com.example.m0416081;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText input_barang , input_harga , input_keterangan;
    private Button btn_submit;
    private  PenyimpananNilaiDisplay penyimpananNilaiDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.input_barang = this.findViewById(R.id.input_barang);
        this.input_harga = this.findViewById(R.id.input_harga);
        this.input_keterangan = this.findViewById(R.id.input_keterangan);
        this.btn_submit = this.findViewById(R.id.btn_submit);
        this.penyimpananNilaiDisplay = new PenyimpananNilaiDisplay(this);
        this.btn_submit.setOnClickListener(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        this.penyimpananNilaiDisplay.saveBarang(input_barang.getText().toString());
        this.penyimpananNilaiDisplay.saveHarga(input_harga.getText().toString());
        this.penyimpananNilaiDisplay.saveKeterangan(input_keterangan.getText().toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.input_barang.setText(this.penyimpananNilaiDisplay.getBarang());
        this.input_harga.setText(this.penyimpananNilaiDisplay.getHarga());
        this.input_keterangan.setText(this.penyimpananNilaiDisplay.getKeterangan());
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == this.btn_submit.getId()){
            String data = this.input_barang.getText().toString() + "\n" + this.input_harga.getText().toString() + "\n" + this.input_keterangan.getText().toString();

            try{
                File file = getFileStreamPath("output.txt");
                if(!file.exists()){
                    file.createNewFile();
                }
                FileOutputStream writer = new FileOutputStream(file);
                writer.write(data.getBytes());
                writer.flush();
                writer.close();
                Toast.makeText(this,"saved in " + file.getCanonicalPath()   , Toast.LENGTH_LONG).show();
                this.input_keterangan.getText().clear();
                this.input_harga.getText().clear();
                this.input_barang.getText().clear();
            }
            catch (Exception e){
                Toast.makeText(this,"saved in " + e.getMessage()   , Toast.LENGTH_LONG).show();
            }

        }
    }
}
