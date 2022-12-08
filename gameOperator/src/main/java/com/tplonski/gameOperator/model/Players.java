package com.tplonski.gameOperator.model;

public class Players {

    private String firstPlayer;

    private String secondPlayer;

    public Players(String firstPlayer, String secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public String getFirstPlayer() {
        return firstPlayer;
    }


    public String getSecondPlayer() {
        return secondPlayer;
    }

}
