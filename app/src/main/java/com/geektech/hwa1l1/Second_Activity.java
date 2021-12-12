package com.geektech.hwa1l1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Second_Activity extends AppCompatActivity {
    private ImageView imageView;
    private TextView editPhoto, username, password;
    private final int CAMERA_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        intents();
        editPhoto.setOnClickListener(v -> {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI.getPath());
                startActivityForResult(intent, CAMERA_REQUEST);
            } else {
                requestPermissions(new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA}, 1);
            }
        });
    }

    private void intents() {
        String usernameFromMainActivity;
        String passwordFromMainActivity;
        usernameFromMainActivity = getIntent().getStringExtra("username");
        username.setText(usernameFromMainActivity);
        passwordFromMainActivity = getIntent().getStringExtra("password");
        password.setText(String.valueOf(passwordFromMainActivity));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK && data != null) {

            Glide.with(this).load(data.getExtras().get("data")).into(imageView);

            /*Bitmap picture = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(picture);*/

        }
    }

    private void initViews() {
        username = findViewById(R.id.tv_email);
        password = findViewById(R.id.tv_password);
        imageView = findViewById(R.id.iv_avatar);
        editPhoto = findViewById(R.id.tv_edit_photo);
    }
}