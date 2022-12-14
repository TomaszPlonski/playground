package com.tplonski.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tplonski.model.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsumeToGameMapperImpl implements ConsumeToGameMapper {

    private final Gson gson;

    public Game map(String key, String value){
        JsonObject dest = stringToJsonObject(key);
        JsonObject src = stringToJsonObject(value);

        mergeJson(dest,src);

//        Gson gson = new Gson();

       return gson.fromJson(dest,Game.class);
    }

    static JsonObject stringToJsonObject(String string){
        return JsonParser.parseString(string).getAsJsonObject();
    }

    static void mergeJson(JsonObject dest, JsonObject src){
        src.entrySet().forEach(e-> dest.add(e.getKey(),e.getValue()));
    }





}
