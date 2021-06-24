package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Checkout extends AppCompatActivity {
    ImageView backg;
    TextView n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        backg = findViewById(R.id.bgapp);
        n=findViewById(R.id.textView);

        backg.animate().translationY(-1900).setDuration(300).setStartDelay(100);
        n.animate().alpha(1).setDuration(800).setStartDelay(900);


    }

    public void tocart(View view)
    {
        Intent t = new Intent(this,shopCart.class);
        startActivity(t);
        finish();
    }

    public void back(View view)
    {
        Intent t = new Intent(this,shopList.class);
        startActivity(t);
        finish();
    }

}


