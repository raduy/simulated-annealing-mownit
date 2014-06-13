'use strict';

angular.module('angularApp', [
  'ngResource',
  'ngRoute'
])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main-view.html',
        controller: 'MapController'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
