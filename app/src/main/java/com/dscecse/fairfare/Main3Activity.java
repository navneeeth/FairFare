package com.dscecse.fairfare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {
    EditText distance, waittime;
    CheckBox checkbox;
    Button button;
    Intent intent;
    double dist, time=0;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        distance = findViewById(R.id.distance);
        waittime = findViewById(R.id.waittime);
        button = findViewById(R.id.calculate);
        checkbox = findViewById(R.id.checkBox);
        intent = new Intent(Main3Activity.this, Main4Activity.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dist = Double.parseDouble(String.valueOf(distance.getText()));
                if(waittime.getText().toString().length()!=0) {
                    time = Double.parseDouble(String.valueOf(waittime.getText()));
                }
                if(checkbox.isChecked())
                {
                    i = 1;
                }
                else
                {
                    i=0;
                }
                intent.putExtra("Distance", dist);
                intent.putExtra("Time", time);
                intent.putExtra("CheckBox", i);
                startActivity(intent);

            }
        });
    }
}
