package edu.gatech.seclass.glm.model;

import android.databinding.BaseObservable;

/**
 * Created by shazamW81 on 10/11/2016.
 */
public class ListItem extends BaseObservable {
    private long ListItem_id;
    private long item_id;
    private long grocery_list_id;
    private int quantity;
    private int checked;


    public ListItem(long listItem_id, long item_id, long grocery_list_id, int quantity, int checked) {
        ListItem_id = listItem_id;
        this.item_id = item_id;
        this.grocery_list_id = grocery_list_id;
        this.quantity = quantity;
        this.checked = checked;
    }



    public long getListItem_id() {
        return ListItem_id;
    }

    public void setListItem_id(long listItem_id) {
        ListItem_id = listItem_id;
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

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }
}
