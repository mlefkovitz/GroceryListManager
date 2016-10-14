package edu.gatech.seclass.glm.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.gatech.seclass.glm.R;
import edu.gatech.seclass.glm.adapter.ItemTypeAdapter;
import edu.gatech.seclass.glm.dao.ItemTypeDao;
import edu.gatech.seclass.glm.model.ItemType;
import edu.gatech.seclass.glm.util.DividerItemDecoration;

public class ItemTypeActivity extends AppCompatActivity {

    private static String LOG_TAG = "ItemTypeActivity";
    EditText itemTypeNameValue;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ItemTypeAdapter mAdapter;
    private ItemTypeDao db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_type_activity);
        itemTypeNameValue = (EditText) findViewById(R.id.itemTypeNameValue);

        Button buttonCompute = (Button) findViewById(R.id.buttonSearch);
        buttonCompute.setOnClickListener(new SearchListener());

        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new AddListener());

        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ItemTypeAdapter(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.item_type_view);
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
        mAdapter.setOnItemClickListener(new ItemTypeAdapter.MyClickListener() {
                 @Override
                 public void onItemClick(int position, View v) {
                     Intent returnIntent = new Intent();
                     ItemActivity.setSelectedItemTypeId(position);
                     setResult(Activity.RESULT_OK, returnIntent);
                     finish();
            }
         });
    }

    private class SearchListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String name = itemTypeNameValue.getText().toString();
            mAdapter.setItemTypes(name);
            mRecyclerView.setAdapter(mAdapter);
        }
    }

    private class AddListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String name = itemTypeNameValue.getText().toString();
            if(name!=null && !name.isEmpty()) {
                ItemType newItemType = new ItemType();
                newItemType.setName(name);
                mAdapter.addItemType(newItemType);
                mRecyclerView.setAdapter(mAdapter);
            }
        }
    }
}
