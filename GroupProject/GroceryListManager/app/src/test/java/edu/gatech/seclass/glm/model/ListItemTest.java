package edu.gatech.seclass.glm.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by thome127 on 10/14/16.
 */
public class ListItemTest {

    private ListItem listItem;

    @Before
    public void setUp() {
        listItem = new ListItem();
    }

    @Test
    public void testSetId() throws Exception {
        listItem.setId(1);
        Assert.assertEquals(listItem.getId(),1);
    }

    @Test
    public void testSetGroceryListId() throws Exception {
        listItem.setGroceryListId(1);
        Assert.assertEquals(listItem.getGroceryListId(),1);
    }

    @Test
    public void testSetItemId() throws Exception {
        listItem.setItemId(1);
        Assert.assertEquals(listItem.getItemId(),1);
    }

    @Test
    public void testSetQuantity() throws Exception {
        listItem.setQuantity(1);
        Assert.assertEquals(listItem.getQuantity(),1);
    }

    @Test
    public void testCheckListItem() throws Exception {
        listItem.setChecked(true);
        Assert.assertTrue(listItem.isChecked());
    }

    @Test
    public void testUncheckListItem() throws Exception {
        listItem.setChecked(false);
        Assert.assertFalse(listItem.isChecked());
    }
}
