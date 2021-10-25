package com.example.afinal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import static android.content.ContentValues.TAG;
import static com.example.afinal.MainActivity6.matière;


public class MainActivity9 extends Activity implements OnClickListener {
    MyCustomAdapter dataAdapter = null;
    Button writeExcelButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        //Générer une vue de liste à partir de ArrayList
        ListView();
        writeExcelButton = (Button) findViewById(R.id.writeExcel);
        writeExcelButton.setOnClickListener(this);


    }

    public void onClick(View v) {
        saveExcelFile(this, "myExcel.xls");
    }

    @SuppressLint({"LongLogTag", "IntentReset"})
    private boolean saveExcelFile(Context context, String fileName) {
        ArrayList <String> list = new ArrayList<>();
        ArrayList<Etudiant> List_Etudiant = dataAdapter.List;
        for (int i = 0; i < List_Etudiant.size(); i++) {
            Etudiant student = List_Etudiant.get(i);
            if (student.isSelected()) {
                list.add(student.getName());
            }
        }

        // vérifier si disponible et non en lecture seule
        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            Log.e(TAG, "Storage not available or read only");
            return false;
        }

        boolean success = false;

        //Nouveau classeur
        Workbook wb = new HSSFWorkbook();
        //Un objet qui gère l'instanciation des classes concrètes des différentes instances dont on a besoin pour HSSF et XSSF
        CreationHelper createHelper = wb.getCreationHelper();
        Cell c = null;
        Cell c1 = null;

        //Style de cellule pour la ligne d'en-tête
        CellStyle cs = wb.createCellStyle();
        cs.setFillForegroundColor(HSSFColor.LIME.index);
        cs.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        //Nouvelle feuille
        Sheet sheet1 = null;
        sheet1 = wb.createSheet("ENSI");

        // Générer des en-têtes de colonne
        Row row = sheet1.createRow(0);

        c = row.createCell(0);
        c.setCellValue("Liste absente");
        c.setCellStyle(cs);
        c.setAsActiveCell();


        c = row.createCell(1);
        c.setCellValue(matière);
        c.setCellStyle(cs);
        c.setAsActiveCell();


        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("d/m/yy h:mm"));
        c = row.createCell(2);
        c.setCellValue(new Date());
        c.setCellStyle(cellStyle);




        //Remplir la colone de la liste absente
        for (int x=0; x<list.size(); x++) {
            Row row1 = sheet1.createRow(x+1);
            row1.createCell(0).setCellValue(list.get(x));
        }

        sheet1.setColumnWidth(0, (15 * 500));
        sheet1.setColumnWidth(1, (15 * 500));
        sheet1.setColumnWidth(2, (15 * 500));

        // Créez un chemin où nous placerons notre liste d'objets sur le stockage externe
        File file = new File(context.getExternalFilesDir(null), fileName);
        FileOutputStream os = null; //OutputStream effectuer des opérations d’E/S

        try {
            os = new FileOutputStream(file);
            wb.write(os);
            Log.w("FileUtils", "Writing file" + file);
            success = true;
        } catch (IOException e) {
            Log.w("FileUtils", "Error writing " + file, e);
        } catch (Exception e) {
            Log.w("FileUtils", "Failed to save file", e);
        } finally {
            try {
                if (null != os)
                    os.close();
            } catch (Exception ex) {
            }
        }

        // ENVOYER UN EMAIL
        //Log.i("Send email", "");
        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        String mailId = "yourmail@gmail.com";
        emailIntent.setData(Uri.fromParts("mailto", mailId, null));
        emailIntent.setType("application/excel");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "liste d'absence");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "");


        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
        return success;
    }

    public static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) { //État de stockage si le support est présent et monté à son point de montage avec accès en lecture / écriture.
            return true;
        }
        return false;
    }

    public static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) { //État de stockage si le support est présent et monté à son point de montage avec un accès en lecture seule.
            return true;
        }
        return false;
    }


    private void ListView() {

        //tableau des etudiant
        ArrayList<Etudiant> listetudiant = new ArrayList<Etudiant>();
        Intent myintent = getIntent();
        Bundle b = myintent.getBundleExtra("BUNDLE");
        final ArrayList<String> arraylis = (ArrayList<String>) b.getSerializable("ARRAYLIST");

        String[] s;
        for (int i = 0; i < arraylis.size(); i++) {
            s = arraylis.get(i).split("-");
            Etudiant etd = new Etudiant(s[1].substring(11) + " " + s[2].substring(9), false);
            listetudiant.add(etd);
        }

        //créer un ArrayAdapter à partir du tableau listetudiant
        dataAdapter = new MyCustomAdapter(this, R.layout.row_item, listetudiant);
        ListView listView = (ListView) findViewById(R.id.Lessons);

        // attribuer l'adaptateur à ListView
        listView.setAdapter(dataAdapter);

    }

    private class MyCustomAdapter extends ArrayAdapter<Etudiant> {

        private ArrayList<Etudiant> List;
        CheckBox name;
        public MyCustomAdapter(Context context, int textViewResourceId, ArrayList<Etudiant> List) {
            super(context, textViewResourceId, List);
            this.List = new ArrayList<Etudiant>();
            this.List.addAll(List);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //définir la disposition des lignes
                convertView = vi.inflate(R.layout.row_item, null);
                name = (CheckBox) convertView.findViewById(R.id.checkBox1);

                name.setOnClickListener( new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v ;
                        Etudiant etd = (Etudiant) cb.getTag();
                        etd.setSelected(cb.isChecked());
                    }
                });
            }
            else {
                convertView.getTag();
            }

            Etudiant student = List.get(position);
            name.setText(student.getName());
            name.setChecked(student.isSelected());
            name.setTag(student);

            return convertView;

        }

    }


}