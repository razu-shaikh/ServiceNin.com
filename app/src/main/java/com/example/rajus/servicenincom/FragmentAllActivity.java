package com.example.rajus.servicenincom;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.rajus.servicenincom.BusinessManagement.ShowManagementActivity;
import com.example.rajus.servicenincom.CarRent.DisplayCarActivity;
import com.example.rajus.servicenincom.DailyLaunch.DisplayImagesActivity;
import com.example.rajus.servicenincom.EventManagement.ShowEventActivity;
import com.example.rajus.servicenincom.ItPackage.ShowCompanyActivity;
import com.example.rajus.servicenincom.OfficeAndHomeEquipment.ShowHomeAndOfficeActivity;
import com.example.rajus.servicenincom.PackAndShift.ShowPackActivity;
import com.example.rajus.servicenincom.RegularService.ShowRegularActivity;
import com.example.rajus.servicenincom.SubActivity.BusinessFragment;
import com.example.rajus.servicenincom.SubActivity.FragmentEvent;
import com.example.rajus.servicenincom.SubActivity.FragmentHome;
import com.example.rajus.servicenincom.SubActivity.FragmentIt;
import com.example.rajus.servicenincom.SubActivity.FragmentRegular;
import com.example.rajus.servicenincom.SubActivity.FragmentRent;
import com.example.rajus.servicenincom.SubActivity.FragmentShift;
import com.example.rajus.servicenincom.SubActivity.FragmentSupply;
import com.example.rajus.servicenincom.SubActivity.FragmentTour;
import com.example.rajus.servicenincom.TourAndTravels.ShowTourActivity;

public class FragmentAllActivity extends AppCompatActivity {
    int value1=1;
    int value2=2;
    int value3=3;
    int value4=4;
    int value5=5;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_all);

        switch (getIntent().getStringExtra("EXTRA")){

            case "rentFragment":
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, new FragmentRent())
                        .commit();
                break;
            case "tourFragment":
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, new FragmentTour())
                        .commit();
                break;
            case "supplyFragment":
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, new FragmentSupply())
                        .commit();
                break;
            case "shiftFragment":
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, new FragmentShift())
                        .commit();
                break;

            case "regularFragment":
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, new FragmentRegular())
                        .commit();
                break;
            case "itFragment":
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, new FragmentIt())
                        .commit();
                break;
            case "homeFragment":
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, new FragmentHome())
                        .commit();
                break;
            case "eventFragment":
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, new FragmentEvent())
                        .commit();
                break;
            case "businessFragment":
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, new BusinessFragment())
                        .commit();
                break;
        }


        mToolbar = (Toolbar)findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("All Services");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void changeFragment(View view) {
        Fragment fragment = null;
        switch (view.getId())
        {
            case R.id.tour:
                 fragment = new FragmentTour();
                break;
            case R.id.event:
                fragment = new FragmentEvent();

                break;
            case R.id.rent:
                fragment = new FragmentRent();

                break;
            case R.id.home:
                fragment = new FragmentHome();

                break;
            case R.id.pack:
                fragment = new FragmentShift();

                break;
            case R.id.food:
                fragment = new FragmentSupply();

                break;
            case R.id.it:
                fragment = new FragmentIt();

                break;
            case R.id.regular:
                fragment = new FragmentRegular();

                break;
            case R.id.business:
                fragment = new BusinessFragment();
                break;

        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainer,fragment);
       ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void dailyLaunch(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, DisplayImagesActivity.class);
        intent.putExtra("value",value1);
        startActivity(intent);
    }

    public void partyFoods(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, DisplayImagesActivity.class);
        intent.putExtra("value",value2);
        startActivity(intent);
    }

    public void eventFood(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, DisplayImagesActivity.class);
        intent.putExtra("value",value3);
        startActivity(intent);
    }

    public void iftarPack(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, DisplayImagesActivity.class);
        intent.putExtra("value",value4);
        startActivity(intent);
    }

    public void giftBox(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, DisplayImagesActivity.class);
        intent.putExtra("value",value5);
        startActivity(intent);
    }

    public void carRent(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, DisplayCarActivity.class);
        intent.putExtra("value",value1);
        startActivity(intent);
    }

    public void trackAndPickUp(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, DisplayCarActivity.class);
        intent.putExtra("value",value2);
        startActivity(intent);
    }

    public void ambulance(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, DisplayCarActivity.class);
        intent.putExtra("value",value3);
        startActivity(intent);
    }

    public void picnicTransport(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, DisplayCarActivity.class);
        intent.putExtra("value",value4);
        startActivity(intent);
    }

    public void software(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowCompanyActivity.class);
        intent.putExtra("value",value1);
        startActivity(intent);
    }

    public void domain(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowCompanyActivity.class);
        intent.putExtra("value",value2);
        startActivity(intent);
    }

    public void website(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowCompanyActivity.class);
        intent.putExtra("value",value3);
        startActivity(intent);
    }

    public void graphics(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowCompanyActivity.class);
        intent.putExtra("value",value4);
        startActivity(intent);
    }

    public void marketing(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowCompanyActivity.class);
        intent.putExtra("value",value5);
        startActivity(intent);
    }

    public void ticket(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowTourActivity.class);
        intent.putExtra("value",value2);
        startActivity(intent);
    }

    public void tourPackage(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowTourActivity.class);
        intent.putExtra("value",value1);
        startActivity(intent);
    }

    public void visa(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowTourActivity.class);
        intent.putExtra("value",value4);
        startActivity(intent);
    }

    public void hotel(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowTourActivity.class);
        intent.putExtra("value",value3);
        startActivity(intent);
    }

    public void wedding(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowEventActivity.class);
        intent.putExtra("value",value2);
        startActivity(intent);
    }

    public void picnic(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowEventActivity.class);
        intent.putExtra("value",value4);
        startActivity(intent);

    }

    public void cultural(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowEventActivity.class);
        intent.putExtra("value",value3);
        startActivity(intent);
    }

    public void corporate(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowEventActivity.class);
        intent.putExtra("value",value1);
        startActivity(intent);
    }

    public void officeShift(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowPackActivity.class);
        intent.putExtra("value",value1);
        startActivity(intent);
    }

    public void homeShift(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowPackActivity.class);
        intent.putExtra("value",value2);
        startActivity(intent);
    }

    public void homeAndOfficeSet(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowPackActivity.class);
        intent.putExtra("value",value3);
        startActivity(intent);
    }

    public void industrial(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowPackActivity.class);
        intent.putExtra("value",value4);
        startActivity(intent);
    }

    public void homeAndOfficeCleaning(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowRegularActivity.class);
        intent.putExtra("value",value1);
        startActivity(intent);
    }

    public void applianceRepair(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowRegularActivity.class);
        intent.putExtra("value",value4);
        startActivity(intent);
    }

    public void vehicleRepair(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowRegularActivity.class);
        intent.putExtra("value",value5);
        startActivity(intent);
    }

    public void pestControl(View view){
        Intent intent = new Intent(FragmentAllActivity.this, ShowRegularActivity.class);
        intent.putExtra("value",value2);
        startActivity(intent);
    }

    public void interiorDesign(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowRegularActivity.class);
        intent.putExtra("value",value3);
        startActivity(intent);
    }

    public void credit(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowManagementActivity.class);
        intent.putExtra("value",value1);
        startActivity(intent);
    }

    public void recovery(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowManagementActivity.class);
        intent.putExtra("value",value2);
        startActivity(intent);
    }

    public void mis(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowManagementActivity.class);
        intent.putExtra("value",value3);
        startActivity(intent);
    }

    public void bpo(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowManagementActivity.class);
        intent.putExtra("value",value4);
        startActivity(intent);
    }

    public void officeFurniture(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowHomeAndOfficeActivity.class);
        intent.putExtra("value",value1);
        startActivity(intent);
    }

    public void homeFurniture(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowHomeAndOfficeActivity.class);
        intent.putExtra("value",value2);
        startActivity(intent);
    }

    public void medicalEquip(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowHomeAndOfficeActivity.class);
        intent.putExtra("value",value3);
        startActivity(intent);
    }

    public void vehicleTools(View view) {
        Intent intent = new Intent(FragmentAllActivity.this, ShowHomeAndOfficeActivity.class);
        intent.putExtra("value",value4);
        startActivity(intent);
    }
}
