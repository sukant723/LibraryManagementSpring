<%@page import="com.jocata.model.Department"%>
<%@page import="com.jocata.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Student Account Creation </title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/AddStudentStyle.css">
	
</head>
<body>
<div class="container">
  
    <br>    
    <h1>You can Add New Student Record here !!</h1>
    <br><br>
   
    <form action = "AddStudent" method = "post"" enctype="multipart/form-data">
      <table  class="box"  >
      		
      		<tr>
      		<td class="p-3 mb-2 bg-light text-white">Upload Photo</td>
      		<td><input type="file" name="spic" id="spic" accept="image/*"></td>
      		</tr>
     
           <tr>
               <td class="p-3 mb-2 bg-light text-white"> Name:</td>
               <td><input type='text' name='Name' value='' id="Name"></td>
            </tr>
 
            <tr>
               <td >Email:</td>
               <td><input type='text' name='email' value='' id="email"></td>
            </tr>
				<%
				List<Department> bTypeList = (List<Department>) request.getAttribute("dList");
			%>
             <tr class="selectrow">
              <td class="selecttd">Department:</td>
              <td> <select class="classic" name="select" id="select">
  					 <%
              if(bTypeList != null){
              	for(Department bt : bTypeList){
              %>
  					<option value="<%= bt.getId()%>" ><%= bt.getDName() %></option>
  			  <%}} %>		
				   </select>
				
             </td>
            </tr>
                         
            <tr>
               <td >Roll NO.:</td>
               <td><input type='text' name='rollno'  id="rollno"></td>
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
      
      <a href="/login">Go Home</a>
      <br>
      <a href ="/WelcomePage">Go Back</a>
   
    </div>

</body>
</html>