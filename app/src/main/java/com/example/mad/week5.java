package com.example.mad;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class week5 extends AppCompatActivity {
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week5);
        submitButton=findViewById(R.id.submitSMS);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textMobileNo = findViewById(R.id.textMobileNo);
                EditText textMessage = findViewById(R.id.textMessage);
                String mobileNo = textMobileNo.getText().toString();
                String message = textMessage.getText().toString();
                if(!mobileNo.isEmpty()&&!message.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.fromParts("sms", mobileNo, null));
                    intent.putExtra("sms_body", message);
                    startActivity(intent);
                }

            }
        });

    }
}