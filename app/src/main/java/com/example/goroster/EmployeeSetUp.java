package com.example.goroster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.goroster.data.EmpDatabase;
import com.example.goroster.dev.CustomAdapter;
import com.example.goroster.emp.Employee;

import java.util.List;

//implements AdapterView.OnItemClickListener
public class EmployeeSetUp extends AppCompatActivity {

    Spinner spinnerMon;
    Spinner spinnerTue;
    Spinner spinnerWed;
    Spinner spinnerThu;
    Spinner spinnerFri;
    Spinner spinnerSat;
    Spinner spinnerSun;
    Button btnSave;

    private TextView txtName;
    private ListView lvEmp;
    private EmpDatabase empDatabase;
    private Employee emp;
    private List<Employee> employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        // create an object database from EmpDatabase to call
        empDatabase = new EmpDatabase(this);
        emp = new Employee();
        String logEmail = getIntent().getStringExtra("Email");

        // set employee name
        txtName = findViewById(R.id.txtEmpName);
        txtName.setText(empDatabase.getDbEmpName(logEmail));

        //dbEmp.testData();
        iniWidget();
        // employee list
        employee = empDatabase.getAllEmployee();

        // using Intent to store email

        emp.setEmail(logEmail);

        // check email to verify instead of id
        //Toast.makeText(EmployeeSetUp.this, "Thee mail is: "+logEmail, Toast.LENGTH_LONG).show();



        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  create emp to use the createEmp function from Employee without instructor

                updateEmp();
                Intent intent = new Intent(EmployeeSetUp.this, Timetable.class);
                startActivity(intent);


            }
        });

        // Spinner as those dropdown menu with multiple choice
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(EmployeeSetUp.this, R.array.available, android.R.layout.simple_spinner_item);
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




    private void updateEmp() {
        // get email from employee and data from spinner
        String email = emp.getEmail();
        String mon = spinnerMon.getSelectedItem().toString();
        String tue = spinnerTue.getSelectedItem().toString();
        String wed = spinnerWed.getSelectedItem().toString();
        String thu = spinnerThu.getSelectedItem().toString();
        String fri = spinnerFri.getSelectedItem().toString();
        String sat = spinnerSat.getSelectedItem().toString();
        String sun = spinnerSun.getSelectedItem().toString();


        boolean isUpdate = empDatabase.updateTimetable(email, mon, tue, wed, thu, fri, sat, sun);
        if (isUpdate == true) {
            Toast.makeText(EmployeeSetUp.this, "Saving...", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(EmployeeSetUp.this, "Error saving", Toast.LENGTH_SHORT).show();

    }

    private void iniWidget() {
        spinnerMon = findViewById(R.id.spinnerMonday);
        spinnerTue = findViewById(R.id.spinnerTuesday);
        spinnerWed = findViewById(R.id.spinnerWednesday);
        spinnerThu = findViewById(R.id.spinnerThursday);
        spinnerFri = findViewById(R.id.spinnerFriday);
        spinnerSat = findViewById(R.id.spinnerSaturday);
        spinnerSun = findViewById(R.id.spinnerSunday);
        //check
        lvEmp = findViewById(R.id.recyclerViewIdTimetable);
    }

}