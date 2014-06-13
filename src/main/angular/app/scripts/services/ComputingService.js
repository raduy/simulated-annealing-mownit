'use strict';

simulatedAnnealingApp.factory('ComputingService', ['$resource', function($resource) {
    return $resource('http://localhost\\:4567//compute', {}, {
        compute: {
            method: 'GET'
        }
    })
}]);