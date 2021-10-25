package com.example.afinal;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;


public class MainActivity6 extends AppCompatActivity  {
    ArrayList<String> List = new ArrayList<>();
    String[] m;
    static String matière ;
    private Db_sqlite mydb ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        final ListView list = findViewById(R.id.Lessons);
        Bundle b = getIntent().getExtras();
        m= b.getString("mod").split(",");
       // Toast.makeText(MainActivity6.this,m, Toast.LENGTH_SHORT).show();
        mydb = new Db_sqlite(this);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Programmation orientée objet");
        arrayList.add("Algorithmique de graphes et optimisation");
        arrayList.add("Programmation web et multimédia");
        arrayList.add("Architecture  micro processeurs");
        arrayList.add("Introduction aux systèmes financiers et gestion bancaire");
        arrayList.add("Francais");
        arrayList.add("Anglais");
        arrayList.add("Introduction aux systèmes d’exploitation et environnement Unix");
        arrayList.add("Economie et gestion d’entreprise");
        arrayList.add("Mathématique de l’ingénieur");
        arrayList.add("Théorie des langages et compilation");
        arrayList.add("Transmission numérique");
        arrayList.add("Logique formelle");
        arrayList.add("Electronique analogique");
        arrayList.add("programmation C");
        arrayList.add("Algorithmique de l’analyse numérique");
        arrayList.add("Probabilités appliquées");
        arrayList.add("Circuits numériques");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int p, long id) {
                String selectedItem = (String) parent.getItemAtPosition(p);
                matière=selectedItem;
                for(int i=0 ;i<m.length;i++)
                    List.add(m[i]);
                switch (matière) {
                    case "Introduction aux systèmes d’exploitation et environnement Unix":
                        if (List.contains("12")){
                            traitement();
                            }
                        break;

                    case "Programmation orientée objet" :
                        if(List.contains("17")){
                            traitement();
                        }
                        break;

                  case "Algorithmique de graphes et optimisation" :
                        if(List.contains("16")){
                            traitement();
                        }
                        break;

                    case "Programmation web et multimédia" :
                        if(List.contains("15")){
                            traitement();
                        }
                        break;

                    case "Architecture  micro processeurs" :
                        if(List.contains("13")){
                            traitement();
                        }
                        break;

                    case "Introduction aux systèmes financiers et gestion bancaire" :
                        if(List.contains("18")){
                            traitement();
                        }
                        break;

                    case "Francais" :
                        if(List.contains("5")){
                            traitement();
                        }
                        break;

                    case "Anglais" :
                        if(List.contains("4")){
                            traitement();
                        }
                        break;

                    case "Economie et gestion d’entreprise" :
                        if(List.contains("1")){
                            traitement();
                        }
                        break;

                    case "Mathématique de l’ingénieur" :
                        if(List.contains("2")){
                            traitement();
                        }
                        break;

                    case "Théorie des langages et compilation" :
                        if(List.contains("10")){
                            traitement();
                        }
                        break;

                    case "Transmission numérique" :
                        if(List.contains("11")){
                            traitement();
                        }
                        break;

                    case "Logique formelle" :
                        if(List.contains("9")){
                            traitement();
                        }
                        break;

                    case "Electronique analogique" :
                        if(List.contains("7")){
                            traitement();
                        }
                        break;

                    case "programmation C" :
                        if(List.contains("3")){
                            traitement();
                        }
                        break;

                    case "Algorithmique de l’analyse numérique" :
                        if(List.contains("8")){
                            traitement();
                        }
                        break;

                    case "Probabilités appliquées" :
                        if(List.contains("14")){
                            traitement();
                        }
                        break;

                    case "Circuits numériques" :
                        if(List.contains("6")){
                            traitement();
                        }
                        break;

                }
            }
        });



    }


    public void traitement()
    {
        String classe = getIntent().getStringExtra("class");
        ArrayList<String> listData = new ArrayList<>(mydb.getGroup(classe));
        Intent myintent = new Intent(this, MainActivity9.class);
        Bundle  B =new Bundle();
        B.putSerializable("ARRAYLIST",(Serializable) listData);
        myintent.putExtra("BUNDLE",B);
        startActivity(myintent);
}

}






