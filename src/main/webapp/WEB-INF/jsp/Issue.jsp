<%@page import="com.jocata.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Book Issue </title>
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
    <h1>Fill Form To Issue Book !!</h1>
    <form action = "IssueBook" method = "post">
      <table  class="box">
		
			<%
				List<Student> StudentList = (List<Student>) request.getAttribute("AllDataStudent");
				
			%>
             <tr class="selectrow">
              <td class="selecttd">Select Student :</td>
              <td> 
              <select class="classic" name="SelectStudent" id="SelectStudent">
              <option value="0">Select Student</option>
              <%
              if(StudentList != null){
              	for(Student bt : StudentList){
              %>
  					<option value="<%= bt.getId()%>"><%= bt.getRollNo() %></option>
  			  <%}} %>		
				   </select>
             </td>
            </tr>
                         
            <tr>
               <td >Book ID:</td>
               <td><input readonly type='text' name='BookId'  id="BookId" value=${BookId}></td>
            </tr>   
            
              <tr>
               <td >Issue Date :</td>
               <td><input readonly type='text' name='Date'  id="Date" value="<%= new java.text.SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date()) %>"></td>
            </tr> 
            
              <tr>
               <td >No. Of Days </td>
               <td><input type='text' name='Days'  id="Days" ></td>
            </tr> 
          
             
              <tr>
               <td >Issued By </td>
               <td><input readonly type='text' name='UserId'  id="UserId" value=${IssuedBy}></td>
            </tr> 
              
             
            <tr class="selectrow">
              <td class="selecttd">Status</td>
              <td> 
              <select class="classic" name="SelectStatus" id="SelectStatus">
              <option value="0">No</option>
              <option value="1" >Yes</option>
			  </select> 
			  </td>
			  </tr>
			  <tr>
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