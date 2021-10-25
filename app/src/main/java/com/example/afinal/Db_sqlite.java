package com.example.afinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Db_sqlite extends SQLiteOpenHelper {
    public  static  final String BDame ="data_db";



    public Db_sqlite(@Nullable Context context) {
        super(context, BDame, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table my_table ( id INTEGER PRIMARY KEY AUTOINCREMENT, fir_name TEXT, surname TEXT, mdp TEXT, gender INTEGER, class TEXT, module INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE my_table1 ( ide INTEGER PRIMARY KEY AUTOINCREMENT, Firstname TEXT, Surname TEXT, Id TEXT, Groupe TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS my_table");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS my_table1");
        onCreate(sqLiteDatabase);

    }
    public boolean insertData(String first, String sur, String pass, int sexe,String classes, int matière){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fir_name",first);
        contentValues.put("surname",sur);
        contentValues.put("mdp",pass);
        contentValues.put("gender",sexe);
        contentValues.put("class",classes);
        contentValues.put("module",matière);
        long res=db.insert("my_table",null,contentValues);
        db.close();
        return res != -1;
    }

    public ArrayList getAll(){
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from my_table",null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            String t0 =cursor.getString(0);
            String t1 =cursor.getString(1);
            String t2 =cursor.getString(2);
            String t4 =cursor.getString(4);
            String t5 =cursor.getString(5);
            String t6 =cursor.getString(6);
            arrayList.add("id : "+t0+"-firstname : "+t1+"-surname : "+t2+"-Password : xxxxxxxx-Gender : "+t4+"-class : "+t5+"-Module : "+t6);
            cursor.moveToNext();

        }
        return arrayList;
    }
    public String getAllCaseId(String id){

        String t1="",t2="",t4="",t5="",t6="";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from my_table",null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            if(cursor.getString(3).equals(id)) {
                //String t0 = cursor.getString(0);
                t1 = cursor.getString(1);
                t2 = cursor.getString(2);
                //g t3 = cursor.getString(3);
                t4 = cursor.getString(4);
                t5 = t5+","+cursor.getString(5);
                t6 = t6+","+cursor.getString(6);


            }
            cursor.moveToNext();

        }
        return t1 + "-" + t2 + "-" + t4 + "-" + t5.substring(1) + "-" + t6.substring(1);

    }

    public boolean delete(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("my_table", "mdp" + "=" + id, null) > 0;
    }

    public boolean searchEmail(String idc){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from my_table",null);
        cursor.moveToFirst();
        while ((!cursor.isAfterLast())&&(!(cursor.getString(1)+"."+cursor.getString(2)+"@ensi-uma.tn").equals(idc))){
            cursor.moveToNext();
        }
        return !cursor.isAfterLast();
    }
    public boolean searchteacher(String idc,String mdp){

        int i=idc.indexOf(".");
        int j=idc.indexOf("@");
        String prenom=idc.substring(0,i);
        String nom=idc.substring(i+1,j);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from my_table",null);
        cursor.moveToFirst();
        while(!(cursor.getString(1)+"."+cursor.getString(2)+"@ensi-uma.tn").equals(idc)) {
            cursor.moveToNext();
        }
        return cursor.getString(3).equals(mdp);
    }

    public ArrayList<String> getGroup(String grp){
        ArrayList<String> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from my_table1",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            if(cursor.getString(4).equals(grp)) {
                String t0 = cursor.getString(0);
                String t1 = cursor.getString(1);
                String t2 = cursor.getString(2);
                String t3 = cursor.getString(3);
                arrayList.add("id : " + t0 + "-firstname : " + t1 + "-surname : " + t2 + "-Password : " + t3);
            }
            cursor.moveToNext();
        }
        return arrayList;
    }
    public void insert_init(){
        SQLiteDatabase db1 = this.getWritableDatabase();
        db1.delete("my_table1",null,null);
        ArrayList<String> listStudent= new ArrayList<String>(){{
            //class ii1A
            add("ABDELMOUMEN-Abir-12345678-A");
            add("AJLANI-Haythem-12345678-A");
            add("ALSAIDI-Wadii-12345678-A");
            add("AMERI-Iheb-12345678-A");
            add("AOULED AMER-Yahya-12345678-A");
            add("BELAIDI-Mohamed-12345678-A");
            add("BEN MAHMOUD-Meher-12345678-A");
            add("BEN SALEM-Mohamed Haykel-12345678-A");
            add("BOUAGILA-Nadine-12345678-A");
            add("JAIDI-Mohamed Aziz-12345678-A");
            //class ii1B
            add("BBBB-bbbbb-12345678-B");
            add("ABDELMOUMEN-Abir-12345678-B");
            add("AJLANI-Haythem-12345678-B");
            add("ALSAIDI-Wadii-12345678-B");
            add("AMERI-Iheb-12345678-B");

            //class ii1C
            add("CCCCC-ccccc-12345678-C");





            //class ii1D
            add("wissem-ben yaagoub-12345678-D");
            add("yassine-abid-12345675-D");
            add("oussema-mhiri-12345678-D");
            add("mohamed-kammoun-98345678-D");
            add("Mohamed Amine -dhorbani-12825645-D");
            add("yahia-mezzi-87654321-D");
            add("ahmed-kharrat-87654321-D");
            add("ANES-Sana-87654321-D");
            add("BEN ALI-Khaoula-87654321-D");
            add("BOUCHOUCHA-Emine-87654321-D");
            add("CHTIOUI GARBAA-Fatma-87654321-D");
            add("DHAHBI-Rania-87654321-D");
            add("DHOUIMIR-Salem-87654321-D");
            add("EL ABED-Mohamed Fares-87654321-D");
            add("EL KHIDRI-Samer-87654321-D");
            add("Arij -Korbi-87654321-D");
            //class ii1E
            add("EEEEE-eeee-12345675-E");

            //class ii1F
            add("FFFFFFF-ffffffff-12345675-F");

            //class ii2

            //class ii3

        }};

        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String[] student = new String[4];
        for(int i=0;i<listStudent.size();i++) {
            student = listStudent.get(i).split("-");

            contentValues.put("Firstname", student[0]);
            contentValues.put("Surname", student[1]);
            contentValues.put("Id", student[2]);
            contentValues.put("Groupe", student[3]);
            db.insert("my_table1", null, contentValues);

        }

        db.close();

    }
}