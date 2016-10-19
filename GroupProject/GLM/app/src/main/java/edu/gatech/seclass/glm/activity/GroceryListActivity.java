package edu.gatech.seclass.glm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.gatech.seclass.glm.R;
import edu.gatech.seclass.glm.adapter.GroceryListAdapter;
import edu.gatech.seclass.glm.model.GroceryList;
import edu.gatech.seclass.glm.util.DividerItemDecoration;

public class GroceryListActivity extends AppCompatActivity {

    private static String LOG_TAG = "GroceryListActivity";
    EditText groceryListNameValue;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private static GroceryListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grocery_list_activity);
        groceryListNameValue = (EditText) findViewById(R.id.groceryListNameValue);

        Button buttonCompute = (Button) findViewById(R.id.buttonSearch);
        buttonCompute.setOnClickListener(new SearchListener());

        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new AddListener());

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.grocery_list_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        resetAdapter();

        //Add Lines between elements
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
    }

    public void resetAdapter() {
        mAdapter = new GroceryListAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public static void resetAdapterList() {
        mAdapter.getItemCount();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setOnItemClickListener(new GroceryListAdapter.MyClickListener() {
                 @Override
                 public void onItemClick(int position, View v) {
                     Intent intent = new Intent(GroceryListActivity.this, edu.gatech.seclass.glm.activity.ListItemActivity.class);
                     ListItemActivity.setSelectedGroceryListId(position);
                     startActivity(intent);
            }
         });
    }

    private class SearchListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String name = groceryListNameValue.getText().toString();
            GroceryListAdapter.setGroceryLists(name);
            mRecyclerView.setAdapter(mAdapter);
        }
    }

    private class AddListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String name = groceryListNameValue.getText().toString();
            if(name!=null && !name.isEmpty()) {
                GroceryList newGroceryList = new GroceryList();
                newGroceryList.setName(name);
                mAdapter.addGroceryList(newGroceryList);
                mRecyclerView.setAdapter(mAdapter);
            }
        }
    }
}
