package com.example.goroster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.goroster.dev.TestRecycleViewTable;
import com.example.goroster.dev.TestTimeTableAdapter;

import java.util.ArrayList;
import java.util.List;

public class Timetable extends AppCompatActivity {

    // test recyclerview timetable
    RecyclerView recyclerView;
    TestTimeTableAdapter adapter;
    ImageView btnTimetableBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

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
        adapter = new TestTimeTableAdapter(this, getList());
        recyclerView.setAdapter(adapter);
    }

    private List<TestRecycleViewTable> getList() {
        List<TestRecycleViewTable> table = new ArrayList<>();
        table.add(new TestRecycleViewTable("1","Jun","N/A","7AM-12AM","12AM-17PM","N/A","7AM-17PM","N/A","N/A"));
        table.add(new TestRecycleViewTable("2","KAS","N/A","N/A","N/A","N/A","12AM-17PM","N/A","N/A"));
        return table;

    }


}