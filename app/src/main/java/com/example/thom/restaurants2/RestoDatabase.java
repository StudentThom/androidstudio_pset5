package com.example.thom.restaurants2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by thom on 30/11/17.
 */

public class RestoDatabase extends SQLiteOpenHelper {
    private RestoDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static RestoDatabase instance;

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table restos (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, amount INT, price FLOAT);");

        // test data
        sqLiteDatabase.execSQL("INSERT INTO restos (name, amount, price) VALUES ('test1', '2','3');");
        sqLiteDatabase.execSQL("INSERT INTO restos (name, amount, price) VALUES ('test2', 39, 12);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "restos");
        onCreate(sqLiteDatabase);

    }

    public static RestoDatabase getInstance(Context applicationContext) {
        if (instance == null) {
            // cal the private constructor
            String name = null;
            SQLiteDatabase.CursorFactory factory = null;
            int version = 1;
            instance = new RestoDatabase(applicationContext, "restos", factory, version);

//            instance = ToDoDatabase(Context applicationContext, String name, SQLiteDatabase.CursorFactory factory, int version) {
//                super(context, name, factory, version);
//        }


        }

        // calling insert() here?


        return instance;
    }

    public void AddItem(String name, int amount, float price) {

        SQLiteDatabase db = this.getWritableDatabase();
        // check whether item is already in database
        String select = "SELECT * FROM restos WHERE name = '" + name + "';";
        //String select = "SELECT * FROM restos";
        Cursor cursor = db.rawQuery(select,new String[]{});
        Log.d("cursor",cursor.toString());
       // String nameFromDb = cursor.getString(cursor.getColumnIndex("name"));
       // Log.d("nameFromDb", nameFromDb);
        //db.execSQL("INSERT INTO restos (name, amount, price) VALUES ( '" + name + " ', '" + amount + "', '" + price + "');" );
    }


    public Cursor selectAll() {
        ;
        //Cursor cursor = getWritableDatabase().rawQuery("SELECT * FROM todos");
        // ref: https://stackoverflow.com/questions/20836968/rawquery-in-android
        SQLiteDatabase db = this.getReadableDatabase();
        String categoryID = "1";
        Log.d("db",db.toString());
//        String select = "SELECT category_id FROM tblProduct WHERE category_id="+categoryID;
        String select = "SELECT * FROM restos";
        Cursor cursor = db.rawQuery(select,new String[]{});
        //Cursor cursor = null;
        //cursor.moveToFirst();

        return cursor;


    }

    public Cursor selectSingle(String name) {
        ;
        //Cursor cursor = getWritableDatabase().rawQuery("SELECT * FROM todos");
        // ref: https://stackoverflow.com/questions/20836968/rawquery-in-android
        SQLiteDatabase db = this.getReadableDatabase();
        String categoryID = "1";
        Log.d("db",db.toString());
//        String select = "SELECT category_id FROM tblProduct WHERE category_id="+categoryID;
        String select = "SELECT * FROM restos WHERE name = '" + name + "';";
        Cursor cursor = db.rawQuery(select,new String[]{});
        //Cursor cursor = null;
        //cursor.moveToFirst();

        return cursor;


    }

}
