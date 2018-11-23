package com.example.rajus.servicenincom.OfficeAndHomeEquipment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rajus.servicenincom.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowEquipmentActivity extends AppCompatActivity {

    static int value;
    static String companyName;
    public DatabaseReference databaseReferen;
    public DatabaseReference databaseReferen1;
    public DatabaseReference databaseReferen2;
    public DatabaseReference databaseReferen3;
    // Creating RecyclerView.
    RecyclerView recyclerView1;
    // Creating RecyclerView.Adapter.
    RecyclerView.Adapter adapter;
    // Creating Progress dialog
    ProgressDialog progressDialog1;
    // Creating List of ImageUploadInfo class.
    List<AddItem> list1 = new ArrayList<>();
    static String stringPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_equipment);

        Intent intent = getIntent();
        int intValue1 = intent.getIntExtra("pos", 0);
        value = intent.getIntExtra("value", 0);
        stringPosition = String.valueOf(intValue1);
        companyName = intent.getStringExtra("companyName");

        recyclerView1 = (RecyclerView) findViewById(R.id.recyclerView1);
        // Setting RecyclerView size true.
        recyclerView1.setHasFixedSize(true);
        // Setting RecyclerView layout as LinearLayout.
        recyclerView1.setLayoutManager(new LinearLayoutManager(ShowEquipmentActivity.this));
        // Assign activity this to progress dialog.
        progressDialog1 = new ProgressDialog(ShowEquipmentActivity.this);
        // Setting up message in Progress dialog.
        progressDialog1.setMessage("Loading Images From Firebase.");
        // Showing progress dialog.
        progressDialog1.show();
        databaseReferen = FirebaseDatabase.getInstance().getReference("Office_Item_Database");
        databaseReferen1 = FirebaseDatabase.getInstance().getReference("Home_Item_database");
        databaseReferen2 = FirebaseDatabase.getInstance().getReference("Medical_Item_database");
        databaseReferen3 = FirebaseDatabase.getInstance().getReference("Vehicle_database");

        if (value==1) {
            databaseReferen.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    list1.clear();
                    for (DataSnapshot shot : snapshot.getChildren()) {
                        if (shot.getKey().equals(stringPosition)) {
                            for (DataSnapshot shot1 : shot.getChildren()) {
                                AddItem imageUploadInfo = shot1.getValue(AddItem.class);
                                list1.add(imageUploadInfo);
                            }
                        }
                    }
                    adapter = new RecyclerViewItem(getApplicationContext(), list1);
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
                                AddItem imageUploadInfo = shot1.getValue(AddItem.class);
                                list1.add(imageUploadInfo);
                            }
                        }
                    }
                    adapter = new RecyclerViewItem(getApplicationContext(), list1);
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
                                AddItem imageUploadInfo = shot1.getValue(AddItem.class);
                                list1.add(imageUploadInfo);
                            }
                        }
                    }
                    adapter = new RecyclerViewItem(getApplicationContext(), list1);
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
                                AddItem imageUploadInfo = shot1.getValue(AddItem.class);
                                list1.add(imageUploadInfo);
                            }
                        }
                    }
                    adapter = new RecyclerViewItem(getApplicationContext(), list1);
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
