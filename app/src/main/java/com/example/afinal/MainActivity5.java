package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {
    EditText id_card;
    private Db_sqlite mydb ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        id_card = (EditText)findViewById(R.id.editTextNumber2);
        mydb = new Db_sqlite(this);
    }

    public void supp(View view) {

        mydb.delete(id_card.getText().toString());

        Toast.makeText(this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);


    }
}