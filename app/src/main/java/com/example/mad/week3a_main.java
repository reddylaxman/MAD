package com.example.mad;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class week3a_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week3a_main);

        Button submitBtn=findViewById(R.id.submitBtn);
            EditText  editTextName = findViewById(R.id.editTextName);

            submitBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    String name = editTextName.getText().toString();
                    Intent intent = new Intent(week3a_main.this, week3a_second.class);
                    intent.putExtra("name", name);
                    if(!name.isEmpty()) {
                        Toast.makeText(week3a_main.this, "Welcome " + name, Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(week3a_main.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                    }

                } });

        }
    }



