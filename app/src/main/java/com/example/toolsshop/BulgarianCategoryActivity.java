package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class BulgarianCategoryActivity extends AppCompatActivity {

    private ListView listViewBulgarian;
    private ArrayList <Bulgarian> bulgarians;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulgarian_category);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        listViewBulgarian = findViewById(R.id.listViewBulgarian);
        bulgarians = new ArrayList<>();
        bulgarians.add(new Bulgarian(getString(R.string.bulgarian_sturm_title), (getString(R.string.bulgarian_sturm_info)), R.drawable.sturm));
        bulgarians.add(new Bulgarian(getString(R.string.bulgarian_metabo_title), (getString(R.string.bulgarian_metabo_info)), R.drawable.matabo));
        bulgarians.add(new Bulgarian(getString(R.string.bulgarian_hitachi_title), (getString(R.string.bulgarian_hitachi_info)), R.drawable.hitachi));

        ArrayAdapter<Bulgarian> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, bulgarians);
        listViewBulgarian.setAdapter(adapter);
        listViewBulgarian.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Bulgarian bulgarian = bulgarians.get(position);
                Intent intent = new Intent(getApplicationContext(), BulgarianDetailActivity.class);
                startActivity(intent);
                intent.putExtra("title", bulgarian.getTitle());
                intent.putExtra("info", bulgarian.getInfo());
                intent.putExtra("imageResourceId", bulgarian.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}