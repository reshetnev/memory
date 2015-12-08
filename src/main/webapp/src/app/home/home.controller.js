(function() {
    'use strict';

angular
    .module('app.controllers')
    .controller('homeCtrl', ['$rootScope', homeCtrl]);

function homeCtrl($rootScope) {

    $rootScope.greeting = "Hello, " + $rootScope.userName;

}

})();