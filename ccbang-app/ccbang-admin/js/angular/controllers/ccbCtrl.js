var ccbCtrl = angular.module('ccbCtrl',[]);

// ccbCtrl.controller('jokeListCtrl', function ($scope, DTOptionsBuilder, DTColumnBuilder) {
//     $scope.dtOptions = DTOptionsBuilder.newOptions()
//         .withOption('ajax', {
//             // Either you specify the AjaxDataProp here
//             // dataSrc: 'data',
//             url: 'http://localhost:8888/ccserver/jokes',
//             type: 'GET'
//         })
//         // or here
//         .withDataProp('data')
//         .withOption('serverSide', true)
//         .withPaginationType('full_numbers');

//     $scope.dtColumns = [
//         DTColumnBuilder.newColumn('id').withTitle('ID'),
//         DTColumnBuilder.newColumn('content').withTitle('Content'),
//         DTColumnBuilder.newColumn('time').withTitle('Time')
//     ];
// });

// ccbCtrl.controller('addJokeCtrl', function($scope,$http,jokeService){

//     $scope.master = {};

//     $scope.save = function(){

//         $scope.master = angular.copy($scope.joke);

//         console.log($scope.joke);
//         jokeService.addJoke($scope.joke)
//         .success(function(responseDate, status) {
//                 console.log(responseDate);
//                 alert("success");
//         })
//         .error(function() {
//             alert("ajax error");
//         });;
//     };

//     $scope.reset = function(){
//         $scope.joke = angular.copy($scope.master);
//     };

//     $scope.isUnchanged = function(joke) {
//         return angular.equals(joke, $scope.master);
//     };

//     $scope.reset();
// });



// ccbCtrl.controller('jokeListCtrl2',function($scope, $http, $state, $stateParams) {
// 	$scope.filterOptions = {
//         filterText: "",
//         useExternalFilter: true
//     }; 
//     $scope.totalServerItems = 0;
//     $scope.pagingOptions = {
//         pageSizes: [5, 10, 2],
//         pageSize: 2,
//         currentPage: 1
//     };	
//     $scope.setPagingData = function(data, page, pageSize){	
//         var pagedData = data.slice((page - 1) * pageSize, page * pageSize);
//         $scope.jokes = pagedData;
//         $scope.totalServerItems = data.length;
//         if (!$scope.$$phase) {
//             $scope.$apply();
//         }
//     };
//     $scope.getPagedDataAsync = function (pageSize, page, searchText) {
//         setTimeout(function () {
//             var data;
//             if (searchText) {
//                 var ft = searchText.toLowerCase();
//                 $http.get('data/joke.json').success(function (largeLoad) {		
//                     data = largeLoad.filter(function(item) {
//                         return JSON.stringify(item).toLowerCase().indexOf(ft) != -1;
//                     });
//                     $scope.setPagingData(data,page,pageSize);
//                 });            
//             } else {
//                 $http.get('data/joke.json').success(function (largeLoad) {
//                     $scope.setPagingData(largeLoad,page,pageSize);
//                 });
//             }
//         }, 100);
//     };
	
//     $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);
	
//     $scope.$watch('pagingOptions', function (newVal, oldVal) {
//         if (newVal !== oldVal && newVal.currentPage !== oldVal.currentPage) {
//           $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
//         }
//     }, true);
//     $scope.$watch('filterOptions', function (newVal, oldVal) {
//         if (newVal !== oldVal) {
//           $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
//         }
//     }, true);
	
//   //   $scope.gridOptions = {
//   //       data: 'jokes',
// 		// rowTemplate: '<div style="height: 100%"><div ng-style="{ \'cursor\': row.cursor }" ng-repeat="col in renderedColumns" ng-class="col.colIndex()" class="ngCell ">' +
//   //           '<div class="ngVerticalBar" ng-style="{height: rowHeight}" ng-class="{ ngVerticalBarVisible: !$last }"> </div>' +
//   //           '<div ng-cell></div>' +
//   //           '</div></div>',        
//   //       enablePaging: true,
// 		// showFooter: true,
//   //       totalServerItems: 'totalServerItems',
//   //       pagingOptions: $scope.pagingOptions,
//   //       filterOptions: $scope.filterOptions
//   //   };

// 	$scope.gridOptions = {
//         data: 'jokes',
//         rowTemplate: '<div style="height: 100%"><div ng-style="{ \'cursor\': row.cursor }" ng-repeat="col in renderedColumns" ng-class="col.colIndex()" class="ngCell ">' +
//             '<div class="ngVerticalBar" ng-style="{height: rowHeight}" ng-class="{ ngVerticalBarVisible: !$last }"> </div>' +
//             '<div ng-cell></div>' +
//             '</div></div>',
//         multiSelect: false,
//         enableCellSelection: false,
//         enableRowSelection: true,
//         enableCellEdit: true,
//         enablePinning: true,
//         columnDefs: [{
//             field: 'id',
//             displayName: 'ID',
//             width: 60,
//             pinnable: false,
//             sortable: false
//         }, {
//             field: 'content',
//             displayName: 'Content',
//             enableCellEdit: true
//         }, {
//             field: 'date',
//             displayName: 'Date',
//             enableCellEdit: true,
//             width: 220
//         // }, {
//         //     field: 'price',
//         //     displayName: '定价',
//         //     enableCellEdit: true,
//         //     width: 120,
//         //     cellFilter: 'currency:"￥"'
//         //}, 
//         }, {
//             field: 'id',
//             displayName: 'Operation',
//             enableCellEdit: false,
//             sortable: false,
//             pinnable: false,
//             cellTemplate: '<div><a ui-sref="bookdetail({bookId:row.getProperty(col.field)})" id="{{row.getProperty(col.field)}}">详情</a></div>'
        
//     	}],
//         enablePaging: true,
//         showFooter: true,
//         totalServerItems: 'totalServerItems',
//         pagingOptions: $scope.pagingOptions,
//         filterOptions: $scope.filterOptions
//     };    

// });