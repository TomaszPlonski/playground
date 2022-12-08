package com.tplonski.business;


import com.tplonski.model.Choices;
import com.tplonski.model.Game;
import com.tplonski.model.Players;
import com.tplonski.model.RockPaperScissors;

import java.security.SecureRandom;
import java.util.*;

public class GameGenerator {

    private static final SecureRandom RANDOM = new SecureRandom();

   final static List<String> players =List.of("Alan","Bob","Cyryl","Daniel","Edgar","Filip","Greg","Helen",
            "Igor","Jen","Kate","Lois","Meg","Norman","Olivier","Paul","Rob","Steve","Tim","Ula","Wendy","Zac");

    public static Game generate(){

        List<String> activePlayers = getActivePlayers();
        return new Game(new Players(activePlayers.get(0),activePlayers.get(1)),
                new Choices(randomChoice(RockPaperScissors.class), randomChoice(RockPaperScissors.class)));
    }

    public static List<String> getActivePlayers(){

        List<String> copyOfPlayers = new java.util.ArrayList<>(List.copyOf(players));

        List<String> activePlayers = new ArrayList<>();
        int randomFirst = RANDOM.nextInt(copyOfPlayers.size());
        activePlayers.add(copyOfPlayers.remove(randomFirst));

        int randomSecond = RANDOM.nextInt(copyOfPlayers.size());
        activePlayers.add(copyOfPlayers.remove(randomSecond));

        Collections.sort(activePlayers);

        return activePlayers;
    }


    public static <T extends Enum<?>> T randomChoice(Class<T> clazz){
        int x = RANDOM.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }


}
