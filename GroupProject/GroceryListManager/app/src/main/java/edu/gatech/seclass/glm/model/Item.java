package edu.gatech.seclass.glm.model;

import android.databinding.BaseObservable;

public class Item extends BaseObservable {
    private long id;
    private String name;

    public Item() {

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
}
