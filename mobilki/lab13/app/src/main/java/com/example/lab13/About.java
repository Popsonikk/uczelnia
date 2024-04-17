package com.example.lab13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class About extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view){
        MainActivity.openDrawer(drawerLayout); //trzeba na statyczna zmienic, git
    }

    public void ClickLogo(View view){
        MainActivity.closeDrawer(drawerLayout); // :)))))))
    }

    public void ClickHome(View view){
        Intent intent= new Intent(About.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void ClickDashboard(View view){

        Intent intent= new Intent(About.this,Dashboard.class);
        startActivity(intent);
        finish();
    }

    public void About(View view){//tylko tu robimy podmiankę
        recreate();
    }

    public void ClickLogout(View view){
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }
}