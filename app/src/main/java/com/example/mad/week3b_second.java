package com.example.mad;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class week3b_second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week3b_second);
        Intent intent=getIntent();
        Student student=(Student) intent.getSerializableExtra("Key");
        TextView nameReceived= findViewById(R.id.nameReceived);
        TextView rollNoReceived= findViewById(R.id.rollNoReceived);
        if (student != null) {
            nameReceived.setText(student.getName());
            rollNoReceived.setText(student.getRollno());
        }else{
            nameReceived.setText("Student data not available");
            rollNoReceived.setText("");
        }


    }
}