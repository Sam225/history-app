/**
 * Created by Suamah on 06/08/2015.
 */
'use strict';

define(['angular'], function(angular) {

    /* Services */

// Demonstrate how to register services
// In this case it is a simple value service.
    angular.module('ivoireApp.services', []).
        value('version', '0.1')
        .factory('ListeEvent',['$http','$q', function($http,$q){
            var url ='http://localhost:9000/listeJson';
            function getListe(){
                var deferred =$q.defer();
                $http.get(url)
                    .then(function result(){
                        events  = result.data;
                        deferred.resolve(events);
                    }, function(error){
                        deferred.reject(error);
                    });
                 return deferred.promise;
            }

            return {
                getListe : getListe
            };
        }
   ]);


});