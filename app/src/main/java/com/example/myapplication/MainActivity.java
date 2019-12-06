package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = findViewById(R.id.btn_start);

    }

    public void startThread(View view) {

    ExampleThread thread = new ExampleThread(20);
    thread.start();
    }

    public void stopThread(View view) {
    }


    class ExampleThread extends Thread{

        int seconds;

        ExampleThread(int seconds){
            this.seconds = seconds;
        }

        @Override
        public void run() {

            for (int i = 0; i<seconds; i++){

                if(i == 5){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            btn_start.setText("50%");
                        }
                    });
                }
                Log.d(TAG, "startThread: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
