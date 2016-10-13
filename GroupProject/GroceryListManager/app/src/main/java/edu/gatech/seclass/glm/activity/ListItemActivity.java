package edu.gatech.seclass.glm.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.gatech.seclass.glm.R;
import edu.gatech.seclass.glm.adapter.ListItemAdapter;
import edu.gatech.seclass.glm.dao.ListItemDao;
import edu.gatech.seclass.glm.model.ListItem;
import edu.gatech.seclass.glm.util.DividerItemDecoration;

public class ListItemActivity extends AppCompatActivity {

    private static String LOG_TAG = "ListItemActivity";
    EditText listItemNameValue;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ListItemAdapter mAdapter;
    private ListItemDao db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_activity);
        listItemNameValue = (EditText) findViewById(R.id.listItemNameValue);

        Button buttonCompute = (Button) findViewById(R.id.buttonSearch);
        buttonCompute.setOnClickListener(new SearchListener());

        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new AddNewItemListener());

        mLayoutManager = new LinearLayoutManager(this);
        Intent intent = getIntent();
        long grocery_list_id = Long.valueOf(intent.getStringExtra("GROCERY_LIST_ID"));
        mAdapter = new ListItemAdapter(this);
        mAdapter.setListItems(grocery_list_id);

        mRecyclerView = (RecyclerView) findViewById(R.id.list_item_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        //Add Lines between elements
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

    }

   @Override
    protected void onResume() {
        super.onResume();
       mAdapter.setOnItemClickListener(new ListItemAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on ListItem " + position);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                long grocery_list_id = Long.valueOf(getIntent().getStringExtra("GROCERY_LIST_ID"));
                long item_id = Long.valueOf(data.getStringExtra("ITEM_ID"));
                Log.i(LOG_TAG, " INSERT " + grocery_list_id + " " + item_id);
                ListItem newListItem = new ListItem();
                newListItem.setGroceryListId(grocery_list_id);
                newListItem.setItemId(item_id);
                mAdapter.addListItem(newListItem);
                mRecyclerView.setAdapter(mAdapter);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }

    private class SearchListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            long grocery_list_id = Long.valueOf(getIntent().getStringExtra("GROCERY_LIST_ID"));
            mAdapter.setListItems(grocery_list_id);
            mRecyclerView.setAdapter(mAdapter);
        }
    }

    private class AddNewItemListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ListItemActivity.this, edu.gatech.seclass.glm.activity.ItemActivity.class);
            startActivityForResult(intent, 1);
            mRecyclerView.setAdapter(mAdapter);
        }
    }
}
