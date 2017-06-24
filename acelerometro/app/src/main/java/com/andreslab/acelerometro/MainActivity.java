package com.andreslab.acelerometro;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView x,y,z;
    Sensor acelerometro; //clase generica de sensores
    SensorManager sm;
    List<Sensor> sensors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x = (TextView)findViewById(R.id.idx);
        y = (TextView)findViewById(R.id.idy);
        z = (TextView)findViewById(R.id.idz);

        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensors = sm.getSensorList(Sensor.TYPE_ACCELEROMETER);

        if(sensors.size()>0){
            sm.registerListener((SensorEventListener)this, sensors.get(0),SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //se manda a llamar cuando lso valores del sensor cambian
        /*x.setText("valor de x: "+event.values[SensorManager.DATA_X]);
        y.setText("valor de y: "+event.values[SensorManager.DATA_Y]);
        z.setText("valor de z: "+event.values[SensorManager.DATA_Z]);*/


        x.setText("valor de x: "+event.values[0]);
        y.setText("valor de y: "+event.values[1]);
        z.setText("valor de z: "+event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
