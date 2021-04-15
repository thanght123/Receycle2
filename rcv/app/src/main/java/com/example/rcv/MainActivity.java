package com.example.rcv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.example.rcv.model.Thuemeo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtId,txtMoney;
    private Button btnAdd,btnTime;
    private Spinner spiner;
    private RatingBar rating;
    private RadioButton radioNam,radioNu;
    private List<Integer> imgs = new ArrayList<>();
    private List<Thuemeo> list = new ArrayList<>();
    private RecyclerView rcv;
    private ThuemeoAdapter adapter;
    private String time;
    private int id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    public void initView(){
        rcv = findViewById(R.id.rcv);
        txtId = findViewById(R.id.txtId);
        txtMoney= findViewById(R.id.txtMoney);
        radioNam=findViewById(R.id.radioNam);
        radioNu=findViewById(R.id.radioNu);
        btnAdd=findViewById(R.id.btnThem);
        btnTime=findViewById(R.id.btnTime);
        spiner = findViewById(R.id.spiner);
        rating = findViewById(R.id.rating);
        btnTime.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        imgs.add(R.drawable.cat1);
        imgs.add(R.drawable.cat2);
        imgs.add(R.drawable.cat3);
        imgs.add(R.drawable.cat4);
        imgs.add(R.drawable.cat5);
        adapter = new ThuemeoAdapter(this,list);
        rcv.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        rcv.setAdapter(adapter);
        spiner.setAdapter(new SpinerAdapter(this,imgs));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnThem:
                list.add(new Thuemeo((int)spiner.getSelectedItem(),txtMoney.getText().toString(),id++,time,rating.getRating(),(radioNam.isChecked())?"Nam":"Nu"));
                adapter.notifyDataSetChanged();
                break;
            case R.id.btnTime:
                TimePickerDialog picker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        time = hourOfDay+":"+minute;
                    }
                },6,0,true);
                picker.show();
                break;
//            DatePickerDialog picker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//                @Override
//                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                    date =dayOfMonth +"/"+month+"/"+year;
//                }
//            },2021,4,1);
//            picker.show();
//            break;
        }
    }
}