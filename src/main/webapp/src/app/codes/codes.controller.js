(function() {
    'use strict';

angular
    .module('app.controllers')
    .controller('codesCtrl', ['$http', codesCtrl]);

function codesCtrl($http) {

    /* jshint validthis: true */
    var vm = this;

    $http({method:'GET', url:'http://localhost:7001/memory/api/v1/codes'})
        .success(function (data, status, headers, config) {
            vm.codesList = data;
        })
        .error(function (data, status, headers, config) {
            alert('Error REST');
        });
}

})();