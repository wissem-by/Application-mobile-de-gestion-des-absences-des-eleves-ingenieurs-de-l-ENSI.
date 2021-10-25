package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Db_sqlite db2 = new Db_sqlite(this);
    EditText email,motdepasse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        motdepasse = (EditText) findViewById(R.id.editTextTextPassword);

    }

    public void submit(View view) {

        if (db2.searchEmail(email.getText().toString())){
            if(db2.searchteacher(email.getText().toString(),motdepasse.getText().toString())){

                db2.insert_init();
                Intent myintent = new Intent(this, MainActivity2.class);
                String listData1 =db2.getAllCaseId(motdepasse.getText().toString());
                Bundle bu= new Bundle();
                bu.putString("lis",listData1);
                myintent.putExtras(bu);
                startActivity(myintent);
            }
            else{
                Toast.makeText(MainActivity.this, "mot de pass incorrect", Toast.LENGTH_SHORT).show();
                Intent myintent = new Intent(this, MainActivity.class);
                startActivity(myintent);
            }
        }
        else{
            Toast.makeText(MainActivity.this, "votre e-mail incorrect", Toast.LENGTH_SHORT).show();
            Intent myintent = new Intent(this, MainActivity.class);
            startActivity(myintent);
        }
    }

    public void add(View view) {
        Intent myintent = new Intent(this, MainActivity3.class);
        startActivity(myintent);

    }


    public void listusers(View view) {
        Intent myintent = new Intent(this, MainActivity4.class);
        startActivity(myintent);


    }
    public void delete(View view) {
        Intent myintent = new Intent(this, MainActivity5.class);
        startActivity(myintent);
    }


}