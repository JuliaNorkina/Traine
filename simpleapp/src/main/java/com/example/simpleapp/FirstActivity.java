package com.example.simpleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvInfo;
    Button bEnterData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);

        tvInfo = findViewById(R.id.tvInfo);
        bEnterData = findViewById(R.id.bEnterData);

        bEnterData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) return;
        String string = "FIO: " + data.getStringExtra("fio") + ", age: " + data.getStringExtra("age");
        tvInfo.setText(string);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
