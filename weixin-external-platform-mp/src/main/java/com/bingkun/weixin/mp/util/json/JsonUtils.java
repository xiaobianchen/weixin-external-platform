package com.bingkun.weixin.mp.util.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;

import java.util.List;
import java.util.Map;

/**
 * Created by chenxiaobian on 17/1/20.
 */
public final class JsonUtils {

    /**
     * 对象转化为JSON
     *
     * @param obj object
     * @param <T> object type
     */
    public static <T> String toJson(T obj) {
        return JSON.toJSONString(obj, true);
    }

    /**
     * List转化为JSON
     *
     * @param list list
     * @param <T>  object type
     */
    public static <T> String toJson(List<T> list) {
        return JSON.toJSONString(list, true);
    }

    /**
     * Map转化为JSON
     *
     * @param map Map
     */
    public static <K, V> String toJson(Map<K, V> map) {
        return JSON.toJSONString(map, true);
    }

    /**
     * 数组转化为JSON
     *
     * @param arrs Array
     * @param <T>  Type of the Array
     */
    public static <T> String toJson(T[] arrs) {
        return JSON.toJSONString(arrs, true);
    }

    /**
     * JSON转化为对象
     *
     * @param json  jsonString
     * @param clazz ClassType
     * @param <T>   Object
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        T obj;
        try {
            obj = JSON.parseObject(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    /**
     * JSON转化为数组
     *
     * @param json jsonString
     */
    public static JSONArray fromJson(String json) {
        JSONArray jsonArray;
        try {
            jsonArray = JSON.parseArray(json);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return jsonArray;
    }

    /**
     * JSON转化List
     *
     * @param json jsonString
     * @param <T>  type
     */
    public static <T> List<T> fromJson2List(String json, Class<T> clazz) {
        List<T> tList;
        try {
            tList = JSON.parseArray(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return tList;
    }

    /**
     * JSON转化为Map
     *
     * @param json jsonString
     */
    public static List<Map<String, Object>> fromJson2Map(String json) {
        List<Map<String, Object>> map;
        try {
            map = JSON.parseObject(json, new TypeReference<List<Map<String, Object>>>() {
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return map;
    }
}
