package com.example.protogame;

import android.util.Log;

public class MainLoop {
    private final boolean debug = true;
    private Map map;
    private Player ply;
    private boolean game;

    MainLoop(Player ply, int mapwidth, int mapheight) {
        this.ply = ply;
        this.map = new Map(mapwidth, mapheight, ply);

        game=true;
    }

    public void update(directions newDir, int movement, boolean makesSound) {// updates the state of the game with provided information, should be called when there is an input

        /*
        * When called ->
        * Process new direction
        * Process movement by checking collision and moving the character
        * if player makes sound, compute distance to wall and compute sound loudness
        * (print debug messages)
        * (Print debug map)*/

        // DEBUG
        map.display_map();
    }
}
