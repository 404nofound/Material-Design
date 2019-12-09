package com.eddy.materialdesign.ui.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.eddy.materialdesign.R;
import com.eddy.materialdesign.ui.recyclerview.helper.onMoveAndSwipedListener;
import com.google.android.material.snackbar.Snackbar;

import java.util.Collections;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> implements onMoveAndSwipedListener {

    private static final String TAG = "ItemAdapter";

    private Context mContext;

    private List<Item> mItemList;

    private View parentView;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView itemImage;
        TextView itemName;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            itemImage = view.findViewById(R.id.item_image);
            itemName = view.findViewById(R.id.item_name);
        }
    }

    public ItemAdapter(List<Item> itemList) {
        mItemList = itemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }

        parentView = parent;

        View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Item item = mItemList.get(position);
                Intent intent = new Intent(mContext, ItemActivity.class);
                intent.putExtra(ItemActivity.ITEM_NAME, item.getName());
                intent.putExtra(ItemActivity.ITEM_IMAGE_ID, item.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Item item = mItemList.get(position);
        holder.itemName.setText(item.getName());
        Glide.with(mContext).load(item.getImageId()).into(holder.itemImage);
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mItemList, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(final int position) {

        final Item item = mItemList.get(position);

        mItemList.remove(position);
        notifyItemRemoved(position);

        Snackbar.make(parentView, "Dismiss", Snackbar.LENGTH_SHORT)
                .setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addItem(position, item);
                    }
                }).show();
    }

    public void addItem(int position, Item insertData) {
        mItemList.add(position, insertData);
        notifyItemInserted(position);
        if(position == 0){
            RecyclerViewActivity.recyclerView.scrollToPosition(0);
        }

    }
}
