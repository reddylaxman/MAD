package com.example.mad;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class week4_second extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week4_second);
        Student student=(Student) getIntent().getSerializableExtra("key");
        String name = "Name: <i>" + student.getName() + "</i>";
        String password = "Password: <i>*****</i>";
        String address = "Address: <i>" + student.getAddress() + "</i>";
        String gender = "Gender: <i>" + student.getGender() + "</i>";
        String age = "Age (in Years): <i>" + student.getAge() + "</i>";
        String dob = "Date of Birth: <i>" + student.getDob() + "</i>";
        String state = "State: <i>" + student.getState() + "</i>";
        TextView textViewName = findViewById(R.id.textViewName);
        textViewName.setText(Html.fromHtml(name));
        TextView textViewPassword = findViewById(R.id.textViewPassword);
        textViewPassword.setText(Html.fromHtml(password));
        TextView textViewAddress = findViewById(R.id.textViewAddress);
        textViewAddress.setText(Html.fromHtml(address));
        TextView textViewGender = findViewById(R.id.textViewGender);
        textViewGender.setText(Html.fromHtml(gender));
        TextView textViewAge = findViewById(R.id.textViewAge);
        textViewAge.setText(Html.fromHtml(age));
        TextView textViewDOB = findViewById(R.id.textViewDOB);
        textViewDOB.setText(Html.fromHtml(dob));
        TextView textViewState = findViewById(R.id.textViewState);
        textViewState.setText(Html.fromHtml(state));
    }
}