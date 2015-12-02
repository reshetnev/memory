(function() {
    'use strict';

angular
    .module('app.controllers')
    .controller('homeCtrl', homeCtrl);

function homeCtrl() {

    /* jshint validthis: true */
    var vm = this;

    vm.greeting = "Hello, Authenticated User!!!";

}

})();