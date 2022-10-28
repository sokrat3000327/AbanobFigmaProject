package com.example.abanobfinalorangeproject.data.data_app;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.abanobfinalorangeproject.data.data_app.cart_data.CartDao;
import com.example.abanobfinalorangeproject.data.data_app.cart_data.CartEntity;
import com.example.abanobfinalorangeproject.data.data_app.cart_data.CartItemsDatabase;
import com.example.abanobfinalorangeproject.data.data_app.favourite_data.FavouriteEntity;

import java.util.List;

public class Repository {
    private CartDao cartDao;
    private LiveData<List<CartEntity>> allCarts;



    private LiveData<List<FavouriteEntity>> allFavos;


    public Repository(Application application) {
        CartItemsDatabase db = CartItemsDatabase.getInstance(application);

        cartDao = db.cartDao();

        allCarts = cartDao.getAllCarts();
        allFavos=cartDao.getProductsFromFavorite();
    }


    public LiveData<List<CartEntity>> getAllData() { return allCarts; }
    public void insert(CartEntity contact) {
        CartItemsDatabase.databaseWriteExecutor.execute(() -> cartDao.insertCart(contact));
    }


    public LiveData<List<FavouriteEntity>> getAllFavos(){
        return allFavos;
    }
    public void insertFavo(FavouriteEntity favo){
        CartItemsDatabase.databaseWriteExecutor.execute(() -> cartDao.insertProductToFavorite(favo));
    }



}
