package com.example.goroster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Manager extends AppCompatActivity {

    ImageView btnManaBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        btnManaBack = findViewById(R.id.btnManagerBack);
        btnManaBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Manager.super.onBackPressed();
            }
        });
    }
}