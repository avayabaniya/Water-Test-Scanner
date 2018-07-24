package com.example.admin.drinkingwater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class notDrinkable extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_drinkable);


        Intent i = getIntent();
        TextView txtM1 = findViewById(R.id.txtM1);
        TextView txtM2 = findViewById(R.id.txtM2);
        String message1 = i.getStringExtra("m1");
        String message2 = i.getStringExtra("m2");
        txtM1.setText(message1);
        txtM2.setText(message2);


    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        startActivity(new Intent(notDrinkable.this, MainActivity.class));
    }
}
