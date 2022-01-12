package com.example.willhero;

import javafx.scene.image.ImageView;

import java.io.Serializable;

public class Chests implements Serializable {
    private boolean isOpened;
    private String type;
    private double positionX;
    private double positionY;
    private String imgPath;
    private transient ImageView chestImage;

    public void setType(String _type) {
        this.type = _type;
    }

    public void setOpened(boolean bool) {
        this.isOpened = bool;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public ImageView getChestImage() {
        return chestImage;
    }

    public void displayChest(){
        chestImage.setLayoutY(chestImage.getLayoutY() + 5);
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImgPath(){
        return imgPath;
    }
}
