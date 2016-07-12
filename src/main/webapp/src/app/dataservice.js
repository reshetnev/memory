(function () {
    'use strict';

    angular
        .module('app.core', ['ngResource'])
        .factory('dataservice', dataservice);

    dataservice.$inject = ['$resource'];

    function dataservice($resource) {

        var service = {
            account: account
        };

        return service;

        /**
         * @ngdoc method
         * @name account
         * @methodOf dataservice.account
         *
         * @description
         * Create a resource object for `account`.
         *
         * @returns {Object} A resource 'class' object with the following set of resource actions:
         *
         * - `[{object}]` `get()` — List all accounts.
         * - `{object}` `getByLogin()` — Retrieve an account with the given login.
         * - `{object}` `create({object} account)` — Create new account.
         * - `{object}` `update(id, {object} account)` — Change parameters of the account with the specified ID.
         * - `void` `delete(id)` — Delete the account with the specified ID.
         */
        function account() {
            return $resource('/api/v1/users', {}, {
                get: {
                    method: 'GET',
                    isArray: true
                },
                getByLogin: {
                    method: 'GET',
                    params: {
                        login: '@login'
                    },
                    url: '/api/v1/users/:login',
                    ignoreLoadingBar: true
                },
                create: {
                    method: 'POST'
                },
                update: {
                    method: 'PUT',
                    params: {
                        id: '@id'
                    },
                    url: '/api/v1/users/:id'
                },
                delete: {
                    method: 'DELETE',
                    params: {
                        id: '@id'
                    },
                    url: '/api/v1/users/:id'
                },
                current: {
                    method: 'GET',
                    url: '/api/v1/users/principal',
                    cache: true
                }
//                ,
//                currentId: {
//                    method: 'GET',
//                    url: '/api/v1/users/principalid'
//                },
//                managers: {
//                    method: 'GET',
//                    url: '/erms/rest/management/managers',
//                    isArray: true
//                }
            });
        }



    }
})();
