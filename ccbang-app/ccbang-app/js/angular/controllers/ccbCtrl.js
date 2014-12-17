var ccbCtrl = angular.module('ccbCtrl', ['ajaxService']);

ccbCtrl.controller('todoFun', ['$scope', function($scope) {
	
}]);

ccbCtrl.controller('jokeCtrl', ['$scope','jokeService',
 function($scope,jokeService) {

		jokeService.getJokeList()
	        .success(function(responseDate, status) {
	        	console.log(responseDate);
	            $scope.jokes = responseDate.data;
        }); 	

	
}]);

ccbCtrl.controller('timelineCtrl', ['$scope','timelineService',
 function($scope,timelineService) {

		timelineService.getTimelineList()
	        .success(function(responseDate, status) {
	        	console.log(responseDate);
	            $scope.timelines = responseDate;
        });

        $scope.timelineStyle = function(category){
        	if(category == '0'){
        		return '';
        	}else{
        		return 'timeline-inverted';
        	}
        } 	

	
}]);

ccbCtrl.controller('memberCtrl', ['$scope','memberService',
 function($scope,memberService) {

		memberService.getMemberList()
	        .success(function(responseDate, status) {
	        	console.log(responseDate);
	            $scope.members = responseDate;
        }); 	

	
}]);

ccbCtrl.controller('memberDetailCtrl', ['$scope','$routeParams','memberDetailService',
 function($scope,$routeParams,memberDetailService) {
 		var id = $routeParams.id;
		memberDetailService.getMemberDetail(id)
	        .success(function(responseDate, status) {
	        	console.log(responseDate);
	            $scope.memberDetail = responseDate;
        }); 	

	
}]);

