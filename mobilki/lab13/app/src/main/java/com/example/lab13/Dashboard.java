package com.example.lab13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    //Niestety szuflade trzeba obsłużyć w każdej aktywności...

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        drawerLayout = findViewById(R.id.drawer_layout);

    }

    public void ClickMenu(View view){
        MainActivity.openDrawer(drawerLayout); //trzeba na statyczna zmienic, git
    }

    public void ClickLogo(View view){
        MainActivity.closeDrawer(drawerLayout); // :)))))))
    }

    public void ClickHome(View view){
        Intent intent= new Intent(Dashboard.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void ClickDashboard(View view){
        recreate();

    }

    public void About(View view){
        Intent intent= new Intent(Dashboard.this,MainActivity.class);
        startActivity(intent);
        finish();
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