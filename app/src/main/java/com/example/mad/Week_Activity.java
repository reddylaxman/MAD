package com.example.mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Week_Activity extends AppCompatActivity {
    Button week1;
    Button week2;
    Button week3a;
    Button week3b;
    Button week4;
    Button week5;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);
        week1=findViewById(R.id.week1Btn);
        week2=findViewById(R.id.week2Btn);
        week3a=findViewById(R.id.week3ABtn);
        week3b=findViewById(R.id.week3BBtn);
        week4=findViewById(R.id.week4Btn);
        week5=findViewById(R.id.week5Btn);


        week1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent switchActivityWeek1= new Intent(Week_Activity.this,week1.class);
                startActivity(switchActivityWeek1);
            }
        });
        week2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent switchActivityWeek2= new Intent(Week_Activity.this,week2.class);
                startActivity(switchActivityWeek2);
            }
        });

        week3a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent switchActivityWeek3A= new Intent(Week_Activity.this,week3a_main.class);
                startActivity(switchActivityWeek3A);
            }
        });
        week3b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent switchActivityWeek3B= new Intent(Week_Activity.this,week3b_main.class);
                startActivity(switchActivityWeek3B);
            }
        });
        week4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent switchActivityWeek4= new Intent(Week_Activity.this,week4_main.class);
                startActivity(switchActivityWeek4);
            }
        });
        week5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent switchActivityWeek5= new Intent(Week_Activity.this,week5.class);
                startActivity(switchActivityWeek5);
            }
        });





    }
}