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
import edu.gatech.seclass.glm.model.ListItem;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by thome127 on 10/14/16.
 */

@RunWith(AndroidJUnit4.class)
public class ListItemDaoTest {
    private ListItemDao database;
    private ItemDao databaseItem;
    private ItemTypeDao databaseItemType;
    private GroceryListDao databaseInitialize;

    @Before
    public void setUp() throws Exception {
        getTargetContext().deleteDatabase(DBContract.DATABASE_NAME);
        databaseInitialize = new GroceryListDao(getTargetContext());
        databaseItem = new ItemDao(getTargetContext());
        databaseItemType = new ItemTypeDao(getTargetContext());
        database = new ListItemDao(getTargetContext());
    }

    @After
    public void tearDown() throws Exception {
//        database.close();
    }

    @Test
    public void shouldAddListItem() throws Exception {

        GroceryList newList = new GroceryList();
        newList.setName("Food");
        databaseInitialize.addGroceryList(newList);
        long newListId = newList.getId();

        ItemType newItemType = new ItemType();
        newItemType.setName("Food Category");
        databaseItemType.addItemType(newItemType);

        Item newItem = new Item();
        newItem.setName("Food");
        newItem.setItemTypeId(newItemType.getId());
        databaseItem.addItem(newItem);

        ListItem newListItem = new ListItem();
        newListItem.setGroceryListId(newListId);
        newListItem.setItemId(0);
        database.addListItem(newListItem);
        List<ListItem> listItems = database.getListItems(0);
        assertThat(listItems.size(), is(1));
        assertTrue(listItems.get(0).getItem().getName().equals("Food"));
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
