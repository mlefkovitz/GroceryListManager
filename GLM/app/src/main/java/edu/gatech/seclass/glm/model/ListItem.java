package edu.gatech.seclass.glm.model;

import android.databinding.BaseObservable;

/**
 * Created by shazamW81 on 10/11/2016.
 */
public class ListItem extends BaseObservable {
    private long id;
    private long itemId;
    private long groceryListId;
    private Item item;
    private int quantity;
    private boolean checked;


    public ListItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getGroceryListId() {
        return groceryListId;
    }

    public void setGroceryListId(long groceryListId) {
        this.groceryListId = groceryListId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
