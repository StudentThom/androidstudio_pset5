package com.example.thom.restaurants2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends ListFragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = this.getArguments();

        /*
 Volley things, using ref:
 https://apps.mprog.nl/android/volley
 https://stackoverflow.com/questions/17037340/converting-jsonarray-to-arraylist
*/
// Instantiate the RequestQueue.

        Log.d(" oncreate", "test");

        final String whatDish = "entrees";

        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url ="https://resto.mprog.nl/menu";

        final List<String> myArray = new ArrayList<>();

        final ArrayList<String> myArray2 = new ArrayList<>();
        final ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_1,
                        myArray);

        final ArrayList<String> myArrayEntrees = new ArrayList<>();
        final ArrayAdapter<String> adapterEntrees =
                new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_1,
                        myArrayEntrees);

        final ArrayList<String> myArrayAppetizers = new ArrayList<>();
        final ArrayAdapter<String> adapterAppetizers =
                new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_1,
                        myArrayAppetizers);


// Request a string response from the provided URL.
        JsonObjectRequest jsObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Display the first 500 characters of the response string.
                        //mTextView.setText("Response is: "+ response.toString());
                        //getJSONArray().getJSONObject(); ref: https://stackoverflow.com/questions/32624166/how-to-get-json-array-within-json-object
                        JSONArray jsonArray = new JSONArray();
                        try {
                            jsonArray = response.getJSONArray("items");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        if (jsonArray != null) {
                            for (int i = 0; i < jsonArray.length(); i++) {
                                try {
//                                    if (jsonArray.getJSONObject(i).getJSONArray("category") == "entrees") {
//                                        Log.d("string", "hoi what dish");
//                                    }
                                    Log.d("String", jsonArray.getJSONObject(i).getString("category"));
                                    if (jsonArray.getJSONObject(i).getString("category").equals("entrees")){
                                        //Log.d("String","TRUE TRUE TRUE");
                                        myArrayEntrees.add(jsonArray.getJSONObject(i).getString("name"));
                                        //myArrayEntrees.add(jsonArray.getJSONObject(i).getString("price"));
                                    }
                                    if (jsonArray.getJSONObject(i).getString("category").equals("appetizers")){
                                        myArrayAppetizers.add(jsonArray.getJSONObject(i).getString("name"));
                                    }
                                    myArray.add(jsonArray.getJSONObject(i).getString("name"));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }



                        if (whatDish.equals("entrees")){
                            setListAdapter(adapterEntrees);
                        }
                        if (whatDish.equals("appetizers")){
                            setListAdapter(adapterAppetizers);
                        }
                        //list.setAdapter(adapter);

                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        //mTextView.setText("That didn't work!");
                    }
                });
// Add the request to the RequestQueue.
        //MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);
        queue.add(jsObjectRequest);
        //this.setListAdapter(adapter);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

}
