package com.example.simpleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etFio, etAge, etCash;
    Button bSave, bOk;
    ArrayList<Customer> customers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        etFio = findViewById(R.id.etFio);
        etAge = findViewById(R.id.etAge);
        etCash = findViewById(R.id.etCash);
        bSave = findViewById(R.id.bSave);
        bOk = findViewById(R.id.bOk);

        bSave.setOnClickListener(this);
        bOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bSave:
                if (etFio != null && etAge != null && etCash != null) {
                    //TODO
                   Customer customer = new Customer(etFio.getText().toString(),Integer.parseInt(etAge.getText().toString()),Integer.parseInt(etCash.getText().toString()));
                   customers.add(customer);
                   etFio.setText("");
                   etAge.setText("");
                   etCash.setText("");
                }
                break;
            case R.id.bOk:
                Intent intent = new Intent();
                intent.putParcelableArrayListExtra("Customers data", customers);
                setResult(RESULT_OK, intent);
                finish();
        }
    }
}