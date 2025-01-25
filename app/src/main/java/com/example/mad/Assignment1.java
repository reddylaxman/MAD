package com.example.mad;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Assignment1 extends AppCompatActivity {

    Faculty faculty;
    EditText facultyName;
    Button submit;





    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment1);

        faculty = new Faculty();
        facultyName=findViewById(R.id.facultyName);
        submit=findViewById(R.id.submitBtn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String doj = faculty.getDoj();
                if (doj==null||doj.isEmpty()) {
                    Toast.makeText(Assignment1.this, "Please fill the all fields", Toast.LENGTH_SHORT).show();
                    return;
                }


                LocalDate joinDate = LocalDate.parse(doj, DateTimeFormatter.ofPattern("d-M-yyyy"));
                LocalDate currentDate = LocalDate.now();

                if (joinDate.isAfter(currentDate)) {
                    Toast.makeText(Assignment1.this, "Date of joining can't be in the future", Toast.LENGTH_SHORT).show();
                    return;
                }



                faculty.setName(facultyName.getText().toString());
                faculty.setGender(GetGender());

                if(!faculty.getName().isEmpty() && !faculty.getDesignation().isEmpty()&& !faculty.getGender().isEmpty()&& !faculty.getDoj().isEmpty()) {

                    Intent intent = new Intent(Assignment1.this, Assignment1_second.class);
                    intent.putExtra("key",faculty);
                    startActivity(intent);
                }else{
                    Toast.makeText(Assignment1.this, "Please fill the all fields", Toast.LENGTH_SHORT).show();
                }



            }
        });
        FillState();


    }


    private String GetGender(){
        RadioGroup rbGroupGender= findViewById(R.id.rbFacultyGroupGender);
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
        String[] data = { "Professor", "Associate Professor","Assistant Professor"};

        Spinner spinnerState = findViewById(R.id.spinnerDesignation);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,data);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerState.setAdapter(aa);
        spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                faculty.setDesignation(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }


    public void ShowDatePicker(View view){
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(
                Assignment1.this,
                new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("NewApi")
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month++;
                        faculty.setDoj(dayOfMonth + "-" + month + "-" + year);
                        LocalDate currentDate= LocalDate.now();
                        LocalDate joinDate= LocalDate.of(year,month,dayOfMonth);
                        Period period= Period.between(joinDate,currentDate);
                        int years= period.getYears();
                        int months=period.getMonths();
                        String exp="";
                        if(years>1 && months>1){
                            exp+=years+" years "+months+" months";
                        }else if(years==1 && months>1){
                            exp+=years+" year "+months+" months";
                        }else if(years>1 && months==1){
                            exp+=years+" years "+months+" month";
                        }else if(years==1 && months==1){
                            exp+=years+" year "+months+" month";
                        }else if(months<1){
                            exp+=years>1 ? years+" years": years+" year";
                        }else if(years<1){
                            exp+=months>1 ? months+" months": months+" month";
                        }

                        faculty.setExp(exp);
                        EditText editTextDOJ = findViewById(R.id.editDOJ);
                        editTextDOJ.setText(faculty.getDoj());
                    }
                },

                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        dialog.show();
    }
}