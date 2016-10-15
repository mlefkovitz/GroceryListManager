package edu.gatech.seclass.glm.model;

import android.databinding.BaseObservable;

public class ItemType extends BaseObservable {
    private long id;
    private String name;
    private String description;

    public ItemType() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId(){
        return this.id;
    }

    public void setId(long id){
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }
}
