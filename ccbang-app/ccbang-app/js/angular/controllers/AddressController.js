//function AddrListCtrl($scope, $http) {
//	$http.get("/ssiframe/test/list")
//    	.success(function(response) {$scope.addresses = response;});
//}

var addressCtrl = angular.module('addressCtrl', []);
data
addressCtrl.controller('AddrListCtrl', ['$scope','$http', 
	function($scope,$http) {
		$http.get("/ssiframe/test/list")
	    .success(function(response) {$scope.addresses = response;});
	}]);

addressCtrl.controller('AddrDetailCtrl', ['$scope','$http','$routeParams', 
	function($scope,$http,$routeParams) {
		var id = $routeParams.id;
		var str = "/ssiframe/test/address/" + id; 
		$http.get(str)
	    .success(function(response) {$scope.addressDetail = response;});
	}]);

