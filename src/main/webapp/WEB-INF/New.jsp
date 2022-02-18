<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>

Add a new song today!
</h1>


<form:form action="/api/create" method="post" modelAttribute="song">
				<p>
					<form:label path="name">Song Name</form:label>
					<form:errors path="name" class="text-danger"/>
					<form:input path="name" />
				</p>
					<form:label path="artist">Artist</form:label>
					<form:errors path="artist" class="text-danger"/>
					<form:input path="artist" />
				<p>
					<form:label path="rating">Rating</form:label>
					<form:errors path="rating" class="text-danger"/>
					<form:input type="number" min="1" max="10" path="rating" />
				</p>
				<p>
					<input type=submit value="Submit"/>
				</p>
				
				
	</form:form>
</body>
</html>