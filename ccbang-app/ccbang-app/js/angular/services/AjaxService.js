var ajaxService = angular.module('ajaxService', [] );


ajaxService.factory('jokeService', ['$http', 
    function($http){

        var baseUrl = 'http://localhost:8888/ccserver/jokes';

        var joke = {};

        joke.getJokeList = function(){
            return $http.get(baseUrl);
        }

        joke.getJokeList1 = function(url){
            return $http.get(url);
        }        

        return joke;
    }
]);



ajaxService.factory('timelineService', ['$http', 
    function($http){

        var baseUrl = 'data/timeline.json';

        var timeline = {};

        timeline.getTimelineList = function(){
            return $http.get(baseUrl);
        }

        return timeline;
    }
]);

ajaxService.factory('memberService', ['$http', 
    function($http){

        var baseUrl = 'data/member.json';

        var member = {};

        member.getMemberList = function(){
            return $http.get(baseUrl);
        }

        return member;
    }
]);


ajaxService.factory('memberDetailService', ['$http', 
    function($http){

        var baseUrl = 'data/memberDetail';
        var urlSuffix = ".json";

        var memberDetail = {};

        memberDetail.getMemberDetail = function(id){
            var url = baseUrl + "_" + id + urlSuffix;
            return $http.get(url);
        }

        return memberDetail;
    }
]);
