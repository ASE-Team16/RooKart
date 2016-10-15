package com.example.raj.rookart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Intent intent = getIntent();
    }

    public void register(View view)
    {
        Intent intent=new Intent(registration.this,MainActivity.class);
        startActivity(intent);
    }
}
