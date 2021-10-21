package fragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import com.example.royalbrothers.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class HomeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ImageView s1,s2,s3,s4,pbanner;
        EditText pDate,pTime,dDate,dTime;
        Button search;
        LinearLayout scramble,scooter,sports,chopper,trending,newArrival,offer,compare;

        View view=inflater.inflate(R.layout.fragment_home,container,false);
        s1=view.findViewById(R.id.service1);
        s2=view.findViewById(R.id.service2);
        s3=view.findViewById(R.id.service3);
        s4=view.findViewById(R.id.service4);
        pbanner=view.findViewById(R.id.banner);
        scramble=view.findViewById(R.id.scrambler);
        scooter=view.findViewById(R.id.scooter);
        sports=view.findViewById(R.id.sports);
        chopper=view.findViewById(R.id.chopper);
        search=view.findViewById(R.id.search);
        pDate=view.findViewById(R.id.pickupDate);
        pTime=view.findViewById(R.id.pickupTime);
        dDate=view.findViewById(R.id.dropDate);
        dTime=view.findViewById(R.id.dropTime);
        trending=view.findViewById(R.id.trending);
        newArrival=view.findViewById(R.id.new_arrival);
        offer=view.findViewById(R.id.offer);
        compare=view.findViewById(R.id.compare);


        trending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(view,"Trending bikes");
            }
        });
        newArrival.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(view,"New Arrival");
            }
        });
        offer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(view,"Offer");
            }
        });

        compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(view,"Spark Plug service");
            }
        });
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(view,"Spark Plug service");
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(view,"Carburetor service");
            }
        });
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(view,"Fuel Lines service");

            }
        });
        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(view,"Air filter service");

            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pd,pt,dd,dt;
                pd=pDate.getText().toString();
                pt=pTime.getText().toString();
                dd=dDate.getText().toString();
                dt=dTime.getText().toString();
                if(!pd.isEmpty() && !pt.isEmpty() && !dd.isEmpty() && !dt.isEmpty())
                {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());

                    builder1.setMessage("Your Ride is Booked");
                    builder1.setCancelable(true);
                    builder1.setCancelable(false);

                    builder1.setPositiveButton(
                            "Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    pDate.setText("");
                                    pTime.setText("");
                                    dDate.setText("");
                                    dTime.setText("");
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();

                }
                else {

                    showDialog(view,"Please Choose Date and time");
                }


            }
        });


        scramble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(view,"Scrambler Category");

            }
        });
        scooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(view,"Scooter Category");
            }
        });
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(view,"Sports bike Category");
            }
        });
        chopper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(view,"Chopper Category");
            }
        });

        pbanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());

                builder1.setTitle("Promotional Banner");
                builder1.setMessage("I made this discount card in photoshop");
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

        pDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mYear,mMonth,mDay;
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                pDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        pTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mHour,mMinute;
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                pTime.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        });


        dDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mYear,mMonth,mDay;
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                dDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        dTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mHour,mMinute;
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                dTime.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        });

        return view;
    }


    private void showDialog(View v,String msg)
    {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(v.getContext());

        builder1.setMessage(msg);
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
}