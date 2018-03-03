package com.example.bogda.mobilejournal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Add_Subject extends AppCompatActivity implements View.OnClickListener{

    Button add_rozklad;
    Button red_db;
    EditText edit_new;
    LinearLayout linearLayoutR;
    LinearLayout linearLayoutL;
    int counter = 0;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__subject);
        linearLayoutR = (LinearLayout) findViewById(R.id.liener_rozkladRGHT);
        linearLayoutL = (LinearLayout) findViewById(R.id.liener_rozkladLEFT);
        add_rozklad  = (Button) findViewById(R.id.add_rozklad);
        edit_new = (EditText) findViewById(R.id.edit_newRozklad);
        red_db = (Button) findViewById(R.id.red_db);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, // Width of TextView
                LinearLayout.LayoutParams.WRAP_CONTENT);
        add_rozklad.setOnClickListener(this);
        red_db.setOnClickListener(this);
        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View v) {
        counter++;
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        TextView textView = new TextView(this);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.BLACK);
        textView.setText(counter+". " +edit_new.getText().toString());
        edit_new.setText("");
            if (counter<=20){
               contentValues.put(DBHelper.Predmet, edit_new.getText().toString());
               sqLiteDatabase.insert(DBHelper.TABLENAME, null,contentValues);
               linearLayoutR.addView(textView);
           }
           else if(counter >40)
               Toast.makeText(this, "Перевищено ліміт пердметів", Toast.LENGTH_SHORT).show();
           else{
               contentValues.put(DBHelper.Predmet, edit_new.getText().toString());
               sqLiteDatabase.insert(DBHelper.TABLENAME, null,contentValues);
               linearLayoutL.addView(textView);
           }


    }
}
