package com.raduy.presentation.web;

import com.google.common.collect.Lists;
import com.raduy.core.City;

import static com.raduy.presentation.web.JsonUtil.*;
import static spark.Spark.after;
import static spark.Spark.exception;
import static spark.Spark.get;

/**
 * @author Lukasz Raduj <raduj.lukasz@gmail.com>
 */
public class WebController {

    public WebController() {
        get("/hello", (request, response) -> {
            return Lists.newArrayList(new City(12, 12));

        }, json());

        after((req, res) -> {
            res.type("application/json");
        });

        exception(IllegalArgumentException.class, (e, req, res) -> {
            res.status(400);
            res.body(toJson(new ResponseError(e)));
        });
    }
}
