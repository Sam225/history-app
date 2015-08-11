/**
 * Created by Suamah on 06/08/2015.
 */
'use strict';

requirejs.config({
    paths: {
        'angular': ['../lib/angularjs/angular'],
        'angular-route': ['../lib/angularjs/angular-route'],
        'jquery': ['../lib/jquery/jquery'],
        'bootstrap': ['../lib/bootstrap/js/bootstrap'],
        'ui-bootstrap': ['../lib/angular-ui-bootstrap/ui-bootstrap-tpls'],
        'ng-table': ['../lib/ng-table/ng-table']
    },
    shim: {
        'angular': {
            exports : 'angular'
        },
        'angular-route': {
            deps: ['angular'],
            exports : 'angular'
        },
        'angular-cookies': ['angular'],
        'bootstrap': ['jquery'],
        'ng-table': ['angular'],
        'ui-bootstrap': ['angular']
    }
});

require(['angular', './controllers', './directives', './filters', './services', 'angular-route','ng-table'],
    function(angular, controllers) {

        // Declare app level module which depends on filters, and services
        angular.module('ivoireApp', ['ivoireApp.filters', 'ivoireApp.services', 'ivoireApp.directives','ngRoute','ngTable']).
            config(['$routeProvider', function($routeProvider) {
                $routeProvider.when('/listeJson', {templateUrl: '/assets/javascripts/templates/event.html',
                    controller: controllers.EventCtrl});
              /*  $routeProvider.when('/',
                    {templateUrl: '/assets/javascripts/templates/main.html',
                    controller: controllers.EventCtrl});*/
                $routeProvider.when('/event/:eventId',
                    {templateUrl: '/assets/javascripts/templates/event-detail.html',
                        controller: controllers.EventDetailCtrl});
               // $routeProvider.when('/view2', {templateUrl: 'events/partial2.html', controller: controllers.MyCtrl2});
                $routeProvider.otherwise({redirectTo: '/'});
            }]);

        angular.bootstrap(document, ['ivoireApp']);

    });

