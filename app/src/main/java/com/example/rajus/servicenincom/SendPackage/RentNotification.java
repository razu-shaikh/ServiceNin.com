package com.example.rajus.servicenincom.SendPackage;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.rajus.servicenincom.R;
import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RentNotification extends AppCompatActivity {
    int value;

    public DatabaseReference databaseRefe;
    Firebase myFirebase;
    String token;

    String carName,serviceArea,yourName,phoneNumber,time,companyName,companyPackage,price,eventCompanyName,eventCompanyPackage,date;
    String packCompanyName,packServiceArea,regularCompanyName,regularCompanyAddress,managementCompanyName,managementCompanyAddress;
    TextView nameTv;
    EditText serviceAreaEt,nameEt,phoneEt,timeEt;

    private RequestQueue mRequest;

    String Url="https://fcm.googleapis.com/fcm/send";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_notification);

        mRequest= Volley.newRequestQueue(this);

        nameTv = (TextView)findViewById(R.id.setText);
        serviceAreaEt = (EditText)findViewById(R.id.service_area);
        nameEt = (EditText)findViewById(R.id.name);
        phoneEt = (EditText)findViewById(R.id.phone);
        timeEt = (EditText)findViewById(R.id.time);

        Intent intent = getIntent();
        value = intent.getIntExtra("value", 0);

        String name = intent.getStringExtra("name");
        String companyName = intent.getStringExtra("name1");
        String companyAddress = intent.getStringExtra("address");
        String companyService = intent.getStringExtra("service");

        String tourCompany = intent.getStringExtra("name2");
        String tourPackage = intent.getStringExtra("package");
        String tourPrice = intent.getStringExtra("price");

        String eventCompanyName = intent.getStringExtra("name3");
        String eventPackage = intent.getStringExtra("package");

        String packCompanyName = intent.getStringExtra("name4");
        String packCompanyService = intent.getStringExtra("serviceArea");

        String regularName =intent.getStringExtra("nameregular");
        String regularAddress = intent.getStringExtra("address5");

        String managementName = intent.getStringExtra("name6");
        String managementAddress= intent.getStringExtra("address6");

        if (value==1)
        {
            nameTv.setText(companyName);
            serviceAreaEt.setText(companyAddress);
            timeEt.setText(companyService);
        }
        else if (value==2)
        {
            nameTv.setText(tourCompany);
            serviceAreaEt.setText(tourPackage);
            timeEt.setText(tourPrice);
        }
       else if (value==3){
            nameTv.setText(eventCompanyName);
            serviceAreaEt.setText(eventPackage);

        }
        else if (value==4)
        {
            nameTv.setText(packCompanyName);
            serviceAreaEt.setText(packCompanyService);
        }
       else if (value==5)
        {
            nameTv.setText(regularName);
            serviceAreaEt.setText(regularAddress);
        }
        else if (value==6)
           {
            nameTv.setText(managementName);
            serviceAreaEt.setText(managementAddress);
        }
        else {
            nameTv.setText(name);
        }
        Firebase.setAndroidContext(this);

        myFirebase = new Firebase("https://serviceninowner.firebaseio.com/");

        databaseRefe = FirebaseDatabase.getInstance().getReference().child("Token");
        databaseRefe.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot shot : dataSnapshot.getChildren()) {

                    token = shot.child("token").getValue().toString();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void Notification(View view) {

        yourName = nameEt.getText().toString();
        phoneNumber = phoneEt.getText().toString();
        if ((!TextUtils.isEmpty(phoneNumber)) && (!TextUtils.isEmpty(yourName))) {
            if (value == 1) {
                carName = nameTv.getText().toString();
                serviceArea = serviceAreaEt.getText().toString();
                time = timeEt.getText().toString();
                sendNotification1();
            } else if (value == 2) {
                companyName = nameTv.getText().toString();
                companyPackage = serviceAreaEt.getText().toString();
                price = timeEt.getText().toString();
                sendNotification2();

            } else if (value == 3) {
                eventCompanyName = nameTv.getText().toString();
                eventCompanyPackage = serviceAreaEt.getText().toString();
                date = timeEt.getText().toString();
                sendNotification3();

            } else if (value == 4) {
                packCompanyName = nameTv.getText().toString();
                packServiceArea = serviceAreaEt.getText().toString();
                date = timeEt.getText().toString();
                sendNotification4();

            } else if (value == 5) {
                regularCompanyName = nameTv.getText().toString();
                regularCompanyAddress = serviceAreaEt.getText().toString();
                date = timeEt.getText().toString();
                sendNotification5();

            } else if (value == 6) {
                managementCompanyName = nameTv.getText().toString();
                managementCompanyAddress = serviceAreaEt.getText().toString();
                date = timeEt.getText().toString();
                sendNotification6();
            } else {
                carName = nameTv.getText().toString();
                serviceArea = serviceAreaEt.getText().toString();
                time = timeEt.getText().toString();
                sendNotification();
            }
            Toast.makeText(RentNotification.this,"SENT MESSAGE SUCCESSFULLY",Toast.LENGTH_LONG).show();
            nameEt.setText("");
            phoneEt.setText("");
        }else
        {
            Toast toast= new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER,0,0);
            TextView tv = new TextView(RentNotification.this);
            tv.setTextColor(Color.RED);
            tv.setTextSize(25);
            tv.setText("SOMETHING WENT WRONG....... Please Fill Up Form Completely");
            toast.setView(tv);
            toast.show();
        }
    }

    private void sendNotification() {
        JSONObject mainObj = new JSONObject();
        try{
            mainObj.put("to",token);
            JSONObject notiObj = new JSONObject();
            notiObj.put("title","");
            notiObj.put("body","Car Name: "+carName+",   "+
                    "From to To: "+serviceArea+",   "+
                    "Client Name: "+yourName+",   "+
                    "Contact Number: "+phoneNumber+",   "+
                    "Time: "+time);

            mainObj.put("data",notiObj);

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, Url,
                    mainObj,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }
            ){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> header = new HashMap<>();
                    header.put("content-type","application/json");
                    header.put("authorization","key = AIzaSyAlhv_Fef-w0tfcvJyxZrS3C7JrimbwCiU");
                    return header;
                }
            };
            mRequest.add(request);


        }catch(JSONException e){
            e.printStackTrace();

        }

    }
    private void sendNotification1() {
        JSONObject mainObj = new JSONObject();
        try{
            mainObj.put("to",token);
            JSONObject notiObj = new JSONObject();
            notiObj.put("title","");
            notiObj.put("body","Company Name: "+carName+",   "+
                    "Company Address: "+serviceArea+",   "+
                    "Service Type: "+time+",   "+
                    "Client Name: "+yourName+",   "+
                    "Contact Number: "+phoneNumber);

            mainObj.put("data",notiObj);

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,Url,
                    mainObj,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }
            ){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> header = new HashMap<>();
                    header.put("content-type","application/json");
                    header.put("authorization","key = AIzaSyAlhv_Fef-w0tfcvJyxZrS3C7JrimbwCiU");
                    return header;
                }
            };
            mRequest.add(request);


        }catch(JSONException e){
            e.printStackTrace();

        }

    }
    private void sendNotification2() {
        JSONObject mainObj = new JSONObject();
        try{
            mainObj.put("to",token);
            JSONObject notiObj = new JSONObject();
            notiObj.put("title","");
            notiObj.put("body","Company Name: "+companyName+",   "+
                    "Package: "+companyPackage+",   "+
                    "Price: "+date+",   "+
                    "Client Name: "+yourName+",   "+
                    "Contact Number: "+phoneNumber);

            mainObj.put("data",notiObj);

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, Url,
                    mainObj,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }
            ){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> header = new HashMap<>();
                    header.put("content-type","application/json");
                    header.put("authorization","key = AIzaSyAlhv_Fef-w0tfcvJyxZrS3C7JrimbwCiU");
                    return header;
                }
            };
            mRequest.add(request);


        }catch(JSONException e){
            e.printStackTrace();

        }

    }
    private void sendNotification3() {
        JSONObject mainObj = new JSONObject();
        try{
            mainObj.put("to",token);
            JSONObject notiObj = new JSONObject();
            notiObj.put("title","");
            notiObj.put("body","Company Name: "+eventCompanyName+",   "+
                    "Package: "+ eventCompanyPackage+",   "+
                    "Time: "+date+",   "+
                    "Client Name: "+yourName+",   "+
                    "Contact Number: "+phoneNumber);

            mainObj.put("data",notiObj);

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, Url,
                    mainObj,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }
            ){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> header = new HashMap<>();
                    header.put("content-type","application/json");
                    header.put("authorization","key = AIzaSyAlhv_Fef-w0tfcvJyxZrS3C7JrimbwCiU");
                    return header;
                }
            };
            mRequest.add(request);


        }catch(JSONException e){
            e.printStackTrace();

        }

    }
    private void sendNotification4() {
        JSONObject mainObj = new JSONObject();
        try{
            mainObj.put("to",token);
            JSONObject notiObj = new JSONObject();
            notiObj.put("title","");
            notiObj.put("body","Company Name: "+packCompanyName+",   "+
                    "Service Area: "+ packServiceArea+",   "+
                    "Time: "+date+",   "+
                    "Client Name: "+yourName+",   "+
                    "Contact Number: "+phoneNumber);

            mainObj.put("data",notiObj);

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, Url,
                    mainObj,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }
            ){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> header = new HashMap<>();
                    header.put("content-type","application/json");
                    header.put("authorization","key = AIzaSyAlhv_Fef-w0tfcvJyxZrS3C7JrimbwCiU");
                    return header;
                }
            };
            mRequest.add(request);


        }catch(JSONException e){
            e.printStackTrace();

        }

    }
    private void sendNotification5() {
        JSONObject mainObj = new JSONObject();
        try{
            mainObj.put("to",token);
            JSONObject notiObj = new JSONObject();
            notiObj.put("title","");
            notiObj.put("body","Company Name: "+regularCompanyName+",   "+
                    "Company Address: "+ regularCompanyAddress+",   "+
                    "Time: "+date+",   "+
                    "Client Name: "+yourName+",   "+
                    "Contact Number: "+phoneNumber);

            mainObj.put("data",notiObj);

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, Url,
                    mainObj,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }
            ){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> header = new HashMap<>();
                    header.put("content-type","application/json");
                    header.put("authorization","key = AIzaSyAlhv_Fef-w0tfcvJyxZrS3C7JrimbwCiU");
                    return header;
                }
            };
            mRequest.add(request);


        }catch(JSONException e){
            e.printStackTrace();

        }

    }
    private void sendNotification6() {
        JSONObject mainObj = new JSONObject();
        try{
            mainObj.put("to",token);
            JSONObject notiObj = new JSONObject();
            notiObj.put("title","");
            notiObj.put("body","Company Name: "+managementCompanyName+",   "+
                    "Company Address: "+ managementCompanyAddress+",   "+
                    "Time: "+date+",   "+
                    "Client Name: "+yourName+",   "+
                    "Contact Number: "+phoneNumber);

            mainObj.put("data",notiObj);

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, Url,
                    mainObj,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }
            ){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> header = new HashMap<>();
                    header.put("content-type","application/json");
                    header.put("authorization","key = AIzaSyAlhv_Fef-w0tfcvJyxZrS3C7JrimbwCiU");
                    return header;
                }
            };
            mRequest.add(request);


        }catch(JSONException e){
            e.printStackTrace();

        }

    }
}
