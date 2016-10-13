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
        buttonAdd.setOnClickListener(new AddListener());

        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ListItemAdapter(this);

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


    private class SearchListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String name = listItemNameValue.getText().toString();
            mAdapter.setListItems("");
            mRecyclerView.setAdapter(mAdapter);
        }
    }


    private class AddListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String name = listItemNameValue.getText().toString();
            if(name!=null && !name.isEmpty()) {
                ListItem newListItem = null;
                newListItem.setQuantity(0);
                mAdapter.addListItem(newListItem);
                mRecyclerView.setAdapter(mAdapter);
            }
        }
    }


}
