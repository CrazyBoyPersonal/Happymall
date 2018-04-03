package com.zjitc.mall.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Create by IntelliJ IDEA
 *
 * @author: jsonor
 * @date-Time: 2018/4/3 15:49
 * @description:
 */
public class GsonOfDate implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {

  public static Gson getInstance() {
    return new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new GsonOfDate()).create();
  }

  @Override
  public LocalDateTime deserialize(JsonElement jsonElement, Type type,
      JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
    return null;
  }

  @Override
  public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
    return new JsonPrimitive(Timestamp.valueOf(src).getTime());
  }
}
