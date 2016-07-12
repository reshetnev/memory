(function () {
    'use strict';

    angular
        .module('app.controllers')
        .controller('CodesController', ['$rootScope', 'dataservice', CodesController]);

    function CodesController($rootScope, dataservice) {

        /* jshint validthis: true */
        var vm = this;
        vm.greeting = "Hello, " + $rootScope.userName + "!!!";

        function init() {
            //var email = "reshetnev1983@gmail.com";
            console.log("user=" + $rootScope.userName);
            var email = $rootScope.userName;
            var principal = undefined;
            dataservice.account().getByLogin({login: email}).$promise
                .then(function(data) {
                    principal = data;
                    console.log("REST for CURRENT USER is Ok " + principal.name);
                    dataservice.code().getCodes({userId: principal.id}).$promise
                        .then(function (data) {
                            vm.codesList = data;
                            console.log("REST for CODES is Ok");
                        })
                        .catch(function () {
                            console.log("REST Error for CODES");
                        });
                }).catch(function() {
                    console.log("REST Error for CURRENT USER");
                })
        }

        vm.encrypt = function (psw) {
            var encObject = CryptoJS.AES.encrypt(psw, $rootScope.key);
            var encPsw = encObject.toString();
            return encPsw;
        }

        vm.decrypt = function(encPsw) {

            var bytes  = CryptoJS.AES.decrypt(encPsw, $rootScope.key);
            var psw = bytes.toString(CryptoJS.enc.Utf8);
            return psw;
        }

        init();
    }

})();