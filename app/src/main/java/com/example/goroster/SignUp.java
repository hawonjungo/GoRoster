package com.example.goroster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {
    private Button signUpAcc;
    private EditText sUpNickName;
    private EditText sUpEmail;
    private EditText sUpPassword;
    private EditText sUpPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

            signUpAcc = findViewById(R.id.btnSignUpAcc);

        signUpAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNickName = sUpNickName.getText().toString();
                String getEmail = sUpEmail.getText().toString();
                String getPassword = sUpPassword.getText().toString();
                String getPhone = sUpPhone.getText().toString();


                Intent intent = new Intent(SignUp.this,Dashboard.class);
                startActivity(intent);
            }
        });
    }
}