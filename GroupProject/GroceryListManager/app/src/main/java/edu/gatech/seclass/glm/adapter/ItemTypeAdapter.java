package edu.gatech.seclass.glm.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import edu.gatech.seclass.glm.R;
import edu.gatech.seclass.glm.dao.ItemTypeDao;
import edu.gatech.seclass.glm.model.ItemType;

/**
 * Created by thome127 on 10/9/16.
 */
public class ItemTypeAdapter extends RecyclerView
        .Adapter<ItemTypeAdapter
        .DataObjectHolder>{
    private static String LOG_TAG = "ItemTypeAdapter";
    private List<ItemType> itemTypes;
    private static MyClickListener myClickListener;
    private ItemTypeDao db;

    public ItemTypeAdapter(Context context) {
        db = new ItemTypeDao(context);
        setItemTypes("");
    }

    public List<ItemType> getItemTypes() {
        return this.itemTypes;
    }

    public void setItemTypes(List<ItemType> itemTypes) {
        this.itemTypes = itemTypes;
    }

    public void setItemTypes(String name) {
        this.itemTypes = db.getItemTypes(name);
    }

    public void addItemType(ItemType itemType){
        db.addItemType(itemType);
        setItemTypes("");
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grovery_list_view_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.name.setText(itemTypes.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return itemTypes==null? 0 : itemTypes.size();
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView name;

        public DataObjectHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textView);
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}
