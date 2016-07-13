(function () {
    'use strict';

    angular
        .module('app.core')
        .factory('dataservice', dataservice);

    dataservice.$inject = ['$resource'];

    function dataservice($resource) {

        var service = {
            account: account,
            code: code
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
            return $resource('/memory/api/v1/users', {}, {
                get: {
                    method: 'GET',
                    isArray: true
                },
                getById: {
                    method: 'GET',
                    params: {
                        id: '@id'
                    },
                    url: '/memory/api/v1/users/:id',
                },
                getByLogin: {
                    method: 'GET',
                    params: {
                        login: '@login'
                    },
                    url: '/memory/api/v1/users/:login',
                },
                create: {
                    method: 'POST'
                },
                update: {
                    method: 'PUT',
                    params: {
                        id: '@id'
                    },
                    url: '/memory/api/v1/users/:id'
                },
                delete: {
                    method: 'DELETE',
                    params: {
                        id: '@id'
                    },
                    url: '/memory/api/v1/users/:id'
                },
                current: {
                    method: 'GET',
                    url: 'memory/api/v1/users/principal',
                    cache: true
                }
            });
        }

        function code() {
            return $resource('/memory/api/v1/:userId/codes', {}, {
                getCodes: {
                    method: 'GET',
                    params: {
                        userId: '@userId'
                    },
                    isArray: true
                },
            });
        }

    }
})();
