package edu.gatech.seclass.glm.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
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
    private static List<ListItem> listItems;
    private ListItemDao db;

    public ListItemAdapter(Context context) {
        db = new ListItemDao(context);
    }

    public List<ListItem> getListItems() {
        return listItems;
    }

    public void setListItems(long grocery_list_id) {
        listItems = db.getListItems(grocery_list_id);
    }

    public void setListItems(List<ListItem> items) {
        listItems = items;
    }

    public ListItem addListItem(ListItem item) {
        return db.addListItem(item);
    }

    public void updateListItemQuantity(ListItem item, int quantity) {
        db.updateListItemQuantity(item, quantity);
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_view_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.name.setText(listItems.get(position).getItem().getName());
        holder.itemType.setText(listItems.get(position).getItem().getItemType().getName());
        holder.quantity.setText("" + listItems.get(position).getQuantity());
        holder.checked.setChecked(listItems.get(position).isChecked());
    }

    @Override
    public int getItemCount() {
        return listItems == null ? 0 : listItems.size();
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        ListItemAdapter.myClickListener = myClickListener;
    }

    public ListItem getListItem(int id) {
        return db.getListItem(id);
    }

    public interface MyClickListener {
        void onItemClick(int position, View v);
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView name;
        TextView itemType;
        TextView quantity;
        CheckBox checked;

        public DataObjectHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.listItemViewItem);
            itemType = (TextView) itemView.findViewById(R.id.listItemTypeViewItem);
            quantity = (TextView) itemView.findViewById(R.id.listItemQuantityViewItem);
            checked = (CheckBox) itemView.findViewById(R.id.listItemCheckedViewItem);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getPosition();
            long id = listItems.get(pos).getId();
            myClickListener.onItemClick((int) id, v);
        }
    }
}
