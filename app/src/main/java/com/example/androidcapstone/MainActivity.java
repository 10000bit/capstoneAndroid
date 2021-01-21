package com.example.androidcapstone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.androidcapstone.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment;
    ArticleMenuFragment articleMenuFragment;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // 프래그먼트 생성
        homeFragment = new HomeFragment();
        articleMenuFragment = new ArticleMenuFragment();

        // 제일 먼저 띄워줄 뷰 세팅
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,homeFragment).commitAllowingStateLoss();

        // bottomnavigationview의 아이콘을 선택 했을때 원하는 프래그먼트가 띄워질 수 있도록 리스너를 추가
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.tab1:{
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_layout, homeFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.tab2:{
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_layout, articleMenuFragment).commitAllowingStateLoss();
                        return true;
                    }


                    default: return false;
                }




            }
        });

    }
}