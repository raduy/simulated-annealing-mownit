package com.raduy.presentation.web;

import static com.raduy.presentation.web.JsonUtil.*;
import static spark.Spark.get;

/**
 * @author Lukasz Raduj <raduj.lukasz@gmail.com>
 */
public class WebController {

    public WebController() {
        get("/hello", (request, response) -> {
           return new SimpleMessage("Hello world");

        }, json());
    }
}
