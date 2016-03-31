(function() {
    'use strict';

    angular
        .module('app', [
            'ui.router',
            'ngResource',
            'app.core',
            'app.controllers',
            'app.filters'
        ]);

    angular
        .module('app.core', []); // set cores
    angular
        .module('app.controllers', []); // set ctrls
    angular
        .module('app.filters', []); // set filters

    angular
        .module('app')
        .config(config);

    config.$inject = ['$stateProvider', '$urlRouterProvider'];

    function config($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/home");

        $stateProvider
            .state('home', {
                url: "/home",
                templateUrl: "pages/home.html",
                controller: "CodesController as codesCtrl"
            })
            .state('about', {
                url: "/about",
                templateUrl: "pages/about.html"
            })
            .state('login', {
                url: "/login",
                templateUrl: "pages/login.html",
                controller: "LoginController as loginCtrl"
            });
    };

})();