package com.kitesoft.activityex;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> datas= new ArrayList<String>();

    ListView listView;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("게시판");

        listView= findViewById(R.id.listview);
        adapter= new ArrayAdapter(this, R.layout.listview_item, datas);
        listView.setAdapter(adapter);

        Toast.makeText(this, "onCreate MainActivity", Toast.LENGTH_SHORT).show();
    }

    public void clickBtn(View view) {

        Intent intent= new Intent(this, EditActivity.class);
        startActivityForResult(intent, 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch ( requestCode ){
            case 10:
                if(resultCode==RESULT_OK){
                    String name= data.getStringExtra("Name");
                    String nick= data.getStringExtra("Nick");
                    String title= data.getStringExtra("Title");
                    String content= data.getStringExtra("Content");

                    String str= name+"   " + nick + "\n\n" + title + "\n\n" + content;

                    datas.add( 0, str );
                    adapter.notifyDataSetChanged();
                }
                break;
        }

    }
}
