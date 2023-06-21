package com.example.protogame;

import android.util.Log;

public class Map {
    private char[][] maparr;
    private int maxmapx, maxmapy;
    private Player ply;

    private int[][] cpList;
    private int maxCp;
    private int currCp;

    public static final char ply_ico = 'o';
    public static final char wall_ico = 'x';
    public static final char cp_ico = '*';
    public static final char exit_ico = 'x';
    public static final char blank = ' ';

    public Map(int width, int height, Player ply) {
        maxmapx = width;
        maxmapy = height;
        this.ply = ply;

        maparr = new char[width][height];
        for (int x = 0; x < maxmapx; x++) {
            for (int y = 0; y < maxmapy; y++) {
                maparr[x][y] = ' ';
            }
        }
    }

    public int getMaxmapx() {
        return maxmapx;
    }

    public int getMaxmapy() {
        return maxmapy;
    }

    public int[][] getCpList() {
        return cpList;
    }

    public int getMaxCp() {
        return maxCp;
    }

    public int getCurrCp() {
        return currCp;
    }
    public void advanceCp() {
        currCp = currCp + 1 <= maxCp ? currCp++ : currCp;
        //add the new cp
        maparr[cpList[currCp][0]][cpList[currCp][1]] = cp_ico; //allow me to explain -> we take the element at position x = current checkpoint x and position Y = current checkpoint y then replace that with cp_ico
        //the old cp_ico will get deleted by the ply_ico since the function must only be called when the player steps on the cp_ico
    }
    public void mvPly(int x, int y) {
        /*
        * Moves the player and changes its coordinates
        */
        maparr[x][y] = ply_ico;
        maparr[ply.posx][ply.posy] = blank;
        ply.posx = x;
        ply.posy = y;
    }

    public void display_map() {
        String buff = "";
        for (int y = 0; y < maxmapy; y++) {
            for (int x = 0; x < maxmapx; x++) {
                if (x == ply.posx && y == ply.posy) {
                    buff += ply_ico;
                } else {
                    buff +=maparr[x][y];
                }
            }
            Log.d("Map", buff);
            buff = "";
        }
    }
}
