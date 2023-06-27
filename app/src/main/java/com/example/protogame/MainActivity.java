package com.example.protogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

/*Prototype explaination
* My idea is that we have buttons and sensors, whenever we change on of them we update the game with a new state.
* Makes it easier fast and good enough for a prototype
* */

public class MainActivity extends AppCompatActivity {

    private MainLoop game;
    private SensorManager sensorManager;
    private Sensor sensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);


        game = new MainLoop(new Player(directions.NORTH, 2, 2), 10, 10);
    }

    /**
     * TODO:
     * Add the listeners for the buttons
     * Figure out a way to detect accelerometer and shake for direction and sound input
     */

    public static MainLoop getGame() {
        return game;
    }
}