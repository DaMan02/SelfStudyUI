package com.innovvscript.selfstudyui;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private List<Subject> subjectsList;
    private RecyclerView recyclerView;
    private SubjectsAdapter subjectsAdapter;
    private ColorStateList colorStateList;
    private  BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("SelfStudy");

        initNav(toolbar);
        subjectsList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view_id);
        setUpRecyclerView();

        addItemToList("Mental Ability",R.drawable.ic_idea,"0");
        addItemToList("Physics",R.drawable.ic_physics,"0");
        addItemToList("Chemistry",R.drawable.ic_chemistry,"0.71");
        addItemToList("Mathematics",R.drawable.ic_maths,"0");

    }

    private void setUpRecyclerView() {

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        subjectsAdapter = new SubjectsAdapter(subjectsList);
        recyclerView.setAdapter(subjectsAdapter);
        subjectsAdapter.notifyDataSetChanged();
    }

    private void addItemToList(String title,int drawable, String percent) {
        Subject sub = new Subject();
        sub.setTitle(title);
        sub.setResource(drawable);
        sub.setPercent(percent);
        subjectsList.add(sub);

    }

    private void initNav(Toolbar toolbar) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


//        bottomNavigation ColorStateList
        colorStateList = new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_checked},
                },
                new int[] {
                       R.color.blueText,
                }
        );
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

//            bottomNavigationView.setBackgroundColor(Color.WHITE);
//            navigation.setItemBackgroundResource(android.R.color.white);
//            navigation.setItemTextColor(colorStateList);
//            navigation.setItemIconTintList(colorStateList);

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_tests:
                    return true;
                case R.id.navigation_analysis:
                    return true;
                case R.id.navigation_doubts:
                    return true;
                case R.id.navigation_profile:
                    return true;
            }
            return false;
        }
    };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
