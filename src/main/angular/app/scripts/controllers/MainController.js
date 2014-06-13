'use strict';

var simulatedAnnealingApp = angular.module('angularApp');

simulatedAnnealingApp.controller('MapController', function ($scope, ComputingService) {

    $scope.model = {
//        Simulated Annealing params
        saParams: {
            initialTemp: 100000,
            coolingRate: 0.0001
        },
        paramsMod: {
            increaseInitTemp: increaseInitTemp,
            decreaseInitTemp: decreaseInitTemp,
            increaseCoolingRate: increaseCoolingRate,
            decreaseCoolingRate: decreaseCoolingRate
        },
        newCityMode: true,
        canvas: {
            ready: false
        },
        addNewCity: addNewCity,
        toggleNewCityMode: toggleNewCityMode,
        compute: compute,

        customCities: []
    };


    function increaseInitTemp() {
        $scope.model.saParams.initialTemp = 10 * $scope.model.saParams.initialTemp;
    }

    function decreaseInitTemp() {
        $scope.model.saParams.initialTemp = 0.1 * $scope.model.saParams.initialTemp;
    }

    function increaseCoolingRate() {
        $scope.model.saParams.coolingRate = 10 * $scope.model.saParams.coolingRate;
    }

    function decreaseCoolingRate() {
        $scope.model.saParams.coolingRate = 0.1 * $scope.model.saParams.coolingRate;
    }

    function addNewCity() {
        if ($scope.model.newCityMode === false) {
            return;
        }

        $scope.model.customCities.push(new City("Custom City", mousePos.x, mousePos.y));
        drawPoint(ctx, mousePos.x, mousePos.y);
    }

    function toggleNewCityMode() {
        $scope.model.newCityMode = !$scope.model.newCityMode;
    }

    var canvas = document.getElementById("map-canvas"),
        ctx = canvas.getContext("2d");

    canvas.width = IMAGE_WIDTH;
    canvas.height = IMAGE_HEIGHT;

    var mousePos;

    canvas.addEventListener('mousemove', function (evt) {
        mousePos = getMousePosition(canvas, evt);
        var message = 'Mouse position: ' + mousePos.x + ', ' + mousePos.y;
        writeMessage(ctx, message);
    }, false);

    var background = createCanvasBackground();

    background.onload = function () {
        $scope.model.canvas.ready = true;
    };

    function compute() {
        var computeRequest = {
            cities: angular.copy($scope.model.customCities),
            initialTemp: angular.copy($scope.model.saParams.initialTemp),
            coolingRate: angular.copy($scope.model.saParams.coolingRate)
        };

        ComputingService.compute({computeRequest: computeRequest}, function (successResult) {
            $scope.model.result = successResult;
            drawTour(ctx, $scope.model.result);

        }, function (failResult) {
            console.log("computing failed", failResult);
        });
    }
});
