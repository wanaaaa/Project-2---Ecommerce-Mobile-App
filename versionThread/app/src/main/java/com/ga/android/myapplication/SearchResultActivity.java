package com.ga.android.myapplication;

import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchResultActivity extends AppCompatActivity {
    private static final String TAG = "SearchResultActivity///";
    ProgressBar mProgressBar;

    RecyclerView mRecyclerView;
    AsyncTask<Integer, Integer, ArrayList<DaIndiItem>> task;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        mRecyclerView = (RecyclerView) findViewById(R.id.searchRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        if (Intent.ACTION_SEARCH.equals(getIntent().getAction())) {

//            String query = getIntent().getStringExtra(SearchManager.QUERY);
//            Cursor cursor = SQhelper.getInstance(this).serachTitle(query) ;
//
//            ArrayList<DaIndiItem> arrayList = new ArrayList<>();
//
//            cursor.moveToFirst();
//            while (cursor.isAfterLast()==false) {
//                String itemTitle = cursor.getString(cursor.getColumnIndex(SQhelper.DataEntryItem
//                        .COLUMN_TITLE));
//                String itemPrice = cursor.getString(cursor.getColumnIndex(SQhelper.DataEntryItem
//                        .COLUMN_PRICE));
//                int intItemPrice = Integer.parseInt(itemPrice);
//                DaIndiItem itemDetail = new DaIndiItem();
//                itemDetail.setIteTitle(itemTitle);
//                itemDetail.setItePrice(intItemPrice);
//                Log.d(TAG, String.valueOf(itemDetail));
//                arrayList.add(itemDetail);
//                cursor.moveToNext();
//            }
//
//            if (arrayList.size() == 0) {
//                Toast.makeText(SearchResultActivity.this, "this is my Toast message!!! =)",
//                        Toast.LENGTH_LONG).show();
//            }

            //////////////////////////////////////////////////////////////
            ArrayList<DaIndiItem> arrayList = returnArrayList();

            AdapterItemAll adapter = new AdapterItemAll(arrayList);
            mRecyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }
    } //End of onCreate

    /**
     * @return
     */
    public ArrayList<DaIndiItem> returnArrayList() {
        if (task != null && task.getStatus()==AsyncTask.Status.RUNNING){
            Toast.makeText(this,  "Still adding data to the database. Please wait",
                    Toast.LENGTH_LONG).show();
        } else {
            task = new AsyncTask<Integer, Integer, ArrayList<DaIndiItem>>() {

                @Override
                protected ArrayList<DaIndiItem> doInBackground(Integer... integers) {
                    String query = getIntent().getStringExtra(SearchManager.QUERY);
                    Cursor cursor = SQhelper.getInstance(this).serachTitle(query) ;

                    ArrayList<DaIndiItem> arrayList = new ArrayList<>();

                    cursor.moveToFirst();
                    while (cursor.isAfterLast()==false) {
                        String itemTitle = cursor.getString(cursor.getColumnIndex(SQhelper.DataEntryItem
                                .COLUMN_TITLE));
                        String itemPrice = cursor.getString(cursor.getColumnIndex(SQhelper.DataEntryItem
                                .COLUMN_PRICE));
                        int intItemPrice = Integer.parseInt(itemPrice);
                        DaIndiItem itemDetail = new DaIndiItem();
                        itemDetail.setIteTitle(itemTitle);
                        itemDetail.setItePrice(intItemPrice);
                        Log.d(TAG, String.valueOf(itemDetail));
                        arrayList.add(itemDetail);
                        cursor.moveToNext();
                    }

                    if (arrayList.size() == 0) {
                        Toast.makeText(SearchResultActivity.this, "this is my Toast message!!! =)",
                                Toast.LENGTH_LONG).show();
                    }
                    return arrayList;
                }//End of arrayList

            };
        }

        //return returnArrayList();
    }//End of returnArrayList()

}
