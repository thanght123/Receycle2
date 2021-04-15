package com.example.rcv;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class    SpinerAdapter extends ArrayAdapter<Integer> {
    private List<Integer> list;
    private Activity activity;
    public SpinerAdapter(@NonNull Context context, List<Integer> list) {
        super(context, R.layout.spiner_custom,list);
        activity = (Activity)context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = activity.getLayoutInflater().inflate(R.layout.spiner_custom,parent,false);
        ImageView img = v.findViewById(R.id.img);
        img.setImageResource(list.get(position));
        return v;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = activity.getLayoutInflater().inflate(R.layout.spiner_custom,parent,false);
        ImageView img = v.findViewById(R.id.img);
        img.setImageResource(getItem(position));
        return v;
    }
}