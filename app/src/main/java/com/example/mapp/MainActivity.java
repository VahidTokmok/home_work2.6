package com.example.mapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private String userName = "admin";
    TextView textView;
    EditText editText;
    EditText editText1;
    MaterialButton materialButton;
    private final TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String emailInput = editText.getText().toString().trim();
            String passwordInput = editText1.getText().toString().trim();

            if (emailInput.isEmpty() || passwordInput.isEmpty()){
                materialButton.setBackgroundColor(getColor(R.color.gray));
            }else {
                materialButton.setBackgroundColor(getColor(R.color.orange));
            }
        }

        @Override
        public void afterTextChanged(Editable s) {}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv_login);
        editText = findViewById(R.id.et_email);
        editText1 = findViewById(R.id.et_password);
        materialButton = findViewById(R.id.bt_enter);

       editText.addTextChangedListener(loginTextWatcher);
       editText1.addTextChangedListener(loginTextWatcher);

       materialButton.setOnClickListener(v -> {
        if (editText.getText().toString().equals(userName) && editText1.getText().toString().equals(userName)){
            Toast.makeText(this, R.string.logged, Toast.LENGTH_SHORT).show();
            textView.setAlpha(0);
        }else{
            Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show();
        }
       });
    }
}