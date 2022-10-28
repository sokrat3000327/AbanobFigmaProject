package com.example.abanobfinalorangeproject.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.abanobfinalorangeproject.data.data_app.Repository;
import com.example.abanobfinalorangeproject.data.data_app.cart_data.CartEntity;
import com.example.abanobfinalorangeproject.data.data_app.favourite_data.FavouriteEntity;
import com.example.abanobfinalorangeproject.network.Repostry;

import java.util.List;


public class ProductViewModle extends AndroidViewModel{
    //this data related to shop_items

    public MutableLiveData <List<Product>> dataList=new MutableLiveData<>();
    public MutableLiveData <List<CategoryPageModel>> dataList2=new MutableLiveData<>();

    public final LiveData<List<CartEntity>> AllCarts;
    public final LiveData<List<FavouriteEntity>> allFavos;




    public static Repository repository;
    private static final Repostry repo =new Repostry();

    public ProductViewModle(@NonNull Application application) {
        super(application);
        repository=new Repository(application);
        AllCarts=repository.getAllData();
        allFavos=repository.getAllFavos();


    }


    public static MutableLiveData<List<Product>> posts1(){
        return repo.posts();
    }
    public static LiveData<String> error(){
        return repo.error();
    }
    public void getPostsFromRepo(){
        repo.getAllPostsFromServer();
    }


    public static MutableLiveData<List<String>> posts2(){
        return repo.categoryPosts();
    }

    public static LiveData<String> errorCat(){
        return repo.error();
    }
    public void getPostsFromRepo2(){
        repo.getAllCategoriesFromServer();
    }



    public LiveData<List<CartEntity>> getAllCarts() { return AllCarts; }
    public static void insert(CartEntity cart) { repository.insert(cart); }


    public LiveData<List<FavouriteEntity>> getAllFavos(){return allFavos;}
    public static  void insertFavo(FavouriteEntity favo){repository.insertFavo(favo);}

}
