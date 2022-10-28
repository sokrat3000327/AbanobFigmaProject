package com.example.abanobfinalorangeproject.screens.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.abanobfinalorangeproject.R;
import com.example.abanobfinalorangeproject.data.data_app.cart_data.CartEntity;
import com.example.abanobfinalorangeproject.data.data_app.cart_data.CartItemsDatabase;
import com.example.abanobfinalorangeproject.model.ProductViewModle;
import com.example.abanobfinalorangeproject.screens.activites.DetailsScreen;
import com.example.abanobfinalorangeproject.screens.adapters.CategoryAdapter;
import com.example.abanobfinalorangeproject.screens.adapters.CustumAdapter;
import com.example.abanobfinalorangeproject.screens.adapters.ShopItemAdapter;


import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShopItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShopItemFragment extends Fragment implements CustumAdapter.RecyclerListener {

    RecyclerView recyclerView1,recyclerView2;
    CustumAdapter custumAdapter;
    CategoryAdapter categoryAdapter;
    ProductViewModle productViewModle;
    CartItemsDatabase cartDatabase;
    ShopItemAdapter shopItemAdapter;





    public ShopItemFragment() {

    }


    public static ShopItemFragment newInstance() {
        ShopItemFragment fragment = new ShopItemFragment();
        Bundle args = new Bundle();


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        productViewModle = new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication()).create(ProductViewModle.class);
        productViewModle.getPostsFromRepo();
        productViewModle.getPostsFromRepo2();
        cartDatabase=CartItemsDatabase.getInstance(getActivity());



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_shop_item, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView1=view.findViewById(R.id.sfi_recyclerview);
        recyclerView2=view.findViewById(R.id.shop_recyclerview2);

        shopItemAdapter=new ShopItemAdapter();
        categoryAdapter=new CategoryAdapter();

        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView1.setAdapter(shopItemAdapter);

        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView2.setAdapter(categoryAdapter);


        ProductViewModle.posts1().observe(getViewLifecycleOwner(), products -> {

            shopItemAdapter.setShopList(products,getContext());

            // this function does(notifies the attached observers that the underlying data has been changed
            // and any View reflecting the data set should refresh itself)

        });
        ProductViewModle.posts2().observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                categoryAdapter.setMyCategories(strings,getContext());
            }
        });


    }

    @Override
    public void onClick(int position) {



    }
}