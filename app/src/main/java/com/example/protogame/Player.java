package com.example.protogame;

public class Player {
    private directions dir;
    private int movecount;
    public int posx, posy;


    public Player(directions default_dir, int default_x, int default_y) {
        this.dir = default_dir;
        this.posx = default_x;
        this.posy = default_y;

        movecount = 0;
    }
}
