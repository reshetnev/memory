(function() {
    'use strict';

    angular
        .module('app', [
            'ngRoute',
            'app.controllers',
            'app.filters'
        ])
        .config(function($routeProvider, $httpProvider) {
    
            $routeProvider.when('/', {
                templateUrl : 'pages/home.html',
                controller : 'home'
            }).when('/login', {
                templateUrl : 'pages/login.html',
                controller : 'login'
            }).otherwise('/');
        
            $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    
        })

    angular.module('app.controllers', []); // set ctrls
    angular.module('app.filters', []); // set filters

    
})();