package com.example.willhero;

import java.io.Serializable;

public class currScoreSerialize implements Serializable {
    private int currentScore;

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getCurrentScore() {
        return currentScore;
    }
}
