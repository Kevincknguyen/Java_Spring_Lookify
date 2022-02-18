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


<div>
	
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">Artist</th>
	      <th scope="col">Song name</th>
	      <th scope="col">rating</th>
	    </tr>
	  </thead>
	  <tbody>
	  
	  <c:forEach var="song" items="${results }">
	  
	  
	    <tr>
	      <td><c:out value="${song.artist }" /></td>
	      <td><c:out value="${song.name }" /></td>
	      <td><c:out value="${song.rating}" /></td>
	    </tr>
	    
	  </c:forEach>
	    
	    
	  </tbody>
</table>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	</div>
</body>
</html>