<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Card Game</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
        <style>
        body {
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            /* Adjust background properties */
            background-image: url("${pageContext.request.contextPath}/images/Background.jpg");
            background-size: cover;
            background-position: center;
            margin: 0; /* Ensure no default margins */
        }
        .start-menu {
            background: rgba(255, 255, 255, 0.9);
            border: 5px solid #8B4513;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.3);
            padding: 30px;
            text-align: center;
            max-width: 400px;
            z-index: 1; /* Ensure it's above background */
        }
        .start-menu h1 {
            font-family: 'Old Western', serif;
            color: #8B4513;
            margin-bottom: 20px;
        }
        .start-menu a {
            text-decoration: none;
        }
        .start-button {
            background-color: #D2691E;
            border: none;
            color: white;
            padding: 10px 20px;
            font-size: 18px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            font-family: 'Old Western', serif;
        }
        .start-button:hover {
            background-color: #A0522D;
        }
        @font-face {
            font-family: 'Old Western';
            src: url('https://www.example.com/fonts/OldWestern.ttf');
    </style>
</head>
<body>
	<div class="start-menu">
		<h1>Welcome to Card Game</h1>
		<a href="<s:url action='setup' />">
			<button class="start-button">Start Game</button>
		</a>
	</div>
	

	
</body>
</html>
