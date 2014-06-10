package com.raduy.presentation.web;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * @author Lukasz Raduj <raduj.lukasz@gmail.com>
 */
public class JsonUtil {

    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static ResponseTransformer json() {
        return JsonUtil::toJson;
    }
}