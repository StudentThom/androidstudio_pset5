package com.example.thom.restaurants2;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class categories extends ListFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // inflater
        View inflaterCategories = inflater.inflate(R.layout.fragment_categories, container, false);

        final TextView mTextView = getListView().findViewById(R.id.textView1);


/*
 Volley things, using ref:
 https://apps.mprog.nl/android/volley
 https://stackoverflow.com/questions/17037340/converting-jsonarray-to-arraylist
*/
// Instantiate the RequestQueue.

        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url ="https://resto.mprog.nl/categories";

        final ArrayList<String> myArray = new ArrayList<>();


// Request a string response from the provided URL.
        JsonObjectRequest jsObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    private ArrayAdapter<String> adapter;

                    public void setAdapter(ArrayAdapter<String> adapter) {
                        this.adapter = adapter;
                    }

                    @Override
                    public void onResponse(JSONObject response) {
                        // Display the first 500 characters of the response string.
                        mTextView.setText("Response is: " + response.toString());
                        //getJSONArray().getJSONObject(); ref: https://stackoverflow.com/questions/32624166/how-to-get-json-array-within-json-object
                        JSONArray jsonArray = new JSONArray();
                        try {
                            jsonArray = response.getJSONArray("categories");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        if (jsonArray != null) {
                            for (int i = 0; i < jsonArray.length(); i++) {
                                try {
                                    myArray.add(jsonArray.getString(i));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }


                        //ListView list = (ListView) findViewById(R.id.list);
                        setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mTextView.setText("That didn't work!");
                    }
                });
// Add the request to the RequestQueue.
        //MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);
        queue.add(jsObjectRequest);


//
        //Button b = (Button) findViewById(R.id.button3);
        //b.setOnClickListener(new GoButtonClickListener());

        //Item item = (Item) findViewById(R.id.item)
        //ClipData.Item item = myArray(1);
        //setOnItemClickListener(AdapterView.OnItemClickListener)

// ref: https://stackoverflow.com/questions/2468100/how-to-handle-listview-click-in-android
        //setAdapter(adapter);




// Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false);
    }

}
