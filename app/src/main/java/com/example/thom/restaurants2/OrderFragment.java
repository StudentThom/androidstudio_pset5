package com.example.thom.restaurants2;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends DialogFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final RestoDatabase db = RestoDatabase.getInstance(getApplicationContext());
        Cursor cursor = db.selectAll();
        RestoAdapter RestoAdapter = new RestoAdapter(getApplicationContext(), cursor);

        //final ListView listView = findViewById(R.id.listView);

        setAdapter(RestoAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

}
