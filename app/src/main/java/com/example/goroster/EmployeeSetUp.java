package com.example.goroster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.goroster.data.EmpDatabase;
import com.example.goroster.emp.Employee;

//implements AdapterView.OnItemClickListener
public class EmployeeSetUp extends AppCompatActivity  {

    Spinner spinnerMon,spinnerTue,spinnerWed,spinnerThu,spinnerFri,spinnerSat, spinnerSun;
    Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        // create an object database from EmpDatabase to call
        EmpDatabase dbEmp = new EmpDatabase(this);
        //dbEmp.testData();

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  create emp to use the createEmp function from Employee without instructor
               Employee emp = createEmp();
               if(emp != null){
                   dbEmp.addEmp(emp);
                   Intent intent = new Intent(EmployeeSetUp.this,Timetable.class);
                   startActivity(intent);

               }
            }
        });



        spinnerMon = findViewById(R.id.spinnerMonday);
        spinnerTue = findViewById(R.id.spinnerTuesday);
        spinnerWed = findViewById(R.id.spinnerWednesday);
        spinnerThu = findViewById(R.id.spinnerThursday);
        spinnerFri = findViewById(R.id.spinnerFriday);
        spinnerSat = findViewById(R.id.spinnerSaturday);
        spinnerSun = findViewById(R.id.spinnerSunday);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(EmployeeSetUp.this,R.array.available,android.R.layout.simple_spinner_item);
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



    private Employee createEmp(){
        String mon = spinnerMon.getSelectedItem().toString();
        String tue = spinnerTue.getSelectedItem().toString();
        String wed = spinnerWed.getSelectedItem().toString();
        String thu = spinnerThu.getSelectedItem().toString();
        String fri = spinnerFri.getSelectedItem().toString();
        String sat = spinnerSat.getSelectedItem().toString();
        String sun = spinnerSun.getSelectedItem().toString();

       Employee emp1 = new Employee("Jun",mon,tue,wed,thu,fri,sat,sun);
       return emp1;
    }

}