package com.example.thom.restaurants2;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends DialogFragment implements View.OnClickListener  {

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

        View inflated = inflater.inflate(R.layout.fragment_order, container, false);
        Button cancelButton = (Button) inflated.findViewById(R.id.buttonCancel);
        cancelButton.setOnClickListener(this);

        Button PlaceOrderButton = (Button) inflated.findViewById(R.id.buttonPlaceOrder);
        PlaceOrderButton.setOnClickListener(this);


        return inflater.inflate(R.layout.fragment_order, container, false);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.buttonPlaceOrder:
                TextView textView = view.findViewById(R.id.textViewOrder);
                textView.setText("order is placed");
                Log.d("order status: ", "placed");
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    // get all items from the database and link an OrderAdapter to the list view
        RestoDatabase db = RestoDatabase.getInstance(getActivity().getApplicationContext());
        Cursor cursor = db.selectAll();
        RestoAdapter restoAdapter = new RestoAdapter(getActivity().getApplicationContext(), R.layout.row_orders, cursor, 1);


        final ListView listView = getView().findViewById(R.id.listOrder);

        listView.setAdapter(restoAdapter);


    }

}
