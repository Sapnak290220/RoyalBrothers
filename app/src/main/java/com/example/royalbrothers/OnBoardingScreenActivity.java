package com.example.royalbrothers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingScreenActivity extends AppCompatActivity {

    private Spinner spinner,cityS;
    SliderView sliderView;
    int[] image={R.drawable.bike1,R.drawable.bike2,R.drawable.bike3,R.drawable.bike4};
    String cityName;
    TextView skipIt;
    EditText phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_screen);
        sliderView=findViewById(R.id.imageSlider);
        cityS = findViewById(R.id.city);
        phone = (EditText)findViewById(R.id.mobileNumber);
        skipIt=findViewById(R.id.skip);
        SliderAdapter sliderAdapter=new SliderAdapter(image);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.startAutoCycle();
        getSupportActionBar().hide();


        SharedPreferences.Editor editor = getSharedPreferences("myPref", MODE_PRIVATE).edit();
        editor.putString("activity", "shown");
        editor.apply();


        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());

                builder1.setMessage("Login or signUp is under Construction");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();


            }
        });
        skipIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cityName = cityS.getSelectedItem().toString();
                if(!cityName.equalsIgnoreCase("Select City"))
                {
                    Intent intent=new Intent(OnBoardingScreenActivity.this,HomeScreenActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(OnBoardingScreenActivity.this, "Plaese Select City", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cityS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                cityName = cityS.getSelectedItem().toString();
                if(!cityName.equalsIgnoreCase("Select City"))
                {

                    SharedPreferences.Editor editor = getSharedPreferences("myPref", MODE_PRIVATE).edit();
                    editor.putString("city", cityName);
                    editor.apply();
                    Intent intent=new Intent(OnBoardingScreenActivity.this,HomeScreenActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }


}