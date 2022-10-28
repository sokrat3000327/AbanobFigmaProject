package com.example.abanobfinalorangeproject.screens.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abanobfinalorangeproject.R;
import com.example.abanobfinalorangeproject.data.data_app.cart_data.CartEntity;
import com.example.abanobfinalorangeproject.data.data_app.cart_data.CartItemsDatabase;
import com.example.abanobfinalorangeproject.model.ProductViewModle;
import com.example.abanobfinalorangeproject.screens.adapters.CartAdapter;


import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MyCartFragment extends Fragment  {
 RecyclerView recycler;
 CartAdapter cartAdapter;
 CartItemsDatabase cartItemsDatabase;
 ProductViewModle productViewModle;
 public static final String TAG="RxError";

    public MyCartFragment() {

    }

    public static MyCartFragment newInstance() {
        MyCartFragment fragment = new MyCartFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       cartItemsDatabase=CartItemsDatabase.getInstance(getActivity());
       productViewModle= new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())
               .create(ProductViewModle.class);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler=view.findViewById(R.id.cart_recycler_view);
        recycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        cartAdapter=new CartAdapter();
        recycler.setAdapter(cartAdapter);
        productViewModle.getAllCarts().observe(getViewLifecycleOwner(), new Observer<List<CartEntity>>() {
            @Override
            public void onChanged(List<CartEntity> cartEntities) {
                cartAdapter.setList(cartEntities,getActivity().getApplicationContext());
            }
        });








    }


}