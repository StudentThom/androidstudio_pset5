package com.example.thom.restaurants2;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

/**
 * Created by thom on 01/12/17.
 */

public class RestoAdapter extends ResourceCursorAdapter {
    public RestoAdapter(Context context, Cursor cursor){
        // TO DO
        super(context, R.layout.fragment_order, cursor);

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        cursor.moveToFirst();
        String name = "name";
        int columnIndex = cursor.getColumnIndex(name);
        String column_value = cursor.getString(columnIndex);
        Log.d("string column value", column_value);

        // get id
        String column_id = cursor.getString(cursor.getColumnIndex("_id"));
        // get boolean
        int columnIndexCompleted = cursor.getColumnIndex("completed");
        String completedValue = cursor.getString(columnIndexCompleted);
        Log.d("completed", completedValue);

        //TextView textView = listview.findViewById(R.id.textViewRowToDo);
        //textView.setText(column_value);

        //TextView textViewRowToDoId = listview.findViewById(R.id.textViewRowToDoId);
        //textViewRowToDoId.setText(column_id);
    }
}
