package com.geektech.hwa1l1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Second_Activity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        imageView = findViewById(R.id.iv_avatar);

        Glide.with(this).load("https://upload.wikimedia.org/" +
                "wikipedia/commons/a/a0/Pierre-Person.jpg").into(imageView);
    }
}