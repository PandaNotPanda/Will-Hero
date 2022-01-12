package com.example.willhero;

import java.io.Serializable;

public abstract class GameObjects implements Serializable {

    public GameObjects(double x, double y) {
    }

    public abstract boolean collision(GameObjects helmet);
}
