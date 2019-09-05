package com.example.t0316081.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.t0316081.R;

import java.util.ArrayList;

public class DrawerAdapter extends    BaseAdapter {
    private ArrayList<String> list;
    @Override
    public int getCount() {
        return  this.list.size();
    }

    @Override
    public Object getItem(int i) {
        return this.list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return  null;
    }
}
