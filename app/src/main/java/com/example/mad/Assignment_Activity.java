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

public class Assignment_Activity extends AppCompatActivity {
    Button Assignment1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_assignment);
        Assignment1=findViewById(R.id.assignment1Btn);

        Assignment1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent switchActivityAssignment1= new Intent(Assignment_Activity.this,Assignment1.class);
                startActivity(switchActivityAssignment1);
            }
        });

    }
}