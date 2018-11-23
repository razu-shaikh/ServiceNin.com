package com.example.rajus.servicenincom.RegularService;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rajus.servicenincom.R;
import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowRegularActivity extends AppCompatActivity {

    int value;

    public DatabaseReference databaseReference;
    public DatabaseReference databaseReference1;
    public DatabaseReference databaseReference2;
    public DatabaseReference databaseReference3;
    public DatabaseReference databaseReference4;

    Firebase myFirebase;

    RecyclerView recyclerView3;
    // Creating RecyclerView.Adapter.
    RecyclerView.Adapter adapter;
    // Creating Progress dialog
    ProgressDialog progressDialog3;
    // Creating List of ImageUploadInfo class.
    List<RegularClass> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_regular);


        Intent intent = getIntent();
        value = intent.getIntExtra("value", 0);

        Firebase.setAndroidContext(this);

        myFirebase = new Firebase("https://serviceninowner.firebaseio.com/");

        recyclerView3 = (RecyclerView) findViewById(R.id.recyclerView);
        // Setting RecyclerView size true.
        recyclerView3.setHasFixedSize(true);
        // Setting RecyclerView layout as LinearLayout.
        recyclerView3.setLayoutManager(new LinearLayoutManager(ShowRegularActivity.this));
        // Assign activity this to progress dialog.
        progressDialog3 = new ProgressDialog(ShowRegularActivity.this);
        // Setting up message in Progress dialog.
        progressDialog3.setMessage("Loading Images From Firebase.");
        // Showing progress dialog.
        progressDialog3.show();

        databaseReference = FirebaseDatabase.getInstance().getReference("Office_Clean_Database");
        databaseReference1 = FirebaseDatabase.getInstance().getReference("Pest_Control_Database");
        databaseReference2 = FirebaseDatabase.getInstance().getReference("Design_Database");
        databaseReference3 = FirebaseDatabase.getInstance().getReference("Appliance_Repair_Database");
        databaseReference4 = FirebaseDatabase.getInstance().getReference("Vehicle_Repair_Database");

        if (value==1) {
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    list.clear();
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        RegularClass imageUploadInfo = postSnapshot.getValue(RegularClass.class);
                        list.add(imageUploadInfo);
                    }
                    adapter = new RegularRecyclerViewAdapter(getApplicationContext(), list);
                    recyclerView3.setAdapter(adapter);
                    // Hiding the progress dialog.
                    progressDialog3.dismiss();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Hiding the progress dialog.
                    progressDialog3.dismiss();

                }
            });
        }
        if (value==2) {
            databaseReference1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    list.clear();
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        RegularClass imageUploadInfo = postSnapshot.getValue(RegularClass.class);

                        list.add(imageUploadInfo);
                    }
                    adapter = new RegularRecyclerViewAdapter(getApplicationContext(), list);
                    recyclerView3.setAdapter(adapter);
                    // Hiding the progress dialog.
                    progressDialog3.dismiss();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Hiding the progress dialog.
                    progressDialog3.dismiss();

                }
            });
        }
        if (value==3) {
            databaseReference2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    list.clear();
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        RegularClass imageUploadInfo = postSnapshot.getValue(RegularClass.class);
                        list.add(imageUploadInfo);
                    }
                    adapter = new RegularRecyclerViewAdapter(getApplicationContext(), list);
                    recyclerView3.setAdapter(adapter);
                    // Hiding the progress dialog.
                    progressDialog3.dismiss();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Hiding the progress dialog.
                    progressDialog3.dismiss();

                }
            });
        }
        if (value==4) {
            databaseReference3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    list.clear();
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        RegularClass imageUploadInfo = postSnapshot.getValue(RegularClass.class);
                        list.add(imageUploadInfo);
                    }
                    adapter = new RegularRecyclerViewAdapter(getApplicationContext(), list);
                    recyclerView3.setAdapter(adapter);
                    // Hiding the progress dialog.
                    progressDialog3.dismiss();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Hiding the progress dialog.
                    progressDialog3.dismiss();

                }
            });
        }
        if (value==5) {
            databaseReference4.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    list.clear();
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        RegularClass imageUploadInfo = postSnapshot.getValue(RegularClass.class);
                        list.add(imageUploadInfo);
                    }
                    adapter = new RegularRecyclerViewAdapter(getApplicationContext(), list);
                    recyclerView3.setAdapter(adapter);
                    // Hiding the progress dialog.
                    progressDialog3.dismiss();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Hiding the progress dialog.
                    progressDialog3.dismiss();

                }
            });
        }
    }
}
