(function() {
    'use strict';

    angular
        .module('app.filters')
        .filter('highlightFilter', ['$sce',  highlightFilter]);

    function highlightFilter($sce) {
        return function(text, exp) {
            if (exp) {
                text = text.replace(new RegExp('('+exp+')','gi'), '<span class="highlight">$1</span>');
            }
            return $sce.trustAsHtml(text);
        };

    }

})();