package com.example.raj.rookart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class task_search_result extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_search_result);


        Intent intent = getIntent();
        Bundle b=intent.getExtras();
        String message = b.getString("result");
        final String user=b.getString("user");
        ListView l= new ListView(this);
        setContentView(l);
        final ArrayList<JSONObject> j= new ArrayList<JSONObject>();
        int count=0;
        String temp="";
        for(int i=0;i<message.length();i++)
        {
            char c=message.charAt(i);

            if(c=='{')
                count++;
            if(count>0)
                temp=temp+c;
            if(c=='}')
            {
                count--;
                if(count==0)
                {
                    try {
                        j.add(new JSONObject(temp));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    //System.out.println(temp);
                    temp="";
                }


            }
        }

        //converting arraylist to String array of jobs
        String jobs[]=new String[j.size()];
        for(int i=0;i<j.size();i++)
            try {
                jobs[i]="Employer:"+j.get(i).getString("id")+"\nTitle:"+j.get(i).getString("title")+"\nDescription:"+j.get(i).getString("description")+"\nMobile:"+j.get(i).getString("time")+" hr\nAmount:"+j.get(i).getString("price")+" $";
            } catch (JSONException e) {
                e.printStackTrace();
            }

        ArrayAdapter<String> ad= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,jobs);
        l.setAdapter(ad);
        Toast.makeText(getApplicationContext(), "Click on task to apply", Toast.LENGTH_LONG).show();
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //  Toast.makeText(getApplicationContext(),"pressed "+id,Toast.LENGTH_SHORT).show();
                search_connection con= new search_connection();
                try {
                    JSONObject temp=j.get((int) id);
                    String tid=(temp.get("tid")).toString();
                    String e_id=(temp.get("id")).toString();
                    String descripton=(temp.get("description").toString());
                    String title=(temp.get("title").toString());
                    //Toast.makeText(getApplicationContext(),oid,Toast.LENGTH_SHORT).show();
                    con.push(user,tid,e_id,descripton,title);
                    Toast.makeText(getApplicationContext(),"Applied for task", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_task_search_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
