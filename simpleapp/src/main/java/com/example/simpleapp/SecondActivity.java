package com.example.simpleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etFio, etAge;
    Button bOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        etFio = findViewById(R.id.etFio);
        etAge = findViewById(R.id.etAge);
        bOk = findViewById(R.id.bOk);

        bOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("fio", etFio.getText().toString());
        intent.putExtra("age", etAge.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
