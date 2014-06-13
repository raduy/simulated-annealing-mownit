package com.raduy.presentation.web;

import com.google.gson.Gson;
import com.raduy.core.SimulatedAnnealing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.raduy.presentation.web.JsonUtil.json;
import static com.raduy.presentation.web.JsonUtil.toJson;
import static spark.Spark.*;

/**
 * @author Lukasz Raduj <raduj.lukasz@gmail.com>
 */
public class WebController {
    private final static Logger LOGGER = LoggerFactory.getLogger(WebController.class);

    public WebController() {
        get("/compute", (request, response) -> {

            Gson gson = new Gson();
            ComputeRequest req = gson.fromJson(request.queryParams("computeRequest"), ComputeRequest.class);
            LOGGER.info("Request received. Cities: {}. InitTemp: {}, CoolingRate: {}", req.getCities(), req.getInitialTemp(), req.getCoolingRate());

            return SimulatedAnnealing.compute(req.getCities(), req.getInitialTemp(), req.getCoolingRate()).getFinalTour();
        }, json());

        after((req, res) -> {
            res.header("Access-Control-Allow-Origin", "*");
            res.type("application/json");
        });

        exception(IllegalArgumentException.class, (e, req, res) -> {
            res.status(400);
            res.body(toJson(new ResponseError(e)));
        });
    }
}
