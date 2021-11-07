package com.animesafar.carrental.mainpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.animesafar.carrental.R;
import com.animesafar.carrental.fragments.Searchfragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Mainpage extends AppCompatActivity {

    FrameLayout frameLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bnv);
        bottomNavigationView.setOnItemSelectedListener(bottomNavigation);


    }

  private   BottomNavigationView.OnItemSelectedListener bottomNavigation = new BottomNavigationView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment=null;
if(item.getItemId() == R.id.search){
    fragment = new Searchfragment();
}

getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment).commit();
            return false;
        }
    };


}