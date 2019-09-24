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

<script type="text/javascript">
	function setBookId(bid){
		//alert("inside setBookId function....");
		document.getElementById("bookid").value=bid;
	}
</script>

</head>
<body class="container" style="background-image:/css/LibraryBooks.jpg">
<div >
 <h3> Welcome You Are At Books Club !!</h3>
 
    <br>
 <form action = "SendBookId" method = "post"> 
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
   	
 	   	<th><input type="hidden" name="bookid" id="bookid" /></th>
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
 	   
 	   <td><input  readonly type="text" name="bid" id="id_<%=id%>" value="<%=currentData.getId()%>" /></td>
   	
 	   	
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


 	   	<td><button class="btn btn-info btn-sm" id="btnIssue_<%=id%>" onClick="setBookId(<%=id%>);">Issue</button>
     	</td>
 	   	</tr>
 	
 	   	<%}%>
		<%}%>
		
  
   </table>
   </div>
   </form> 
 		 <a style="text-decoration:none" color= "#ffffff" href="/login">Go Home</a>
 		<br>
      <a style="text-decoration:none" color= "#ffffff" href ="/WelcomePage">Go Back</a>
   	 <br><br>  
<script>

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