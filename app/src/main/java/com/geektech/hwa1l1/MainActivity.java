package com.geektech.hwa1l1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button btn_Go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        btn_Go.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Second_Activity.class);
            startActivity(intent);
        });

        Glide.with(this).load("https://i.pinimg.com/474x/23/ab/a6/" +
                "23aba60b66ef08174bb7455c4a8a2d2f.jpg").into(imageView);
        // загружаем изображение из интенета в iv_image
    }

    private void initViews() {
        btn_Go = findViewById(R.id.button);
        //инициализируем кнопку
        imageView = findViewById(R.id.iv_image);
        // инициализируем изображение
    }

}