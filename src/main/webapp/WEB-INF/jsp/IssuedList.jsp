<!DOCTYPE html>
<%@page import="com.jocata.model.BookType"%>
<%@page import="org.springframework.data.repository.core.support.SurroundingTransactionDetectorMethodInterceptor"%>
<%@page import="java.util.List"%>
<%@page import="com.jocata.model.BookMaster"%>
<%@page import="com.jocata.model.BookIssue"%>
<%@page import="com.jocata.model.Student"%>
<%@page import="com.jocata.model.UserMaster"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en">
<head>
<meta content='width=device-width, initial-scale=1.0' name='viewport'>
<title>Book Return Page</title>

<link rel="stylesheet" href="css/BooksStyle.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<script>
function DisplayData(){
	$('tbody tr').fadeIn(); 	
}
  	
function SendData(id){
	
	
	if(1>0) {
	var id=$("#id_"+id).val();
  	
	
	 $.post("/UpdateReturn" , {sid:id} , function(data){
	       $("#result").html(data);
	        
	        $("#" + id).fadeOut('slow' , function(){$(this).replaceWith(data).fadeIn('slow');});
	           } );
	
  	
	console.log("ID :"+id);
	
	refreshPage();
			
	}
}

function refreshPage(){
window.location.reload();
} 

</script>
</head>
<body class="container" style="background-image:/css/LibraryBooks.jpg">
<div >
 <h3> Welcome You Are At Return Center!!</h3>
 
    <br>
		<div class="box">
	<table  class= "box1">
	
	<thead><tr>
	
	  <td><input type="text" placeholder="Search" id="emailSearch"></td>
  		<td><button class="btn btn-info btn-sm" onClick="SearchData();">Search</button></td>
		<td><button class="btn btn-info btn-sm"	 onClick="DisplayData()">AllData</button></td>
	
	</tr></thead>
	
   <thead><tr>
    <th>ID</th>
   	<th>Student Roll No</th>
   	<th>Book Name</th>
   	<th>Issue Date</th>
   	<th>No Of Days</th>
   	<th>Issued By</th>
   	<th>Status</th>
   	</tr></thead>
   	<%	List<BookIssue> AllData=null; %>
   	<% 
   		if(request.getAttribute("AllDet") != null)
   			 AllData=(List<BookIssue>)request.getAttribute("AllDet");
   
	if(AllData != null){
 		for(BookIssue currentData:AllData){%>
 	   	
 	   	<%int id=(int)currentData.getId(); %>
 	   	
 	   <div >
 	   	<tr class="<%=id%>">
 	   
 	   	
 	   <td><input  readonly type="text" name="id" id="id_<%=id%>" value="<%=currentData.getId()%>" /></td>
 	   
 	   <%
 	   		Student btype = currentData.getStudid();
 	   		if(btype != null){
 	   	 %>
 	   	<td ><input  readonly type="text" id="sname_<%=id%>" value="<%= btype.getRollNo()%>" required /></td>	
 	   	<%}	
 	   	 %>
 	   	 
   	   <%
 	   		BookMaster btype1 = currentData.getBookid();
 	   		if(btype != null){
 	   	 %>
 	   	
 		<td><input readonly type="text" id="title_<%=id%>" value="<%=btype1.getTitle()%>" /></td>
 		
 	   		<%}	
 	   	 %>
 	   	
 	   	<td><input readonly type="text" id="issuedate_<%=id%>" value="<%=currentData.getIssueDate()%>" required /></td>
 	 
 	   	
 	   	<td><input  readonly type="text" id="noofdays_<%=id%>" value="<%=currentData.getNoDfDays() %>" required /></td>
 	   	
 	   	 
   	   <%
 	   		UserMaster btype2 = currentData.getIssuedBy();
 	   		if(btype != null){
 	   	 %>
 	   	
 	   	<td><input  readonly type="text" id="username_<%=id%>" value="<%=btype2.getName()%>"/></td>
 	 	<%}	
 	   	 %>
 	   	<%if(currentData.getReturned()==0) {%>
 	   	<td><input  readonly type="text" id="status_<%=id%>" value="No" /></td>	  	
         <%}%>
         <%if(currentData.getReturned()==1) {%>
 	   	<td><input  readonly type="text" id="status_<%=id%>" value="Yes" /></td>	  	
         <%}%>

 	   	<td><button class="btn btn-success btn-sm" id="btnReturn_<%=id%>" onClick="SendData('<%=id%>'); ">Return</button>
 	  
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


	<div class="col-lg-0"></div>
   </div>
  </div>
 </div>
</body>
</html>