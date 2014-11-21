package com.vijayarunkumar.anupama.androidappautomationwithappium;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by anupama on 21/11/14.
 */
public class DisplayListView extends Activity{

    @InjectView(R.id.list) ListView mlistView;
//    ListView mlistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        ButterKnife.inject(this);

//        mlistView = (ListView)findViewById(R.id.list);
        //Define Array values to show in ListView
        String[] values = new String[]
               {
                "Android List View",
                "Adapter implementation",
                "Simple List View in Android",
                "Create List View in Android",
                "Android Example",
                "List View Source code",
                "List View Array Adapter",
                "Android Example List View"
               };

        // Define adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                                       android.R.layout.simple_list_item_1,
                                       android.R.id.text1,
                                       values);
        mlistView.setAdapter(adapter);

        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //ListView clicked item index
                int itemPosition = position;

                //ListView clicked item value
                String itemValue = (String) mlistView.getItemAtPosition(itemPosition);

                //Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+ " ListItem :"+itemValue,Toast.LENGTH_LONG)
                        .show();
            }
        });

//        final ArrayList<String> list = new ArrayList<String>();
//        for(int i=0; i < values.length; i++){
//            list.add(values[i]);
//        }
//        final StableArrayAdapter adapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1,list);
//        mlistView.setAdapter(adapter);
//
//    }
//
//
//    private class StableArrayAdapter extends ArrayAdapter<String> {
//
//        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();
//        public StableArrayAdapter(Context context, int textViewResourceId, String[] objects) {
//            super(context, textViewResourceId, objects);
//        }
//    }
    }
}
