'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
    'ngRoute',
    'ui.router',
    'ngResource',
    'myApp.Admin',
    'ngAnimate',
    'angular-growl',
    'myApp.User',
    '720kb.datepicker',
    
]).service('sharedProperties', function () {

        var baseUrl = "http://localhost:8080/api";
        return {
            getBaseUrl: function () {
                return baseUrl;
            }
        };
    }).config(['growlProvider', function(growlProvider) {
        growlProvider.globalTimeToLive(5000);
        growlProvider.globalDisableCountDown(true);
        growlProvider.globalPosition('top-center');
        growlProvider.onlyUniqueMessages(false);
    }]);;


