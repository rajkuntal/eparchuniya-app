<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
<div>
					Toggle column: 
					<a class="toggle-vis" data-column="0">User GroupId</a> 
					<a class="toggle-vis" data-column="1">User Group Name</a> 
					<a class="toggle-vis" data-column="2">is Active</a> 
				</div>
	<table id="dataTableExample" class="display" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>User GroupId</th>
					<th>User Group Name</th>
					<th>is Active</th>
				</tr>
			</thead>
		</table>
</body>
<script type="text/javascript">
$(document).ready(function() {
    var table = $('#dataTableExample').DataTable( {
        "ajax": {
            "url": "http://localhost:8080/eparchuniya-app/REST/usergroupmanagement/usergroups",
            "type": "GET",
            "dataSrc": ""
           },
            "columns": [
            { "data": "userGroupId" },
            { "data": "userGroupName" },
            { "data": "isActive" }
        ]
    } );

    $('a.toggle-vis').on( 'click', function (e) {
        e.preventDefault();
 
        // Get the column API object
        var column = table.column( $(this).attr('data-column') );
 
        // Toggle the visibility
        column.visible( ! column.visible() );
    } );

} );
</script>
</html>