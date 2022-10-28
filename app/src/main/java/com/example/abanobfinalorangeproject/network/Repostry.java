package com.example.abanobfinalorangeproject.network;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.abanobfinalorangeproject.model.Product;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repostry {
    //this  related to shop_items_fragment_screen

    private MutableLiveData<List<Product>> responsePost = new MutableLiveData<List<Product>>();
    private MutableLiveData<String> errorPost = new MutableLiveData<>();

    public LiveData<String> error() {
        return errorPost;
    }

    public MutableLiveData<List<Product>> posts() {
        return responsePost;
    }

    //this related to explore_fragment_screen and related to all categories

    private MutableLiveData<List<String>> responsePostCat = new MutableLiveData<List<String>>();
    private MutableLiveData<String> errorPostCat = new MutableLiveData<>();

    public MutableLiveData<List<String>> categoryPosts() {
        return responsePostCat;
    }

    public LiveData<String> error2() {
        return errorPostCat;
    }


    public void getAllPostsFromServer() {
        ProductClient.getINSTANCE().getALLPosts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    responsePost.setValue(response.body());
                } else {
                    errorPost.setValue(response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                errorPost.setValue(t.getMessage());
            }
        });
    }

    public void getAllCategoriesFromServer() {
        CategoryClient.getINSTANCE().getALLPosts().enqueue(new Callback<List<java.lang.String>>() {
            @Override
            public void onResponse(Call<List<java.lang.String>> call, Response<List<java.lang.String>> response) {
                responsePostCat.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<java.lang.String>> call, Throwable t) {
                errorPostCat.setValue(t.getMessage());
            }
        });
    }
}
