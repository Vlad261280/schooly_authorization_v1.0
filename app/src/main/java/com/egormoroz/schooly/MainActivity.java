package com.egormoroz.schooly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.egormoroz.schooly.ui.main.MainFragment;
import com.egormoroz.schooly.ui.news.NewsFragment;
import com.egormoroz.schooly.ui.people.PeopleFragment;
import com.egormoroz.schooly.ui.profile.ProfileFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView toolbarTitle = findViewById(R.id.toolbar_title);

        toolbarTitle.setText(getString(R.string.app_name));
        toolbarTitle.setTextColor(getColor(R.color.purple_300));
        setCurrentFragment(MainFragment.newInstance());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_nav_home:
                        setCurrentFragment(MainFragment.newInstance());
                        toolbarTitle.setText(getString(R.string.app_name));
                        toolbarTitle.setTextColor(getColor(R.color.purple_300));
                        return true;
                    case R.id.bottom_nav_news:
                        setCurrentFragment(NewsFragment.newInstance());
                        toolbarTitle.setText(getString(R.string.toolbar_news));
                        toolbarTitle.setTextColor(getColor(R.color.black));
                        return true;
                    case R.id.bottom_nav_people:
                        setCurrentFragment(PeopleFragment.newInstance());
                        toolbarTitle.setText(getString(R.string.toolbar_people));
                        toolbarTitle.setTextColor(getColor(R.color.black));
                        return true;
                    case R.id.bottom_nav_profile:
                        setCurrentFragment(ProfileFragment.newInstance());
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_top_nav, menu);
        return true;
    }

    private void setCurrentFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame, fragment);
        ft.commit();
    }
}