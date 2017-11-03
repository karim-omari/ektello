'use strict';

angular.module('myApp.User', ['ui.router'])

.config(['$stateProvider', function($stateProvider) {
    $stateProvider.state({
        name: "User",
        url: '^/user',
        templateUrl: 'User/User.html',
        controller: 'UserCtrl'
    });
}])

.controller('UserCtrl', ["$scope","$http" ,"sharedProperties","growl",
  function($scope, $http,sharedProperties,growl) {
   
	$scope.showForm = true;
    $scope.user = {
        "firstName": "",
        "lastName": "",
        "address1": "",
        "address2": "",
        "city": "",
        "state": "",
        "zip": "",
        "country": "US",
    }

    $scope.submit = function(){
     if (validateForm()){
    	 $http({
             method : "POST",
             url : "/api/user/add",
             headers: {
           	   'Content-Type': 'application/json'
           	 },
             data : $scope.user
         }).then(function mySuccess(response) {
                growl.success("Registration Form Submitted Successfuly");
                $scope.showForm = false;
         }, function myError(response) {
             growl.error(response.statusText);
         });
     }
        
    }

    var validateForm = function(){
    	if ($scope.user.firstName.length == 0){
    		 growl.error("First Name is Required");
    		 return false;
    	}
    	else if ($scope.user.lastName.length == 0){
   		 growl.error("Last Name is Required");
   		 return false;
    	}
    	else if ($scope.user.address1.length == 0){
      		 growl.error("Address 1 is Required");
      		 return false;
       	}
    	else if ($scope.user.city.length == 0){
      		 growl.error("City is Required");
      		 return false;
       	}
    	else if ($scope.user.state.length == 0){
      		 growl.error("State is Required");
      		 return false;
       	}
    	else if ($scope.user.zip.length != 5){
      		 growl.error("Zip is wrong");
      		 return false;
       	}
    	else
    		return true;
    }

    }]);