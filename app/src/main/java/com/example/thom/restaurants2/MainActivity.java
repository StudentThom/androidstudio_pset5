package com.example.thom.restaurants2;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.actions, menu);
            return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                //case R.id.place_order:
            //todo
            }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("test", "test");

        FragmentManager fm = getSupportFragmentManager();
        Log.d(" manager", fm.toString());
        CategoryFragment fragment = new CategoryFragment();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_container, fragment, "categories");
        ft.commit();

        Log.d("test", "test2");

        // not sure whether this is in the  right place:
        FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
        OrderFragment fragment2 = new OrderFragment();
        fragment2.show(ft2, "dialog");

        final RestoDatabase db = RestoDatabase.getInstance(getApplicationContext());
        TextView textView = findViewById(R.id.textView1);
        textView.setText(db.toString());
        Log.d("db", db.toString());


    }

    public void showDialog(View view) {
        FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
        OrderFragment fragment2 = new OrderFragment();
        fragment2.show(ft2, "dialog");
    }
}
