package com.example.b10709043_hw2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.EditText;

import com.example.b10709043_hw2.myDbUtil.MyDbContact;
import com.example.b10709043_hw2.myDbUtil.MyDbHelper;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    SQLiteDatabase myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        MyDbHelper myDbHelper = new MyDbHelper(this);
        myDb = myDbHelper.getWritableDatabase();
        MyAdapter myAdapter = new MyAdapter(this,getGuest());
        rv.setAdapter(myAdapter);




    }
    private Cursor getGuest(){
        return myDb.query(MyDbContact.WaitList.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                MyDbContact.WaitList.COLUMN_TIMESTAMP);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
}
