(function() {
    'use strict';

angular
    .module('app.controllers')
    .controller('groupsCtrl', ['$http', groupsCtrl]);

function groupsCtrl($http) {

    /* jshint validthis: true */
    var vm = this;

    $http({method:'GET', url:'http://localhost:7001/memory/api/v1/groups'})
        .success(function (data, status, headers, config) {
            vm.groupsList = data;
        })
        .error(function (data, status, headers, config) {
            Console.out("REST Error");
        });

}

})();