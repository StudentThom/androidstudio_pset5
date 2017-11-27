package com.example.thom.restaurants2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class categories extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false);

        final ArrayList<String> myArrayAppetizers = new ArrayList<>();
        final ArrayAdapter<String> adapterAppetizers =
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        myArrayAppetizers);
        //this.setListAdapter(someAdapter);


    }

}
