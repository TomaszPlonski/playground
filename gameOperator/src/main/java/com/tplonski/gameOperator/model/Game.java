package com.tplonski.gameOperator.model;

public class Game {

    private Players players;

    private Choices choices;


    public Game(Players players, Choices choices) {
        this.players = players;
        this.choices = choices;
    }

    public Players getPlayers() {
        return players;
    }

    public Choices getChoices() {
        return choices;
    }
}
