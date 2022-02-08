package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PerforatorDetailActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private TextView textViewInfo;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perforator_detail);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.hide();
        }
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewInfo = findViewById(R.id.textViewInfo);
        imageView = findViewById(R.id.imageView);
        Intent intent = getIntent();
        if(intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("imageResourceId")) {
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int resId = intent.getIntExtra("imageResourceId", -1);
            textViewTitle.setText(title);
            textViewInfo.setText(info);
            imageView.setImageResource(resId);
        } else {
            Intent backToCategoryActivity = new Intent(this, PerforatorCategoryActivity.class);
            startActivity(intent);
        }
    }
}