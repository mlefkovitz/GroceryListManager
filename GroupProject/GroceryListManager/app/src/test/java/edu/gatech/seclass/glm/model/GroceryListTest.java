package edu.gatech.seclass.glm.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by thome127 on 10/10/16.
 */
public class GroceryListTest {
    private GroceryList grocery_list;

    @Before
    public void setUp() {
        grocery_list = new GroceryList();
    }

    @Test
    public void testSetName() throws Exception {
        grocery_list.setName("test");
        Assert.assertEquals(grocery_list.getName(),"test");
    }

    @Test
    public void testSetId() throws Exception {
        grocery_list.setId(1);
        Assert.assertEquals(grocery_list.getId(),1);
    }
}
