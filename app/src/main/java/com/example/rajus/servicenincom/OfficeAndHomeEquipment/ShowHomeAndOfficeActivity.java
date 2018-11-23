package com.example.rajus.servicenincom.OfficeAndHomeEquipment;

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

public class ShowHomeAndOfficeActivity extends AppCompatActivity {
    static int value;
    Firebase myFirebase;
    // Creating DatabaseReference.
    public DatabaseReference databaseReference;
    public DatabaseReference databaseReference1;
    public DatabaseReference databaseReference2;
    public DatabaseReference databaseReference3;

    RecyclerView recyclerView;
    // Creating RecyclerView.Adapter.
    RecyclerView.Adapter adapter;
    // Creating Progress dialog
    ProgressDialog progressDialog;
    // Creating List of ImageUploadInfo class.
    List<AddCompany> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_home_and_office);

        Intent intent = getIntent();
        value = intent.getIntExtra("value", 0);


        Firebase.setAndroidContext(this);

        myFirebase = new Firebase("https://serviceninowner.firebaseio.com/");

        // Assign id to RecyclerView.
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // Setting RecyclerView size true.
        recyclerView.setHasFixedSize(true);
        // Setting RecyclerView layout as LinearLayout.
        recyclerView.setLayoutManager(new LinearLayoutManager(ShowHomeAndOfficeActivity.this));
        // Assign activity this to progress dialog.
        progressDialog = new ProgressDialog(ShowHomeAndOfficeActivity.this);
        // Setting up message in Progress dialog.
        progressDialog.setMessage("Loading Images From Firebase.");
        // Showing progress dialog.
        progressDialog.show();

        databaseReference = FirebaseDatabase.getInstance().getReference("Office_Database");
        databaseReference1 = FirebaseDatabase.getInstance().getReference("Home_Database");
        databaseReference2 = FirebaseDatabase.getInstance().getReference("Medical_Database");
        databaseReference3 = FirebaseDatabase.getInstance().getReference("Vehicles_Database");

        if (value==1) {
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        AddCompany imageUploadInfo = postSnapshot.getValue(AddCompany.class);
                        //imageUploadInfo.setKey(postSnapshot.getKey();
                        list.add(imageUploadInfo);
                    }
                    adapter = new RecyclerViewCompany(getApplicationContext(), list);
                    recyclerView.setAdapter(adapter);
                    // Hiding the progress dialog.
                    progressDialog.dismiss();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Hiding the progress dialog.
                    progressDialog.dismiss();

                }
            });
        }
        if (value==2) {
            databaseReference1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        AddCompany imageUploadInfo = postSnapshot.getValue(AddCompany.class);
                        //imageUploadInfo.setKey(postSnapshot.getKey();
                        list.add(imageUploadInfo);
                    }
                    adapter = new RecyclerViewCompany(getApplicationContext(), list);
                    recyclerView.setAdapter(adapter);
                    // Hiding the progress dialog.
                    progressDialog.dismiss();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Hiding the progress dialog.
                    progressDialog.dismiss();

                }
            });
        }
        if (value==3) {
            databaseReference2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        AddCompany imageUploadInfo = postSnapshot.getValue(AddCompany.class);
                        //imageUploadInfo.setKey(postSnapshot.getKey();
                        list.add(imageUploadInfo);
                    }
                    adapter = new RecyclerViewCompany(getApplicationContext(), list);
                    recyclerView.setAdapter(adapter);
                    // Hiding the progress dialog.
                    progressDialog.dismiss();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Hiding the progress dialog.
                    progressDialog.dismiss();

                }
            });
        }
        if (value==4) {
            databaseReference3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        AddCompany imageUploadInfo = postSnapshot.getValue(AddCompany.class);
                        //imageUploadInfo.setKey(postSnapshot.getKey();
                        list.add(imageUploadInfo);
                    }
                    adapter = new RecyclerViewCompany(getApplicationContext(), list);
                    recyclerView.setAdapter(adapter);
                    // Hiding the progress dialog.
                    progressDialog.dismiss();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Hiding the progress dialog.
                    progressDialog.dismiss();

                }
            });
        }
    }
}