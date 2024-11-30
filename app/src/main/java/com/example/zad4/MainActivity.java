package com.example.zad4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPhone;
    private RadioGroup radioGroupGender;
    private ProgressBar progressBar;
    private Button btnSubmit;
    private int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        progressBar = findViewById(R.id.progressBar);
        btnSubmit = findViewById(R.id.btnSubmit);


        etName.addTextChangedListener(new SimpleTextWatcher(() -> updateProgress()));
        etEmail.addTextChangedListener(new SimpleTextWatcher(() -> updateProgress()));
        etPhone.addTextChangedListener(new SimpleTextWatcher(() -> updateProgress()));

        radioGroupGender.setOnCheckedChangeListener((group, checkedId) -> updateProgress());


        btnSubmit.setOnClickListener(v -> {

        });
    }


    private void updateProgress() {
        int filledFields = 0;


        if (!etName.getText().toString().trim().isEmpty()) filledFields++;
        if (!etEmail.getText().toString().trim().isEmpty()) filledFields++;
        if (!etPhone.getText().toString().trim().isEmpty()) filledFields++;
        if (radioGroupGender.getCheckedRadioButtonId() != -1) filledFields++;

        progress = (filledFields * 100) / 4;
        progressBar.setProgress(progress);
    }


    private static class SimpleTextWatcher implements android.text.TextWatcher {
        private final Runnable onTextChanged;

        public SimpleTextWatcher(Runnable onTextChanged) {
            this.onTextChanged = onTextChanged;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            onTextChanged.run();
        }

        @Override
        public void afterTextChanged(android.text.Editable editable) {}
    }
}
