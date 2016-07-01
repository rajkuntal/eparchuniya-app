'use strict';

MyApp.controller('userMgmtController', [
        'ModalService',
		'$scope',
		'$http',
		'$log',

		function(ModalService, $scope, $http, $log) {

			$scope.show = function() {
		        ModalService.showModal({
		            templateUrl: 'modal.html',
		            controller: "UserGroupFormController"
		        }).then(function(modal) {
		            modal.element.modal();
		            modal.close.then(function(result) {
		                $scope.userGroupName = usergroup.name;
		            });
		        });
		    };
			
		} ]);

MyApp.controller('UserGroupFormController', function($scope, close) {
	
	$scope.userGroupName = null;
	  
	 $scope.close = function(result) {
	 	close(result, 500); // close, but give 500ms for bootstrap to animate
	 };
	 
	 $scope.addUserGroup = function() {
		 	
		userGroupName : $scope.userGroupName;
		isActive : $scope.isActive;
				
			var userGroup = angular.toJson($scope.data);

			$http.post('/eparchuniya-app/REST/usergroupmanagement/addUserGroup', userGroup
					).then(
					function(response) {
						$log.info(response.data);
						$log.info($scope.userlist);
					}, function(reason) {
						$scope.error = reason.data;
						$log.info(reason);
					});
		};

	});