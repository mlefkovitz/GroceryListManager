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
import edu.gatech.seclass.glm.dao.GroceryListDao;
import edu.gatech.seclass.glm.model.GroceryList;

/**
 * Created by thome127 on 10/9/16.
 */
public class GroceryListAdapter extends RecyclerView
        .Adapter<GroceryListAdapter
        .DataObjectHolder>{
    private static String LOG_TAG = "GroceryListAdapter";
    private List<GroceryList> groceryLists;
    private static MyClickListener myClickListener;
    private GroceryListDao db;

    public GroceryListAdapter(Context context) {
        db = new GroceryListDao(context);
        setGroceryLists("");
    }

    public List<GroceryList> getGroceryLists() {
        return this.groceryLists;
    }

    public void setGroceryLists(List<GroceryList> groceryLists) {
        this.groceryLists = groceryLists;
    }

    public void setGroceryLists(String name) {
        this.groceryLists = db.getGroceryLists(name);
    }

    public void addGroceryList(GroceryList groceryList){
        db.addGroceryList(groceryList);
        setGroceryLists("");
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
        holder.name.setText(groceryLists.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return groceryLists==null? 0 : groceryLists.size();
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
