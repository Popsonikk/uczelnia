package com.example.pz_patryk_popek;

import static android.content.Context.ALARM_SERVICE;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class AddNotiFragment extends Fragment {

    Button timeButton,dateButton,addButton;
    DatePickerDialog datePickerDialog;
    EditText title;
    TextView textView;
    int year,month,day,hour,minute;
    public static final String klucz="klucz";
    public static final String klucz2="klucz2";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_noti, container, false);
        initDatePicker();
        timeButton=view.findViewById(R.id.timebutton);
        dateButton=view.findViewById(R.id.datePickerButton);
        title=view.findViewById(R.id.addNotiTitle);
        addButton=view.findViewById(R.id.AddNotiComfirm);
        textView= view.findViewById(R.id.textView3);
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener onTimeSetListener=new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        hour=selectedHour;
                        minute=selectedMinute;
                        timeButton.setText(String.format(Locale.getDefault(),"%02d:%02d",hour,minute));
                    }
                };
                TimePickerDialog timePickerDialog=new TimePickerDialog(v.getContext(),onTimeSetListener,hour,minute,true);
                timePickerDialog.setTitle("Select time");
                timePickerDialog.show();
            }
        });
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String notiName=title.getText().toString();
                Date date=new Date(year-1900,month,day,hour,minute);
                String timeText=date.toString();

                //textView.setText(date.toString());
                long time=date.getTime()-7200000;
                long now=System.currentTimeMillis();

               textView.setText(Long.toString(time-now));
               // Date today=Calendar.getInstance().getTime();
                //textView.setText(today.toString());
                Intent intent=new Intent(v.getContext(),ReminderBroadcast.class);
                intent.putExtra(klucz,notiName);
                intent.putExtra(klucz2,timeText);
                ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
                SQLiteDatabase database= contactDbHelper.getWritableDatabase();
                contactDbHelper.addNotiContact(notiName,timeText,database);
                contactDbHelper.close();
                title.setText("");
                PendingIntent pendingIntent= PendingIntent.getBroadcast(v.getContext(),0,intent,0);
                AlarmManager alarmManager=(AlarmManager) getActivity().getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP,time,pendingIntent);
                Toast.makeText(getActivity(), "Ustawiono Powiadomienie", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int selectedyear, int selectedmonth, int selectedday) {
                year=selectedyear;
                month=selectedmonth;
                day=selectedday;
                String date=makeDateString(day,month,year);
                dateButton.setText(date);
            }
        };
        Calendar cal=Calendar.getInstance();
        //int style= AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog=new DatePickerDialog(getContext(),dateSetListener,cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH));
    }
    private String makeDateString(int day,int month,int year)
    {
        return  day+"/"+month+"/"+year;
    }


}