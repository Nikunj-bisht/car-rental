package com.animesafar.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.animesafar.carrental.authpack.Authactivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.button:

                startActivity(new Intent(this, Authactivity.class));
    break;

        }


    }
}