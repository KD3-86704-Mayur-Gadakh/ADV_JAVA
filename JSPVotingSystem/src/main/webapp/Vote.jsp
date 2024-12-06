<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voting </title>
</head>
<body>

<h2>Voting Status </h2>


<jsp:useBean id="vb" class="com.sunbeam.Beans.VoteBean" />
<jsp:setProperty  name="vb" property="candId" param="candidate"/>
<jsp:setProperty  name="vb" property="userId" value="${lg.user.id}"/>
${lg.user.status}
${lg.user.id}
<c:choose>
		<c:when test="${lg.user.status == 0}">
		${vb.vote()}
			<c:choose>
				<c:when test="${vb.success}">
					<p>You Voted Successfully</p>
					${lg.user.setStatus(1)}
				</c:when>
				<c:otherwise>
					<p>Your voting failed.</p>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<p>You already voted.</p>
	</c:otherwise>
	</c:choose>
	<p>
	<a href="logout.jsp">Sign Out</a>
	</p>


</body>
</html>