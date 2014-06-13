'use strict';

var simulatedAnnealingApp = angular.module('angularApp');

simulatedAnnealingApp.controller('MapController', function ($scope, ComputingService) {

    $scope.model = {
        newCityMode: true,
        canvas: {
            ready: false
        },
        addNewCity: addNewCity,
        toggleNewCityMode: toggleNewCityMode,
        compute: compute,

        customCities: []
    };

    function compute() {
        var citiesToVisit = {
            cities: angular.copy($scope.model.customCities)
        };

        ComputingService.compute({cities: citiesToVisit}, function (successResult) {
            $scope.model.result = successResult;
            drawTour(ctx, $scope.model.result);

        }, function (failResult) {
            console.log("computing failed", failResult);
        });
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
});
