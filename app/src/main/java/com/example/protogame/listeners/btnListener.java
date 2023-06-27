package com.example.protogame.listeners;

import android.view.View;

import com.example.protogame.MainActivity;
import com.example.protogame.R;
import com.example.protogame.directions;

public class btnListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        int newMov;

        if (v.getId() == R.id.btnFwrd) {
            newMov = 1;
        } else {
            newMov = -1;
        }

        MainActivity.getGame().update(directions.NO_CHANGE, newMov);
    }
}
