package com.tplonski.mapper;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tplonski.model.Game;
import com.tplonski.model.RockPaperScissors;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class consumeToGameMapperImplTest {

    @Test
    void should_parse_Json_to_String(){
        //given
        String string = "    {\n" +
                "       \"firstPlayer\":\"Alan\",\n" +
                "       \"secondPlayer\":\"Bob\"\n" +
                "    }";

        //when
        JsonObject jsonObject = ConsumeToGameMapperImpl.stringToJsonObject(string);

        //then
        assertInstanceOf(JsonObject.class,jsonObject);
        assertEquals("Alan",jsonObject.get("firstPlayer").getAsString());
        assertEquals("Bob",jsonObject.get("secondPlayer").getAsString());
    }

    @Test
    void should_marge_two_Jsons(){
        //given
        JsonObject dest = new JsonObject();
        dest.add("firstPlayer", JsonParser.parseString("Alan"));
        dest.add("secondPlayer", JsonParser.parseString("Bob"));

        JsonObject src = new JsonObject();
        src.add("firstPlayerChoice", JsonParser.parseString("ROCK"));
        src.add("secondPlayerChoice", JsonParser.parseString("PAPER"));

        JsonObject expected = new JsonObject();
        expected.add("firstPlayer", JsonParser.parseString("Alan"));
        expected.add("secondPlayer", JsonParser.parseString("Bob"));
        expected.add("firstPlayerChoice", JsonParser.parseString("ROCK"));
        expected.add("secondPlayerChoice", JsonParser.parseString("PAPER"));

        //when
        ConsumeToGameMapperImpl.mergeJson(dest,src);

        //then
        assertEquals(expected,dest);
    }

//    @Test
//    void should_map_game_from_strings(){
//        //given
//        String key = "    {\n" +
//                "       \"firstPlayer\":\"Alan\",\n" +
//                "       \"secondPlayer\":\"Bob\"\n" +
//                "    }";
//
//        String value = "    {\n" +
//                "       \"firstPlayerChoice\":\"ROCK\",\n" +
//                "       \"secondPlayerChoice\":\"PAPER\"\n" +
//                "    }";
//
//        ConsumeToGameMapperImpl consumeToGameMapper = new ConsumeToGameMapperImpl();
//        //when
//
//        Game result = consumeToGameMapper.map(key,value);
//
//        //then
//        assertInstanceOf(Game.class,result);
//        assertEquals("Alan",result.getFirstPlayer());
//        assertEquals("Bob",result.getSecondPlayer());
//        assertEquals(RockPaperScissors.ROCK,result.getFirstPlayerChoice());
//        assertEquals(RockPaperScissors.PAPER,result.getSecondPlayerChoice());
//    }

}