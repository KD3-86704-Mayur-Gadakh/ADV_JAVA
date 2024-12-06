<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>

<h3>Register User</h3>


<div>

<jsp:useBean id="rb" class="com.sunbeam.Beans.RegisterBean"/>
<jsp:setProperty property="firstName" name="rb" param="fname"/>
<jsp:setProperty property="lastName" name="rb" param="lname"/>
<jsp:setProperty property="email" name="rb" param="email"/>
<jsp:setProperty property="passwd" name="rb" param="passwd"/>
<jsp:setProperty property="dob" name="rb" param="dob"/>
<%rb.registerUser(); %>
User count :<jsp:getProperty property="count" name="rb"/>



<c:choose>
       
          


            <c:set var="isUserRegister" value="${rb.count==1}" />

            <c:choose>
                <c:when test="${isUserRegister}">
                    <c:redirect url="Candidate.jsp" />
                </c:when>

                <c:otherwise>
                    <c:redirect url="Register.jsp" />
                </c:otherwise>
            </c:choose>
     

       
    </c:choose>


</div>


</body>
</html>