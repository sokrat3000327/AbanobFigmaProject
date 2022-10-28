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
import com.example.abanobfinalorangeproject.data.data_app.favourite_data.FavouriteEntity;
import com.example.abanobfinalorangeproject.model.ProductViewModle;
import com.example.abanobfinalorangeproject.screens.adapters.FavoAdapter;

import java.util.List;


public class FavouriteFragment extends Fragment {
    ProductViewModle productViewModle;
    RecyclerView favoRecycle;
    FavoAdapter favoAdapter;

    public FavouriteFragment() {
        // Required empty public constructor
    }


    public static FavouriteFragment newInstance() {
        FavouriteFragment fragment = new FavouriteFragment();


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productViewModle = new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication()).create(ProductViewModle.class);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        favoRecycle = view.findViewById(R.id.favo_recyclerview);
        favoAdapter=new FavoAdapter();
        favoRecycle.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        favoRecycle.setHasFixedSize(true);
        favoRecycle.setAdapter(favoAdapter);



        productViewModle.getAllFavos().observe(getViewLifecycleOwner(), new Observer<List<FavouriteEntity>>() {
            @Override
            public void onChanged(List<FavouriteEntity> favouriteEntities) {
                favoAdapter.setList(favouriteEntities,getContext());
            }
        });
    }
}





