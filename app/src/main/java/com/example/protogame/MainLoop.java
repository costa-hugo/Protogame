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

        int[] currentCpXY = map.getCpList()[map.getCurrCp()]; //Collision with cp and exit, might be useful multiple times

        //Process direction
        System.out.println(newDir);
        if (newDir != directions.NO_CHANGE) {
            System.out.println("Changing direction");
            ply.dir = newDir;
        }
        System.out.println("UwU ?");
        //MOVEMENT
        //Wall collision
        System.out.println(movement);
        int r = 1;
        if (movement != 0) {
            System.out.println("Checking for wall");
            r = checkWall(ply.dir, movement);
        }

        System.out.println(r);

        if (r == 0) {
            //r is 0 only and only if checkWall as returned 0 which mean newx and newy should be used, else we skip the collision check for cp and exit as newx and newy should not be used


             //get the current cp from the cp list
            if (newx == currentCpXY[0] && newy == currentCpXY[1]) { //check if we are on the cp
                map.advanceCp();
            }

            //When everything is processed, move the player
            map.mvPly(newx, newy);
        }

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
        System.out.println(newx);
        System.out.println(newy);
        if (newx < 0 || newy < 0 || newx >= map.getMaxmapx() || newy >= map.getMaxmapy()) {
            return 1;
        }

        return 0;
    }
}
