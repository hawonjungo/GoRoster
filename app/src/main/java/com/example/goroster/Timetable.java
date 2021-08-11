package com.example.goroster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.goroster.data.EmpDatabase;
import com.example.goroster.dev.CustomAdapter;
import com.example.goroster.emp.Employee;

import java.util.ArrayList;
import java.util.List;

public class Timetable extends AppCompatActivity {

    // test recyclerview timetable
    RecyclerView recyclerView;
    CustomAdapter adapter;
    ImageView btnTimetableBack;
    private EmpDatabase dbEmp;
    public Employee employee;
    private List<Employee> employeeList ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        // check this
            dbEmp = new EmpDatabase(this);
           employeeList = dbEmp.getAllEmployee();

        btnTimetableBack = findViewById(R.id.btnTimetableBack);
        btnTimetableBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timetable.super.onBackPressed();
            }
        });

        recyclerView = findViewById(R.id.recyclerViewIdTimetable);
        setRecyclerView();



    }

    private void setRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter(this,employeeList,recyclerView);
        recyclerView.setAdapter(adapter);
    }




}