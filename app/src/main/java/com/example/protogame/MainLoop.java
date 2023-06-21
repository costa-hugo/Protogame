package com.example.protogame;

import android.util.Log;

public class MainLoop {
    private final boolean debug = true;
    private Map map;
    private Player ply;
    private boolean game;

    private int newx, newy;

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
        * Play sounds from nearest check point according to distance and direction
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

        //MOVEMENT
        //Wall collision
        int r = 1;
        if (movement != 0) {
            r = checkWall(newDir, movement);
        }
        //Collision with cp and exit
        //TODO HERE

        //When everything is processed, move the player

        //Sound

        // DEBUG
        if (debug){
            map.display_map();
        }

    }
    private int checkWall(directions dir, int movement) {
        /*
        * Computes newx and newy and then check if there is a wall at this place or if outside of array
        * returns 0 if newx and newy can be used otherwise return 1
        */

        switch (dir) {
            case NORTH: {
                newx = ply.posx;
                newy = ply.posy - movement;
                break;
            }
            case SOUTH: {
                newx = ply.posx;
                newy = ply.posy + movement;
                break;
            }
            case EAST: {
                newx = ply.posx + movement;
                newy = ply.posy;
                break;
            }
            case WEST: {
                newx = ply.posx - movement;
                newy = ply.posy;
                break;
            }
        } //computed new coordinates based on the movement and dir

        if (newx < 0 || newy < 0 || newx > map.getMaxmapx() || newy > map.getMaxmapy()) {
            return 1;
        }

        return 0;
    }
}
