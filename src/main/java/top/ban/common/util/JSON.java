package top.ban.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JSON {
    private static ObjectMapper jsonMapper = new ObjectMapper();

    public static String stringify(Object o) throws JsonProcessingException {
        return jsonMapper.writeValueAsString(o);
    }

    public static <T> T parse(String json, Class<T> clazz) throws Exception {
        return jsonMapper.readValue(json, clazz);
    }
}
