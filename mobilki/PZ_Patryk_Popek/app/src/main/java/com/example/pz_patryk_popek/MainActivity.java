package com.example.pz_patryk_popek;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MenuFragment.ChooseFragment{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container)!=null)
        {
            if(savedInstanceState!=null)
                return;
            StartFragment startFragment=new StartFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,startFragment).commit();
        }
        createNotificationChannel();
    }
    private void createNotificationChannel()
    {

            CharSequence name="NotificationChannel";
            int importance= NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel=new NotificationChannel("notify",name,importance);

            NotificationManager notificationManager= getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
    }

    @Override
    public void takeFragment(int i) {
        switch (i)
        {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AddFragment()).addToBackStack(null).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ShowFragment()).addToBackStack(null).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new UpdateFragment()).addToBackStack(null).commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new DeleteFragment()).addToBackStack(null).commit();
                break;
            case 4:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MenuFragment()).addToBackStack(null).commit();
                break;
            case 5:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MenuNotiFragment()).addToBackStack(null).commit();
                break;
            case 6:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AddNotiFragment()).addToBackStack(null).commit();
                break;
            case 7:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShowNotiFragment()).addToBackStack(null).commit();
                break;

        }

    }

}