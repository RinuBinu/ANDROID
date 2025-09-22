package com.example.sharedpreferance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, number, Email, password, cpassword;
    Button Submit;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        number = findViewById(R.id.number);
        Email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);
        cpassword = findViewById(R.id.cPassword);
        Submit = findViewById(R.id.Submit);

        sharedPreferences = getSharedPreferences("user details", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ✅ Rename local variables to avoid conflict with EditText variables
                String strName = name.getText().toString().trim();
                String strNumber = number.getText().toString().trim();
                String strEmail = Email.getText().toString().trim();
                String strPassword = password.getText().toString().trim();
                String strCPassword = cpassword.getText().toString().trim();

                if (strName.isEmpty()) {
                    name.setError("name is Empty");
                    name.requestFocus();
                    return;
                }
                if (strNumber.isEmpty()) {
                    number.setError("phone number is Empty");
                    number.requestFocus();
                    return;
                }
                if (strEmail.isEmpty()) {
                    Email.setError("input email");
                    Email.requestFocus();
                    return;
                }
                if (strPassword.isEmpty()) {
                    password.setError("Enter password");
                    password.requestFocus();
                    return;
                }
                if (strCPassword.isEmpty()) {
                    cpassword.setError("confirm password");
                    cpassword.requestFocus();
                    return;
                }
                if (strPassword.length() < 6) {
                    password.setError("length must be minimum of 6 characters");
                    password.requestFocus();
                    return;
                }

                if (!strPassword.equals(strCPassword)) {
                    cpassword.setError("password not matched");
                    cpassword.requestFocus();
                    return;
                }

                Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                editor.putString("keyname", strName);
                editor.putString("keynumber", strNumber);
                editor.putString("keyEmail", strEmail);
                editor.putString("keypassword", strPassword);
                editor.apply();
            }
        });
    }
}
