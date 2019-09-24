<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.jocata.model.UserMaster"%>

<%@page import="com.jocata.model.BookType"%>
<%@page import="org.springframework.data.repository.core.support.SurroundingTransactionDetectorMethodInterceptor"%>
<%@page import="java.util.List"%>
<%@page import="com.jocata.model.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User's</title>

<link rel="stylesheet" href="css/UserStyle.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>


</head>
<body class="container" style="background-image:/css/LibraryBooks.jpg">
<div >
 <h3>You Are At User's Records !!</h3>
 
    <br>
		<div class="box">
	<table  class= "box1">
	
	<thead><tr>
	
	  <td><input type="text" placeholder="Search" id="emailSearch"></td>
  		<td><button class="btn btn-info btn-sm" onClick="SearchData();">Search</button></td>
		<td><button class="btn btn-info btn-sm"	 onClick="DisplayData()">AllData</button></td>
		<td><a id="abc"class="btn btn-warning btn-sm" href="/AddUser">Add User</a></td>
	</tr></thead>
	
   <thead><tr>
    <th>ID</th>
   	<th>Name</th>
   	<th>Username</th>
   	
   	<th>Password</th>
  
   	
   	</tr></thead>
   	<%	List<UserMaster> AllData=null; %>
   	<% 
   		if(request.getAttribute("AllDet") != null)
   			 AllData=(List<UserMaster>)request.getAttribute("AllDet");
   
	if(AllData != null){
 		for(UserMaster currentData:AllData){%>
 	   	
 	   	<%int id=(int)currentData.getId(); %>
 	   	
 	   <div >
 	   	<tr class="<%=id%>">
 	   
 	   	
 	   <td><input  readonly type="text" name="id" id="id_<%=id%>" value="<%=currentData.getId()%>" /></td>
   	
 	   	
 		<td><input readonly type="text" id="name_<%=id%>" value="<%=currentData.getName()%>" /></td>
 		
 	
 	   	<td ><input  readonly type="text" id="Username_<%=id%>" value="<%= currentData.getUserName()%>" required /></td>	
 	
 	 
 	   	
 	   	<td><input  readonly type="text" id="password_<%=id%>" value="<%=currentData.getPassWord()%>" required /></td>
 	   	
 	  
 	   	
 	 
 	   	
 	 

 	   	<td><button class="btn btn-info btn-sm" id="btnEDIT_<%=id%>" onClick="DisplayUpdateBtn(<%=id%>); ">EDIT</button>
 	   	<button  class ="btn btn-danger btn-sm" id="btnUpdate_<%=id%>" onClick="SendData('<%=id%>'); ">Update</button>
 	   	<button class ="btn btn-danger btn-sm" id="btnDelete_<%=id%>" onClick="SendDatadelete('<%=id%>');">Delete</button>

 	   	</td>
 	   	</tr>
 	
 	   	<%}%>
		<%}%>
		
  
   </table>
   </div>
 		 <a style="text-decoration:none" color= "#ffffff" href="/login">Go Home</a>
 		<br>
      <a style="text-decoration:none" color= "#ffffff" href ="/WelcomePage">Go Back</a>
   	 <br><br>  
	<script>
	
	$( document ).ready(function() {
		<c:forEach items="${AllDet}" var="allDet">
		var DBid = "<c:out value="${allDet.id}"/>";	  	
		$("#btnUpdate_"+DBid).hide();
		$("#btnDelete_"+DBid).hide();

	 	</c:forEach>


	});
	
	function DisplayData(){
		$('tbody tr').fadeIn(); 	
	}
	
	function DisplayUpdateBtn(id){	
		
		document.getElementById('name_'+id).readOnly = false;
		document.getElementById('Username_'+id).readOnly = true;		
		document.getElementById('password_'+id).readOnly = false;
	
		
		$("#btnEDIT_"+id).fadeOut();
		$("#btnUpdate_"+id).fadeIn('slow');
		$("#btnDelete_"+id).fadeIn('slow');
	}	
	
    
	   

   		 function show(id){
    	  $('tbody tr').hide()   
    	  $('tbody tr:has('+id+')').show()
    	 }
    	  function hide(id){
    	  $('tbody tr').show()   
    	  $('tbody tr:has('+id+')').hide()
    	 }
  
	function SendData(id){
		

		if(1>0) {
		var id=$("#id_"+id).val();
		var name=$("#name_"+id).val();
		var username=$("#Username_"+id).val();
		var password=$("#password_"+id).val();
	

	  	
		
		 $.post("/UpdateUser" , {sid:id,sname:name,susername:username,spassword:password} , function(data){
		       $("#result").html(data);
		        
		        $("#" + id).fadeOut('slow' , function(){$(this).replaceWith(data).fadeIn('slow');});
		           } );
		
	  	
		console.log("ID :"+id);
		console.log("name :"+name);
	
	 
				
		}
		 
	else{
		alert("Something is Wrong");
		window.location.reload();
		}
		$("#btnUpdate_"+id).fadeOut('fast');
		$("#btnDelete_"+id).fadeOut('fast');
		$("#btnEDIT_"+id).fadeIn();
		document.getElementById('name_'+id).readOnly = true;
		document.getElementById('Username_'+id).readOnly = true;
		document.getElementById('password_'+id).readOnly = true;
		

		
	}
	function SendDatadelete(id){
		var id=$("#id_"+id).val();
		var name=$("#name_"+id).val();
		var username=$("#Username_"+id).val();
		var password=$("#password_"+id).val();
		

		
		refreshPage();
		console.log("ID :"+id);
		console.log("name :"+name);

		
		$.post("/DeleteUser" , {sid:id,sname:name,susername:username,spassword:password} 
		, function(data){
		       $("#result").html(data);
		        
		        $("#" + id).fadeOut('slow' , function(){$(this).replaceWith(data).fadeIn('slow');});
		           } );
	}

	
function refreshPage(){
    window.location.reload();
} 


	</script>

	<div class="col-lg-0"></div>
   </div>
  </div>
 </div>
</body>
</html>