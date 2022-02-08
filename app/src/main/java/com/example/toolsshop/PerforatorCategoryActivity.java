package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PerforatorCategoryActivity extends AppCompatActivity {

    private ListView listViewPerforators;
    private ArrayList <Perforator> perforators;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perforator_category);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.hide();
        }
        perforators = new ArrayList <>();
        perforators.add(new Perforator(getString(R.string.perforator_stanley_title), getString(R.string.perforator_stanley_info), R.drawable.stanley));
        perforators.add(new Perforator(getString(R.string.perforator_diold_title), getString(R.string.perforator_diold_info), R.drawable.diold));
        listViewPerforators = findViewById(R.id.listViewPerforators);
        ArrayAdapter <Perforator> adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, perforators);
        listViewPerforators.setAdapter(adapter);
        listViewPerforators.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Perforator perforator = perforators.get(position);
                Intent intent = new Intent(getApplicationContext(), PerforatorDetailActivity.class);
                startActivity(intent);
                intent.putExtra("title", perforator.getTitle());
                intent.putExtra("info", perforator.getInfo());
                intent.putExtra("imageResourceId", perforator.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}
