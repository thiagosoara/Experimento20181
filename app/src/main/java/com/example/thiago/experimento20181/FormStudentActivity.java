package com.example.thiago.experimento20181;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_student);

        final TextInputEditText etName = (TextInputEditText) findViewById(R.id.et_name);
        final TextInputEditText etEmail = (TextInputEditText) findViewById(R.id.et_email);
        final TextInputEditText etPhone = (TextInputEditText) findViewById(R.id.et_phone);

        Button btSave = (Button)findViewById(R.id.bt_save);

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student();
                student.setName(etName.getText().toString());
                student.setEmail(etEmail.getText().toString());
                student.setPhone(etPhone.getText().toString());
                Intent it = getIntent();
                it.putExtra("student",student);
                setResult(RESULT_OK, it);
                finish();
            }
        });
    }
}
