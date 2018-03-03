package com.example.bogda.mobilejournal.days;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bogda.mobilejournal.R;

public class MondayActivity extends AppCompatActivity {

    Button button_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);
        Toast.makeText(this, "Понеділок", Toast.LENGTH_SHORT).show();
        button_save = (Button) findViewById(R.id.btn_save);
    }
    public void func_edits(View view){
        button_save.setVisibility(View.VISIBLE);
    }
}
