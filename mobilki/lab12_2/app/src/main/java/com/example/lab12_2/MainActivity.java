package com.example.lab12_2;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager mgr;
    private Sensor accelerometer;
    private TextView text;
    private float[] gravity= new float[3];
    private float[] motion= new float[3];
    private double ratio;
    private double mAngle;
    private  int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mgr= (SensorManager) this.getSystemService(SENSOR_SERVICE);
        accelerometer=mgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        text= (TextView) findViewById(R.id.text);
    }
    @Override
    protected void onResume()
    {
        mgr.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_UI);
        super.onResume();
    }
    @Override
    protected void onPause()
    {
        mgr.unregisterListener(this,accelerometer);
        super.onPause();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        for(int i=0;i<3;i++)
        {
            gravity[i]=(float) (0.1* sensorEvent.values[i]+0.9 *gravity[i]);
            motion[i]= sensorEvent.values[i]-gravity[i];
        }
        ratio= gravity[1]/SensorManager.GRAVITY_EARTH;
        if(ratio>1.0)
            ratio=1.0;
        if(ratio <-1.0)
            ratio=-1.0;
        mAngle= Math.toDegrees(Math.acos(ratio));
        if(gravity[2]<0)
            mAngle=-mAngle;
        if(counter++%10==0)
        {
            String msg=String.format("NIeprzetworzonr wartosci \n X: %8.4f\n Y: %8.4f\n Z: %8.4f\n "+"Składowa grawitacji \n X: %8.4f\n Y: %8.4f\n Z: %8.4f\n"+"Składowa ruchu \n X: %8.4f\n Y: %8.4f\n Z: %8.4f\nKąt: %8.1f",sensorEvent.values[0],sensorEvent.values[1],sensorEvent.values[2],gravity[0],gravity[1],gravity[2],motion[0],motion[1],motion[2],mAngle);
            text.setText(msg);
            text.invalidate();
            counter=1;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


}