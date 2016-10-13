package edu.gatech.seclass.glm.model;

import android.databinding.BaseObservable;

/**
 * Created by shazamW81 on 10/11/2016.
 */
public class ListItem extends BaseObservable {
    private long id;
    private long item_id;
    private long grocery_list_id;
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

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public long getGrocery_list_id() {
        return grocery_list_id;
    }

    public void setGrocery_list_id(long grocery_list_id) {
        this.grocery_list_id = grocery_list_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
