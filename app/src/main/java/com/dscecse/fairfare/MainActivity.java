package com.dscecse.fairfare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    Button button;
    int progress=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ProgressBar pb = findViewById(R.id.progressBar);
        button = findViewById(R.id.button);
        button.setVisibility(View.VISIBLE);
        intent = new Intent(MainActivity.this, Main2Activity.class);
        pb.setProgress(0);
        pb.setMax(100);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (progress <= 100) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progress = progress + 25;
                    pb.setProgress(progress);
                }
                if(progress>100)
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            button.setVisibility(VISIBLE);
                            button.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            }
        });


        thread.start();
    }
}
