package com.example.afinal;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity4 extends AppCompatActivity {
    ListView list;
    Db_sqlite db2 = new Db_sqlite(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        list = (ListView) findViewById(R.id.list);
        Toast.makeText(MainActivity4.this, "ok", Toast.LENGTH_SHORT).show();

        showData();
    }

    public void showData(){
        ArrayList<String> listData = new ArrayList<>(db2.getAll());
        String[] message = new  String[7];
        for(int i=0;i<listData.size();i++){
            message = listData.get(i).split("-");
            if((message[4].substring(9)).equals("1")){
                listData.set(i,"MRS " + message[1].substring(12).toUpperCase()+" "+message[2].substring(10).toUpperCase());
            }
            else {
                listData.set(i,"SIR " + message[1].substring(12).toUpperCase()+" "+message[2].substring(10).toUpperCase());
            }
        }
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.addAll(listData);
        listData.clear();
        listData.addAll(hashSet);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listData);
        list.setAdapter(arrayAdapter);

    }
}