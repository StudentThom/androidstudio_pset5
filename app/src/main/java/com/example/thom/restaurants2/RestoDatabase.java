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


        sqLiteDatabase.execSQL("create table restos (_id INTEGER, name TEXT, amount INT, price FLOAT);");

        // test data
        sqLiteDatabase.execSQL("INSERT INTO restos (_id, name, amount, price) VALUES ('1', 'test1', '2','3');");
        sqLiteDatabase.execSQL("INSERT INTO restos (_id, name, amount, price) VALUES ('50', 'test2', 39, 12);");



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

    public void AddItem(int id, String name, int amount, float price) {

        SQLiteDatabase db = this.getWritableDatabase();

        // check whether item is already in database
        Log.d("name in additem", name);
        //name = "test1";
        String select = "SELECT * FROM restos WHERE _id = ?;";
        //String select = "SELECT * FROM restos";
        Cursor cursor = db.rawQuery(select,new String[]{ Integer.toString(id) });
        Log.d("cursor",cursor.toString());
        Log.d("cursor count",Integer.toString(cursor.getCount()));
        cursor.moveToFirst();
        Log.d("cursor count",Integer.toString(cursor.getCount()));
        if (cursor.getCount() > 0){
            db.execSQL("UPDATE restos SET amount = amount + 1 WHERE _id = '" + id + "';");
            db.execSQL("UPDATE restos SET price = price + '" + price + "' WHERE _id = '" + id + "';");
        }
        else {
            db.execSQL("INSERT INTO restos (_id, name, amount, price) VALUES ( '" + id + "', '" + name + " ', '" + amount + "', '" + price + "');" );
        }
        //String nameFromDb = cursor.getString(cursor.getColumnIndex("name"));
       // Log.d("nameFromDb", nameFromDb);

    }


    public Cursor selectAll() {
        ;
        //Cursor cursor = getWritableDatabase().rawQuery("SELECT * FROM todos");
        // ref: https://stackoverflow.com/questions/20836968/rawquery-in-android
        SQLiteDatabase db = this.getReadableDatabase();
        String categoryID = "1";
        Log.d("db in selectall",db.toString());
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
        //String select = "SELECT * FROM restos";
        Cursor cursor = db.rawQuery(select,new String[]{});
        //Cursor cursor = null;
        //cursor.moveToFirst();
        Log.d("msg", "na cursor selectSingle");

        return cursor;


    }

    public void deleteAll() {

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM restos");

    }

}
