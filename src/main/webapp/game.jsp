<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="actions.GameAction"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Medieval Cards - Game</title>

<link href='https://fonts.googleapis.com/css?family=MedievalSharp'
	rel='stylesheet'>
<link rel="icon" href="images/favicon.png">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<link href="css/game.css" rel="stylesheet">

</head>
<body>

	<!-- Menu btns -->
	<div
		class="container-fluid position-absolute d-flex justify-content-end">
		<button type="button" class="btn mt-3" data-bs-toggle="modal"
			data-bs-target="#leaderboardModal">
			<img src="images/leaderboard.png">
		</button>
		<button type="button" class="btn mt-3" data-bs-toggle="modal"
			data-bs-target="#infoModal">
			<img src="images/info.png">
		</button>
	</div>
	<!-- Menu btns -->

	<!-- Card -->
	<div
		class="container fs-1 fw-bold text-white position-absolute top-50 start-50 translate-middle"
		style="pointer-events: none;">
		<div class="row d-flex justify-content-center mb-4">
			<%=GameAction.getGame().getLastDigitOfScore()%>
		</div>
		<div class="row d-flex justify-content-center mt-4">
			<img src="<%=GameAction.getGame().getCurrentCard().getUrl()%>"
				class="card m-0 p-0">
		</div>
	</div>
	<!-- Card -->

	<!-- Gameplay btns -->
	<div class="container-fluid">
		<div class="row main-wrapper">
			<a href='<s:url action="higher" />' class="col btn-custom-higher">
				<i
				class="bi bi-caret-up-fill position-absolute top-50 translate-middle"
				style="left: 25vw"></i>
			</a> <a href='<s:url action="lower" />' class="col btn-custom-lower">
				<i
				class="bi bi-caret-down-fill position-absolute top-50 translate-middle"
				style="left: 75vw"></i>
			</a>
		</div>
	</div>
	<!-- Gameplay btns -->

	<!-- Info modal -->
	<div class="modal fade" id="infoModal" tabindex="-1"
		aria-labelledby="infoModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header text-center">
					<h1 class="modal-title fs-5 w-100" id="infoModalLabel">How to
						play</h1>
				</div>
				<div class="modal-body">
					<p class="text-center">
						<strong>Gameplay:</strong>
					</p>
					<p class="text-center">Er wordt een kaart getoond, aan jou de
						taak om de juiste keuze te maken: zal de volgende kaart hoger of
						lager zijn? Klik op de pijl omhoog voor "hoger" of op de pijl
						omlaag voor "lager". Probeer zoveel mogelijk juiste antwoorden te
						geven en kom op het leaderboard terecht! Veel succes!!</p>
					<hr>
					<div class="row">
						<p class="text-center">
							<strong>Cards &#38; values:</strong>
						</p>
						<div class="col d-flex justify-content-end">
							<ul class="p-0">
								<li>Twee - 2</li>
								<li>Drie - 3</li>
								<li>Vier - 4</li>
								<li>Vijf - 5</li>
								<li>Zes - 6</li>
								<li>Zeven - 7</li>
								<li>Acht - 8</li>
							</ul>
						</div>
						<div class="col d-flex justify-content-start">
							<ul class="p-0 ms-3">
								<li>Negen - 9</li>
								<li>Tien - 10</li>
								<li>Boer - 11</li>
								<li>Koningin - 12</li>
								<li>Koning - 13</li>
								<li>Aas - 14</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="modal-footer justify-content-center">
					<button type="button"
						class="btn btn-secondary border border-dark col-2"
						data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Info modal -->

	<!-- Leaderboard modal -->
	<div class="modal fade" id="leaderboardModal" tabindex="-1"
		aria-labelledby="leaderboardModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header text-center">
					<h1 class="modal-title fs-5 w-100" id="leaderboardModalLabel">Leaderboard
						top 10</h1>
				</div>
				<div class="modal-body text-center">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Naam</th>
								<th scope="col">Score</th>
							</tr>
						</thead>
					</table>
				</div>
				<div class="modal-footer justify-content-center">
					<button type="button"
						class="btn btn-secondary border border-dark col-2"
						data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal-footer justify-content-center">
		<button type="button"
			class="btn btn-secondary border border-dark col-2"
			data-bs-dismiss="modal">Close</button>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

	<!-- JS -->
	<script src="js/index.js"></script>

</body>
</html>