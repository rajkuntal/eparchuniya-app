'use strict';
 
App.controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
          var self = this;
          self.user={id:null,username:'',address:'',email:''};
          self.users=[];
          $scope.flags = ["Y","N"];
          $scope.stores = [{"storeId":"BTM"},{"storeId":"JP Nagar"}];
           
          self.createUser = function(user){
              UserService.createUser(user)
                      .then(
                      self.fetchAllUsers, 
                              function(errResponse){
                                   console.error('Error while creating User.');
                              } 
                  );
          };
          
          self.reset = function(){
              self.user={id:null,username:'',address:'',email:''};
              $scope.myForm.$setPristine(); //reset Form
          };
}]);