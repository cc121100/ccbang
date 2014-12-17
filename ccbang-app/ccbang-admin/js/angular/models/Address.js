var AddressApp = angular.module('Address', ['ngRoute','addressCtrl']);

AddressApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider.
		when('/addresses', {templateUrl: 'static_resources/angular/templates/addresses.html', controller: 'AddrListCtrl'})
		
		.when('/address/:id', {templateUrl: 'static_resources/angular/templates/addressDetail.html', controller: 'AddrDetailCtrl'})
		
		.otherwise({
			redirectTo: ''
		});
}]);


