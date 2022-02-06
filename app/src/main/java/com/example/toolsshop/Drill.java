package com.example.toolsshop;

import android.widget.ImageView;

import androidx.annotation.NonNull;

public class Drill {
    private String title;
    private String info;
    private int imageResourceId;

    public String getTitle() {
        return title;
    }
    public String getInfo() {
        return info;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }

    public Drill(String title, String info, int imageResourceId) {
        this.title = title;
        this.info = info;
        this.imageResourceId = imageResourceId;
    }

    @Override
    public String toString() {
        return title;
    }
}
