(function() {
    'use strict';

    angular
        .module('app.filters')
        .filter('highlightFilter', highlightFilter);

    function highlightFilter($sce) {
        return function(text, exp) {
            if (exp) text = text.replace(exp, '<span class="highlighted">'+exp+'</span>');
            return $sce.trustAsHtml(text);
        }
    }

})();