package com.example.dbdatainsertapp;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.dbdatainsertapp.task.BackgroundTask;

public class RegisterActivity extends AppCompatActivity {

    EditText etName, etPassword, etContact, etCountry;
    String name, password, contact, country;

    public static final String TAG = "RActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.etNameId);
        etPassword = findViewById(R.id.etPasswordID);
        etContact = findViewById(R.id.etContactID);
        etCountry = findViewById(R.id.etCountryId);


    }

    public void registerUser(View view) {

        name = etName.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        contact = etContact.getText().toString().trim();
        country = etCountry.getText().toString().trim();

        Log.e(TAG,"before register");

        String method = "register";

        BackgroundTask backgroundTask = new BackgroundTask(this);


        backgroundTask.execute(method,name,password,contact,country);

        finish();


    }
}
