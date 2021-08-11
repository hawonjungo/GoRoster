package com.example.goroster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class Dashboard extends AppCompatActivity {

    ImageView btnDashboardBack;
    Button btnDashboardTable;
    Button btnEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        btnDashboardBack = findViewById(R.id.btnDashboardBack);
        btnDashboardBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dashboard.super.onBackPressed();
            }
        });

        btnDashboardTable = findViewById(R.id.btnDashboardTable);
        btnDashboardTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Timetable.class);
                startActivity(intent);
            }
        });

        btnEmployee = findViewById(R.id.btnEmployee);
        btnEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, EmployeeSetUp.class);
                startActivity(intent);
            }
        });
    }
}