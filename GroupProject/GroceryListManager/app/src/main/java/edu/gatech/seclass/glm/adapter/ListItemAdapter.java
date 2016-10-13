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
import edu.gatech.seclass.glm.dao.ListItemDao;
import edu.gatech.seclass.glm.model.ListItem;

public class ListItemAdapter extends RecyclerView
        .Adapter<ListItemAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "ListItemAdapter";
    private static MyClickListener myClickListener;
    private List<ListItem> items;
    private ListItemDao db;

    public ListItemAdapter(Context context) {
        db = new ListItemDao(context);
    }

    public List<ListItem> getListItems() {
        return this.items;
    }

    public void setListItems(String name) {
        this.items = db.getListItems();
    }

    public void setListItems(List<ListItem> items) {
        this.items = items;
    }

    public void addListItem(ListItem item) {
        db.addListItem(item);
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
        holder.name.setText(items.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        ListItemAdapter.myClickListener = myClickListener;
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
            myClickListener.onItemClick(getPosition(), v);
        }
    }
}
