package com.example.willhero;

import java.io.Serializable;

class ScoreandCoin implements Serializable {
    private int HighScore;
    private int TotalCoins;

    public void setHighScore(int highScore) {
        HighScore = highScore;
    }

    public void setTotalCoins(int totalCoins) {
        TotalCoins = totalCoins;
    }

    public int getHighScore() {
        return HighScore;
    }

    public int getTotalCoins() {
        return TotalCoins;
    }
}
