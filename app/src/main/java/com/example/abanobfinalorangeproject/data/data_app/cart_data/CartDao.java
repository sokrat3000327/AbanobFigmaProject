package com.example.abanobfinalorangeproject.data.data_app.cart_data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.abanobfinalorangeproject.data.data_app.favourite_data.FavouriteEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

@Dao
public interface CartDao {

    @Insert
     void insertCart(CartEntity cart);
    @Query("select * from cart_table")
     LiveData<List<CartEntity>> getAllCarts();

    @Insert
    void insertProductToFavorite(FavouriteEntity entity );

    @Query("select * from favourite_table")
    LiveData<List<FavouriteEntity>> getProductsFromFavorite();
}
