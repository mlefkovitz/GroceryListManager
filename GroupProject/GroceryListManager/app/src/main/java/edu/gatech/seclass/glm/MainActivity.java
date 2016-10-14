package edu.gatech.seclass.glm;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import edu.gatech.seclass.glm.dao.GroceryListDao;
import edu.gatech.seclass.glm.dao.ItemDao;
import edu.gatech.seclass.glm.dao.ItemTypeDao;
import edu.gatech.seclass.glm.dao.ListItemDao;
import edu.gatech.seclass.glm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static GroceryListDao groceryListDao;
    public static ItemDao itemDao;
    public static ItemTypeDao itemTypeDao;
    public static ListItemDao listItemDao;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        groceryListDao = new GroceryListDao(this);
        itemDao = new ItemDao(this);
        itemTypeDao = new ItemTypeDao(this);
        listItemDao = new ListItemDao(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.groceryListsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, edu.gatech.seclass.glm.activity.GroceryListActivity.class));
            }
        });
        binding.itemTypesButton.setVisibility(View.INVISIBLE);
        binding.itemTypesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, edu.gatech.seclass.glm.activity.ItemTypeActivity.class));
                   }
        });
        binding.itemsButton.setVisibility(View.INVISIBLE);
        binding.itemsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, edu.gatech.seclass.glm.activity.ItemActivity.class));
            }
        });
        binding.listItemsButton.setVisibility(View.INVISIBLE);
        binding.listItemsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, edu.gatech.seclass.glm.activity.ListItemActivity.class));
            }
        });
    }
}
