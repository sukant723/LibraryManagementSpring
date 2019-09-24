<!DOCTYPE html>
<%@page import="org.springframework.data.repository.core.support.SurroundingTransactionDetectorMethodInterceptor"%>
<%@page import="java.util.List"%>
<%@page import="com.jocata.model.Details"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en">
<head>
<meta content='width=device-width, initial-scale=1.0' name='viewport'>
<title>ADMIN WELCOME</title>


<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/handsontable@7.0.0/dist/handsontable.full.min.js"></script>

<link href="https://cdn.jsdelivr.net/npm/handsontable@7.0.0/dist/handsontable.full.min.css" rel="stylesheet" media="screen">

<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>


<div class="container">
<div class="row">
	<div class="col-xs-0"></div>
	<div class="col-xs-12">
	<div id="table">
</div>
</div>
<div class="col-xs-0"></div>
</div></div>
<script>

var jsonObject = JSON.parse('${AllDet}');
console.log(jsonObject);
	
	var
	 container = document.getElementById('table');
	 searchFiled = document.getElementById('search_field'),
	 hot = new Handsontable(container, {
	  data: jsonObject,
	  rowHeaders: true,
	  colHeaders: ['ID', 'First Name', 'Last Name', 'Email','Department','PassWord','admin'],
	  columns: [
	    {data: 'id'},
	    {data: 'firstName'},
	    {data: 'lastName'},
	    {data: 'email'},
	    {data: 'department'},
	    {data: 'password'},
	    {data: 'admin'}
	  ],
	  search: true,
	  filters: true,
	  manualRowMove: true,
	  bindRowsWithHeaders: 'strict',
	  dropdownMenu: true,
	  licenseKey: 'non-commercial-and-evaluation'

	});
	
	Handsontable.dom.addEvent(searchFiled, 'keyup', function (event) {
		  var search = hot.getPlugin('search');
		  var queryResult = search.query(this.value);

		  console.log(queryResult);
		  hot.render();
		});
	
</script>


</body>
</html>