package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrillDetailActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private TextView textViewInfo;
    private ImageView imageViewDrill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detail);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        imageViewDrill = findViewById(R.id.imageViewDrill);
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewInfo = findViewById(R.id.textViewInfo);
        Intent intent = getIntent();
        if(intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("imageResourceId")) {
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int imageResourceId = intent.getIntExtra("imageResourceId", -1);
            textViewTitle.setText(title);
            textViewInfo.setText(info);
            imageViewDrill.setImageResource(imageResourceId);
        } else {
            Intent backToCategory = new Intent(this, DrillCategoryActivity.class);
            startActivity(intent);
        }
    }
}