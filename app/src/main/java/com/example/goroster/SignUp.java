package com.example.goroster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.goroster.data.EmpDatabase;
import com.example.goroster.emp.Employee;

public class SignUp extends AppCompatActivity {
    private Button signUpAcc;
    private EditText sUpNickName;
    private EditText sUpEmail;
    private EditText sUpPassword;
    private EditText sUpPhone;

    private EmpDatabase dbEmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        dbEmp = new EmpDatabase(this);
        sUpNickName = findViewById(R.id.sUpNickName);
        sUpEmail = findViewById(R.id.sUpEmail);
        sUpPassword = findViewById(R.id.sUpPassword);
        sUpPhone = findViewById(R.id.sUpPhone);

        // button sign up
        signUpAcc = findViewById(R.id.btnSignUpAcc);
        signUpAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Employee emp = sUpEmployee();
                //add Sign up new account as add new employee
                if(emp != null){
                    dbEmp.addEmp(emp);
                    Intent intent = new Intent(SignUp.this,Login.class);
                    startActivity(intent);
                    Toast.makeText(SignUp.this,"Sign Up successful !",Toast.LENGTH_LONG).show();
                }



            }
        });
    }

    private Employee sUpEmployee(){
        // get data from User signUP
        String getNickName = sUpNickName.getText().toString();
        String getEmail = sUpEmail.getText().toString();
        String getPassword = sUpPassword.getText().toString();
        String getPhone = sUpPhone.getText().toString();

        boolean verifyEmail = dbEmp.verifyUser(getEmail);
        // check if email exist
        if(verifyEmail ==false){
            Employee emp = new Employee(getNickName,getEmail,getPassword,getPhone);
            return emp;
        }
        Toast.makeText(SignUp.this,"Email already exist",Toast.LENGTH_LONG).show();
            return null;



    }

}