package com.example.kishbelic.placeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;


public class MainActivity extends AppCompatActivity {

    TextView txt_view;
    int PLACE_PICKER_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_view = (TextView) findViewById(R.id.txt_view);


    }

    public void OnAddressClicked(View View){

        //Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
        //startActivity(intent);


        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

        try {
            startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "idhu vanthuttu ", Toast.LENGTH_LONG).show();

        Log.i("OnAdressClicked","Button Clicked");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PLACE_PICKER_REQUEST){

            if(resultCode == RESULT_OK){

                Place place = PlacePicker.getPlace(this,data);

                //txt_view.setText(place.getAddress());
                String toastMsg = String.format("Place: %s", place.getName());
                Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
            }

        }


    }
}
