package com.example.goroster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.goroster.data.EmpDatabase;
import com.example.goroster.emp.Employee;

public class Login extends AppCompatActivity {



    private Button signUp;
    private Button btnLogin;
    private EditText email;
    private EditText password;

    private EmpDatabase dbEmp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        dbEmp = new EmpDatabase(this);

        signUp = findViewById(R.id.btnSignUp);
        btnLogin = findViewById(R.id.btnLogin);
        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);



        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);

            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String logEmail = email.getText().toString();
                String logPassword = password.getText().toString();

                if(logEmail.equals("") || logPassword.equals("")){
                    Toast.makeText(Login.this,"Email or password can't be empty",Toast.LENGTH_SHORT).show();
                }else{
                    boolean logVerify = dbEmp.verifyLogin(logEmail,logPassword);
                    if(logVerify == true){
                        Intent intent = new Intent(Login.this,Dashboard.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login.this,"Incorrect email or password",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }

}