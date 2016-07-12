(function () {
    'use strict';

    angular
        .module('app.controllers')
        .controller('codesCtrl', ['$rootScope', '$scope', '$http', '$location', '$sce', codesCtrl]);

    function codesCtrl($rootScope, $scope, $http, $location, $sce) {

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
                    vm.key = credentials.password;
                    console.log("login=" + $rootScope.userName);
                    console.log("psw=" + vm.key);
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

        $http({method: 'GET', url: 'api/v1/codes'})
            .success(function (data, status, headers, config) {
                vm.codesList = data;
            })
            .error(function (data, status, headers, config) {
                console.log("REST Error for CODES");
            });

        vm.encrypt = function (psw) {
            var encObject = CryptoJS.AES.encrypt(psw, 'mts');
            var encPsw = encObject.toString();
            return encPsw;
        }

        vm.decrypt = function(encPsw) {

            var bytes  = CryptoJS.AES.decrypt(encPsw, 'mts');
            var psw = bytes.toString(CryptoJS.enc.Utf8);
            return psw;
        }
    }

})();