package com.example.protogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import com.example.protogame.listeners.btnListener;

/*Prototype explaination
* My idea is that we have buttons and sensors, whenever we change on of them we update the game with a new state.
* Makes it easier fast and good enough for a prototype
* */

public class MainActivity extends AppCompatActivity {

    private static MainLoop game;
    private SensorManager sensorManager;
    private Sensor sensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);


        game = new MainLoop(new Player(directions.NORTH, 2, 2), 10, 10);
        btnListener b =new btnListener();
        findViewById(R.id.btnFwrd).setOnClickListener(b);
        findViewById(R.id.btnBwrd).setOnClickListener(b);
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