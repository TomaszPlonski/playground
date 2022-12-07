package com.tplonski;

import com.tplonski.model.Game;
import com.tplonski.model.GameGenerator;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(Main::myTask, 0, 1, TimeUnit.SECONDS);
    }

        private static void myTask() {

            Game game = GameGenerator.generate();
            System.out.println(game.getFirstPlayer() + " - " + game.getSecondPlayer());
            System.out.println(game);
        }

}