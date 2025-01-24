package com.example.mad;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Assignment1_second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment1_second);
        Faculty faculty=(Faculty) getIntent().getSerializableExtra("key");
        if (faculty == null) {
            Toast.makeText(this, "Faculty data is missing!", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        String name = "Name: <i>" + faculty.getName() + "</i>";

        String designation = "Designation: <i>" + faculty.getDesignation() + "</i>";
        String gender = "Gender: <i>" + faculty.getGender() + "</i>";
        String exp = "Experience (in Years): <i>" + faculty.getExp() + "</i>";
        String doj = "Date of Join: <i>" + faculty.getDoj() + "</i>";

        TextView textViewName = findViewById(R.id.textViewName);
        textViewName.setText(Html.fromHtml(name));
        TextView textViewDesignation = findViewById(R.id.textViewDesignation);
        textViewDesignation.setText(Html.fromHtml(designation));
        TextView textViewGender = findViewById(R.id.textViewGender);
        textViewGender.setText(Html.fromHtml(gender));
        TextView textViewDOJ = findViewById(R.id.textViewDOJ);
        textViewDOJ.setText(Html.fromHtml(doj));
        TextView textViewExp = findViewById(R.id.textViewExp);
        textViewExp.setText(Html.fromHtml(exp));

    }
}