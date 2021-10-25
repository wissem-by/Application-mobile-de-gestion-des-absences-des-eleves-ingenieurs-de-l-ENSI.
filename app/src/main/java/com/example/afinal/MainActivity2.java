package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity2 extends AppCompatActivity {
    String str;
    TextView tx;
    String[] t,tc,tm;
    Animation topAnim2,bottomAnim2;
    TableLayout table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle b = getIntent().getExtras();
        str = b.getString("lis");
        t = str.split("-");

        table =(TableLayout)findViewById(R.id.tableLayout);
        tx = (TextView) findViewById(R.id.textView2);

        if(t[2].equals("1")){
            tx.setText("WELCOME MRS " + t[1].toUpperCase()+"\nPlease choice your group");
        }
        else {
            tx.setText("WELCOME SIR " + t[1].toUpperCase()+"\nPlease choice your group");
        }
        tc = t[3].split(",");
        tm = t[4].split(",");


        topAnim2 = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim2 = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        tx.setAnimation(topAnim2);
        table.setAnimation(bottomAnim2);



    }
    public String searchMod(String s){
        int i;
        String str="";
        for(i=0;i<tc.length;i++){
            if(tc[i].equals(s)){
                str+=","+tm[i];
            }
        }
        str =str.substring(1);
        return str;
    }

    public void classe_a(View view) {
        Intent myintent = new Intent(this, MainActivity6.class);
        Bundle b = new Bundle();
        if(t[3].contains("A")) {
            b.putString("mod",searchMod("A"));
            b.putString("class","A");
            myintent.putExtras(b);
            startActivity(myintent);

        }
        else
            Toast.makeText(MainActivity2.this, "no", Toast.LENGTH_SHORT).show();
    }
    public void classe_b(View view) {
        Intent myintent = new Intent(this, MainActivity6.class);
        Bundle b = new Bundle();
        if(t[3].contains("B")) {
            b.putString("mod",searchMod("B"));
            b.putString("class","B");
            myintent.putExtras(b);
            startActivity(myintent);
        }
        else
            Toast.makeText(MainActivity2.this, "no", Toast.LENGTH_SHORT).show();
    }
    public void classe_c(View view) {
        Intent myintent = new Intent(this, MainActivity6.class);
        Bundle b = new Bundle();
        if(t[3].contains("C")) {
            b.putString("mod",searchMod("C"));
            b.putString("class","C");
            myintent.putExtras(b);
            startActivity(myintent);
        }

        else
            Toast.makeText(MainActivity2.this, "no", Toast.LENGTH_SHORT).show();
    }
    public void classe_d(View view) {
        Intent myintent = new Intent(this, MainActivity6.class);
        Bundle b = new Bundle();
        if(t[3].contains("D")) {
            b.putString("mod",searchMod("D"));
            b.putString("class","D");
            myintent.putExtras(b);
            startActivity(myintent);
        }
        else
            Toast.makeText(MainActivity2.this, "no", Toast.LENGTH_SHORT).show();
    }
    public void classe_e(View view) {
        Intent myintent = new Intent(this, MainActivity6.class);
        Bundle b = new Bundle();
        if(t[3].contains("E")) {
            b.putString("mod",searchMod("E"));
            b.putString("class","E");
            myintent.putExtras(b);
            startActivity(myintent);
        }
        else
            Toast.makeText(MainActivity2.this, "no", Toast.LENGTH_SHORT).show();
    }
    public void classe_f(View view) {
        Intent myintent = new Intent(this, MainActivity6.class);
        Bundle b = new Bundle();
        if(t[3].contains("F")) {
            b.putString("mod",searchMod("F"));
            b.putString("class","F");
            myintent.putExtras(b);
            startActivity(myintent);
        }
        else
            Toast.makeText(MainActivity2.this, "no", Toast.LENGTH_SHORT).show();
    }
}