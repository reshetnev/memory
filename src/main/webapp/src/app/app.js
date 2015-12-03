(function() {
    'use strict';

    angular
        .module('app', [
            'ngRoute',
            'app.controllers',
            'app.filters'
        ]);

    angular.module('app.controllers', []); // set ctrls
    angular.module('app.filters', []); // set filters

    angular
        .module('app')
        .config(config);

    function config($routeProvider, $httpProvider) {

        $routeProvider.when('/', {
            templateUrl : 'pages/home.html',
            controller : 'homeCtrl'
        })
//        .when('/about', {
//            templateUrl : 'pages/about.html',
//            controller : 'codesCtrl'
//        })
        .when('/login', {
            templateUrl : 'pages/login.html',
            controller : 'codesCtrl'
        })
        .otherwise('/');

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

    }

})();