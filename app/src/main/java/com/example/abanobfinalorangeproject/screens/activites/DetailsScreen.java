package com.example.abanobfinalorangeproject.screens.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.abanobfinalorangeproject.R;
import com.example.abanobfinalorangeproject.data.data_app.favourite_data.FavouriteEntity;
import com.example.abanobfinalorangeproject.model.ProductViewModle;


public class DetailsScreen extends AppCompatActivity {
    TextView name, price, description;
    ImageView image, favouriteImage;
    String nameOfFavoItem, imgOfFavoItem, catOfFav;
    double priceOfFavoItem;
    ProductViewModle productViewModle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_screen);
//        favoDatabase=FavoDatabase.getInstance(this);
        productViewModle = new ViewModelProvider.AndroidViewModelFactory(DetailsScreen.this.getApplication()).create(ProductViewModle.class);


        ///////////////
        name = findViewById(R.id.shop_name);
        price = findViewById(R.id.details_price);
        description = findViewById(R.id.details_description);
        image = findViewById(R.id.details_image);
        favouriteImage = findViewById(R.id.details_favourite);

        //////////////////

        nameOfFavoItem = getIntent().getExtras().get("detail_name").toString();
        priceOfFavoItem = (double) getIntent().getExtras().get("detail_price");
        catOfFav = getIntent().getExtras().get("detail_category").toString();
        imgOfFavoItem = getIntent().getExtras().get("detail_img").toString();
        name.setText(nameOfFavoItem);
        price.setText(String.valueOf(priceOfFavoItem));
        description.setText(getIntent().getExtras().get("detail_description").toString());
        Glide.with(this).load(imgOfFavoItem).into(image);


        favouriteImage.setOnClickListener(
                view -> {
                    favouriteImage.setColorFilter(Color.RED);
                    FavouriteEntity favoItem = new FavouriteEntity(nameOfFavoItem, priceOfFavoItem, imgOfFavoItem);
                    ProductViewModle.insertFavo(favoItem);
                }

        );


    }
}