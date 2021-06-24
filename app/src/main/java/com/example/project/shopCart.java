package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class shopCart extends AppCompatActivity {
    private DBManager dbManager;
    private SQLiteDatabase db;
    private DatabaseHelper dbHandler;


    TextView user2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_cart);

        Intent t = getIntent();
        String user1 = t.getStringExtra("user");
        user2 =findViewById(R.id.user);
        user2.setText(user1);

        dbManager = new DBManager(this);
        dbManager.open();
        dbHandler = new DatabaseHelper(getApplicationContext());
        db = dbHandler.getWritableDatabase();

        ImageView b =findViewById(R.id.bgapp);
        b.animate().translationY(-1900).setDuration(300).setStartDelay(100);




        ListView listView = (ListView) findViewById(R.id.listview);

        //populate an ArrayList<String> from the database and then view it
        final ArrayList<String> theList = new ArrayList<>();
        Cursor data = dbHandler.getListContents();

        if(data.getCount() == 0){

        }
        else{
            while(data.moveToNext()){
                theList.add(data.getString(1));
                theList.add(data.getString(2));
                theList.add(data.getString(3));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,theList);
                listView.setAdapter(listAdapter);



            }
        }



    }


    public void how(View view)
    {
        String query = "SELECT * FROM " + DatabaseHelper.TABLE_NAME;
        String dbData = " ";
//Cursor point to a location in your result
        Cursor c = db.rawQuery(query, null);
//Move to first row in your result
        c.moveToFirst();
//Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            dbData += c.getString(c.getColumnIndex(DatabaseHelper._ID));
            dbData += " | " + c.getString(c.getColumnIndex(DatabaseHelper.ITEM));
            dbData += " | " + c.getString(c.getColumnIndex(DatabaseHelper.PRICE));
            dbData += " | " + c.getString(c.getColumnIndex(DatabaseHelper.Quantity));
            dbData += "\n";
            c.moveToNext();
        }
        c.close();
        Toast.makeText(getApplicationContext(),dbData, Toast.LENGTH_LONG).show();
    }

    public void toUp(View view)
    {
        Intent t = new Intent(this,Update.class);
        startActivity(t);
        finish();
    }


    public void check(View view)
    {
        Cursor data = dbHandler.getListContents();

        if(data.getCount() == 0){
            Toast.makeText(this, "There are no contents in this list!",Toast.LENGTH_LONG).show();
            return;
        }
        Intent t = new Intent(this,Checkout.class);
        startActivity(t);
        finish();

       dbHandler.Delete();
    }


    public void toList(View view)
    {
        Intent t = new Intent(this,shopList.class);
        startActivity(t);
        finish();
    }
}
