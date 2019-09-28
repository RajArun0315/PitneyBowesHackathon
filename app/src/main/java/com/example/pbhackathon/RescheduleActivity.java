package com.example.pbhackathon;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class RescheduleActivity extends AppCompatActivity {
    private TextView tv_date;
    private Button b_generate;
    private Button btn5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reschedule);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Reschedule Here");

        tv_date =(TextView) findViewById(R.id.tv_date);
        b_generate = (Button) findViewById(R.id.b_generate);

        b_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_date.setText(generateRandomDate());
            }
        });

        btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddData();

            }
        });
    }

    private String generateRandomDate(){
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(2019,2019);
        gc.set(GregorianCalendar.YEAR,year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(GregorianCalendar.DAY_OF_YEAR));
        gc.set(GregorianCalendar.DAY_OF_YEAR,dayOfYear);

        return gc.get(GregorianCalendar.YEAR)+"-"+
                (gc.get(GregorianCalendar.MONTH))+"-"+
                gc.get(GregorianCalendar.DAY_OF_MONTH);
    }

    private static  int randBetween(int start, int end){
        return start + (int) Math.round(Math.random()*(end-start));
    }


    public void AddData(){
        Toast.makeText(getApplication(),"Order has been Cancelled Successfully",Toast.LENGTH_LONG).show();
    }
}


