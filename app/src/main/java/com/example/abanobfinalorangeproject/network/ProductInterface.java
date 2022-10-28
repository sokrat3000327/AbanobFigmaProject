package com.example.abanobfinalorangeproject.network;

import com.example.abanobfinalorangeproject.model.Product;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductInterface {
    @GET("products")
    public Call<List<Product>> get_data();

}
