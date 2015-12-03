(function() {
    'use strict';

angular
    .module('app.controllers')
    .controller('groupsCtrl', ['$http', groupsCtrl]);

function groupsCtrl($http) {

    /* jshint validthis: true */
    var vm = this;

    $http({method:'GET', url:'api/v1/groups'})
        .success(function (data, status, headers, config) {
            vm.groupsList = data;
        })
        .error(function (data, status, headers, config) {
            console.log("REST Error for GROUPS");
        });

}

})();