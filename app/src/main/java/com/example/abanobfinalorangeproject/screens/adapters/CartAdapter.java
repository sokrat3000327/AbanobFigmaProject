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
import com.example.abanobfinalorangeproject.data.data_app.cart_data.CartEntity;


import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private List<CartEntity> myCart=new ArrayList<>();
    private Context context;




    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.mycart_list_items, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(myCart.get(position).getImg()).into(holder.img);
        holder.t1.setText(myCart.get(position).getTitle());
        holder.t2.setText(String.valueOf(myCart.get(position).getPrice()));

    }

    @Override
    public int getItemCount() {
        return myCart.size();
    }

    public void setList(List<CartEntity> myCart, Context context){
        this.myCart = myCart;
        this.context = context;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView t1,t2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.cartimg);
            t1= itemView.findViewById(R.id.cart_item_title);
            t2=itemView.findViewById(R.id.cart_item_price);
        }
    }
}
