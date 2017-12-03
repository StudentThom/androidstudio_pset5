package com.example.thom.restaurants2;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends DialogFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        final RestoDatabase db = RestoDatabase.getInstance(getApplicationContext());
//        Cursor cursor = db.selectAll();
//        RestoAdapter RestoAdapter = new RestoAdapter(getApplicationContext(), cursor);
//

//        //final ListView listView = findViewById(R.id.listView);
//
//        setListAdapter(RestoAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    // get all items from the database and link an OrderAdapter to the list view
        RestoDatabase db = RestoDatabase.getInstance(getContext());
        Cursor cursor = db.selectAll();
        RestoAdapter RestoAdapter = new RestoAdapter(getContext(), cursor);


        final ListView listView = getView().findViewById(R.id.listOrder);

        listView.seAdapter(RestoAdapter);


    }

}
