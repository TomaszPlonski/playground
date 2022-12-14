package com.tplonski.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="games")
public class Game {

    @Id
    @GeneratedValue
    private Long gameId;

    private String firstPlayer;

    private String secondPlayer;

    @Enumerated(EnumType.STRING)
    private RockPaperScissors firstPlayerChoice;

    @Enumerated(EnumType.STRING)
    private RockPaperScissors secondPlayerChoice;

    private Boolean isFirstPlayerAWinner;



}
