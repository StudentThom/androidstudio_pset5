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
    public RestoAdapter(Context context, int layout, Cursor cursor, int flags){
        // TO DO
        super(context, R.layout.row_orders, cursor);

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        //cursor.moveToFirst();
        // get id
        String Id = cursor.getString(cursor.getColumnIndex("_id"));
        Log.d("ID", Id);

        // get name
        String name = "name";
        int columnIndex = cursor.getColumnIndex(name);
        String columnName = cursor.getString(columnIndex);
        Log.d("string column name", columnName);

        // get amount
        String amount = cursor.getString(cursor.getColumnIndex("amount"));
        Log.d("amount", amount);


        // get price
        int columnIndexPrice = cursor.getColumnIndex("price");
        String price = cursor.getString(columnIndexPrice);
        Log.d("completed", price);

        // put values in textviews

        TextView textViewId = view.findViewById(R.id.textViewId);
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewAmount = view.findViewById(R.id.textViewAmount);
        TextView textViewPrice = view.findViewById(R.id.textViewPrice);
        textViewId.setText(Id);
        textViewName.setText(columnName);
        textViewPrice.setText("€" + price);
        textViewAmount.setText(amount);

        //TextView textView = listview.findViewById(R.id.textViewRowToDo);
        //textView.setText(column_value);

        //TextView textViewRowToDoId = listview.findViewById(R.id.textViewRowToDoId);
        //textViewRowToDoId.setText(column_id);
    }
}
