package com.example.mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button week;
    Button assignment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        week=findViewById(R.id.weekBtn);;

        assignment=findViewById(R.id.assignmentBtn);
        week.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent switchActivityWeek= new Intent(MainActivity.this, Week_Activity.class);
                startActivity(switchActivityWeek);
            }
        });
        assignment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent switchActivityAssignment= new Intent(MainActivity.this,Assignment_Activity.class);
                startActivity(switchActivityAssignment);
            }
        });


    }
}