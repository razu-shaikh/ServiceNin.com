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

public class SendNotification extends AppCompatActivity {

    int value;
    public DatabaseReference databaseRefe;
    Firebase myFirebase;
    String token;
    String name1,quantity1,location1,phone1,time1,name2;
    String restaurantCompanyName, companyEquipment;
    TextView nameTv,restaurant;
    EditText quantity,location,phone,time;

    private RequestQueue mRequest;

    String Url="https://fcm.googleapis.com/fcm/send";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_notification);

        mRequest= Volley.newRequestQueue(this);

        nameTv = (TextView) findViewById(R.id.setText);//item
        restaurant = (TextView) findViewById(R.id.restaurantName);
        quantity = (EditText)findViewById(R.id.quantity);
        location = (EditText)findViewById(R.id.location);
        phone = (EditText)findViewById(R.id.phone);
        time = (EditText)findViewById(R.id.Time);

        Intent intent = getIntent();
        value = intent.getIntExtra("value", 0);

        String name = intent.getStringExtra("name");
        String restaurantCompany = intent.getStringExtra("companyN");
        String itemName = intent.getStringExtra("name1");
        String companyName = intent.getStringExtra("company");


        if (value==1){
            nameTv.setText(itemName);
            restaurant.setText(companyName);
        }else{
            nameTv.setText(name);
            restaurant.setText(restaurantCompany);
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
        quantity1 = quantity.getText().toString();
        location1 = location.getText().toString();
        phone1 = phone.getText().toString();
        time1 = time.getText().toString();
        if ((!TextUtils.isEmpty(quantity1))&&(!TextUtils.isEmpty(phone1))) {
            if (value == 1) {
                companyEquipment = restaurant.getText().toString();
                name2 = nameTv.getText().toString();
                sendNotification1();
            } else {
                restaurantCompanyName = restaurant.getText().toString();
                name1 = nameTv.getText().toString();
                sendNotification();

            }
            Toast.makeText(SendNotification.this,"SENT MESSAGE SUCCESSFULLY",Toast.LENGTH_LONG).show();
            quantity.setText("");
            phone.setText("");

        }
        else{
            Toast toast= new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER,0,0);
            TextView tv = new TextView(SendNotification.this);
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
            notiObj.put("body","Restaurant Name: "+ restaurantCompanyName +",   "+
                   "Item Name: "+name1+",   "+
                    "Quantity: "+quantity1+",   "+
                    "Location: "+location1+",   "+
                    "Client Contact Number: "+phone1+",   "+
                    "Delavery Time: "+time1);

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
            notiObj.put("body","Restaurant Name: "+ companyEquipment +",   "+
                    "Item Name: "+name2+",   "+
                    "Quantity: "+quantity1+",   "+
                    "Location: "+location1+",   "+
                    "Client Contact Number: "+phone1+",   "+
                    "Delavery Time: "+time1);

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
