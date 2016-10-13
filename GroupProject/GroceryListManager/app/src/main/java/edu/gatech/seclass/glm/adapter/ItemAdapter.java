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
import edu.gatech.seclass.glm.dao.ItemsDao;
import edu.gatech.seclass.glm.model.Item;

public class ItemAdapter extends RecyclerView
        .Adapter<ItemAdapter
        .DataObjectHolder>{
    private static String LOG_TAG = "ItemAdapter";
    private static MyClickListener myClickListener;
    private static List<Item> items;
    private ItemsDao db;

    public ItemAdapter(Context context) {
        db = new ItemsDao(context);
        setItems("");
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        ItemAdapter.items = items;
    }

    public void setItems(String name) {
        items = db.getItems(name);
    }

    public void addItem(Item item){
        db.addItem(item);
        setItems("");
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grocery_list_view_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.name.setText(items.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return items==null? 0 : items.size();
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        ItemAdapter.myClickListener = myClickListener;
    }

    public interface MyClickListener {
        void onItemClick(int position, View v);
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
            int pos = getPosition();
            long id = items.get(pos).getId();
            myClickListener.onItemClick((int) id, v);
        }
    }
}
