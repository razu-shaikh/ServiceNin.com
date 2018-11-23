package com.example.rajus.servicenincom.DailyLaunch;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Parcelable;
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

public class DisplayImagesActivity extends AppCompatActivity {
    static int value;
    Firebase myFirebase;

    // Creating DatabaseReference.
     DatabaseReference databaseReference;
     DatabaseReference databaseReference1;
     DatabaseReference databaseReference2;
     DatabaseReference databaseReference3;
     DatabaseReference databaseReference4;

    // Creating RecyclerView.
    RecyclerView recyclerView;

    // Creating RecyclerView.Adapter.
    RecyclerView.Adapter adapter;
    // Creating Progress dialog
    ProgressDialog progressDialog;
    //public static String key;


    // Creating List of ImageUploadInfo class.
    List<Upload> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_images);

        Intent intent = getIntent();
        value = intent.getIntExtra("value", 0);

        Firebase.setAndroidContext(this);

        myFirebase = new Firebase("https://serviceninowner.firebaseio.com/");
        // Assign id to RecyclerView.
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
// Setting RecyclerView size true.
        recyclerView.setHasFixedSize(true);

// Setting RecyclerView layout as LinearLayout.
        recyclerView.setLayoutManager(new LinearLayoutManager(DisplayImagesActivity.this));


        // Assign activity this to progress dialog.
        progressDialog = new ProgressDialog(DisplayImagesActivity.this);

// Setting up message in Progress dialog.
        progressDialog.setMessage("Loading Images From Firebase.");

// Showing progress dialog.
        progressDialog.show();


        // Setting up Firebase image upload folder path in databaseReference.
// The path is already defined in MainActivity.
        databaseReference = FirebaseDatabase.getInstance().getReference("All_Image_Uploads_Database");
        databaseReference1= FirebaseDatabase.getInstance().getReference("Party_food_Database");
        databaseReference2 = FirebaseDatabase.getInstance().getReference("Event_food_Database");
        databaseReference3 = FirebaseDatabase.getInstance().getReference("Iftar_food_Database");
        databaseReference4 = FirebaseDatabase.getInstance().getReference("Gift_Box_Database");

        if (value==1) {

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    list.clear();
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        Upload imageUploadInfo = postSnapshot.getValue(Upload.class);
                        list.add(imageUploadInfo);
                    }
                    adapter = new RecyclerViewAdapter(getApplicationContext(), list);
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
                    list.clear();
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        Upload imageUploadInfo = postSnapshot.getValue(Upload.class);
                        list.add(imageUploadInfo);
                    }
                    adapter = new RecyclerViewAdapter(getApplicationContext(), list);
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
                    list.clear();
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        Upload imageUploadInfo = postSnapshot.getValue(Upload.class);
                        list.add(imageUploadInfo);
                    }
                    adapter = new RecyclerViewAdapter(getApplicationContext(), list);
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
                    list.clear();
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        Upload imageUploadInfo = postSnapshot.getValue(Upload.class);
                        list.add(imageUploadInfo);
                    }
                    adapter = new RecyclerViewAdapter(getApplicationContext(), list);
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
        if (value==5) {

            databaseReference4.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    list.clear();
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        Upload imageUploadInfo = postSnapshot.getValue(Upload.class);
                        list.add(imageUploadInfo);
                    }
                    adapter = new RecyclerViewAdapter(getApplicationContext(), list);
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
