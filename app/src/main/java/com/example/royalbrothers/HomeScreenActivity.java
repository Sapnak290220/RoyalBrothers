package com.example.royalbrothers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import fragments.HomeFragment;
import fragments.MenuFragment;
import fragments.rbxFragment;
import fragments.tariffFragment;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeScreenActivity extends AppCompatActivity {


    private BottomNavigationView bnv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        bnv=findViewById(R.id.bottomNavigation);


        SharedPreferences prefs = getSharedPreferences("myPref", MODE_PRIVATE);
        String name = prefs.getString("city", "  City Name");//"No name defined" is the default value.


        /*ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(getResources().getDrawable(R.drawable.city_icon));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle(Html.fromHtml("<font color='#000000'>"+name +"</font>"));
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));*/

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(actionBar.getDisplayOptions()
                | ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setIcon(getResources().getDrawable(R.drawable.location_city));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle(Html.fromHtml("<font color='#000000'>"+name +"</font>"));
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));

        Button b = new Button(actionBar.getThemedContext());

        Drawable image = getResources().getDrawable( R.drawable.star );
        int h = image.getIntrinsicHeight();
        int w = image.getIntrinsicWidth();
        image.setBounds( 0, 0, w, h );
        b.setCompoundDrawables( image, null, null, null );
        //b.setCompoundDrawables(getResources().getDrawable(R.drawable.city_icon),getResources().getDrawable(R.drawable.city_icon),null,null);
        b.setText(" Offers");
        b.setTextColor(Color.parseColor("#000000"));

        b.setBackground(new ColorDrawable(Color.parseColor("#ffffff")));
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT, Gravity.RIGHT
                | Gravity.CENTER_VERTICAL);
        layoutParams.rightMargin = 1;
        b.setLayoutParams(layoutParams);
        actionBar.setCustomView(b);



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());

                builder1.setMessage("New Offers");
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



        Fragment temp1=null;
        temp1=new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.myContainer,temp1).addToBackStack(null).commit();



        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                Fragment temp=null;
                switch (item.getItemId())
                {
                    case R.id.home_menu:

                        temp=new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.myContainer,temp).addToBackStack(null).commit();
                        break;
                    case R.id.tariff_menu:

                        temp=new tariffFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.myContainer,temp).addToBackStack(null).commit();

                        break;
                    case R.id.rbx_menu:
                        temp=new rbxFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.myContainer,temp).addToBackStack(null).commit();

                        break;
                    case R.id.menu:
                        temp=new MenuFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.myContainer,temp).addToBackStack(null).commit();

                       // Toast.makeText(HomeScreenActivity.this, "Its menu", Toast.LENGTH_SHORT).show();
                        break;

                }

                return true;
            }
        });
    }
}