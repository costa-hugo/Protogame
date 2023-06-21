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

    public void update(directions newDir, int movement) {// updates the state of the game with provided information, should be called when there is an input

        /*
        * When called ->
        * Process new direction
        * Process movement by checking collision and moving the character
        * if player makes sound, compute distance to wall and compute sound loudness
        * (print debug messages)
        * (Print debug map)
        */

        /* map legend
        * o = player
        * # is wall
        * * = checkpoint
        * x = exit
        *
        * Remember, map is a 2D array of char:
        * These symboles are in the map, blank spaces are considered free space*/

        //Process direction
        if (newDir != directions.NO_CHANGE) {
            ply.dir = newDir;
        }
        // DEBUG
        map.display_map();
    }
}
