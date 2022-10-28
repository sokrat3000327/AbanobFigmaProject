package com.example.abanobfinalorangeproject.network;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryInterface {
    @GET("categories")
    public Call<List<String>> get_category_data();
}
