package com.example.raj.rookart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by rajes on 9/25/2016.
 */

public class HomeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homelayout);
    }


    public void product(View view)
    {
        Intent intent =new Intent(HomeActivity.this, Product.class);
        startActivity(intent);
    }
    public void service(View view)
    {
        Intent intent =new Intent(HomeActivity.this,Service.class);
        startActivity(intent);
    }
}
