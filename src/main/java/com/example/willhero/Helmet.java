package com.example.willhero;

import javafx.scene.shape.Rectangle;

import java.io.Serializable;

public class Helmet extends Rectangle {

    private String weapon;
    private boolean isDead;
    private boolean hasWeapon;
    private int score;
    private boolean posX;
    private boolean posY;
    private Rectangle hero;

    public void setHasWeapon(boolean hasWeapon) {
        this.hasWeapon = hasWeapon;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void incScore(){
        this.score += 1;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    Helmet(int x, int y, double posX, double posY){
        super(posX, posY);
        setTranslateX(x);
        setTranslateY(y);
    }

    public void dash(){
        setTranslateX(getTranslateX() - 5);
    }
}
