package edu.gatech.seclass.glm.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by thome127 on 10/14/16.
 */
public class ItemTest {
    private Item item;

    @Before
    public void setUp() {
        item = new Item();
    }

    @Test
    public void testSetName() throws Exception {
        item.setName("test");
        Assert.assertEquals(item.getName(),"test");
    }

    @Test
    public void testSetId() throws Exception {
        item.setId(1);
        Assert.assertEquals(item.getId(),1);
    }

    @Test
    public void testSetItemTypeId() throws Exception {
        item.setItemTypeId(1);
        Assert.assertEquals(item.getItemTypeId(),1);
    }
}
