(function() {
    'use strict';

angular
    .module('app.controllers')
    .controller('usersCtrl', ['$http', usersCtrl]);

function usersCtrl($http) {

    /* jshint validthis: true */
    var vm = this;

    $http({method:'GET', url:'api/v1/users'})
        .success(function (data, status, headers, config) {
            vm.usersList = data;
        })
        .error(function (data, status, headers, config) {
            console.log("REST Error for USERS");
        });

}

})();