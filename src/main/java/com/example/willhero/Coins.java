package com.example.willhero;

import javafx.scene.image.ImageView;
import java.io.Serializable;

public class Coins implements Serializable {
    private boolean isCollected;
    private double position;
    private String imgPath;
    private transient ImageView coinImage;

    public boolean getIsCollected(){
        return isCollected;
    }

    public void setIsCollected(boolean _isCollected){
        this.isCollected = _isCollected;
    }

    public Coins(double _position, ImageView img){
        position = _position;
        coinImage = img;
        isCollected = false;
        imgPath = coinImage.getImage().getUrl();
    }

    public void setCoinImg(ImageView _coinImage) {
        this.coinImage = _coinImage;
    }

    public ImageView getCoinImage() {
        return coinImage;
    }

    public void display(){
        coinImage.setLayoutY(coinImage.getLayoutY() + 5);
    }

    public double getPosition(){
        return position;
    }

    public void setImgPath(String path){
        this.imgPath = path;
    }

    public String getImgPath(){
        return imgPath;
    }
}
