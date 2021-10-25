
package com.example.afinal;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    CheckBox check_female,check_male,checkA,checkB,checkC,checkD,checkE,checkF,Economie_et_gestion_entreprise,Mathématique_de_ingénieur,programmation_C,Programmation_web_et_multimédia;
    CheckBox Anglais,Francais,Circuits_numériques,Electronique_analogique,Algorithmique_de_analyse_numérique,Logique_formelle,Théorie_des_langages_et_compilation,Algorithmique_de_graphes_et_optimisation;
    CheckBox Transmission_numérique,Introduction_aux_systèmes_exploitation_et_environnement_Unix,Architecture_micro_processeurs,Probabilités_appliquées,Programmation_orientée_objet,Introduction_aux_systèmes_financiers_et_gestion_bancaire;
    EditText f_name,s_name,pa;
    Db_sqlite db2 = new Db_sqlite(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        f_name = (EditText) findViewById(R.id.editTextTextPersonName);
        s_name = (EditText) findViewById(R.id.editTextTextPersonName2);
        pa = (EditText) findViewById(R.id.editTextNumber);
        check_female = (CheckBox) findViewById(R.id.checkBox3);
        check_male = (CheckBox) findViewById(R.id.checkBox2);
        checkA = (CheckBox) findViewById(R.id.checkBox9);
        checkB = (CheckBox) findViewById(R.id.checkBox8);
        checkC = (CheckBox) findViewById(R.id.checkBox7);
        checkD = (CheckBox) findViewById(R.id.checkBox6);
        checkE = (CheckBox) findViewById(R.id.checkBox5);
        checkF = (CheckBox) findViewById(R.id.checkBox4);
        Economie_et_gestion_entreprise = (CheckBox) findViewById(R.id.checkBox20);
        Mathématique_de_ingénieur = (CheckBox) findViewById(R.id.checkBox21);
        programmation_C = (CheckBox) findViewById(R.id.checkBox22);
        Anglais = (CheckBox) findViewById(R.id.checkBox28);
        Francais = (CheckBox) findViewById(R.id.checkBox27);
        Circuits_numériques = (CheckBox) findViewById(R.id.checkBox26);
        Electronique_analogique = (CheckBox) findViewById(R.id.checkBox25);
        Algorithmique_de_analyse_numérique = (CheckBox) findViewById(R.id.checkBox24);
        Logique_formelle = (CheckBox) findViewById(R.id.checkBox23);
        Théorie_des_langages_et_compilation = (CheckBox) findViewById(R.id.checkBox19);
        Transmission_numérique = (CheckBox) findViewById(R.id.checkBox18);
        Introduction_aux_systèmes_exploitation_et_environnement_Unix = (CheckBox) findViewById(R.id.checkBox17);
        Architecture_micro_processeurs = (CheckBox) findViewById(R.id.checkBox16);
        Probabilités_appliquées = (CheckBox) findViewById(R.id.checkBox15);
        Programmation_web_et_multimédia = (CheckBox) findViewById(R.id.checkBox13);
        Algorithmique_de_graphes_et_optimisation = (CheckBox) findViewById(R.id.checkBox11);
        Programmation_orientée_objet = (CheckBox) findViewById(R.id.checkBox14);
        Introduction_aux_systèmes_financiers_et_gestion_bancaire = (CheckBox) findViewById(R.id.checkBox12);


    }

    public void adds(View view) {
        ArrayList<Integer> mod = new ArrayList(18);
        int sexe = 0;
        String cl ="";
        boolean verify1 = true;


        String F_name = f_name.getText().toString();
        String S_name = s_name.getText().toString();

        if (F_name.equals("")) {
            Toast.makeText(MainActivity3.this, "First name is empty", Toast.LENGTH_SHORT).show();
            verify1 = false;
        } else if (S_name.equals("")){
            Toast.makeText(MainActivity3.this, "Surname is empty", Toast.LENGTH_SHORT).show();
            verify1 = false;
        }
        else if(((check_female.isChecked())&&(check_male.isChecked()))||(!(check_female.isChecked())&&!(check_male.isChecked()))){
            Toast.makeText(MainActivity3.this, "you must choice your gender correctly", Toast.LENGTH_SHORT).show();
            verify1 = false;
        }
        else if((pa.getText().toString()).equals("")){
            Toast.makeText(MainActivity3.this, "enter your ID_card", Toast.LENGTH_SHORT).show();
            verify1 = false;
        }
        else if((Long.parseLong(pa.getText().toString())<10000000)||(Long.parseLong(pa.getText().toString())>99999999)) {
            Toast.makeText(MainActivity3.this, "your ID_card is incorrect", Toast.LENGTH_SHORT).show();
            verify1 = false;
        }

        if((checkA.isChecked())&&!(checkB.isChecked())&&!(checkC.isChecked())&&!(checkD.isChecked())&&!(checkE.isChecked())&&!(checkF.isChecked()))
            cl="A";
        else if(!(checkA.isChecked())&&(checkB.isChecked())&&!(checkC.isChecked())&&!(checkD.isChecked())&&!(checkE.isChecked())&&!(checkF.isChecked()))
            cl="B";
        else if(!(checkA.isChecked())&&!(checkB.isChecked())&&(checkC.isChecked())&&!(checkD.isChecked())&&!(checkE.isChecked())&&!(checkF.isChecked()))
            cl="C";
        else if(!(checkA.isChecked())&&!(checkB.isChecked())&&!(checkC.isChecked())&&(checkD.isChecked())&&!(checkE.isChecked())&&!(checkF.isChecked()))
            cl="D";
        else if(!(checkA.isChecked())&&!(checkB.isChecked())&&!(checkC.isChecked())&&!(checkD.isChecked())&&(checkE.isChecked())&&!(checkF.isChecked()))
            cl="E";
        else if(!(checkA.isChecked())&&!(checkB.isChecked())&&!(checkC.isChecked())&&!(checkD.isChecked())&&!(checkE.isChecked())&&(checkF.isChecked()))
            cl="F";
        else
        if(verify1 && cl=="") {
            Toast.makeText(MainActivity3.this, "you must choice one and only one group", Toast.LENGTH_SHORT).show();

        }
        if (Economie_et_gestion_entreprise.isChecked())
            mod.add(1);
         if (Mathématique_de_ingénieur.isChecked())
            mod.add(2);
         if (programmation_C.isChecked())
            mod.add(3);
         if (Anglais.isChecked())
            mod.add(4);
          if (Francais.isChecked())
            mod.add(5);
          if (Circuits_numériques.isChecked())
            mod.add(6);
         if (Electronique_analogique.isChecked())
            mod.add(7);
          if (Algorithmique_de_analyse_numérique.isChecked())
            mod.add(8);
           if (Logique_formelle.isChecked())
            mod.add(9);
          if (Théorie_des_langages_et_compilation.isChecked())
            mod.add(10);
          if (Transmission_numérique.isChecked())
            mod.add(11);
          if (Introduction_aux_systèmes_exploitation_et_environnement_Unix.isChecked())
            mod.add(12);
          if (Architecture_micro_processeurs.isChecked())
            mod.add(13);
         if (Probabilités_appliquées.isChecked())
            mod.add(14);
         if (Programmation_web_et_multimédia.isChecked())
            mod.add(15);
         if (Algorithmique_de_graphes_et_optimisation.isChecked())
            mod.add(16);
         if (Programmation_orientée_objet.isChecked())
            mod.add(17);
         if (Introduction_aux_systèmes_financiers_et_gestion_bancaire.isChecked())
            mod.add(18);


        if((!cl.equals(""))&&(verify1 && (mod.size() != 1) )) {
            Toast.makeText(MainActivity3.this, "you must choice one and only one module", Toast.LENGTH_SHORT).show();
        }
        if((!cl.equals("")) && ((mod.size() == 1) && (mod.get(0)!=0 )) && (verify1)){
            if(check_female.isChecked())
                sexe=1;
            else{
                sexe=2;}

            Boolean r = db2.insertData(f_name.getText().toString(), s_name.getText().toString(),pa.getText().toString(),sexe, cl,  mod.get(0));
            if (r){
                Intent myintent = new Intent(this, MainActivity.class);
            startActivity(myintent);}


        }



    }



}
