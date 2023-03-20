<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
insert alien<br>
	<form action="addAlien">
		<input type="text" name="aid"><br>
		<input type="text"name="aname"><br>
		<input type="submit"><br>
	</form><br><br>
findalien<br>

	<form action="findId" method = "post">
		<input type="text" name="aid" required><br>
		<input type="submit"><br>
	</form>
	
	${alien}
	<br><br><br>
findalien by tech<br>

	<form action="findTech" method = "post">
		<input type="text" name="tech" required><br>
		<input type="submit"><br>
	</form>

</body>
</html>