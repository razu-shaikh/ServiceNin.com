package com.example.rajus.servicenincom.CarRent;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.rajus.servicenincom.R;
import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DisplayCarActivity extends AppCompatActivity {

    int value;

    public DatabaseReference databaseReference;
    public DatabaseReference databaseReference1;
    public DatabaseReference databaseReference2;
    public DatabaseReference databaseReference3;

    Firebase myFirebase;

    RecyclerView recyclerView2;
    // Creating RecyclerView.Adapter.
    RecyclerView.Adapter adapter;
    // Creating Progress dialog
    ProgressDialog progressDialog2;
    // Creating List of ImageUploadInfo class.
    List<RentClass> list2 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_car);
        Intent intent = getIntent();
        value = intent.getIntExtra("value", 0);

        Firebase.setAndroidContext(this);

        myFirebase = new Firebase("https://serviceninowner.firebaseio.com/");

        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView2);
        // Setting RecyclerView size true.
        recyclerView2.setHasFixedSize(true);
        // Setting RecyclerView layout as LinearLayout.
        recyclerView2.setLayoutManager(new LinearLayoutManager(DisplayCarActivity.this));
        // Assign activity this to progress dialog.
        progressDialog2 = new ProgressDialog(DisplayCarActivity.this);
        // Setting up message in Progress dialog.
        progressDialog2.setMessage("Loading Images From Firebase.");
        // Showing progress dialog.
        progressDialog2.show();

        databaseReference = FirebaseDatabase.getInstance().getReference("Car_Database");
        databaseReference1 = FirebaseDatabase.getInstance().getReference("Truck_Database");
        databaseReference2 = FirebaseDatabase.getInstance().getReference("Ambulance_Database");
        databaseReference3 = FirebaseDatabase.getInstance().getReference("Picnic_Car_Database");

        if (value==1) {
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    list2.clear();
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        RentClass imageUploadInfo = postSnapshot.getValue(RentClass.class);
                        //imageUploadInfo.setKey(postSnapshot.getKey());
                        list2.add(imageUploadInfo);
                    }
                    adapter = new RentRecyclerViewAdapter(getApplicationContext(), list2);
                    recyclerView2.setAdapter(adapter);
                    // Hiding the progress dialog.
                    progressDialog2.dismiss();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Hiding the progress dialog.
                    progressDialog2.dismiss();

                }
            });
        }
        if (value==2) {
            databaseReference1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    list2.clear();
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        RentClass imageUploadInfo = postSnapshot.getValue(RentClass.class);
                        list2.add(imageUploadInfo);
                    }
                    adapter = new RentRecyclerViewAdapter(getApplicationContext(), list2);
                    recyclerView2.setAdapter(adapter);
                    // Hiding the progress dialog.
                    progressDialog2.dismiss();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Hiding the progress dialog.
                    progressDialog2.dismiss();

                }
            });
        }
        if (value==3) {
            databaseReference2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    list2.clear();
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        RentClass imageUploadInfo = postSnapshot.getValue(RentClass.class);
                        list2.add(imageUploadInfo);
                    }
                    adapter = new RentRecyclerViewAdapter(getApplicationContext(), list2);
                    recyclerView2.setAdapter(adapter);
                    // Hiding the progress dialog.
                    progressDialog2.dismiss();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Hiding the progress dialog.
                    progressDialog2.dismiss();

                }
            });
        }
        if (value==4) {
            databaseReference3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    list2.clear();
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        RentClass imageUploadInfo = postSnapshot.getValue(RentClass.class);
                        list2.add(imageUploadInfo);
                    }
                    adapter = new RentRecyclerViewAdapter(getApplicationContext(), list2);
                    recyclerView2.setAdapter(adapter);
                    // Hiding the progress dialog.
                    progressDialog2.dismiss();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Hiding the progress dialog.
                    progressDialog2.dismiss();

                }
            });
        }

    }


}
