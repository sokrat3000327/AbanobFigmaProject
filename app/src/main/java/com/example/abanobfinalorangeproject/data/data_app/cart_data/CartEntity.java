package com.example.abanobfinalorangeproject.data.data_app.cart_data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cart_table")
public class CartEntity {

    @PrimaryKey(autoGenerate = true)
    private int id ;


    private String title ;
    private String img ;
    private Double price;


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }




    public CartEntity(String title, String img, Double price) {
        this.title = title;
        this.img = img;
        this.price = price;
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
