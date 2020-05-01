package com.dscecse.fairfare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
    Intent intent1;
    double fare=0;
    TextView tv, range;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        intent1 = getIntent();
        String x = intent1.getStringExtra("Distance");
        double distance;
        distance = intent1.getDoubleExtra("Distance", distance=0);
        String y = intent1.getStringExtra("Time");
        double time = intent1.getDoubleExtra("Time", time=0);
        //int i = Integer.parseInt(intent1.getStringExtra("CheckBox"));
        int i = intent1.getIntExtra("CheckBox", i=0);
        double z;
        int timez;
        int finalt;
        int waitcharges=0;
        double finalfare;
        range = findViewById(R.id.range);
        tv = findViewById(R.id.finalanswer);
        if(distance<=1.9)
        {
            fare = 25;
        }
        else
        {
            z = ( distance - 1.9 ) * 2;
            fare = 25 + ( 6.5 * z );
        }
        if(time>5)
        {
            timez = (int) time - 5;
            finalt = timez/15;
            waitcharges = finalt*5;
        }
        finalfare = waitcharges+fare;
        if(i==1)
        {
            finalfare=finalfare*1.5;
        }
        tv.setText("Estimated Cost: "+Math.round(finalfare));
        double r1 = 0.95*finalfare;
        double r2 = 1.05*finalfare;
        range.setText(""+Math.round(r1)+"\n &\n"+Math.round(r2));
    }
}
