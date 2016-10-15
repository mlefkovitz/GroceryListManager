package edu.gatech.seclass.glm.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by thome127 on 10/14/16.
 */
public class ItemTypeTest {

    private ItemType itemType;

    @Before
    public void setUp() {
        itemType = new ItemType();
    }

    @Test
    public void testSetName() throws Exception {
        itemType.setName("test");
        Assert.assertEquals(itemType.getName(),"test");
    }

    @Test
    public void testSetId() throws Exception {
        itemType.setId(1);
        Assert.assertEquals(itemType.getId(),1);
    }
}
