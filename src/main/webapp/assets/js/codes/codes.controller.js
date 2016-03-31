(function () {
    'use strict';

    angular
        .module('app.controllers')
        .controller('CodesController', ['$rootScope', 'dataservice', CodesController]);

    function CodesController($rootScope, dataservice) {

        /* jshint validthis: true */
        $rootScope.authenticated = true;
        var vm = this;
        vm.greeting = "Hello!!!";

        function init() {
            dataservice.code().getCodes().$promise
                .then(function (data) {
                    vm.codesList = data;
                    console.log("REST for CODES is Ok");
                })
                .catch(function () {
                    console.log("REST Error for CODES");
                });
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