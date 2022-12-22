package com.tplonski.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @ParameterizedTest(name = "firstPlayerChoice={0}, secondPlayerChoice={1}, result={2}")
    @CsvSource(value = {"PAPER, ROCK, true",  "SCISSORS, PAPER, true", "ROCK, SCISSORS, true",
            "ROCK, PAPER, false",  "PAPER, SCISSORS, false", "SCISSORS, ROCK, false"})
    void should_Return_true_or_False_if_First_player_is_a_Winner(String firstPlayerChoice, String secondPlayerChoice, Boolean result) {
        //given
        Game game = new Game();
        game.setFirstPlayerChoice(RockPaperScissors.valueOf(firstPlayerChoice));
        game.setSecondPlayerChoice(RockPaperScissors.valueOf(secondPlayerChoice));

        //when
        game.setIsFirstPlayerAWinner();

        //then
        assertEquals(game.getIsFirstPlayerAWinner(),result);

    }

    @ParameterizedTest(name = "firstPlayerChoice={0}, secondPlayerChoice={1}")
    @CsvSource(value = {"ROCK, ROCK", "PAPER, PAPER", "SCISSORS, SCISSORS"})
    void should_Return_null_if_both_choices_are_same(String firstPlayerChoice, String secondPlayerChoice) {
        //given
        Game game = new Game();
        game.setFirstPlayerChoice(RockPaperScissors.valueOf(firstPlayerChoice));
        game.setSecondPlayerChoice(RockPaperScissors.valueOf(secondPlayerChoice));

        //when
        game.setIsFirstPlayerAWinner();

        //then
        assertNull(game.getIsFirstPlayerAWinner());

    }
}