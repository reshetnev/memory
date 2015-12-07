//(function () {
//    'use strict';
//
//    angular
//        .module('app.core')
//        .factory('dataservice', dataservice);
//
//    dataservice.$inject = ['$resource'];
//
//    function dataservice($resource) {
//
//        //@formatter:off
//        var service = {
//            configuration:         configuration,
//            account:               account,
//            team:                  team,
//            userCase:              userCase,
//            userCaseSectionByName: sectionByName,
//            hwFile: hwFile,
//            closureCriteria: closureCriteria,
//            closureCriteriaGroup: closureCriteriaGroup,
//            userClosureCriteria: userClosureCriteria,
//            autoRejectUserCase: autoRejectUserCase,
//            statistics: statistics,
//            testList: testList,
//            autoActionConfig: autoActionConfig,
//            queue: queue,
//            testAccount: testAccount,
//            tasks: tasks,
//            testAccountOffice: testAccountOffice,
//            myPerformance: myPerformance,
//            audit: audit,
//            cdaqueue: cdaqueue,
//            dataElements: dataElements,
//            rescoring: rescoring,
//            rescoringQueue: rescoringQueue,
//            notifications: notifications,
//            project: project
//};
//        //@formatter:on
//
//        return service;
//
//        /**
//         * @ngdoc method
//         * @name configuration
//         * @methodOf dataservice.configuration
//         *
//         * @description
//         * Create a resource object for `configuration`.
//         *
//         * @returns {Object} A resource 'class' object with the following set of resource actions:
//         *
//         * - `[{object}]` `get()` — List all configurations.
//         * - `{object}` `update(id, {object} configuration)` — Request for update the configuration with the given id.
//         */
//        function configuration() {
//            return $resource('/erms/ere/configuration', {}, {
//                get: {
//                    method: 'GET',
//                    isArray: true
//                },
//                getThresholds: {
//                    method: 'GET',
//                    url: '/erms/ere/configuration/thresholds'
//                },
//                update: {
//                    method: 'PUT',
//                    params: {
//                        id: '@id'
//                    },
//                    url: '/erms/ere/configuration/:id'
//                }
//            });
//        }
//
//        /**
//         * @ngdoc method
//         * @name account
//         * @methodOf dataservice.account
//         *
//         * @description
//         * Create a resource object for `account`.
//         *
//         * @returns {Object} A resource 'class' object with the following set of resource actions:
//         *
//         * - `[{object}]` `get()` — List all accounts.
//         * - `{object}` `getByLogin()` — Retrieve an account with the given login.
//         * - `{object}` `create({object} account)` — Create new account.
//         * - `{object}` `update(id, {object} account)` — Change parameters of the account with the specified ID.
//         * - `void` `delete(id)` — Delete the account with the specified ID.
//         */
//        function account() {
//            return $resource('/erms/rest/management/accounts', {}, {
//                get: {
//                    method: 'GET',
//                    isArray: true
//                },
//                getByLogin: {
//                    method: 'GET',
//                    params: {
//                        login: '@login'
//                    },
//                    url: '/erms/rest/management/accounts/:login',
//                    ignoreLoadingBar: true
//                },
//                create: {
//                    method: 'POST'
//                },
//                update: {
//                    method: 'PUT',
//                    params: {
//                        id: '@id'
//                    },
//                    url: '/erms/rest/management/accounts/:id'
//                },
//                delete: {
//                    method: 'DELETE',
//                    params: {
//                        id: '@id'
//                    },
//                    url: '/erms/rest/management/accounts/:id'
//                },
//                current: {
//                    method: 'GET',
//                    url: '/erms/rest/management/principal',
//                    cache: true
//                },
//                currentId: {
//                    method: 'GET',
//                    url: '/erms/rest/management/principalid'
//                },
//                managers: {
//                    method: 'GET',
//                    url: '/erms/rest/management/managers',
//                    isArray: true
//                }
//            });
//        }
//
//        /**
//         * @ngdoc method
//         * @name team
//         * @methodOf dataservice.team
//         *
//         * @description
//         * Create a resource object for `team`.
//         *
//         * @returns {Object} A resource 'class' object with the following set of resource actions:
//         *
//         * - `[{object}]` `get()` — List all teams.
//         * - `{object}` `update(id, {object} team)` — Request for update the team with the given id.
//         */
//        function team() {
//            return $resource('/erms/rest/management/teams', {}, {
//                get: {
//                    method: 'GET',
//                    isArray: true
//                },
//                update: {
//                    method: 'PUT',
//                    params: {
//                        id: '@id'
//                    },
//                    url: '/erms/rest/management/teams/:id'
//                }
//            });
//        }
//
//        function userCase() {
//            return $resource('/erms/ere/users/:uid', {}, {
//                get: {
//                    method: 'GET',
//                    params: {
//                        uid: '@uid'
//                    }
//                },
//                put: {
//                    method: 'PUT',
//                    params: {
//                        uid: '@uid'
//                    }
//                },
//                create: {
//                    method: 'POST',
//                    params: {
//                        uid: '@uid'
//                    }
//                },
//                returnToQueue: {
//                    method: 'POST',
//                    url: '/erms/ere/users/return'
//                },
//                myCaseBucket: {
//                    method: 'GET',
//                    url: '/erms/ere/users/myCaseBucket',
//                    isArray: true
//                },
//                myCaseBucketUserIds: {
//                    method: 'GET',
//                    url: '/erms/ere/users/myCaseBucket/uid',
//                    isArray: true
//                },
//                myCaseBucketRiskData: {
//                    method: 'GET',
//                    url: '/erms/ere/users/myCaseBucket/riskTests',
//                    isArray: true
//                },
//                getPreviousCases: {
//                    method: 'GET',
//                    url: '/erms/ere/users/previousCases',
//                    isArray: true
//                },
//                testAccountUserCase: {
//                    method: 'GET',
//                    url: '/erms/ere/users/testAccounts'
//                },
//                fillAccountBucket: {
//                    method: 'PUT',
//                    isArray: true,
//                    url: '/erms/ere/users/fillAccountBucket'
//                },
//                assignTo: {
//                    method: 'POST',
//                    url: '/erms/ere/users/assign',
//                    isArray: true
//                }
//            });
//        }
//
//        function rescoring() {
//            return $resource('/erms/ere/rescoring/queue', {}, {
//                rescore: {
//                    method: 'POST'
//                }
//            });
//        }
//
//        function autoRejectUserCase() {
//            return $resource('/erms/ere/users/autorejected', {}, {
//                get: {
//                    method: 'GET'
//                },
//                closeInAdmin: {
//                    method: 'PUT',
//                    url: '/erms/ere/users/closedInAdmin'
//                }
//            });
//        }
//
//        function testAccount() {
//            return $resource('/erms/ere/testAccount/:id', {}, {
//                get: {
//                    method: 'GET',
//                    isArray: true
//                },
//                create: {
//                    method: 'POST'
//                },
//                update: {
//                    method: 'PUT',
//                    params: {
//                        id: '@id'
//                    }
//                },
//                delete: {
//                    method: 'DELETE'
//                }
//            });
//        }
//
//        function testAccountOffice() {
//            return $resource('/erms/ere/testAccount/offices/:id', {}, {
//                get: {
//                    method: 'GET',
//                    isArray: true
//                },
//                create: {
//                    method: 'POST'
//                },
//                update: {
//                    method: 'PUT',
//                    params: {
//                        id: '@id'
//                    }
//                },
//                delete: {
//                    method: 'DELETE'
//                }
//            });
//        }
//
//        function myPerformance() {
//            return $resource('/erms/rest/myPerformance/:year', {}, {
//                get: {
//                    method: 'GET',
//                    isArray: true,
//                    params: {
//                        year: '@year'
//                    }
//                },
//                save: {
//                    method: 'POST',
//                    isArray: true
//                }
//            });
//        }
//
//        function audit() {
//            return $resource('/erms/rest/audit/:id', {}, {
//                get: {
//                    method: 'GET',
//                    isArray: true,
//                    params: {
//                        id: '@id'
//                    }
//                },
//                getOne: {
//                    method: 'GET',
//                    params: {
//                        id: '@id'
//                    }
//                },
//                history: {
//                    method: 'GET',
//                    isArray: true,
//                    url: '/erms/rest/audit/history'
//                },
//                all: {
//                    method: 'GET',
//                    isArray: true,
//                    url: '/erms/rest/audit/all'
//                },
//                save: {
//                    method: 'POST',
//                    isArray: true,
//                    params: {
//                        id: '@id'
//                    }
//                },
//                saveQaCaseComment: {
//                    method: 'PUT',
//                    isArray: true,
//                    params: {
//                        id: '@id'
//                    },
//                    url: '/erms/rest/audit/case/:id/comment'
//                },
//                copyQaCase: {
//                    method: 'PUT',
//                    params: {
//                        id: '@id'
//                    },
//                    url: '/erms/rest/audit/case/qacase/:id'
//                },
//                addQaCases: {
//                    method: 'PUT',
//                    params: {
//                        auditId: '@auditId'
//                    },
//                    url: '/erms/rest/audit/case/:auditId/qacase',
//                    isArray: true
//                },
//                createQa: {
//                    method: 'POST',
//                    url: '/erms/rest/audit/case'
//                },
//                deleteQa: {
//                    method: 'DELETE',
//                    params: {
//                        id: '@id'
//                    },
//                    url: '/erms/rest/audit/case/:id'
//                },
//                deleteQaCase: {
//                    method: 'DELETE',
//                    params: {
//                        id: '@id'
//                    },
//                    url: '/erms/rest/audit/case/qacase/:id'
//                },
//                getComments: {
//                    method: 'GET',
//                    isArray: true,
//                    params: {
//                        id: '@id'
//                    },
//                    url: '/erms/rest/audit/:id/comments'
//                }
//            });
//        }
//
//        function statistics() {
//            return $resource('/erms/ere/stats', {}, {
//                autoRejectQueue: {
//                    method: 'GET',
//                    url: '/erms/ere/stats/autoRejectQueue'
//                },
//                myCaseBucket: {
//                    method: 'GET',
//                    url: '/erms/ere/stats/myCaseBucket'
//                },
//                queue: {
//                    method: 'GET',
//                    url: '/erms/ere/stats/queue/:id',
//                    params: {
//                        id: '@id'
//                    }
//                },
//                queueTotalCases: {
//                    method: 'GET',
//                    url: '/erms/ere/stats/queue/:id/totalCases',
//                    params: {
//                        id: '@id'
//                    }
//                },
//                teamStats: {
//                    method: 'GET',
//                    isArray: true,
//                    url: '/erms/ere/stats/team'
//                },
//                caseSearch: {
//                    method: 'GET',
//                    url: '/erms/ere/stats/caseSearch'
//                },
//            });
//        }
//
//        function sectionByName() {
//            return $resource('/erms/ere/users/:uid/sections/:section', {}, {
//                get: {
//                    method: 'GET',
//                    params: {
//                        uid: '@uid',
//                        section: '@section'
//                    }
//                },
//                query: {
//                    method: 'GET',
//                    isArray: true,
//                    params: {
//                        uid: '@uid',
//                        section: '@section'
//                    },
//                    cache: true
//                },
//                queryPage: {
//                    method: 'GET',
//                    params: {
//                        uid: '@uid',
//                        section: '@section'
//                    },
//                    cache: true
//                },
//                queryNonCached: {
//                    method: 'GET',
//                    isArray: true,
//                    params: {
//                        uid: '@uid',
//                        section: '@section'
//                    }
//                }
//            });
//        }
//
//        function hwFile() {
//            return $resource('/erms/ere/rulesetitems/postcolumn/:postColumn/value/:value', {}, {
//                get: {
//                    method: 'GET',
//                    params: {
//                        postColumn: '@postColumn',
//                        value: '@value'
//                    },
//                    cache: true
//                }
//            });
//        }
//
//        function closureCriteria() {
//            return $resource('/erms/rest/closureCriteria/:id', {}, {
//                get: {
//                    method: 'GET',
//                    isArray: true
//                },
//                create: {
//                    method: 'POST'
//                },
//                put: {
//                    method: 'PUT',
//                    params: {
//                        uid: '@uid'
//                    }
//                },
//                delete: {
//                    method: 'DELETE',
//                    params: {
//                        id: '@id'
//                    }
//                }
//            });
//        }
//
//        function closureCriteriaGroup() {
//            return $resource('/erms/rest/closureCriteria/group/:id', {}, {
//                get: {
//                    method: 'GET',
//                    isArray: true
//                },
//                create: {
//                    method: 'POST'
//                },
//                put: {
//                    method: 'PUT',
//                    params: {
//                        uid: '@uid'
//                    }
//                },
//                delete: {
//                    method: 'DELETE',
//                    params: {
//                        id: '@id'
//                    }
//                }
//            });
//        }
//
//        function userClosureCriteria() {
//            return $resource('/erms/rest/closureCriteria/user/:uid', {}, {
//                get: {
//                    method: 'GET',
//                    isArray: true
//                },
//                put: {
//                    method: 'PUT',
//                    params: {
//                        uid: '@uid'
//                    }
//                }
//            });
//        }
//
//        function autoActionConfig() {
//            return $resource('/erms/ere/autoaction', {}, {
//                get: {
//                    method: 'GET'
//                },
//                update: {
//                    method: 'PUT'
//                }
//            });
//        }
//
//        function dataElements() {
//            return $resource('/erms/ere/data/elements', {}, {
//                getVisible: {
//                    method: 'GET',
//                    isArray: true,
//                    url: '/erms/ere/data/elements/visible'
//                }
//            });
//        }
//
//        function testList() {
//            return $resource('/erms/ere/tests/:testId', {}, {
//                get: {
//                    method: 'GET',
//                    isArray: true
//                },
//                getActive: {
//                    method: 'GET',
//                    isArray: true,
//                    url: '/erms/ere/tests/active'
//                }
//            });
//        }
//
//        function cdaqueue() {
//            return $resource('/erms/rest/reports/cdaqueue/:userId', {}, {
//                getCommon: {
//                    method: 'GET',
//                    url: '/erms/rest/reports/cdaqueue/common'
//                },
//                getPersonal: {
//                    method: 'GET',
//                    url: '/erms/rest/reports/cdaqueue/personal'
//                },
//                assignCases: {
//                    method: 'POST',
//                    url: '/erms/rest/reports/cdaqueue/assign'
//                },
//                save: {
//                    method: 'POST',
//                },
//                deleteFromQueue: {
//                    method: 'DELETE',
//                    params: {
//                        userId: '@userId'
//                    }
//                },
//            });
//        }
//
//        function tasks() {
//            return $resource('/erms/ere/tasks', {}, {
//                get: {
//                    method: 'GET',
//                    isArray: true
//                }
//            });
//        }
//
//        function queue() {
//            return $resource('/erms/ere/queues/:id', {}, {
//                get: {
//                    method: 'GET',
//                    isArray: true
//                },
//                create: {
//                    method: 'POST'
//                },
//                update: {
//                    method: 'PUT',
//                    params: {
//                        id: '@id'
//                    }
//                },
//                toggleActive: {
//                    method: 'PUT',
//                    url: '/erms/ere/queues/toggleActive'
//                },
//                updatePriorities: {
//                    method: 'PUT',
//                    url: '/erms/ere/queues/priorities'
//                },
//                delete: {
//                    method: 'DELETE',
//                    params: {
//                        id: '@id'
//                    }
//                },
//                active: {
//                    method: 'GET',
//                    isArray: true,
//                    url: '/erms/ere/queues/active'
//                },
//                forAccount: {
//                    method: 'GET',
//                    isArray: true,
//                    url: '/erms/ere/queues/current'
//                }
//            });
//        }
//
//        function rescoringQueue() {
//            return $resource('/erms/ere/rescoring/queue', {}, {
//                getSize: {
//                    method: 'GET',
//                    url: '/erms/ere/rescoring/queue/size'
//                }
//            });
//        }
//
//        function notifications() {
//            return $resource('/erms/rest/notifications', {}, {
//                getLast: {
//                    method: 'GET',
//                    isArray: true,
//                    url: '/erms/rest/notifications/last'
//                },
//                markAsRead: {
//                    method: 'POST',
//                    url: '/erms/rest/notifications/:id/read',
//                    params: {
//                        id: '@id'
//                    }
//                }
//            });
//        }
//
//        function project() {
//            return $resource('/erms/rest/project/current', {}, {
//                get: {
//                    method: 'GET'
//                },
//                update: {
//                    method: 'PUT',
//                    url: '/erms/rest/project/current/:projectId',
//                    params: {
//                        projectId: '@projectId'
//                    }
//                }
//            });
//        }
//    }
//})();
