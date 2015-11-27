(function() {
    'use strict';

    angular
        .module('app')
        .config('config', ['$routeProvider', config]);

        function config($routeProvider) {

            $routeProvider.when('/', {
                templateUrl : 'pages/home.html',
                controller : 'codesCtrl',
                controllerAs: 'codes'
            }).when('/login', {
                templateUrl : 'pages/login.html',
                controller : 'codesCtrl',
                controllerAs: 'codes'
            }).when('/about', {
                templateUrl : 'pages/about.html',
                controller : 'codesCtrl',
                controllerAs: 'codes'
            }).otherwise('/');

        }

})();