package com.example.mad;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class week2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week2);

        TextView textViewName=findViewById(R.id.textViewName);
        EditText editTextName=findViewById(R.id.editTextName);
        Button clearButton=findViewById(R.id.clearButton);
        Button submitButton=findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String input=editTextName.getText().toString();
                if(!input.isEmpty()){
                    textViewName.setText("You entered: "+input);
                }else{
                    textViewName.setText("Please enter some text.");
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                editTextName.setText("");
                textViewName.setText("");
            }
        });
    }



}