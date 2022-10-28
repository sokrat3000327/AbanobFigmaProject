package com.example.abanobfinalorangeproject.network;

import com.example.abanobfinalorangeproject.model.Product;



import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductClient {
    private static final String URL="https://fakestoreapi.com/";
    private static ProductClient client;
    private ProductInterface post;

    public ProductClient() {
        Retrofit retrofit=new Retrofit.Builder().
                baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        post=retrofit.create(ProductInterface.class);
    }
    public static ProductClient getINSTANCE(){
        if(client==null){
            client=new ProductClient();
        }
        return client;
    }
    public Call<List<Product>> getALLPosts(){
        return post.get_data();
    }
}