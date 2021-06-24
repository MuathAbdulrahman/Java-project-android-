package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ImageView bgapp, clover;
    LinearLayout linearLayout,linearLayout3,linearLayout_shop;
    Animation frombottom;
    TextView usernamee;
    EditText usr ;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usr = findViewById(R.id.name);



        linearLayout3=findViewById(R.id.linearLayout3);
        linearLayout = findViewById(R.id.linearLayout);
        linearLayout_shop=findViewById(R.id.linearLayout_shop);


        linearLayout_shop.setVisibility(View.GONE);



    }

        public void usrLogIn(View V)
        {
            String user = usr.getText().toString();

            frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottton);
            usernamee = findViewById(R.id.user);




            if (user.trim().equals(""))
            {
                Toast.makeText(getApplicationContext(),"Enter a Name",Toast.LENGTH_LONG).show();
                return;
            }

                else
                    {
            Toast.makeText(getApplicationContext(),user+", Loged in successfully",Toast.LENGTH_LONG).show();
            usernamee.setText(user);
                    }





            bgapp =  findViewById(R.id.bgapp);
            clover =  findViewById(R.id.clover);

            linearLayout.animate().translationY(1200).alpha(0).setDuration(800).setStartDelay(300);
            bgapp.animate().translationY(-1900).setDuration(800).setStartDelay(600);
            clover.animate().alpha(0).setDuration(800).setStartDelay(900);



            ViewCompat.setElevation(linearLayout3, 7);



            linearLayout3.startAnimation(frombottom);

            linearLayout_shop.startAnimation(frombottom);


            linearLayout_shop.setVisibility(View.VISIBLE);


        }



        public void shop(View view)
        {
            String user = usr.getText().toString();
            Intent t = new Intent(this,shopList.class);
            t.putExtra("user", user);
            startActivity(t);
            finish();
        }






}









