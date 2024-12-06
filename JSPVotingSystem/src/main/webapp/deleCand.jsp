<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Delete Candidate Here</h2>

	<jsp:useBean id="dcb" class="com.sunbeam.Beans.DeleteCandidate"/>
	<jsp:setProperty name="dcb" property="candId" param="id" />
	${dcb.deleteCandidate()}
	<c:choose>
	
	<c:when test="${ dcb.count==1}">
	<jsp:forward page="Result.jsp">
	<jsp:param value=" Candidate DeletedSuccessfully" name="msg"/>
	</jsp:forward>
	</c:when>
	
	<c:otherwise>
	<jsp:forward page="Result.jsp">
	<jsp:param value="Faild to Delete Candidate" name="msg"/>
	
	</jsp:forward>
	</c:otherwise>
	
	</c:choose>
	<




</body>
</html>