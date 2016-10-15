package com.example.raj.rookart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registration extends AppCompatActivity {
    Button register, login;
    EditText fname, email, pass1, num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Intent intent = getIntent();
    }

    public void register(View view) {


            fname = (EditText) findViewById(R.id.fname);
            email = (EditText) findViewById(R.id.email);
            pass1 = (EditText) findViewById(R.id.pass1);
            num = (EditText) findViewById(R.id.num);
                register = (Button) findViewById(R.id.register);
            login = (Button) findViewById(R.id.login);

        String Email= email.getText().toString();
        String Password = pass1.getText().toString();
        String Num = num.getText().toString();
        String Fname = fname.getText().toString();

        Log.d("Details:",Email+Password+Num+Fname);


            if ((Fname.equals("")||Email.equals("") || Password.equals("")|| Num.equals("")))
            {
                if (fname.length() < 3)
                {
                    fname.setError("at least 3 characters");

                }
                else
                {
                  fname.setError(null);
                }




                if (email.length() < 3)
                {
                    email.setError("UMKC email address only");

                }
                else
                {
                    email.setError(null);
                }




                if (pass1.length() < 6)
                {
                    pass1.setError("at least 6 characters");

                }
                else
                {
                    pass1.setError(null);
                }


                if (num.length() < 10)
                {
                    num.setError("10 numbers please");

                }
                else
                {
                    num.setError(null);
                }

            }
            else
            {

               Intent intent = new Intent(registration.this, MainActivity.class);
                startActivity(intent);

            }

    }
    public void login(View view)
    {
        Intent intent = new Intent(registration.this, MainActivity.class);
        startActivity(intent);
    }




}






