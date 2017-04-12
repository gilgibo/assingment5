package com.example.gibo.assignment5;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    TextView txtname,tvTel,tvURL,tvRegdate,etmenu1,etmenu2,etmenu3;
    RestData restdata;
    ImageView imgno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        putdata();
    }

    private void putdata(){
        txtname = (TextView)findViewById(R.id.txtname);
        tvTel = (TextView)findViewById(R.id.tvTel);
        tvURL = (TextView)findViewById(R.id.tvURL);
        tvRegdate = (TextView)findViewById(R.id.tvRegdate);
        etmenu1 = (TextView) findViewById(R.id.etmenu1);
        etmenu2 = (TextView) findViewById(R.id.etmenu2);
        etmenu3 = (TextView) findViewById(R.id.etmenu3);
        imgno = (ImageView)findViewById(R.id.imgno);
        Intent intent = getIntent();

        restdata = intent.getParcelableExtra("list");
        if(restdata.getCate_num().equals("1")){
            imgno.setImageResource(R.drawable.chicken);
        }
        if(restdata.getCate_num().equals("2")){
            imgno.setImageResource(R.drawable.pizza);
        }
        if(restdata.getCate_num().equals("3")){
            imgno.setImageResource(R.drawable.hamburger);
        }
        txtname.setText(restdata.getname());
        etmenu1.setText(restdata.getMenu1());
        etmenu2.setText(restdata.getMenu2());
        etmenu3.setText(restdata.getMenu3());
        tvTel.setText(restdata.getPhone_num());
        tvURL.setText(restdata.getHp());
        tvRegdate.setText(restdata.getDay());
    }
    public void onClick(View v){
        if(v.getId() == R.id.btnback){
            finish();
        }
        if(v.getId() == R.id.imageView2){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/"+restdata.getPhone_num()));
            startActivity(intent);
        }
        if(v.getId() == R.id.imageView3){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+restdata.getHp()));
            startActivity(intent);
        }
    }
}
