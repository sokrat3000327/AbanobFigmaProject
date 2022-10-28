package com.example.abanobfinalorangeproject.data.data_app.favourite_data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favourite_table")
public class FavouriteEntity {

    @PrimaryKey(autoGenerate = true)
    private int id ;

    private String title ;
    private Double price;
    private String img ;



    public FavouriteEntity(String title, Double price, String img) {
        this.title = title;
        this.price = price;
        this.img = img;

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Double price) {
        this.price = price;
    }



    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }


}
