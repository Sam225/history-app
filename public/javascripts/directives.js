/**
 * Created by Suamah on 06/08/2015.
 */
'use strict';

define(['angular'], function(angular) {

    /* Directives */

    angular.module('ivoireApp.directives', []).
        directive('appVersion', ['version', function(version) {
            return function(scope, elm, attrs) {
                elm.text(version);
            };
        }]);

});