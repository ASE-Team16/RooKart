package com.example.raj.rookart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    EditText ed1, ed2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void homepage(View view)
    {
        b1 = (Button) findViewById(R.id.login);
        b2 = (Button) findViewById(R.id.login);
        ed1 = (EditText) findViewById(R.id.email);
        ed2 = (EditText) findViewById(R.id.pass1);

                if (!ed1.toString().isEmpty() && !ed2.toString().isEmpty()) {
                    if (ed1.getText().toString().equals("admin") && ed2.getText().toString().equals("admin")) {
                        Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
                else {//page not redirecting
                    Intent i = new Intent(this, home.class);
                    startActivity(i);
                }

        }


    /**
     * Called when the user clicks the Send button
     */
    public void register(View view) {
        Intent intent = new Intent(MainActivity.this, registration.class);
        startActivity(intent);

    }
}








