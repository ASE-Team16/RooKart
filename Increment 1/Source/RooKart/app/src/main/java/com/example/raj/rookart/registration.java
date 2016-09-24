package com.example.raj.rookart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registration extends AppCompatActivity {
     Button register;
     EditText fname;
     EditText email;
     EditText pass1;
     EditText num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        fname = (EditText) findViewById(R.id.fname);
        email=(EditText) findViewById(R.id.email);
        pass1=(EditText) findViewById(R.id.pass1);
        register=(Button)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (fname.getText().toString().length() == 0) {
                    fname.setError("First name not entered");
                    fname.requestFocus();
                }

                if (email.getText().toString().length() == 0) {
                    email.setError("UMKC email is Required");
                    email.requestFocus();
                }
                if (pass1.getText().toString().length() == 0) {
                    pass1.setError("Password not entered");
                    pass1.requestFocus();
                }
                if (num.getText().toString().length() == 0) {
                    num.setError("UMKC email is Required");
                    num.requestFocus();
                } else {
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public void homepage(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

}}
