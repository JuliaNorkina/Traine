package com.example.simpleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvInfo;
    Button bEnterData;
    ArrayList<Customer> customers = new ArrayList<>();

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
        customers = data.getParcelableArrayListExtra("Customers data");
        tvInfo.setText(customers.toString().replace("[","").replace("]","").replace(",",""));
        super.onActivityResult(requestCode, resultCode, data);
    }
}
