<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div class="container upper"></div>

		<div class="container middle">
			<div class="col-md-4"></div>
			<div class="col-md-8">
				<div class="text-left">
					<a class="btn btn-default" ng-click="openUserGroupForm()">Add
						User Group</a>
				</div>
			</div>
		</div>
		<div class="container lower">
			<div class="row searchrow">
				<div class="col-md-4"></div>
				<div class="col-md-8">
					<form class="form-inline">
						<div class="form-group">
							<input type="text" ng-model="search" class="form-control"
								placeholder="Search">
						</div>
					</form>
				</div>
			</div>
			<div>
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<table class="table dispaydata table-striped table-hover">
						<thead>
							<tr>
								<th class="col-md-2">Group Name <span
									class="glyphicon sort-icon" ng-show="sortKey=='userGroupName'"
									ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
								</th>
								<th class="col-md-1">Active <span
									class="glyphicon sort-icon" ng-show="sortKey=='isActive'"
									ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
								</th>
							</tr>
						</thead>
						<tbody>
							<tr
								ng-repeat="user in userlist | orderBy:sortKey:reverse | filter:search">
								<td ng-click="sort('userGroupName')">{{user.userGroupName}}</td>

								<td ng-click="sort('isActive')">{{user.isActive}}</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="col-md-4"></div>

			</div>
		</div>
	</div>

	<script type="text/ng-template" id="myModalContent.html">
        <div class="modal-header">
            <h4 class="modal-title">Please Provide Group Detail</h3>
        </div>

         <form name = "addFriendForm">
         <p> Group Name :
			<input ng-model = "userGroup.userGroupName" type = "text" title="UserGroupName" />
		 </p>
		 <p> Active :
		 <input ng-model = "userGroup.isActive" type = "text" title="isActive" />
		 </p>
        </form>
        
        <div class="modal-footer">
            <button class="btn btn-primary" ng-click="addUserGroup()">Submit</button>
            <button class="btn btn-warning" ng-click="cancel()">Cancel</button>
        </div>
    </script>
</body>
</html>