package com.example.abanobfinalorangeproject.screens.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.abanobfinalorangeproject.R;
import com.example.abanobfinalorangeproject.data.data_app.cart_data.CartEntity;
import com.example.abanobfinalorangeproject.model.ProductViewModle;
import com.example.abanobfinalorangeproject.screens.activites.DetailsScreen;
import com.example.abanobfinalorangeproject.screens.adapters.CustumAdapter;


public class ExploreFragment extends Fragment implements CustumAdapter.RecyclerListener {

//    RecyclerView categoryRecyclerView;
//    CategoryAdapter categoryAdapter;
    ProductViewModle productViewModle;
    RecyclerView recyclerView2;
  CustumAdapter custumAdapter;





    public ExploreFragment() {

    }


    public static ExploreFragment newInstance() {
        ExploreFragment fragment = new ExploreFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        productViewModle= new ViewModelProvider(this).get(ProductViewModle.class);
//        categoryAdapter=new CategoryAdapter();

        productViewModle = new ViewModelProvider(this).get(ProductViewModle.class);
        productViewModle.getPostsFromRepo();




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView2=view.findViewById(R.id.recycle2);
        custumAdapter=new CustumAdapter(this);
        recyclerView2.setLayoutManager(new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false));
        recyclerView2.setAdapter(custumAdapter);
//        categoryRecyclerView=view.findViewById(R.id.recycle2);
//        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
//        categoryRecyclerView.setHasFixedSize(true);
//        categoryRecyclerView.setAdapter(categoryAdapter);

//        getString(queue);
        ProductViewModle.posts1().observe(getViewLifecycleOwner(), products -> {

            custumAdapter.setList(products,getContext());

            // this function does(notifies the attached observers that the underlying data has been changed
            // and any View reflecting the data set should refresh itself)

        }

        );



    }

    @Override
    public void onClick(int position) {
        String name=custumAdapter.getList().get(position).getTitle();
        double price=custumAdapter.getList().get(position).getPrice();
        String category=custumAdapter.getList().get(position).getCategory();
        String description=custumAdapter.getList().get(position).getDescription();
        CartEntity item=new CartEntity (name,custumAdapter.getList().get(position).getImage(),price);
        ProductViewModle.insert(item);
        Toast.makeText(getContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        Intent goToDetails=new Intent(getActivity(), DetailsScreen.class);
        goToDetails.putExtra("detail_img",custumAdapter.getList().get(position).getImage());
        goToDetails.putExtra("detail_name",name);
        goToDetails.putExtra("detail_price",price);
        goToDetails.putExtra("detail_description",description);
        goToDetails.putExtra("detail_category",category);
        startActivity(goToDetails);
    }


//    private void getString(RequestQueue queue) {
//
//
//        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        queue.add(stringRequest);
//    }


}