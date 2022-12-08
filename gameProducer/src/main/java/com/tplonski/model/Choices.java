package com.tplonski.model;

public class Choices {

    public Choices(RockPaperScissors firstPlayerChoice, RockPaperScissors secondPlayerChoice) {
        this.firstPlayerChoice = firstPlayerChoice;
        this.secondPlayerChoice = secondPlayerChoice;
    }

    private RockPaperScissors firstPlayerChoice;

    private RockPaperScissors secondPlayerChoice;



    public RockPaperScissors getFirstPlayerChoice() {
        return firstPlayerChoice;
    }


    public RockPaperScissors getSecondPlayerChoice() {
        return secondPlayerChoice;
    }

}
