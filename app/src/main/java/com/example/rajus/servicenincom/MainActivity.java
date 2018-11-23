package com.example.rajus.servicenincom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rentCar(View view) {
        Intent intent = new Intent(MainActivity.this,FragmentAllActivity.class);
        intent.putExtra("EXTRA", "rentFragment");
        startActivity(intent);
    }


    public void tourItem(View view) {
        Intent intent = new Intent(MainActivity.this,FragmentAllActivity.class);
        intent.putExtra("EXTRA", "tourFragment");
        startActivity(intent);
    }


    public void regularService(View view) {
        Intent intent = new Intent(MainActivity.this,FragmentAllActivity.class);
        intent.putExtra("EXTRA", "regularFragment");
        startActivity(intent);
    }

    public void eventManage(View view) {
        Intent intent = new Intent(MainActivity.this,FragmentAllActivity.class);
        intent.putExtra("EXTRA", "eventFragment");
        startActivity(intent);
    }

    public void home(View view) {
        Intent intent = new Intent(MainActivity.this,FragmentAllActivity.class);
        intent.putExtra("EXTRA", "homeFragment");
        startActivity(intent);
    }

    public void shift(View view) {
        Intent intent = new Intent(MainActivity.this,FragmentAllActivity.class);
        intent.putExtra("EXTRA", "shiftFragment");
        startActivity(intent);
    }

    public void supply(View view) {
        Intent intent = new Intent(MainActivity.this,FragmentAllActivity.class);
        intent.putExtra("EXTRA", "supplyFragment");
        startActivity(intent);
    }

    public void itSales(View view) {
        Intent intent = new Intent(MainActivity.this,FragmentAllActivity.class);
        intent.putExtra("EXTRA", "itFragment");
        startActivity(intent);
    }

     public void business(View view) {
        Intent intent = new Intent(MainActivity.this,FragmentAllActivity.class);
         intent.putExtra("EXTRA", "businessFragment");
         startActivity(intent);
     }
}
