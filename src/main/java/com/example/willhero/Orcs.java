package com.example.willhero;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.io.Serializable;

public class Orcs extends GameObjects implements Serializable {

    private boolean isKilled = false;
    private String imgPath;
    private int hitsLanded;
    private int health;
    private String type;
    private double posX;
    private double posY;
    private transient ImageView orcImage;

    public boolean getIsKilled(){
        return isKilled;
    }

    public void kill() {
        isKilled = true;
    }

    public void setType(String _type) {
        this.type = _type;
    }

    public String getType(){
        return type;
    }

    public void setIsKilled() {
        this.isKilled = true;
    }

    public void setHitsLanded(int _hitsLanded) {
        this.hitsLanded = _hitsLanded;
    }

    public ImageView getOrcImage(){
        return orcImage;
    }

    public void display(){
        orcImage.setLayoutY(orcImage.getLayoutY() + 5);
    }

    public void setImgPath(String path){
        this.imgPath = path;
    }

    public String getImgPath(){
        return imgPath;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public Orcs(String _type, int _health, double X, double Y){
        super(X, Y);
        this.type = _type;
        this.health = _health;
        this.posX = X;
        this.posY = Y;
    }

    public Group generateObjects(){
        Group group = new Group();
        Orcs orc = new Orcs("green", 2, 15, 20);

        return group;
    }

    public double getPositionY() {
        return 0;
    }


    @Override
    public boolean collision(GameObjects helmet) {
        return false;
    }
}
