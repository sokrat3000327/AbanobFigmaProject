package com.example.abanobfinalorangeproject.data.data_app.cart_data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.abanobfinalorangeproject.data.data_app.favourite_data.FavouriteEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {CartEntity.class, FavouriteEntity.class},version = 3,exportSchema = false)
public abstract class CartItemsDatabase extends RoomDatabase {
    public static final int NUMBER_OF_THREADS = 1;

    public static final ExecutorService databaseWriteExecutor
            = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static volatile CartItemsDatabase instance;
    public abstract CartDao cartDao();
    private static final RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);

                    databaseWriteExecutor.execute(() -> {
                        CartDao cartDao = instance.cartDao();





                    });
                }
            };
    public static synchronized CartItemsDatabase getInstance(Context context)
    {
        if(instance==null){
            synchronized (CartItemsDatabase.class){
                instance= Room.databaseBuilder(context,CartItemsDatabase.class,"Cartdb_Database")
                        .fallbackToDestructiveMigration()
                        .addCallback(sRoomDatabaseCallback)
                        .build();
            }

        }
        return instance;
    }
}
