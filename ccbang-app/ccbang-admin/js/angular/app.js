var routerApp = angular.module('ccbangAdminApp', 
		['ui.router', 'ccbCtrl']
);

/**
 * 由于整个应用都会和路由打交道，所以这里把$state和$stateParams这两个对象放到$rootScope上，方便其它地方引用和注入。
 * 这里的run方法只会在angular启动的时候运行一次。
 * @param  {[type]} $rootScope
 * @param  {[type]} $state
 * @param  {[type]} $stateParams
 * @return {[type]}
 */
routerApp.run(function($rootScope, $state, $stateParams) {
    $rootScope.$state = $state;
    $rootScope.$stateParams = $stateParams;
});

routerApp.config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/login');
    $stateProvider
	    .state('login', {
	        url: '/login',
	        templateUrl: 'js/angular/templates/login.html'
	    })
        .state('main', {
            url: '/main',
            templateUrl: 'js/angular/templates/main.html'
        })
        .state('main.jokes', {
        	parent: 'main',
            url: '/jokes',
            templateUrl: 'js/angular/templates/joke/jokes.html'
        })
        .state('main.addJoke', {
            // parent: 'main',
            url: '/addJoke',
            templateUrl: 'js/angular/templates/joke/add.html'
        })        
});

//routerApp.config(function($stateProvider, $urlRouterProvider) {
//    $urlRouterProvider.otherwise('/index');
//    $stateProvider
//        .state('index', {
//            url: '/index',
//            views: {
//                '': {
//                    templateUrl: 'tpls/home.html'
//                },
//                'main@index': {
//                    templateUrl: 'tpls/loginForm.html'
//                }
//            }
//        })
//        .state('booklist', {
//            url: '/{bookType:[0-9]{1,4}}',
//            views: { //注意这里的写法，当一个页面上带有多个ui-view的时候如何进行命名和视图模板的加载动作
//                '': {
//                    templateUrl: 'tpls/bookList.html'
//                },
//                'booktype@booklist': {
//                    templateUrl: 'tpls/bookType.html'
//                },
//                'bookgrid@booklist': {
//                    templateUrl: 'tpls/bookGrid.html'
//                }
//            }
//        })
//        .state('addbook', {
//            url: '/addbook',
//            templateUrl: 'tpls/addBookForm.html'
//        })
//        .state('bookdetail', {
//            url: '/bookdetail/:bookId', //注意这里在路由中传参数的方式
//            templateUrl: 'tpls/bookDetail.html'
//        })
//});