package com.example.navdrawertut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

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
        MainActivity.redirectActivity(this, MainActivity.class);
    }

    public void ClickDashboard(View view){

        MainActivity.redirectActivity(this, Dashboard.class);
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
//Teoretycznie pwinno działać, w praktyce pewnie się wykrzaczy