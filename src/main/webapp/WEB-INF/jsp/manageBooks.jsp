<%@page import="java.util.Collection"%>
<%@page import="com.books.factory.AppContext"%>
<%@page import="com.books.service.BookDetailsService"%>
<%@page import="com.books.entity.BookDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Amazon | Admin Home</title>
<script type="text/javascript">
	function edit(bookid,categoryname, title, author, publisher, isbn, price,
			description) {
		alert("bookid");
        document.getElementById("bookid").value = bookid;
		document.getElementById("cname").value = categoryname;
		document.getElementById("title").value = title;
		document.getElementById("author").value = author;
		document.getElementById("publisher").value = publisher;
		document.getElementById("isbn").value = isbn;
		document.getElementById("price").value = price;
		document.getElementById("description").value = description;

		document.getElementById("check").value = "update product";
		document.getElementById("action").value = "update";
	}
</script>
</head>
<body>
	<%@include file="header.jsp"%>
	<table border="1" width="100%" height="100%">
		<tr>
			<td width="20%" valign="top"><%@include file="adminMenu.jsp"%>
			</td>
			<td width="80%" valign="middle">
				<form action="Dispatcher" method="post">
					<input type="hidden" name="controllerName"
						value="bookDetailsController" /> <input type="hidden"
						name="action" id="action" value="add" /> <input type="hidden"
						id="bookid" name="bookid" value="0" />
					<table align="center">
						<tr>
							<td colspan="2" style="font-size: 4">Add New Book</td>
						</tr>

						<td align="right">Category Name</td>
						<td><input type="text" name="cname" id="cname"></td>
						</tr>
						<tr>
							<td align="center">Title</td>
							<td><input type="text" name="title" id="title"></td>
						</tr>
						<tr>
							<td align="center">Author</td>
							<td><input type="text" name="author" id="author"></td>
						</tr>
						<tr>
							<td align="center">Publisher</td>
							<td><input type="text" name="publisher" id="publisher"></td>
						</tr>
						<tr>
							<td align="center">Isbn</td>
							<td><input type="text" name="isbn" id="isbn"></td>
						</tr>
						<tr>
							<td align="center">Price</td>
							<td><input type="text" name="price" id="price"></td>
						</tr>
						<tr>
							<td align="center">Description</td>
							<td><input type="text" name="description" id="description"></td>
						</tr>
						<tr>
							<td align="right"></td>
							<td><input type="submit" id="check" name="register"
								value="Add Product" /></td>
						</tr>
					</table>
				</form> <br />
			</td>
		</tr>
	</table>
	<table align="center">
		<tr>
			<td colspan="2"><b>Existing Books</b></td>
		</tr>
		<tr>
			<th>Book Name</th>
		</tr>

		<%
			BookDetailsService bdService = (BookDetailsService) AppContext.getBean("bookDetailsService");
			Collection<Object> bdList = bdService.list();
			for (Object obj : bdList) {
				BookDetails bd = (BookDetails) obj;
		%>
		<tr>
	        <td><%=bd.getBookid() %></td>
			<td><%=bd.getCategoryname()%></td>

			<td><%=bd.getTitle()%></td>

			<td><%=bd.getAuthor()%></td>
			<td><%=bd.getPublisher()%></td>
			<td><%=bd.getIsbn()%></td>
			<td><%=bd.getPrice()%></td>
			<td><%=bd.getDescription()%></td>

			<td width="10px"></td>
			<td><a href="#"
				onclick="edit('<%=bd.getBookid() %>',<%=bd.getCategoryname()%>','<%=bd.getTitle()%>','<%=bd.getAuthor()%>','<%=bd.getPublisher()%>','<%=bd.getIsbn()%>','<%=bd.getPrice()%>','<%=bd.getDescription()%>');">edit</a></td>
			<td><a
				href="Dispatcher?controllerName=bookDetailsController&action=delete&bookid=<%=bd.getBookid()%>">delete</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>