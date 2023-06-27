package com.example.protogame.listeners;

import android.view.View;

import com.example.protogame.MainActivity;
import com.example.protogame.R;
import com.example.protogame.directions;

public class btnListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        int newDir;

        if (v.getId() == R.id.btnFwrd) {
            newDir = 1;
        } else {
            newDir = -1;
        }


        MainActivity.getGame().update(directions.NO_CHANGE, 0);
    }
}
