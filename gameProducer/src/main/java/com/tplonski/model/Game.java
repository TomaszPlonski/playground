package com.tplonski.model;

public class Game {

    private String firstPlayer;
    private String secondPlayer;

    private RockPaperScissors firstPlayerChoice;
    private RockPaperScissors secondPlayerChoice;

    public Game(String firstPlayer, String secondPlayer, RockPaperScissors firstPlayerChoice, RockPaperScissors secondPlayerChoice) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.firstPlayerChoice = firstPlayerChoice;
        this.secondPlayerChoice = secondPlayerChoice;
    }

    public String getFirstPlayer() {
        return firstPlayer;
    }

    public String getSecondPlayer() {
        return secondPlayer;
    }

    public RockPaperScissors getFirstPlayerChoice() {
        return firstPlayerChoice;
    }

    public RockPaperScissors getSecondPlayerChoice() {
        return secondPlayerChoice;
    }

    @Override
    public String toString() {
        return "Game{" +
                "firstPlayer='" + firstPlayer + '\'' +
                ", secondPlayer='" + secondPlayer + '\'' +
                ", firstPlayerChoice=" + firstPlayerChoice +
                ", secondPlayerChoice=" + secondPlayerChoice +
                '}';
    }
}
