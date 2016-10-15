package com.example.raj.rookart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the user clicks the Send button
     *
     *
     *
     *
     */
    public void validate(View view)
    {
        EditText Mail=(EditText)findViewById(R.id.mail);
        EditText password=(EditText)findViewById(R.id.pwd);



        TextView errorText = (TextView)findViewById(R.id.status);
        String userName = Mail.getText().toString();
        String Password = password.getText().toString();

        boolean validationFlag = false;
        //Verify if the username and password are not empty.
        if(!userName.isEmpty() && !Password.isEmpty()) {
            if(userName.equals("umkc") && Password.equals("umkc"))
            {
                validationFlag = true;

            }
        }



        if(!validationFlag)
        {
            errorText.setVisibility(View.VISIBLE);
            Toast.makeText(getBaseContext(),"Please Enter Correct Credentials",Toast.LENGTH_LONG).show();
        }
        else
        {
            //This code redirects the from login page to the home page.
            Intent redirect = new Intent(MainActivity.this, HomeActivity.class);
           // redirect.putExtra("key","value");
            startActivity(redirect);
        }




    }
    public void register(View view)
    {
        Intent intent=new Intent(MainActivity.this,registration.class);
        startActivity(intent);
    }




}
