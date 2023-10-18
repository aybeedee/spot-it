//package com.ramish.f200433_3;
//
//
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentTransaction;
//import android.os.Bundle;
//import android.view.MenuItem;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//
//public class bottom_navigation_bar extends AppCompatActivity {
//    BottomNavigationView navbar;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_bottom_navigation_bar);
//        navbar=findViewById(R.id.navbar);
//
//        navbar.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Fragment selected=null;
//                int itemid=item.getItemId();
//                if(itemid==R.id.home){
//                    replaceFrag(new HomeFragment());
//                }
//            }
//        });
//
//    }
//}