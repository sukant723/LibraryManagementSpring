<html>
<head>
<title>UPDATE</title>
<link href="webjars/bootstrap/4.2.1/css/bootstrap.min.css" 
	rel="stylesheet">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</head>
<body >
<div class="container">
<h1>Welcome <a id="1"></a> !!</h1>
    
    <br>
    
   ${Ustatjsp}
    <br><br>
   
      <table cellspacing="20" class = "table table-striped" >
      		<tr>
               <td></td>
               <td><input type='hidden' name='id' value='${id}'></td>
            </tr>
           <tr>
               <td>First Name:</td>
               <td id="6"></td>
            </tr>
            <tr>
               <td>Last Name:</td>
               <td id="2"></td>
            </tr>
            
            <tr>
               <td>Email:</td>
               <td id="3"></td>
            </tr>
              <tr>
               <td>Department:</td>
               <td id="4"></td>
            </tr>
            
            <tr>
               <td>Password:</td>
               <td id="5"></td>
            </tr>
              <tr>
               <td></td>
               <td><input type='hidden'></td>
            </tr>
            
         </table>
        <br><br>
    <a class="btn btn-info" href="/login">Go Home</a>
	<br><br>
	</div>
	
</body>
<script>
	
	$( document ).ready(function(){
	
		
		var id='${id}';
		var firstname='${firstname}';
		var lastname='${lastname}';
		var email='${email}';
		var department='${department}';
		var password='${password}';
		var admin='${access}';
	  	$.post("/decrypt",{sid:id,sfname:firstname,slname:lastname,semail:email,sDepartment:department,spass:password,sadmin:admin} , function(list){	
	  	
	  	
	  	 id=list[0];
		 firstname=list[1];
		 lastname=list[2];
		 email=list[3];
		 department=list[4];
		 password=list[5];
		 admin=list[6];
		 
		 //table data 
		 
		 document.getElementById('1').innerHTML =  firstname
			 document.getElementById('2').innerHTML = lastname
				 document.getElementById('3').innerHTML = email
					 document.getElementById('4').innerHTML = department
						 document.getElementById('5').innerHTML = password
						  document.getElementById('6').innerHTML = firstname
	  	})
	  	});
	
	
</script>

</html>
