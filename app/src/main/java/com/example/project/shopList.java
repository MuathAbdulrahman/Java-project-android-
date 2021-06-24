package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class shopList extends AppCompatActivity implements View.OnClickListener {
    //Define elements
    private DBManager dbManager;
    private SQLiteDatabase db;
    private DatabaseHelper dbHandler;

    TextView user2;
    LinearLayout items,cartI;
    ImageView apple,salad,lemon,fish,steak,food,can,milk,water,cart,backg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);
        dbManager = new DBManager(this);
        dbManager.open();
        dbHandler = new DatabaseHelper(getApplicationContext());
        db = dbHandler.getWritableDatabase();
        //Define the source id

        backg = findViewById(R.id.bgapp);
        cartI = findViewById(R.id.linearLayout_cart);
        cart =findViewById(R.id.tocart);
        items = findViewById(R.id.items);
        apple = findViewById(R.id.apple);
        salad = findViewById(R.id.salad);
        lemon = findViewById(R.id.lemon);
        fish = findViewById(R.id.fish);
        steak = findViewById(R.id.steak);
        food = findViewById(R.id.food);
        can = findViewById(R.id.can);
        milk = findViewById(R.id.milk);
        water = findViewById(R.id.water);

        //animation
        backg.animate().translationY(-1900).setDuration(300).setStartDelay(100);
        items.animate().alpha(1).setDuration(300).setStartDelay(120);
        cartI.animate().alpha(1).setDuration(300).setStartDelay(120);

        //get the user name from Main_Activity
        Intent t = getIntent();
        String user1 = t.getStringExtra("user");
        user2 =findViewById(R.id.user);
        user2.setText(user1);



        //For one Click method
        cart.setOnClickListener(this);
        apple.setOnClickListener(this);
        salad.setOnClickListener(this);
        lemon.setOnClickListener(this);
        fish.setOnClickListener(this);
        steak.setOnClickListener(this);
        food.setOnClickListener(this);
        can.setOnClickListener(this);
        milk.setOnClickListener(this);
        water.setOnClickListener(this);



    }



    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    int count4 = 0;
    int count5 = 0;
    int count6 = 0;
    int count7 = 0;
    int count8 = 0;
    int count9 = 0;
    @Override
    public void onClick(View v) {


        switch (v.getId())
        {

            case R.id.tocart:

                Intent t = new Intent(this,shopCart.class);
                startActivity(t);
                finish();
                break;

            case R.id.apple:

                String name = "Apple";
                String price = "2$";
                String q = "1";
                if (count1 == 0){

                    dbManager.insert(name,price,q);
                    apple.setBackgroundColor(0xFF00FF00);
                    count1++;

                }
                else
                    Toast.makeText(getApplicationContext(),"Add more in the cart", Toast.LENGTH_LONG).show();

                break;

            case R.id.salad:

                  name = "salad";
                  price = "10$";
                  q = "1";

                if (count2 == 0){

                    dbManager.insert(name,price,q);
                    salad.setBackgroundColor(0xFF00FF00);
                    count2++;

                }
                else
                    Toast.makeText(getApplicationContext(),"Add more in the cart", Toast.LENGTH_LONG).show();

                break;

            case R.id.lemon:

                  name = "lemon";
                  price = "10$";
                  q = "1";
                if (count3 == 0){

                    dbManager.insert(name,price,q);
                    lemon.setBackgroundColor(0xFF00FF00);
                    count3++;

                }
                else
                    Toast.makeText(getApplicationContext(),"Add more in the cart", Toast.LENGTH_LONG).show();

                break;

            case R.id.fish:

                  name = "fish";
                  price = "50$";
                  q = "1";
                if (count4 == 0){

                    dbManager.insert(name,price,q);
                    fish.setBackgroundColor(0xFF00FF00);
                    count4++;

                }
                else
                    Toast.makeText(getApplicationContext(),"Add more in the cart", Toast.LENGTH_LONG).show();

                break;


            case R.id.steak:


                  name = "steak";
                  price = "40$";
                  q = "1";
                if (count5 == 0){

                    dbManager.insert(name,price,q);
                    steak.setBackgroundColor(0xFF00FF00);
                    count5++;

                }
                else
                    Toast.makeText(getApplicationContext(),"Add more in the cart", Toast.LENGTH_LONG).show();

                break;

            case R.id.food:

                  name = "food";
                  price = "10$";
                  q = "1";
                if (count6 == 0){

                    dbManager.insert(name,price,q);
                    food.setBackgroundColor(0xFF00FF00);
                    count6++;

                }
                else
                    Toast.makeText(getApplicationContext(),"Add more in the cart", Toast.LENGTH_LONG).show();


                break;

            case R.id.can:

                  name = "can";
                  price = "5$";
                  q = "1";
                if (count7 == 0){

                    dbManager.insert(name,price,q);
                    can.setBackgroundColor(0xFF00FF00);
                    count7++;


                }
                else
                    Toast.makeText(getApplicationContext(),"Add more in the cart", Toast.LENGTH_LONG).show();

                break;

            case R.id.milk:

                  name = "milk";
                  price = "3$";
                  q = "1";
                if (count8 == 0){

                    dbManager.insert(name,price,q);
                    milk.setBackgroundColor(0xFF00FF00);
                    count8++;

                }
                else
                    Toast.makeText(getApplicationContext(),"Add more in the cart", Toast.LENGTH_LONG).show();

                break;

            case R.id.water:

                  name = "water";
                  price = "1$";
                  q = "1";
                if (count9 == 0){

                    dbManager.insert(name,price,q);
                    water.setBackgroundColor(0xFF00FF00);
                    count9++;

                }
                else {
                    Toast.makeText(getApplicationContext(), "Add more in the cart", Toast.LENGTH_LONG).show();

                }
                break;


        }

    }
}
