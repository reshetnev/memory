(function() {
    'use strict';

    angular
        .module('app', [
            'ngRoute',
            'app.controllers',
            'app.filters'
        ]);

    angular.module('app.controllers', []); // set ctrls
    angular.module('app.filters', []); // set filters

})();