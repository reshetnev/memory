    angular
        .module('app.controllers')
        .controller('codesCtrl', codesCtrl);

    function codesCtrl() {
        var vm = this;
        vm.codesList = codes;
    }

    codes = [
             {
                 "name":"velcom velcom",
                 "password":"1234"
             },
             {
                 "name":"mts",
                 "password":"5678"
             },
             {
                 "name":"velcom",
                 "password":"9999"
             },
             {
                 "name":"mts",
                 "password":"3333"
             },
             {
                 "name":"velcom",
                 "password":"2222"
             }
         ]

