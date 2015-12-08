(function() {
    'use strict';

    angular
        .module('app', [
            'app.core',
            'app.controllers',
            'app.filters'
        ]);

    angular.module('app.core', []); // set cores
    angular.module('app.controllers', []); // set ctrls
    angular.module('app.filters', []); // set filters

})();