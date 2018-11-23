package com.example.rajus.servicenincom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splish);

    Thread thread = new Thread()
    {
        @Override
        public void run()
        {
            try
            {
                sleep(4000);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                Intent intent = new Intent(SplishActivity.this,MainActivity.class);
                startActivity(intent);
            }

        }
    };
    thread.start();
}

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
