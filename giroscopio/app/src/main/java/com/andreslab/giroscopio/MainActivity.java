package com.andreslab.giroscopio;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    TextView x,y,z;
    Sensor magnetometro, giroscopio; //add sensor magnetometro
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x = (TextView)findViewById(R.id.idx);
        y = (TextView)findViewById(R.id.idy);
        z = (TextView)findViewById(R.id.idz);

        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        giroscopio = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        magnetometro = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD); //add sensor
        sm.registerListener(this, giroscopio, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this, magnetometro, SensorManager.SENSOR_DELAY_NORMAL); //add sensor
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        //one sensor
        /*x.setText("sensor x: "+ event.values[0]);
        y.setText("sensor y: "+ event.values[1]);
        z.setText("sensor z: "+ event.values[2]);*/

        //add multisensor
        switch (event.sensor.getType()){
            case Sensor.TYPE_MAGNETIC_FIELD :
                /*x.setText("sensor x: "+ event.values[0]);
                y.setText("sensor y: "+ event.values[1]);
                z.setText("sensor z: "+ event.values[2]);*/
                break;
            case Sensor.TYPE_GYROSCOPE:
                x.setText("sensor x: "+ event.values[0]);
                y.setText("sensor y: "+ event.values[1]);
                z.setText("sensor z: "+ event.values[2]);
                break;
            default:
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
