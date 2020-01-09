<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>RA Login</title>
<link rel="icon" type="image/png" href="icon.png">
<!-- <link rel="stylesheet" href="login.css" type="text/css"> -->
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Roboto:300);

.login-page {
	width: 360px;
	padding: 8% 0 0;
	margin: auto;
}

.form {
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-width: 360px;
	margin: 0 auto 100px;
	padding: 45px;
	text-align: center;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}

.form input {
	font-family: "Roboto", sans-serif;
	outline: 0;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

.form button {
	font-family: "Roboto", sans-serif;
	text-transform: uppercase;
	outline: 0;
	background: #4CAF50;
	width: 100%;
	border: 0;
	padding: 15px;
	color: #FFFFFF;
	font-size: 14px;
	-webkit-transition: all 0.3 ease;
	transition: all 0.3 ease;
	cursor: pointer;
}

.form button:hover, .form button:active, .form button:focus {
	background: #43A047;
}

.form .message {
	margin: 15px 0 0;
	color: #b3b3b3;
	font-size: 12px;
}

.form .message a {
	color: #4CAF50;
	text-decoration: none;
}

.form .register-form {
	display: none;
}

.container {
	position: relative;
	z-index: 1;
	max-width: 300px;
	margin: 0 auto;
}

.container:before, .container:after {
	content: "";
	display: block;
	clear: both;
}

.container .info {
	margin: 50px auto;
	text-align: center;
}

.container .info h1 {
	margin: 0 0 15px;
	padding: 0;
	font-size: 36px;
	font-weight: 300;
	color: #1a1a1a;
}

.container .info span {
	color: #4d4d4d;
	font-size: 12px;
}

.container .info span a {
	color: #000000;
	text-decoration: none;
}

.container .info span .fa {
	color: #EF3B3A;
}

body {
	background: #76b852; /* fallback for old browsers */
	background: -webkit-linear-gradient(right, #76b852, #8DC26F);
	background: -moz-linear-gradient(right, #76b852, #8DC26F);
	background: -o-linear-gradient(right, #76b852, #8DC26F);
	background: linear-gradient(to left, #76b852, #8DC26F);
	font-family: "Roboto", sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
}

.check {
	width: 10%;
}
</style>
</head>
<body>
	<%-- <%
String name=null;
name.length();
%> --%>
	<%-- <c:set var="x" value="8" scope="page"></c:set>
<c:set var="y" value="one" scope="page"></c:set>
<c:out value="${x*y}"></c:out> --%>
<%try {
	Thread.sleep(5000);
} catch (InterruptedException e) {
	e.printStackTrace();
} %>
	<div class="login-page">
		<div class="form">
			<form class="register-form">
				<input type="text" placeholder="name" /> <input type="password"
					placeholder="password" /> <input type="text"
					placeholder="email address" />
				<button onclick="">create</button>
				<p class="message">
					Already registered? <a href="#">Sign In</a>
				</p>
			</form>
			<form class="login-form" action="HomeServlet" method="post">
				<input type="text" placeholder="username" name="username" /> <input
					type="password" placeholder="password" name="password" />
				<button>login</button>
				<br> <br> <input style="width: 10%" type="checkbox"
					name="remember" value="cache"><label style="width: 10%">Remember
					Me</label>
			</form>
			<div align="center">
				<c:if test='<%=request.getAttribute("errormsg") != null%>'>
					<h4 style="color: blue; font-weight: bold;"><%=request.getAttribute("errormsg")%></h4>
				</c:if>

				<h3>
					<fmt:setLocale value="ja_JP"/>
					<fmt:setBundle basename="com.l7.i18n.Messages" />
					<fmt:message key="CountryName" />
				</h3>
			</div>
		</div>
	</div>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="./login.js"></script>

</body>
</html>