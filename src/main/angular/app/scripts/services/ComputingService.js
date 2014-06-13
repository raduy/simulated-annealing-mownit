'use strict';

simulatedAnnealingApp.factory('ComputingService', ['$resource', function($resource) {
    return $resource('http://localhost\\:4567//hello', {
    }, {
        compute: {
            method: 'GET',
            isArray: true
        }
    })
}]);