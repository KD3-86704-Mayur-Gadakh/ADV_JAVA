<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidates</title>
</head>
<body>
<h2>BJP WINS</h2>

<body>
	<h2>Voting Result</h2>
	<jsp:useBean id="rb" class="com.sunbeam.Beans.ResultBean"/>
	${rb.fetchCandidate()}

	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Party</th>
				<th>Votes</th>
				<th>Action</th>
			</tr>
		</thead>
	<tbody>
			<c:forEach var="can" items="${rb.candList}">
				<tr>
					<td>${can.id}</td>
					<td>${can.name}</td>
					<td>${can.party}</td>
					<td>${can.votes}</td>
					<td>
						<a href="editCand.jsp?id=${can.id}">
							<img src="images/edit.jpg" alt="Edit" width="20" height="20"/>
					</a>
						<a href="deleCand.jsp?id=${can.id}">
							<img src="images/delete.jpg" alt="Delete" width="20" height="20"/>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<p>${param.msg}</p>
	<p>
<a href="logout.jsp">Sign Out</a>
	</p>
</body>
</html>