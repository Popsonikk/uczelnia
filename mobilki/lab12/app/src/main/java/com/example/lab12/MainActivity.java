package com.example.lab12;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mgr;
    private Sensor light;
    private TextView text;
    private StringBuilder msg= new StringBuilder(2048);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mgr =(SensorManager) this.getSystemService(SENSOR_SERVICE);
        light= mgr.getDefaultSensor(Sensor.TYPE_LIGHT);
        text=(TextView) findViewById(R.id.text);
    }
    @Override
    protected void onResume()
    {
        mgr.registerListener(this,light,SensorManager.SENSOR_DELAY_NORMAL);
        super.onResume();
    }
    @Override
    protected void onPause()
    {
        mgr.unregisterListener(this,light);
        super.onPause();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        msg.insert(0,"Getting info from sensor "+ sensorEvent.values[0]+" lux\n");
        text.setText(msg);
        text.invalidate();

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        msg.insert(0,sensor.getName()+" Accuracy changed: "+accuracy+(accuracy==1?" (LOW)":(accuracy==2?" (MIDDLE)":" (HIGH)"))+"\n");
        text.setText(msg);
        text.invalidate();


    }
}