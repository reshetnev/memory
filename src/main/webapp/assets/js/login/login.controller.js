(function () {
    'use strict';

    angular
        .module('app.controllers')
        .controller('LoginController', ['$rootScope', '$scope', '$http', '$location', LoginController]);

    function LoginController($rootScope, $scope, $http, $location) {

        /* jshint validthis: true */
        var vm = this;

        var authenticate = function (credentials, callback) {

            var headers = credentials ? {
                authorization: "Basic " + btoa(credentials.username + ":" + credentials.password)
            } : {};

            $http.get('api/v1/users/principal', {headers: headers}).success(function (data) {
                console.log("User LOGIN: " + data.name);
                if (data.name) {
                    $rootScope.authenticated = true;
                    $rootScope.userName = data.name;
                    $rootScope.key = credentials.password;
                    console.log("login=" + $rootScope.userName);
                    console.log("psw=" + $rootScope.key);
                } else {
                    $rootScope.authenticated = false;
                }
                callback && callback();
            }).error(function () {
                $rootScope.authenticated = false;
                callback && callback();
            });
        };

        authenticate();
        $scope.credentials = {};
        $scope.login = function () {
            authenticate($scope.credentials, function () {
                if ($rootScope.authenticated) {
                    $location.path("/");
                    $scope.error = false;
                } else {
                    $location.path("/login");
                    $scope.error = true;
                }
            });
        };

        $scope.logout = function () {
            $http.post('logout', {}).success(function () {
                console.log("Logout success");
                $rootScope.authenticated = false;
                $location.path("/");
            }).error(function (data) {
                console.log("Logout error");
                $rootScope.authenticated = false;
            });
        };

    }

})();