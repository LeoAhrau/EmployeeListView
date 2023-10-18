package com.example.employeelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userNameInput;
    EditText userAgeInput;
    EditText userSalaryInput;

    Spinner genderSpinner;

    DataManager dataManager = new DataManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameInput = findViewById(R.id.et_name);
        userAgeInput = findViewById(R.id.et_age);
        userSalaryInput = findViewById(R.id.et_salary);
        genderSpinner = findViewById(R.id.gender_spinner);

        Button loginButton = findViewById(R.id.btn_login);
        Button registerButton = findViewById(R.id.btn_register);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gender_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(adapter);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!areInputsValid()) {
                    return;
                }

                String name = userNameInput.getText().toString();
                String age = userAgeInput.getText().toString();
                String gender = genderSpinner.getSelectedItem().toString();
                String salary = userSalaryInput.getText().toString();

                dataManager.createUser(name, age, gender, salary);
                Toast.makeText(MainActivity.this, R.string.employee_added, Toast.LENGTH_SHORT).show();

                userNameInput.setText("");
                userSalaryInput.setText("");
                userAgeInput.setText("");
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UsersActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean areInputsValid() {
        if (userNameInput.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please input a name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (userAgeInput.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please input an age", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (userSalaryInput.getText().toString().isEmpty()){
            Toast.makeText(this, "Please input a salary", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}