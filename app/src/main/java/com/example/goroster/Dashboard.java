package com.example.goroster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    ImageView btnDashboardBack;
    Button btnDashboardTable;
    Button btnEmployee;
    Button btnManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        String logEmail = getIntent().getStringExtra("Email");


        // button back
        btnDashboardBack = findViewById(R.id.btnDashboardBack);
        btnDashboardBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dashboard.super.onBackPressed();
            }
        });
        // button table - roster
        btnDashboardTable = findViewById(R.id.btnDashboardTable);
        btnDashboardTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Timetable.class);
                startActivity(intent);
            }
        });
        // button for employee input availability
        btnEmployee = findViewById(R.id.btnEmployee);
        btnEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, EmployeeSetUp.class);
                intent.putExtra("Email",logEmail);
                startActivity(intent);
            }
        });
        // button manager
        btnManager = findViewById(R.id.btnManager);
        btnManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Manager.class);
                startActivity(intent);
            }
        });









    }
}