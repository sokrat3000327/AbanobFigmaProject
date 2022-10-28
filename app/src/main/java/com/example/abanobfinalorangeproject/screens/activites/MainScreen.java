package com.example.abanobfinalorangeproject.screens.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.abanobfinalorangeproject.R;
import com.example.abanobfinalorangeproject.screens.fragments.AccountFragment;
import com.example.abanobfinalorangeproject.screens.fragments.ExploreFragment;
import com.example.abanobfinalorangeproject.screens.fragments.FavouriteFragment;
import com.example.abanobfinalorangeproject.screens.fragments.MyCartFragment;
import com.example.abanobfinalorangeproject.screens.fragments.ShopItemFragment;



import com.google.android.material.bottomnavigation.BottomNavigationView;

/*
this screen contains all the 5 fragments
explore,shop,cart,favourite,account
 */
public class MainScreen extends AppCompatActivity {
//    List<Product> myLocalData=new ArrayList<>();
//    CategoryPageModel myLocalData2=new CategoryPageModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);



        // this code refer to bottom navigation bar
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_nav);
        // this code refer to when selected an item in the navigation bar this will lead to the selected fragment
        bottomNavigationView.setOnNavigationItemReselectedListener(item -> {
            Fragment selectedFragment=null;
            int id=item.getItemId();
            if(id==R.id.shop){
                selectedFragment= ShopItemFragment.newInstance();
            }
            else if(id== R.id.cart){
                selectedFragment= MyCartFragment.newInstance();

            }
            else if(id == R.id.favourite){
                selectedFragment= FavouriteFragment.newInstance();
            }
            else if(id == R.id.explore){
                selectedFragment= ExploreFragment.newInstance();
            }
            else if(id==R.id.account){
                selectedFragment= AccountFragment.newInstance();
            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.myFragment, selectedFragment)
                    .commit();
        });
    }
}