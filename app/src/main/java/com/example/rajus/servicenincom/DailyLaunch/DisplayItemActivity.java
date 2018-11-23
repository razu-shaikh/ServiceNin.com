package com.example.rajus.servicenincom.DailyLaunch;

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

public class DisplayItemActivity extends AppCompatActivity {

    static int value;
    static String companyNam;
    public DatabaseReference databaseReferen;
    public DatabaseReference databaseReferen1;
    public DatabaseReference databaseReferen2;
    public DatabaseReference databaseReferen3;
    public DatabaseReference databaseReferen4;

    // Creating RecyclerView.
    RecyclerView recyclerView1;

    // Creating RecyclerView.Adapter.
    RecyclerView.Adapter adapter;

    // Creating Progress dialog
    ProgressDialog progressDialog1;

    // Creating List of ImageUploadInfo class.
    List<Upload1> list1 = new ArrayList<>();

    static String stringPosition;
    Firebase myFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_item);

        Intent intent = getIntent();
        int intValue1 = intent.getIntExtra("pos", 0);
        value = intent.getIntExtra("value", 0);
        stringPosition = String.valueOf(intValue1);
        companyNam = intent.getStringExtra("companyName");

        Firebase.setAndroidContext(this);
        myFirebase = new Firebase("https://serviceninowner.firebaseio.com/");
        recyclerView1 = (RecyclerView) findViewById(R.id.recyclerView1);

// Setting RecyclerView size true.
        recyclerView1.setHasFixedSize(true);

// Setting RecyclerView layout as LinearLayout.
        recyclerView1.setLayoutManager(new LinearLayoutManager(DisplayItemActivity.this));


        // Assign activity this to progress dialog.
        progressDialog1 = new ProgressDialog(DisplayItemActivity.this);

// Setting up message in Progress dialog.
        progressDialog1.setMessage("Loading Images From Firebase.");

// Showing progress dialog.
        progressDialog1.show();

        databaseReferen = FirebaseDatabase.getInstance().getReference("All_Uploads_Database");
        databaseReferen1 = FirebaseDatabase.getInstance().getReference("Party_Foods_database");
        databaseReferen2 = FirebaseDatabase.getInstance().getReference("Event_Foods_database");
        databaseReferen3 = FirebaseDatabase.getInstance().getReference("Iftar_Pack_database");
        databaseReferen4 = FirebaseDatabase.getInstance().getReference("Gift_Box_database");

        if (value==1) {
            databaseReferen.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    list1.clear();
                    for (DataSnapshot shot : snapshot.getChildren()) {

                        if (shot.getKey().equals(stringPosition)) {

                            for (DataSnapshot shot1 : shot.getChildren()) {

                                Upload1 imageUploadInfo = shot1.getValue(Upload1.class);
                                //imageUploadInfo.setKey(shot1.getKey());

                                list1.add(imageUploadInfo);
                            }
                        }
                    }
                    adapter = new RecyclerViewAdapter1(getApplicationContext(), list1);
                    recyclerView1.setAdapter(adapter);


                    // Hiding the progress dialog.
                    progressDialog1.dismiss();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                    // Hiding the progress dialog.
                    progressDialog1.dismiss();

                }
            });
        }

        if (value==2) {
            databaseReferen1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    list1.clear();
                    for (DataSnapshot shot : snapshot.getChildren()) {

                        if (shot.getKey().equals(stringPosition)) {

                            for (DataSnapshot shot1 : shot.getChildren()) {

                                Upload1 imageUploadInfo = shot1.getValue(Upload1.class);
                                //imageUploadInfo.setKey(shot1.getKey());

                                list1.add(imageUploadInfo);
                            }
                        }
                    }
                    adapter = new RecyclerViewAdapter1(getApplicationContext(), list1);
                    recyclerView1.setAdapter(adapter);


                    // Hiding the progress dialog.
                    progressDialog1.dismiss();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                    // Hiding the progress dialog.
                    progressDialog1.dismiss();

                }
            });
        }
        if (value==3) {
            databaseReferen2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    list1.clear();
                    for (DataSnapshot shot : snapshot.getChildren()) {

                        if (shot.getKey().equals(stringPosition)) {

                            for (DataSnapshot shot1 : shot.getChildren()) {

                                Upload1 imageUploadInfo = shot1.getValue(Upload1.class);
                                //imageUploadInfo.setKey(shot1.getKey());

                                list1.add(imageUploadInfo);
                            }
                        }
                    }
                    adapter = new RecyclerViewAdapter1(getApplicationContext(), list1);
                    recyclerView1.setAdapter(adapter);


                    // Hiding the progress dialog.
                    progressDialog1.dismiss();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                    // Hiding the progress dialog.
                    progressDialog1.dismiss();

                }
            });
        }
        if (value==4) {
            databaseReferen3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    list1.clear();
                    for (DataSnapshot shot : snapshot.getChildren()) {

                        if (shot.getKey().equals(stringPosition)) {

                            for (DataSnapshot shot1 : shot.getChildren()) {

                                Upload1 imageUploadInfo = shot1.getValue(Upload1.class);
                                //imageUploadInfo.setKey(shot1.getKey());

                                list1.add(imageUploadInfo);
                            }
                        }
                    }
                    adapter = new RecyclerViewAdapter1(getApplicationContext(), list1);
                    recyclerView1.setAdapter(adapter);


                    // Hiding the progress dialog.
                    progressDialog1.dismiss();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                    // Hiding the progress dialog.
                    progressDialog1.dismiss();

                }
            });
        }
        if (value==5) {
            databaseReferen4.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    list1.clear();
                    for (DataSnapshot shot : snapshot.getChildren()) {

                        if (shot.getKey().equals(stringPosition)) {

                            for (DataSnapshot shot1 : shot.getChildren()) {

                                Upload1 imageUploadInfo = shot1.getValue(Upload1.class);
                                //imageUploadInfo.setKey(shot1.getKey());

                                list1.add(imageUploadInfo);
                            }
                        }
                    }
                    adapter = new RecyclerViewAdapter1(getApplicationContext(), list1);
                    recyclerView1.setAdapter(adapter);


                    // Hiding the progress dialog.
                    progressDialog1.dismiss();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                    // Hiding the progress dialog.
                    progressDialog1.dismiss();

                }
            });
        }
    }
}
