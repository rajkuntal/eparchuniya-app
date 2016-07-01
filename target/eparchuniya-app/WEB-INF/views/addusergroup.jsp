<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body >
	<div ng-controller="userGroupController as ctrl">
		<form ng-submit="ctrl.addUserGroup()">
			<h3>Add User Group</h3>
			<p>
				GroupName: <input type="text" data-ng-model="ctrl.userGroupName">
			</p>
			<p>
				isActive: <input type="text" data-ng-model="ctrl.isActive">
			</p>
			<input type="submit" id="submit" value="Submit" /><br>

			<h4>List of Users :</h4>
			<div>
			<form class="form-inline">
		        <div class="form-group">
		            <label >Search</label>
		            <input type="text" ng-model="search" class="form-control" placeholder="Search">
		        </div>
    		</form>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
						<td>User Group Id
							<span class="glyphicon sort-icon" ng-show="sortKey=='userGroupId'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
							<td>User Group Name
							<span class="glyphicon sort-icon" ng-show="sortKey=='userGroupName'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></td>
							<td>Active
							
						<span class="glyphicon sort-icon" ng-show="sortKey=='isActive'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
							</td>
						</tr>
					</thead>
					<tr ng-repeat="user in userlist | orderBy:sortKey:reverse | filter:search">
						<td ng-click="sort('userGroupId')">{{user.userGroupId}}</td>
						<td ng-click="sort('userGroupName')">{{user.userGroupName}}</td>
						
						<td ng-click="sort('isActive')">{{user.isActive}}</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>