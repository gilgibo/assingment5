package com.example.gibo.assignment5;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main2Activity extends AppCompatActivity {

    EditText etname,ettel,etmenu1,etmenu2,etmenu3,etaddr;
    RadioButton radio1,radio2,radio3;
    RestData data;
    SimpleDateFormat cNow = new SimpleDateFormat("yyyy/MM/dd");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etname = (EditText)findViewById(R.id.etname);
        ettel = (EditText)findViewById(R.id.ettel);
        etmenu1 = (EditText)findViewById(R.id.etmenu1);
        etmenu2 = (EditText)findViewById(R.id.etmenu2);
        etmenu3 = (EditText)findViewById(R.id.etmenu3);
        etaddr = (EditText)findViewById(R.id.etaddr);
        radio1 = (RadioButton)findViewById(R.id.radio1);
        radio2 = (RadioButton)findViewById(R.id.radio2);
        radio3 = (RadioButton)findViewById(R.id.radio3);
    }

    public void onClick(View v){
        if(v.getId() == R.id.btnCancel){
            finish();
        }
        if(v.getId() == R.id.btnAdd){
            Intent intent = new Intent();
            setdata();
            if(radio1.isChecked()){
                data.setcate("1");
            }else if(radio2.isChecked()){
                data.setcate("2");
            }else if(radio3.isChecked()){
                data.setcate("3");
            }
            intent.putExtra("info",data);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    public void setdata(){
        Date date = new Date(System.currentTimeMillis());
        String formateDate = cNow.format(date);

        data = (new RestData(etname.getText().toString(),ettel.getText().toString(),etmenu1.getText().toString(),etmenu2.getText().toString(),
                etmenu3.getText().toString(),etaddr.getText().toString(),formateDate,""));
    }
}
