package com.example.mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class week3b_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week3b_main);

        Button submitBtn=findViewById(R.id.submitBtn);
        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextRollNo=findViewById(R.id.editRollNo);

        submitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Student student=new Student();
                student.setName(editTextName.getText().toString());
                student.setRollno(editTextRollNo.getText().toString());
                Intent intent = new Intent(week3b_main.this, week3b_second.class);
                intent.putExtra("Key", student);
                if(!student.getName().isEmpty() && !student.getRollno().isEmpty()) {
                    Toast.makeText(week3b_main.this, "Welcome " + student.getName(), Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else{
                    Toast.makeText(week3b_main.this, "Please fill the data", Toast.LENGTH_SHORT).show();
                }

            } });
    }
}