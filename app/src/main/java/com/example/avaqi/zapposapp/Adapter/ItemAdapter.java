package com.example.avaqi.zapposapp.Adapter;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.avaqi.zapposapp.Activity.ProductActivity;
import com.example.avaqi.zapposapp.R;
import com.example.avaqi.zapposapp.model.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Avaqi on 2017/2/8.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    private Context mContext;
    private List<Item> itemList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, price;
        public ImageView thumbnail;
        public CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            price = (TextView) view.findViewById(R.id.price);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            cardView= (CardView) itemView.findViewById(R.id.card_view);
        }
    }

    public ItemAdapter(Context mContext, List<Item> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final int j=position;
        Item item = itemList.get(position);
        holder.title.setText(item.getProductName());
        holder.price.setText(item.getPrice());

        Picasso.with(mContext).load(item.getThumbnail()).into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext,ProductActivity.class);
                intent.putExtra("Product",itemList.get(j));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
