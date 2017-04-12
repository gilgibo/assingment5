package com.example.gibo.assignment5;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<RestData> restdata = new ArrayList<RestData>();
    ArrayList<String> namedata = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    RestData info;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.tv);
        setListView();
    }


    public void onClick(View v){
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivityForResult(intent,10);
    }

    public void setListView(){
        listView = (ListView)findViewById(R.id.listview);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,namedata);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("").setIcon(R.drawable.potato).setTitle("제거").setMessage("제거 하십니까?").setPositiveButton("닫기",null)
                        .setNegativeButton("제거", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "제거 했습니다",Toast.LENGTH_SHORT).show();
                                namedata.remove(position);
                                restdata.remove(position);
                                tv.setText("맛집 리스트("+restdata.size()+"개)");
                                adapter.notifyDataSetChanged();
                            }
                        }).show();
                return true;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this , Main3Activity.class);
                intent.putExtra("list",restdata.get(position));
                startActivity(intent);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if(requestCode == 10){
            if(resultCode == RESULT_OK){
                RestData info = data.getParcelableExtra("info");
                restdata.add(info);
                namedata.add(info.getname());
                tv.setText("맛집 리스트("+restdata.size()+"개)");
                adapter.notifyDataSetChanged();
            }
        }
    }
}
