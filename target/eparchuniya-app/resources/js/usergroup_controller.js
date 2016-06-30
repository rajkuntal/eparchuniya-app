'use strict';

App.controller('userGroupController', [
		'$scope',
		'$http',
		'$log',
		function($scope, $http, $log) {

			$scope.userlist = '';
			
			$scope.userGroupId = "";
			$scope.userGroupName = "";
		    $scope.isActive = "";
			
			this.addUserGroup = function() {

				$scope.data = {
					userGroupId : this.userGroupId,
					userGroupName : this.userGroupName,
					isActive : this.isActive
				};
				var userGroup = angular.toJson($scope.data);

				$http.post('/eparchuniya-app/REST/usergroupmanagement/addUserGroup', userGroup
						).then(
						function(response) {
							$scope.userlist = response.data;
							$log.info(response.data);
							$log.info($scope.userlist);
						}, function(reason) {
							$scope.error = reason.data;
							$log.info(reason);
						});
			},
			
		       
		    $scope.sort = function(keyname){
		           $scope.sortKey = keyname;   //set the sortKey to the param passed
		           $scope.reverse = !$scope.reverse; //if true make it false and vice versa
		       },

			$scope.getAllUserGroups = function() {

				$http({
					method : "GET",
					url : "/eparchuniya-app/REST/usergroupmanagement/usergroups",
				}).then(function(response) {
					$scope.userlist = response.data;
					$log.info(response.data);
					$log.info($scope.userlist);
				}, function(reason) {
					$scope.error = reason.data;
					$log.info(reason);
				});
			},

			$scope.getAllUserGroups();
			
		} ]);