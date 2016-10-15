package edu.gatech.seclass.glm.model;

import android.databinding.BaseObservable;

public class Item extends BaseObservable {
    private long id;
    private String name;
    private long itemTypeId;
    private ItemType itemType;

    public Item() {

    }

    public long getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(long itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId(){
        return this.id;
    }

    public void setId(long id){
        this.id = id;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
}
