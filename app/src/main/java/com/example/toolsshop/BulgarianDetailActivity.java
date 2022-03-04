package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BulgarianDetailActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private TextView textViewInfo;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulgarian_detail);
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
            int imageResourceId = intent.getIntExtra("imageResourceId", -1);
            textViewTitle.setText(title);
            textViewInfo.setText(info);
            imageView.setImageResource(imageResourceId);
        } else {
            Intent backToCategoryActivity = new Intent(getApplicationContext(), BulgarianCategoryActivity.class);
            startActivity(backToCategoryActivity);
        }
    }
}