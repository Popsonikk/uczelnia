package com.example.pz_patryk_popek;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ReminderBroadcast extends BroadcastReceiver {
    public String timeText,text;
    @Override
    public void onReceive(Context context, Intent intent) {
        text=intent.getStringExtra(AddNotiFragment.klucz);
        timeText=intent.getStringExtra(AddNotiFragment.klucz2);
        ContactDbHelper contactDbHelper=new ContactDbHelper(context.getApplicationContext());
        SQLiteDatabase database=contactDbHelper.getWritableDatabase();
        contactDbHelper.deleteNotiContact(text,database);
        contactDbHelper.close();

        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,"notify")
                .setContentTitle(text)
                .setContentText(timeText)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setSmallIcon(android.R.drawable.ic_dialog_info) ;
        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(context);
        managerCompat.notify(200,builder.build());



    }


}
