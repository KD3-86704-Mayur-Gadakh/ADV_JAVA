<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form </title>
</head>
<body>

<h3>Login User</h3>

<div>
<jsp:useBean id="lg" class="com.sunbeam.Beans.LoginBean" scope="session"/>
<jsp:setProperty property="email" name="lg" param="email"/>
<jsp:setProperty property="passwd" name="lg" param="passwd"/>
<%lg.execute(); %>
User Form Database :<jsp:getProperty property="user" name="lg"/>
<%lg.getUser();
lg.getPasswd();
%>


param email :${email}
param password :${password}
userEmail:${useremail}
userpassword:${userPassword}



<c:choose>
        <c:when test="${lg.user != null}">
          


            <c:set var="isUserLogin" value="${email == useremail && password == userPassword}" />

            <c:choose>
                <c:when test="${lg.user.role=='admin'}">
                    <c:redirect url="Result.jsp" />
                </c:when>

                <c:otherwise>
                    <c:redirect url="CandidateList.jsp" />
                </c:otherwise>
            </c:choose>
        </c:when>

       
    </c:choose>



</div>

</body>
</html>