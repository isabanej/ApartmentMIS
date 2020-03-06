
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>


<style>
* {
	box-sizing: border-box;
}

input[type=text], [type=email], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	resize: vertical;
}

label {
	padding: 12px 12px 12px 0;
	display: inline-block;
}

input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: right;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

.col-25 {
	float: left;
	width: 10%;
	margin-top: 6px;
}

.col-75 {
	float: left;
	width: 30%;
	margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
	.col-25, .col-75, input[type=submit] {
		width: 100%;
		margin-top: 0;
	}
}
</style>
</head>
<body>

	<h2><spring:message code="addNewRoom"/></h2>

	<div class="container">
		<form id="roomForm">
			<div class="row">
				<div class="col-25">
					<label for="roomCode"><spring:message code="room.form.roomCode"/></label>
				</div>
				<div class="col-75">
					<input type="text" id="roomCode" name="roomCode"
						placeholder="Enter Room Number..">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="roomCost"><spring:message code="room.form.roomCost"/></label>
				</div>
				<div class="col-75">
					<input type="text" id="roomCost" name="roomCost"
						placeholder="Enter Room Cost">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="roomStatus"><spring:message code="room.form.roomStatus"/> </label>
				</div>
				<div class="col-75">
				 <select id="roomStatus" name="roomStatus">
                    <option value="Available">Available</option>
                    <option value="Occupied">Occupied</option>
                </select>
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="building"> <spring:message code="room.form.bid"/> </label>
				</div>
				<div class="col-75">
				 <select id="building" name="bid">
                    
                </select>
				</div>
			</div>


			<div class="row">
				<!--  <input type="submit" value="Submit"> -->
				<input type="button" value="Add" onclick="AddingRoom();">
			</div>
		</form>
		<!-- Success - or Validation errors -->
		<div id="errors" style="display: none"></div>

		<div id="formInput" style="display: none"></div>
	</div>

	<script type="text/javascript" src="<spring:url value="/resources/js/roomAjax.js"/>"></script>

</body>
</html>
