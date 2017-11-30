package com.example.thom.restaurants2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
        sqLiteDatabase.execSQL("create table restos (_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, completed BIT);");

        // test data
        sqLiteDatabase.execSQL("INSERT INTO restos (title, completed) VALUES ('test', 0);");
        sqLiteDatabase.execSQL("INSERT INTO restos (title, completed) VALUES ('test2', 1);");
        sqLiteDatabase.execSQL("INSERT INTO restos (title, completed) VALUES ('test3', 0);");

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
}
