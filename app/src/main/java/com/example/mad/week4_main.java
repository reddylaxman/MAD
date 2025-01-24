package com.example.mad;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class week4_main extends AppCompatActivity {
    Student student;
    private boolean isPasswordVisible=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week4_main);

        student = new Student();
        EditText editName=findViewById(R.id.editTextName);
        EditText editPassword=findViewById(R.id.editPassword);
        EditText editAddress=findViewById(R.id.editAddress);
        EditText editAge=findViewById(R.id.editAge);
        EditText editDOB=findViewById(R.id.editDOB);
        Button submitData= findViewById(R.id.btnSubmit);
        ImageButton togglePasswordBtn= findViewById(R.id.togglePassqwordBtn);

        submitData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                student.setName(editName.getText().toString());
                student.setPassword(editPassword.getText().toString());
                student.setAddress(editAddress.getText().toString());
                student.setGender(GetGender());
                student.setAge(editAge.getText().toString());
                student.setDob(editDOB.getText().toString());
                Intent intent = new Intent(week4_main.this, week4_second.class);
                intent.putExtra("key", student);
                if(!student.getName().isEmpty() && !student.getAddress().isEmpty() && !student.getAge().isEmpty() && !student.getDob().isEmpty() && !student.getGender().isEmpty() && !student.getState().isEmpty()) {
                    Toast.makeText(week4_main.this, "Welcome " + student.getName(), Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
                else{
                    Toast.makeText(week4_main.this, "Please fill the data", Toast.LENGTH_SHORT).show();
                }
            }
        });
FillState();

        togglePasswordBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(isPasswordVisible){
                    editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    editPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    togglePasswordBtn.setImageResource(R.drawable.visibility_off);
                }else{
                    editPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                    togglePasswordBtn.setImageResource(R.drawable.visibility_on);
                }
                isPasswordVisible=!isPasswordVisible;
                editPassword.setSelection(editPassword.length());

            }
        });

    }
    private String GetGender(){
        RadioGroup rbGroupGender= findViewById(R.id.rbGroupGender);
        RadioButton selectedRadioButton;
        int selectedRadioButtonId = rbGroupGender.getCheckedRadioButtonId();
        if (selectedRadioButtonId != -1) {
            selectedRadioButton = findViewById(selectedRadioButtonId);
            String selectedGender = selectedRadioButton.getText().toString();
            return selectedGender;
        }else {
            return "";
        }
    }

    private void FillState(){
        String[] data = { "Telangana", "Andhra Pradesh"};
        Spinner spinnerState = findViewById(R.id.spinnerState);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,data);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerState.setAdapter(aa);
        spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                student.setState(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }


    public void ShowDatePicker(View view){
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(
                week4_main.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month++;
                        student.setDob(dayOfMonth + "-" + month + "-" + year);
                        EditText editTextDOB = findViewById(R.id.editDOB);
                        editTextDOB.setText(student.getDob());
                    }
                },

                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        dialog.show();
    }



}