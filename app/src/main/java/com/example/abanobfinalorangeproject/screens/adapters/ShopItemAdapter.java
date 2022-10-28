package com.example.abanobfinalorangeproject.screens.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.abanobfinalorangeproject.R;
import com.example.abanobfinalorangeproject.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ShopItemAdapter extends RecyclerView.Adapter<ShopItemAdapter.ViewHolder> {
    private List<Product> shopList=new ArrayList<>();
    private Context context;
    @NonNull
    @Override
    public ShopItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.find_product_list_items3, parent, false);
        return new ShopItemAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopItemAdapter.ViewHolder holder, int position) {
        holder.title.setText(shopList.get(position).getTitle());
        holder.price.setText(String.valueOf(shopList.get(position).getPrice()));
        Glide.with(context).load(shopList.get(position).getImage()).into(holder.image);
    }

    public void setShopList(List<Product> list,Context context){
        this.shopList=list;
        this.context=context;
    }
    @Override
    public int getItemCount() {
        return shopList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,price;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.shop_name);
            price= itemView.findViewById(R.id.shop_price);
            image=itemView.findViewById(R.id.shop_img);
        }
    }
}
