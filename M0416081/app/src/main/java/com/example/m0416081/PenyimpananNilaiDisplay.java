package com.example.m0416081;

import android.content.Context;
import android.content.SharedPreferences;

public class PenyimpananNilaiDisplay {
    protected SharedPreferences sharedPreferences;
    protected  final String NAMA_SHARED_PREF="sp_nilai_display";
    protected  final  String KEY_BARANG="BARANG" , KEY_HARGA="HARGA" , KEY_KETERANGAN="KETERANGAN" ;

    public PenyimpananNilaiDisplay(Context context){
        this.sharedPreferences = context.getSharedPreferences(NAMA_SHARED_PREF,0);
    }

    public void saveBarang(String barang){
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putString(KEY_BARANG,barang);
        editor.apply();
    }
    public void saveHarga(String s){
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putString(KEY_HARGA,s);
        editor.apply();
    }
    public void saveKeterangan(String s){
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putString(KEY_KETERANGAN,s);
        editor.apply();
    }

    public String getBarang(){
        return this.sharedPreferences.getString(KEY_BARANG,"");
    }
    public String getHarga(){
        return this.sharedPreferences.getString(KEY_HARGA,"");
    }
    public String getKeterangan(){
        return this.sharedPreferences.getString(KEY_KETERANGAN , "");
    }
}
