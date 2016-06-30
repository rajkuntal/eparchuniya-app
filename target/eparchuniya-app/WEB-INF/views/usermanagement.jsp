<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>usermanagement</title>
</head>
<body >
	<div class="submenubar">
		<ul class = "nav nav-tabs">
		   <li class ="active"> <a data-target="#usergroups" data-toggle="tab">User Groups</a></li>
		   <li> <a data-target="#users" data-toggle="tab">Users</a></li>
		</ul>
	</div>
	<div>
		<div class="customBody">
		<div class="col-md-2">
		</div>
			<div class="tab-content">
				<div class="tab-pane active" id="usergroups">
					<div class="col-md-8">
						<br><br><br>
						<h4> User Groups Detail </h4>
						<div ng-controller="userMgmtController">
                			<div class="page-body">
                    			<button class="btn btn-primary" ng-click="addusergroupform()">Add UserGroup</button>
               	 			</div>
            			</div>
						<table class="table table-striped table-hover">
							<thead>
							   <tr>
							      <th>UserGroupName</th>
							      <th>Active</th>
							      <th>Deactivate</th>
							   </tr>
							</thead>
							<tbody>
							   <tr>
							      <td>Hello How Are You   </td>
							      <td>Active</td>
							      <td>Active</td>
							   </tr>
							   <tr>
							      <td>Hello How Are You   </td>
							      <td>Active</td>
							      <td>Active</td>
							   </tr>
							   <tr>
							      <td>Hello How Are You   </td>
							      <td>Active</td>
							      <td>Active</td>
							   </tr>
							   <tr>
							      <td>Hello How Are You   </td>
							      <td>Active</td>
							      <td>Active</td>
							   </tr>
							   <tr>
							      <td>Hello How Are You   </td>
							      <td>Active</td>
							      <td>Active</td>
							   </tr>
							   <tr>
							      <td>Hello How Are You   </td>
							      <td>Active</td>
							      <td>Active</td>
							   </tr>
							   <tr>
							      <td>Hello How Are You   </td>
							      <td>Active</td>
							      <td>Active</td>
							   </tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="tab-pane" id="users">
					<div class="col-md-8">
						<br><br><br>
						<h4>Users Detail</h4>
							<table class="table table-striped table-hover">
							<thead>
							   <tr>
							      <th>User Name</th>
							      <th>Mobile Number</th>
							      <th>Group Name</th>
							      <th>Address</th>
							   </tr>
							</thead>
							<tbody>
								<tr>
									<td> Raj Kumar </td>
									<td> 9986080444 </td>
									<td> ADMIN </td>
									<td> AJAN </td>
								</tr>
								<tr>
									<td> Raj Kumar </td>
									<td> 9986080444 </td>
									<td> ADMIN </td>
									<td> AJAN </td>
								</tr>
								<tr>
									<td> Raj Kumar </td>
									<td> 9986080444 </td>
									<td> ADMIN </td>
									<td> AJAN </td>
								</tr>
								<tr>
									<td> Raj Kumar </td>
									<td> 9986080444 </td>
									<td> ADMIN </td>
									<td> AJAN </td>
								</tr>
								<tr>
									<td> Raj Kumar </td>
									<td> 9986080444 </td>
									<td> ADMIN </td>
									<td> AJAN </td>
								</tr>
								<tr>
									<td> Raj Kumar </td>
									<td> 9986080444 </td>
									<td> ADMIN </td>
									<td> AJAN </td>
								</tr>
								<tr>
									<td> Raj Kumar </td>
									<td> 9986080444 </td>
									<td> ADMIN </td>
									<td> AJAN </td>
								</tr>
								<tr>
									<td> Raj Kumar </td>
									<td> 9986080444 </td>
									<td> ADMIN </td>
									<td> AJAN </td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>