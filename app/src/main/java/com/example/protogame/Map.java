package com.example.protogame;

import android.util.Log;

public class Map {
    private char[][] maparr;
    private int maxmapx, maxmapy;
    private Player ply;

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

    public void display_map() {
        String buff = "";
        for (int y = 0; y < maxmapy; y++) {
            for (int x = 0; x < maxmapx; x++) {
                if (x == ply.posx && y == ply.posy) {
                    buff += 'o';
                } else {
                    buff +=maparr[x][y];
                }
            }
            Log.d("Map", buff);
            buff = "";
        }
    }
}
