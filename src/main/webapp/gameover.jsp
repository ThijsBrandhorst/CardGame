<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="actions.GameAction"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Medieval Cards - Game Over</title>
<link href='https://fonts.googleapis.com/css?family=MedievalSharp'
	rel='stylesheet'>
<link href="./css/gameover.css" rel="stylesheet">
</head>
<body>
	<div class="game-over">
		<h1>Game Over</h1>
		<p>
			Your Last Score:
			<%=GameAction.getGame().getLastDigitOfScore()%>
		</p>
		<form action="<s:url action='setup' />" method="post"
			class="form-style">
			<label for="name">Name:</label> <input type="text" id="name"
				name="name" class="input-field">
			<button type="submit"
				style="background-color: #D2691E; color: white; padding: 10px 20px; font-size: 18px; font-family: 'MedievalSharp', serif; border-radius: 5px; cursor: pointer; transition: background-color 0.3s ease; text-align: center; border: none; margin-bottom: 10px; width: calc(100% - 42px);">
				Restart Game</button>
		</form>
		<a href="<s:url action='mainMenu' />"
			style="background-color: #D2691E; text-decoration: none; color: white; padding: 10px 20px; font-size: 18px; font-family: 'MedievalSharp', serif; border-radius: 5px; cursor: pointer; transition: background-color 0.3s ease; text-align: center; border: none; margin-bottom: 10px; width: calc(100% - 42px);">
			Main Menu </a>
	</div>
</body>
</html>

