(function() {
    'use strict';

    angular
        .module('app', [
			'app.testData',
            'app.controllers',
            'app.filters'
        ]);

	angular.module('app.testData', []); // set testData
    angular.module('app.controllers', []); // set ctrls
    angular.module('app.filters', []); // set filters

})();