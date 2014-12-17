var ccbangApp = 
		  angular.module('ccbangApp', 
				  ['ngRoute','ccbCtrl'] //
		  );

ccbangApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider.
		when('/main', {
			templateUrl: 'js/angular/templates/main.html', 
			controller: 'todoFun'
		})
		//.when('/', {templateUrl: '', controller: ''})
		.when('/member', {
			templateUrl: 'js/angular/templates/member.html', 
			controller: 'memberCtrl'
		})
		.when('/memberDetail/:id', {
			templateUrl: 'js/angular/templates/memberDetail.html', 
			controller: 'memberDetailCtrl'
		})		
		.when('/timeline', {
			templateUrl: 'js/angular/templates/timeline.html', 
			controller: 'timelineCtrl'
		})
		.when('/joke', {
			templateUrl: 'js/angular/templates/joke.html', controller: 'jokeCtrl'
		})
		.otherwise({
			redirectTo: '/main'
		});
}]);


