package com.example.abanobfinalorangeproject.screens.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.abanobfinalorangeproject.R;

import java.util.ArrayList;
import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
   private List<String> myCategories=new ArrayList<String>();
    Context context;
    private int resultNo;


    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_items, parent, false);
        return new CategoryAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
//        Glide.with(context).load(myProd.get(position).getImg()).into(holder.im);
        holder.tv1.setText(myCategories.get(position));


    }

    @Override
    public int getItemCount() {
      ;
        return myCategories.size();
    }
    public void setMyCategories(List<String> list1, Context context) {
        this.myCategories = list1;
        this.context=context;

    }
    public void setFilterList(List<String> list1) {
        this.myCategories = list1;

    }
    public class ViewHolder extends RecyclerView.ViewHolder {
//        ImageView im;
        TextView tv1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            im=itemView.findViewById(R.id.cat_img);
            tv1=itemView.findViewById(R.id.cattext1);
        }


    }

}
