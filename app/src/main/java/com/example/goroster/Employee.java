package com.example.goroster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
//implements AdapterView.OnItemClickListener
public class Employee extends AppCompatActivity  {
    Spinner spinnerMon,spinnerTue,spinnerWed,spinnerThu,spinnerFri,spinnerSat, spinnerSun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        spinnerMon = findViewById(R.id.spinnerMonday);
        spinnerTue = findViewById(R.id.spinnerTuesday);
        spinnerWed = findViewById(R.id.spinnerWednesday);
        spinnerThu = findViewById(R.id.spinnerThursday);
        spinnerFri = findViewById(R.id.spinnerFriday);
        spinnerSat = findViewById(R.id.spinnerSaturday);
        spinnerSun = findViewById(R.id.spinnerSunday);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Employee.this,R.array.available,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMon.setAdapter(adapter);
        spinnerTue.setAdapter(adapter);
        spinnerWed.setAdapter(adapter);
        spinnerThu.setAdapter(adapter);
        spinnerFri.setAdapter(adapter);
        spinnerSat.setAdapter(adapter);
        spinnerSun.setAdapter(adapter);
        //spinner.setOnItemClickListener(this);
    }

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        String text = parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();
//    }
}