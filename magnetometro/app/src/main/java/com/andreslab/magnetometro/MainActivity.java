package com.andreslab.magnetometro;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView x,y,z;
    Sensor sensor;
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x = (TextView)findViewById(R.id.idx);
        y = (TextView)findViewById(R.id.idy);
        z = (TextView)findViewById(R.id.idz);

        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sm.registerListener(this,sensor, SensorManager.SENSOR_DELAY_NORMAL);//para que trabaje
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x.setText("sensor en x: " + String.valueOf(event.values[0]));
        y.setText("sensor en y: " + String.valueOf(event.values[1]));
        z.setText("sensor en z: " + String.valueOf(event.values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
