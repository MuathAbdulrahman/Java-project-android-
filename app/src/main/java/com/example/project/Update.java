package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Update extends AppCompatActivity {


    private EditText etID,quu;
    private TextView naTxtView,phTxtView,qu;
    private DatabaseHelper dbHandler;
    SQLiteDatabase database;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        etID = (EditText)findViewById(R.id.idInp);
        quu = (EditText)findViewById(R.id.bunq);
        naTxtView = (TextView)findViewById(R.id.naTxtView);
        phTxtView = (TextView)findViewById(R.id.phTxtView);
        qu = (TextView)findViewById(R.id.qu);
        //dbHandler = new MyDBHandler(this);
        dbHandler = new DatabaseHelper(getApplicationContext());
        database = dbHandler.getWritableDatabase();
        dbManager = new DBManager(this);
        dbManager.open();


    }


    public void shwIDInfo(View V){
        String id =  etID.getText().toString();
        if(id.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please, fill-in missing data",Toast.LENGTH_LONG).show();
            return;
        }
        String sqltStmt = "Select * from " + DatabaseHelper.TABLE_NAME
                + " where " + DatabaseHelper._ID + " = ?";
        Cursor c = database.rawQuery(sqltStmt, new String[] {id});
        if(!c.moveToFirst()){
            Toast.makeText(getApplicationContext(),"No ID has matched",Toast.LENGTH_LONG).show();
            return;
        };
        naTxtView.setText(c.getString(1));
        phTxtView.setText(c.getString(2));
        qu.setText(c.getString(3));
        c.close();
    }


    public void delTsk(View view){
        String id =  etID.getText().toString();
        String qun =  quu.getText().toString();
        String nam = naTxtView.getText().toString();


        if(id.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please, fill-in missing data", Toast.LENGTH_LONG).show();
            return;
        }
        //The remaining code is left as homework

        // database.execSQL("DELETE FROM "+ DatabaseHelper.TABLE_NAME + " Where "+ DatabaseHelper._ID +" = ? ", new String[] {id});
        // database.execSQL("DELETE FROM "+ dbHandler.TABLE_NAME + " Where "+ dbHandler.COLUMN_RECID +"= " + id );



        dbManager.update(id,nam,qun);

    }


    public void backTo(View view){
        Intent t = new Intent(this,shopCart.class);
        startActivity(t);
        dbHandler.close();
        finish();
    }}