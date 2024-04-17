package com.example.lab8_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button simpleNoti,betterNoti,actionNoti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleNoti=(Button) findViewById(R.id.SimpleNoti);
        betterNoti=(Button) findViewById(R.id.BetterNoti);
        actionNoti=(Button) findViewById(R.id.ActionNoti);
        simpleNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpleNotofication();
            }
        });
        betterNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 betterNotification();
            }
        });
        actionNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 actionNotification();
            }
        });
    }
    private  void simpleNotofication()
    {
        Intent intent=new Intent(this,Rezultat.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,0);
        Bitmap icon= BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background);
        String chanel_id="1";
        NotificationChannel mChannel=null;
        mChannel=new NotificationChannel(chanel_id,"powiadomienie proste", NotificationManager.IMPORTANCE_LOW);
        mChannel.enableLights(true);
        mChannel.setLightColor(Color.BLUE);
        Notification notification= new NotificationCompat.Builder(this,chanel_id).setContentTitle("new noti").setContentText("helo , im simple noti").setTicker("hello").setSmallIcon(R.drawable.ic_launcher_foreground).setLargeIcon(icon).setContentIntent(pendingIntent).setPriority(NotificationCompat.PRIORITY_MAX).build();
        NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(mChannel);
        notificationManager.notify(0,notification);

    }
    private void betterNotification()
    {
        Intent intent=new Intent(this,Rezultat.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,0);
        Bitmap icon= BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background);
        String[] pozycjaWiadomosci= new String[3];
        pozycjaWiadomosci[0]="pirewsze rozszerzenie";
        pozycjaWiadomosci[1]="drugie rozszerzenie";
        pozycjaWiadomosci[2]="trzecie rozszerzenie";
        String chanel_id="2";
        NotificationChannel mChannel=null;
        mChannel=new NotificationChannel(chanel_id,"powiadomienie rozszerzone", NotificationManager.IMPORTANCE_LOW);
        mChannel.enableLights(true);
        mChannel.setLightColor(Color.BLUE);
        NotificationCompat.InboxStyle inboxStyle=new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("Pozycje wiadomosci");
        for(int i=0;i<pozycjaWiadomosci.length;i++)
        {
            inboxStyle.addLine(pozycjaWiadomosci[i]);
        }
        Notification notification= new NotificationCompat.Builder(this,chanel_id).setContentTitle("new noti").setContentText("helo , im simple noti").setTicker("hello").setStyle(inboxStyle).setSmallIcon(R.drawable.ic_launcher_foreground).setLargeIcon(icon).setContentIntent(pendingIntent).setPriority(NotificationCompat.PRIORITY_MAX).build();
        NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(mChannel);
        notificationManager.notify(0,notification);

    }
    private void actionNotification()
    {
        Intent intent=new Intent(this,Rezultat.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,0);
        Bitmap icon= BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background);
        Intent actionIntent=new Intent(this,Rezultat.class);
        PendingIntent pedingActionIntent=PendingIntent.getActivity(this,0,actionIntent,0);
        String chanel_id="3";
        NotificationChannel mChannel=null;
        mChannel=new NotificationChannel(chanel_id,"powiadomienie akcja", NotificationManager.IMPORTANCE_LOW);
        mChannel.enableLights(true);
        mChannel.setLightColor(Color.BLUE);
        Notification notification= new NotificationCompat.Builder(this,chanel_id).setContentTitle("new noti").
                setContentText("helo , im simple noti").
                setTicker("hello").setSmallIcon(R.drawable.ic_launcher_foreground).
                setLargeIcon(icon).setContentIntent(pendingIntent).
                setPriority(NotificationCompat.PRIORITY_MAX).
                addAction(R.drawable.ic_launcher_background,"akcja",pendingIntent).build();
        NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(mChannel);
        notificationManager.notify(0,notification);
    }

}