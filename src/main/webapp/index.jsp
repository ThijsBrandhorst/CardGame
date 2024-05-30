<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Medieval Cards - Main Menu</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href='https://fonts.googleapis.com/css?family=MedievalSharp' rel='stylesheet'>
	<link href="css/index.css" rel="stylesheet">
	
</head>
<body>
	<div class="start-menu">
		<h1>Welcome to Medieval Cards</h1>
		<a href="<s:url action='setup' />">
			<button class="start-button">Start Game</button>
		</a>
	</div>
	

	
</body>
</html>
