'use strict';

MyApp.controller('UserGroupCtrl', function($scope, $modal, $log, $http) {

	$scope.userGroup = {
		userGroupName : "",
		isActive : ""
	}

	$scope.userlist = '';

	$scope.openUserGroupForm = function() {

		var modalInstance = $modal.open({
			templateUrl : 'myModalContent.html',
			controller : 'UserGroupModalInstanceCtrl',
			resolve : {
				userGroup : function() {
					return $scope.userGroup;
				}
			}
		});

		modalInstance.result.then(function() {
			// $scope.user.name = user.name;

		}, function() {
			$log.info('Modal dismissed at: ' + new Date());
		});
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

	$scope.sort = function(keyname) {
		$scope.sortKey = keyname; // set the sortKey to the param passed
		$scope.reverse = !$scope.reverse; // if true make it false and vice
	};

});

MyApp.controller('UserGroupModalInstanceCtrl', function($log, $scope,
		$modalInstance, $http, userGroup) {

	$scope.userGroup = userGroup;

	$log.info('User :----' + $scope.userGroup.userGroupName);

	$scope.addUserGroup = function() {

		$log.info('User Ok :----' + $scope.userGroup.userGroupName);
		$log.info('User Ok :----' + $scope.userGroup.isActive);

		var userGroupData = angular.toJson($scope.userGroup);

		$http.post('/eparchuniya-app/REST/usergroupmanagement/addUserGroup',
				userGroupData).then(function(response) {
			$scope.userlist.push(userGroupData);
			$log.info($scope.userlist);
		}, function(reason) {
			$scope.error = reason.data;
			$log.info(reason);
		});

		$modalInstance.close();
	};

	$scope.cancel = function() {
		$modalInstance.dismiss('cancel');
	};
});
