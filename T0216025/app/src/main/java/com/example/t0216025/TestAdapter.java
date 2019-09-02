package com.example.t0216025;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class TestAdapter extends BaseAdapter {
    private List<String> listItems;
    private Activity activity;

    public TestAdapter(Activity activity)
    {
        this.activity=activity;
        this.listItems=new ArrayList<String>();
    }

    public void addLine(String newItem)
    {
        this.listItems.add(newItem);
        this.notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int i) {
        return listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    protected class ViewHolder {
        protected TextView tvText ;

        public ViewHolder (View view) {
            this.tvText = view.findViewById(R.id.tvNama) ;
        }

        public void updateView(String text) {
            tvText.setText(text);
        }
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder ;

        if(view == null) {
            view = LayoutInflater.from(this.activity).inflate(R.layout.list_item_string,viewGroup,false);
            viewHolder = new ViewHolder(view) ;
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag() ;
        }

        viewHolder.updateView(this.getItem(i).toString());

        return view ;
        //View itemView=this.activity.getLayoutInflater().inflate(R.layout.list_item_string,null);
        //TextView tvNama= itemView.findViewById(R.id.tvNama);
        //tvNama.setText(this.listItems.get(i));
        //return itemView;
    }
}
