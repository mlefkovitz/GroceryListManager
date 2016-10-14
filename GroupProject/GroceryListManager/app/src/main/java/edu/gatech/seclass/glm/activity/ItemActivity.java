package edu.gatech.seclass.glm.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import edu.gatech.seclass.glm.R;
import edu.gatech.seclass.glm.adapter.ItemAdapter;
import edu.gatech.seclass.glm.dao.ItemDao;
import edu.gatech.seclass.glm.dao.ItemTypeDao;
import edu.gatech.seclass.glm.model.Item;
import edu.gatech.seclass.glm.model.ItemType;
import edu.gatech.seclass.glm.util.DividerItemDecoration;

public class ItemActivity extends AppCompatActivity {

    private static String LOG_TAG = "ItemActivity";
    EditText itemNameValue;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ItemAdapter mAdapter;
    private ItemDao db;
    private ItemTypeDao itemTypeDao;

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
                Intent returnIntent = new Intent();
                returnIntent.putExtra("ITEM_ID", "" + position);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
    }

    private void showAddItemTypeDialog(Item newItem) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        final Spinner spinner = new Spinner(this);
        alertDialogBuilder.setTitle("Select Item Type");
        alertDialogBuilder.setView(spinner);
        itemTypeDao = new ItemTypeDao(this);
        ArrayAdapter<ItemType> adapter;
        List<ItemType> list = itemTypeDao.getItemTypes();
        adapter = new ArrayAdapter<ItemType>(getApplicationContext(), android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        spinner.setOnItemSelectedListener(new SpinnerListener(newItem, alertDialog));
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
            if (name != null && !name.isEmpty()) {
                //TODO: ASK FOR ITEM TYPE
                Item newItem = new Item();
                newItem.setName(name);
                showAddItemTypeDialog(newItem);
//                mAdapter.addItem(newItem);
                mRecyclerView.setAdapter(mAdapter);
            }
        }
    }

    private class SpinnerListener implements AdapterView.OnItemSelectedListener {
        AlertDialog alertDialog;
        boolean first = true;
        private Item item;

        public SpinnerListener(Item item, AlertDialog alertDialog) {
            this.item = item;
            this.alertDialog = alertDialog;
        }

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
            //TODO: ADD BUTTON
            if (!first) {
                ItemType itemType = (ItemType) parent.getItemAtPosition(pos);
                item.setItemTypeId(itemType.getId());
                mAdapter.addItem(item);
                alertDialog.dismiss();
                mRecyclerView.setAdapter(mAdapter);
            } else {
                first = false;
            }
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }


}
