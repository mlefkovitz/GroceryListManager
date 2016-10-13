package edu.gatech.seclass.glm.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.gatech.seclass.glm.R;
import edu.gatech.seclass.glm.adapter.ItemAdapter;
import edu.gatech.seclass.glm.dao.ItemsDao;
import edu.gatech.seclass.glm.model.Item;
import edu.gatech.seclass.glm.util.DividerItemDecoration;

public class ItemsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "ItemsActivity";
    private ItemAdapter mAdapter;
    private ItemsDao db;

    EditText itemNameValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_activity);
        itemNameValue = (EditText) findViewById(R.id.ItemBox);

        Button buttonCompute = (Button) findViewById(R.id.buttonSearch);
        buttonCompute.setOnClickListener(new SearchListener());

        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new AddListener());

        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ItemAdapter(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.item_view);
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
        mAdapter.setOnItemClickListener(new ItemAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });
    }


    private class SearchListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String name = itemNameValue.getText().toString();
            mAdapter.setItems(name);
            mRecyclerView.setAdapter(mAdapter);
        }
    }


    private class AddListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String name = itemNameValue.getText().toString();
            if(name!=null && !name.isEmpty()) {
                Item newItem = new Item();
                newItem.setName(name);
                mAdapter.addItem(newItem);
                mRecyclerView.setAdapter(mAdapter);
            }
        }
    }


}