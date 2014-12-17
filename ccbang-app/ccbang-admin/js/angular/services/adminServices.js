var ajaxService = angular.module('ajaxService', [] );

var baseUrl = 'http://localhost:8888/ccserver/';

ajaxService.factory('jokeService', ['$http', 
    function($http){


        var jokeObj = {};

        jokeObj.getJokeList = function(){
            return $http.get(baseUrl);
        };

        jokeObj.getJokeList1 = function(url){
            return $http.get(url);
        } ;

		jokeObj.addJoke = function(joke){
            return $http.put(baseUrl + 'joke',joke);
        }  ;               

        return jokeObj;
    }
]);



