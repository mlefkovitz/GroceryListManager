package edu.gatech.seclass.glm.dao;

import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import edu.gatech.seclass.glm.activity.ListItemActivity;
import edu.gatech.seclass.glm.model.GroceryList;
import edu.gatech.seclass.glm.model.Item;
import edu.gatech.seclass.glm.model.ItemType;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by thome127 on 10/14/16.
 */

@RunWith(AndroidJUnit4.class)
public class ItemDaoTest {
    private ItemDao database;
    private ItemTypeDao databaseItemType;

    @Before
    public void setUp() throws Exception {
        getTargetContext().deleteDatabase(DBContract.DATABASE_NAME);
        databaseItemType = new ItemTypeDao(getTargetContext());
        database = new ItemDao(getTargetContext());
    }

    @After
    public void tearDown() throws Exception {
  //      database.close();
    }

    @Test
    public void shouldAddItem() throws Exception {
        ItemType newItemType = new ItemType();
        newItemType.setName("Food Category");
        databaseItemType.addItemType(newItemType);

        Item newItem = new Item();
        newItem.setName("XYZ Cereal");
        newItem.setItemTypeId(newItemType.getId());
        database.addItem(newItem);
        List<Item> items = database.getItems("");
        assertThat(items.size(), is(1));
        assertTrue(items.get(0).getName().equals("XYZ Cereal"));
    }
/*
    @Test
    public void shouldNotAddGroceryListWithoutName() throws Exception {
        GroceryList newList = new GroceryList();
        database.addGroceryList(newList);
        List<GroceryList> groceryLists = database.getGroceryLists("");
        assertThat(groceryLists.size(), is(0));
    }

    @Test
    public void shouldNotAddDuplicateGroceryList() throws Exception {
        GroceryList newList = new GroceryList();
        newList.setName("Food");
        database.addGroceryList(newList);
        database.addGroceryList(newList);
        List<GroceryList> groceryLists = database.getGroceryLists("");
        assertThat(groceryLists.size(), is(1));
    }

    @Test
    public void shouldSelectAGroceryList() throws Exception {
        GroceryList newList = new GroceryList();
        newList.setName("Food");
        database.addGroceryList(newList);
        List<GroceryList> groceryLists = database.getGroceryLists("");
        ListItemActivity.setSelectedGroceryListId(groceryLists.get(0).getId());
        Assert.assertEquals(ListItemActivity.getSelectedGroceryListId(),1);
    }

    @Test
    public void shouldUpdateGroceryListName() throws Exception {
        GroceryList newList = new GroceryList();
        newList.setName("Food");
        database.addGroceryList(newList);
        List<GroceryList> groceryLists = database.getGroceryLists("");
        database.updateGroceryList(groceryLists.get(0).getId(),"Bobby");
        groceryLists = database.getGroceryLists("");
        assertThat(groceryLists.size(), is(1));
        assertTrue(groceryLists.get(0).getName().equals("Bobby"));
    }

    @Test
    public void shouldDeleteGroceryList() throws Exception {
        GroceryList newList = new GroceryList();
        newList.setName("Food");
        database.addGroceryList(newList);
        List<GroceryList> groceryLists = database.getGroceryLists("");
        assertThat(groceryLists.size(), is(1));
        database.deleteGroceryList(groceryLists.get(0).getId());
        groceryLists = database.getGroceryLists("");
        assertThat(groceryLists.size(), is(0));
    }
*/
}
