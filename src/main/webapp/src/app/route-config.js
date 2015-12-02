//(function() {
//    'use strict';
//
//    angular
//        .module('app')
//        .config('config', ['$routeProvider', '$httpProvider', config]);
//
//        function config($routeProvider, $httpProvider) {
//
//            $routeProvider.when('/', {
//                templateUrl : 'pages/home.html',
//                controller : 'homeCtrl'
//            }).when('/login', {
//                templateUrl : 'pages/login.html',
//                controller : 'codesCtrl'
//            }).when('/about', {
//                templateUrl : 'pages/about.html',
//                controller : 'aboutCtrl'
//            }).otherwise('/');
//
//            $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
//
//        }
//
//})();