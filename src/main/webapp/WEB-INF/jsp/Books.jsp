<!DOCTYPE html>
<%@page import="com.jocata.model.BookType"%>
<%@page import="org.springframework.data.repository.core.support.SurroundingTransactionDetectorMethodInterceptor"%>
<%@page import="java.util.List"%>
<%@page import="com.jocata.model.BookMaster"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en">
<head>
<meta content='width=device-width, initial-scale=1.0' name='viewport'>
<title>ADMIN WELCOME</title>

<link rel="stylesheet" href="css/BooksStyle.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</head>
<body class="container" style="background-image:/css/LibraryBooks.jpg">
<div >
 <h3> Welcome You Are At Books Club !!</h3>
 
    <br>
		<div class="box">
	<table  class= "box1">
	
	<thead><tr>
	
	  <td><input type="text" placeholder="Search" id="emailSearch"></td>
  		<td><button class="btn btn-info btn-sm" onClick="SearchData();">Search</button></td>
		<td><button class="btn btn-info btn-sm"	 onClick="DisplayData()">AllData</button></td>
		<td><a id="abc"class="btn btn-warning btn-sm" href="/AddBook">Add Book</a></td>
	</tr></thead>
	
   <thead><tr>
    <th>ID</th>
   	<th>Title</th>
   	<th>Category</th>
   	<th>Description</th>
   	<th>Publisher</th>
   	<th>Year of Publish</th>
   	<th>Ebook Url</th>
   	</tr></thead>
   	<%	List<BookMaster> AllData=null; %>
   	<% 
   		if(request.getAttribute("AllDet") != null)
   			 AllData=(List<BookMaster>)request.getAttribute("AllDet");
   
	if(AllData != null){
 		for(BookMaster currentData:AllData){%>
 	   	
 	   	<%int id=(int)currentData.getId(); %>
 	   	
 	   <div >
 	   	<tr class="<%=id%>">
 	   
 	   	
 	   <td><input  readonly type="text" name="id" id="id_<%=id%>" value="<%=currentData.getId()%>" /></td>
   	
 	   	
 		<td><input readonly type="text" id="title_<%=id%>" value="<%=currentData.getTitle()%>" /></td>
 		
 	   	<%
 	   		BookType btype = currentData.getBookType();
 	   		if(btype != null){
 	   	 %>
 	   	<td ><input  readonly type="text" id="booktypeid_<%=id%>" value="<%= btype.getBookCategory() %>" required /></td>	
 	   	<%}	
 	   	 %>
 	   	
 	   	<td><input readonly type="text" id="description_<%=id%>" value="<%=currentData.getDescription()%>" required /></td>
 	 
 	   	
 	   	<td><input  readonly type="text" id="publication_<%=id%>" value="<%=currentData.getPublication() %>" required /></td>
 	   	
 	  
 	   	<td><input  readonly type="text" id="yearofpublication_<%=id%>" value="<%=currentData.getYearOfPublication() %>"/></td>
 	 
 	   	
 	   	<td><input  readonly type="text" id="ebookurl_<%=id%>" value="<%=currentData.getEbookUrl() %>" /></td>	  	


 	   	<td><button class="btn btn-info btn-sm" id="btnEDIT_<%=id%>" onClick="DisplayUpdateBtn(<%=id%>); ">EDIT</button>
 	   	<button  class ="btn btn-danger btn-sm" id="btnUpdate_<%=id%>" onClick="SendData('<%=id%>'); ">Update</button>
 	   	<button class ="btn btn-danger btn-sm" id="btnDelete_<%=id%>" onClick="SendDatadelete('<%=id%>');">Delete</button>
 	   	<!-- <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#editModal">Edit</button> -->
 		<!-- <Button class="btn btn-info" type="submit" form="form1" value="editadmin">EDIT</Button>    -->
 	    <!--	<a class ="btn btn-danger btn-sm"href="/delete" > Delete </a> -->
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
	  /*
	    $('#id_'+DBid).fadeOut();
		$('#title_'+DBid).fadeOut();
		$('#booktypeid_'+DBid).fadeOut();
		$('#description_'+DBid).fadeOut();
		$('#publication_'+DBid).fadeout(); 
	  */
	 	</c:forEach>


	});
	
	function DisplayData(){
		$('tbody tr').fadeIn(); 	
	}
	
	function DisplayUpdateBtn(id){	
		
		document.getElementById('title_'+id).readOnly = false;
		document.getElementById('booktypeid_'+id).readOnly = true;
		document.getElementById('description_'+id).readOnly = false;
		document.getElementById('publication_'+id).readOnly = false;
		document.getElementById('yearofpublication_'+id).readOnly=false;
		document.getElementById('ebookurl_'+id).readOnly = false;
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
		
		var idE;
		var firstnameE;
		var emailE;
		var departmentE;
		var lastnameE;
		var passwordE;
		var adminE;
		if(1>0) {
		var id=$("#id_"+id).val();
		var title=$("#title_"+id).val();
		var booktypeid=$("#booktypeid_"+id).val();
		var description=$("#description_"+id).val();
		var publication=$("#publication_"+id).val();
		var yearofpublication=$("#yearofpublication_"+id).val();
		var ebookurl=$("#ebookurl_"+id).val();
	  	//$.post("/encrypt",{sid:id,sfname:firstname,slname:lastname,semail:email,sDepartment:department,spass:password,sadmin:admin} , function(list){	
	  	
	  	
	  	
		
		 $.post("/UpdateBooks" , {sid:id,stitle:title,sbooktypeid:booktypeid,sdescription:description,spublication:publication,syearofpublication:yearofpublication,sebookurl:ebookurl} , function(data){
		       $("#result").html(data);
		        
		        $("#" + id).fadeOut('slow' , function(){$(this).replaceWith(data).fadeIn('slow');});
		           } );
		
	  	
		console.log("ID :"+id);
		console.log("Title :"+title);
		console.log("Book Type :"+booktypeid);
		console.log("Description :"+description);
	 
				
		}
		 
	else{
		alert("Something is Wrong");
		window.location.reload();
		}
		$("#btnUpdate_"+id).fadeOut('fast');
		$("#btnDelete_"+id).fadeOut('fast');
		$("#btnEDIT_"+id).fadeIn();
		document.getElementById('title_'+id).readOnly = true;
		document.getElementById('booktypeid_'+id).readOnly = true;
		document.getElementById('description_'+id).readOnly = true;
		document.getElementById('publication_'+id).readOnly = true;
		document.getElementById('yearofpublication_'+id).readOnly=true;
		document.getElementById('ebookurl_'+id).readOnly = true;
		
	}
	function SendDatadelete(id){
		var id=$("#id_"+id).val();
		var title=$("#title_"+id).val();
		var booktypeid=$("#booktypeid_"+id).val();
		var description=$("#description_"+id).val();
		var publication=$("#publication_"+id).val();
		var yearofpublication=$("#yearofpublication_"+id).val();
		var ebookurl=$("#ebookurl_"+id).val();
		
		refreshPage();
		console.log("ID :"+id);
		console.log("Title :"+title);
		console.log("Book Type :"+booktypeid);
		console.log("Description :"+description);
		$.post("/DeleteBook" , {sid:id,stitle:title,sbooktypeid:booktypeid,sdescription:description,spublication:publication,syearofpublication:yearofpublication,sebookurl:ebookurl} 
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