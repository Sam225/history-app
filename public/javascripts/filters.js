/**
 * Created by Suamah on 06/08/2015.
 */

'use strict';

define(['angular'], function(angular) {

    /* Filters */

    angular.module('ivoireApp.filters', []).
        filter('interpolate', ['version', function(version) {
            return function(text) {
                return String(text).replace(/\%VERSION\%/mg, version);
            }
        }])
        .filter('underscore', function(){

            return function(text){
                var str = text.replace(/_/g, " ");
                return str;

            }

        })
        .filter('capitalize', function() {
            return function(input, $scope) {
                if (input!=null)
                    input = input.toLowerCase();
                return input.substring(0,1).toUpperCase()+input.substring(1);
            }
        });




});