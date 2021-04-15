package com.example.rcv;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rcv.model.Thuemeo;

import java.util.List;

public class ThuemeoAdapter extends RecyclerView.Adapter<ThuemeoAdapter.ThuemeoViewholder> {
    private Activity activity;
    private List<Thuemeo> list;
    public ThuemeoAdapter(Activity activity, List<Thuemeo> list){
        this.list = list;
        this.activity = activity;
        }

    @NonNull
    @Override
    public ThuemeoViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = activity.getLayoutInflater().inflate(R.layout.item,parent,false);
        return new ThuemeoViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ThuemeoViewholder holder, int position) {
        Thuemeo t = list.get(position);
        holder.img.setImageResource(t.getRsImg());
        holder.money.setText("money:" +t.getMoney());
        holder.time.setText("time:" +t.getTime());
        holder.rating.setRating(t.getRating());
        holder.gender.setText("gender: "+t.getGender());
        holder.btnremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
         return list.size();
    }


    class ThuemeoViewholder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView time,money;
        private RatingBar rating;
        private Button btnremove;
        private TextView gender;

        public ThuemeoViewholder(@NonNull View v) {
            super(v);
            img =v.findViewById(R.id.img);
            time = v.findViewById(R.id.time);
            money= v.findViewById(R.id.moneys);
            rating=v.findViewById(R.id.rating);
            btnremove=v.findViewById(R.id.btnRemove);
            gender=v.findViewById(R.id.gender);

        }
    }
}
