<%@page import="com.jocata.model.BookType"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Account Creation </title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/AddBookStyle.css">
	
</head>
<body>
<div class="container">
  <div class="addbook">
    <h1>You can Add New Student Record here !!</h1>
    <form action = "AddBook" method = "post">
      <table  class="box">
      
     
           <tr>
               <td class="p-3 mb-2 bg-light text-white"> Title:</td>
               <td><input type='text' name='title' value='' id="title"></td>
            </tr>
 
            <tr>
               <td >Description:</td>
               <td><input type='text' name='description' value='' id="description"></td>
            </tr>
		
			<%
				List<BookType> bTypeList = (List<BookType>) request.getAttribute("bTypeList");
			%>
             <tr class="selectrow">
              <td class="selecttd">Book Type:</td>
              <td> 
              <select class="classic" name="select" id="select">
              <option value="0">Select Book Category</option>
              <%
              if(bTypeList != null){
              	for(BookType bt : bTypeList){
              %>
  					<option value="<%= bt.getId()%>" ><%= bt.getBookCategory() %></option>
  			  <%}} %>		
				   </select>
             </td>
            </tr>
                         
            <tr>
               <td >Publication:</td>
               <td><input type='text' name='publication'  id="publication"></td>
            </tr>   
            
              <tr>
               <td >Year Of Publication:</td>
               <td><input type='text' name='yearofpublication'  id="yearofpublication"></td>
            </tr> 
            
              <tr>
               <td >Ebook URL:</td>
               <td><input type='text' name='ebookurl'  id="ebookurl"></td>
            </tr> 
              
            <tr>
             	<td></td>
               <td cellspacing="10" style="text-align:right"><input class="btn btn-success" name="submit" type="submit" value="SAVE RECORD" /></td>
           </tr>
           <tr><td></td>
           <td><h5>${Ustatjsp}</h5></td></tr>
         
         </table>
         </form>
         <br>
      <div class=>
      <a href="/login">Go Home</a>
      </div>
      <br>
      <a href ="/WelcomePage">Go Back</a>
   	</div>
    </div>

</body>
</html>