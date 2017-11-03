'use strict';

angular.module('myApp.Admin', ['ui.router'])

    .config(['$stateProvider', function($stateProvider) {
        $stateProvider.state({
            name: "Admin",
            url: '^/admin',
            templateUrl: 'Admin/Admin.html',
            controller: 'AdminCtrl'
        });
    }])

    .controller('AdminCtrl', [ "$scope" ,"$http", function($scope,$http) {

        $scope.users = [] ;

       var getAll =  function() {
       $http({
              method : "GET",
              url : "/api/user/all"
          }).then(function mySuccess(response) {
              $scope.users = response.data;
          }, function myError(response) {
              growl.error(response.statusText);
          });
        };

        getAll();

    }]);