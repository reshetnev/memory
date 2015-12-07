(function() {
    'use strict';

    angular
        .module('app.core', ['ngRoute'])
        .config(['$routeProvider', '$httpProvider', config]);

        function config($routeProvider, $httpProvider) {

            $routeProvider.when('/', {
                templateUrl : 'pages/home.html',
                controller : 'homeCtrl'
            })
//            .when('/about', {
//                templateUrl : 'pages/about.html',
//                controller : 'codesCtrl'
//            })
            .when('/login', {
                templateUrl : 'pages/login.html',
                controller : 'codesCtrl'
            })
//            .when('/login?logout', {
//                templateUrl : 'pages/login.html',
//                controller : 'codesCtrl'
//            })
            .otherwise('/');

            $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

        }

})();