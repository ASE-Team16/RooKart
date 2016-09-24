package com.example.raj.rookart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registration extends AppCompatActivity {
    private Button register;
    private EditText fname;
    private EditText email;
    private EditText pass1;
    private EditText num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
       // fname = (EditText) findViewById(R.id.fname);
       // email=(EditText) findViewById(R.id.email);
     //   pass1=(EditText) findViewById(R.id.pass1);
    }



    public void homepage(View view) {
        Intent i = new Intent(this, home.class);
        startActivity(i);

}}
