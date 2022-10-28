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

public class CustumAdapter extends RecyclerView.Adapter<CustumAdapter.ViewHolder>{
    private List<Product> list = new ArrayList<>();
    private Context c;
    private int resultNo;
    private RecyclerListener recyclerListener;

    public CustumAdapter(RecyclerListener recyclerListener) {
        this.recyclerListener = recyclerListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_fragment_list_item, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.description.setText(list.get(position).getDescription());
        holder.price.setText(String.valueOf(list.get(position).getPrice()));
        Glide.with(c).load(list.get(position).getImage()).into(holder.productImage);


    }

    @Override
    public int getItemCount() {

        resultNo=list.size();
        return list.size();
    }

    public void setList(List<Product> list1, Context context) {
        this.list = list1;
        this.c=context;
        notifyDataSetChanged();
    }
    public void setFilterList(List<Product> list1) {
        this.list = list1;
        notifyDataSetChanged();
    }

    public List<Product> getList() {
        return list;
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {

        private TextView title ,description,price ;
        private ImageView productImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.shop_name);
            description=itemView.findViewById(R.id.shopfrag_t2);
            price=itemView.findViewById(R.id.shop_price);
            productImage=itemView.findViewById(R.id.shop_img);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            recyclerListener.onClick(getAdapterPosition());
        }
    }
    public interface  RecyclerListener {
        void onClick(int position);
    }
}
