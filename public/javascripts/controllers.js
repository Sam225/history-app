/**
 * Created by Suamah on 06/08/2015.
 */

define(function(){

    var controllers = {};

    controllers.EventCtrl = function ($scope,$http, $filter,ngTableParams,$q) {

        $http.get('http://localhost:9000/listeJson').
            success(function(data) {
                $scope.liste = data;
            }).
            error(function(data, status, headers, config) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            });


     //    $scope.data = $scope.liste;
        var api =$http.get('http://localhost:9000/listeJson').success(function(data) {
            $scope.events = data;
        });

        $scope.ListEvent = function() {
            var deferred = $q.defer();

            $http.get('http://localhost:9000/listeJson').
                success(function(data) {
                    $scope.liste = data;
                    deferred.resolve(data);
                }).
                error(function(data, status, headers, config) {
                    // called asynchronously if an error occurs
                    // or server returns response with an error status.
                    deferred.reject()
                });

            return deferred.promise;
        };




        $scope.ListEvent().then(function(data){
            $scope.event  = data;
        });

        var data = [];
        $scope.tableParams = new ngTableParams({
            page: 1,            // show first page
            count: 10,          // count per page
            sorting: {
                title: 'asc'     // initial sorting
            },
            filter: {
                title: ''       // initial filter
            }
        }, {
            total: 0,
            getData: function ($defer, params) {
                $scope.ListEvent().then(function (data) {
                   // params.total(data.length);
                    var donnne = data;
                    var orderedData =  params.filter() ? $filter('filter')(donnne, params.filter()) :  data;

                    params.total(orderedData.length); // set total for recalc pagination

                   $defer.resolve( orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));

                });

            }

        })


    }


    controllers.EventCtrl.$inject = ['$scope','$http','$filter','ngTableParams','$q'];


    controllers.EventDetailCtrl = function ($scope,$http,$routeParams) {
       $scope.param =$routeParams.eventId;
        var url = "http://localhost:9000/event/id="+$scope.param;

     $http.get(url).
            success(function(data) {
                $scope.eventDetail = data;
            }).
            error(function(data, status, headers, config) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            });


        $scope.country = function(id){
            var result;
            switch(id) {
                case 1:
                    result ="Côte D'Ivoire";
                    break;
                case 2:
                    result ="Côte D'Ivoire";
                    break;
                default:  result ="Inconnu";
                break;
            }
             return result;
        }


    }

    controllers.EventDetailCtrl.$inject = ['$scope','$http','$routeParams'];

    return controllers;

});