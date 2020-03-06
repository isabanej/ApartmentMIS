<%--
  Created by IntelliJ IDEA.
  User: jeandelapaixdukomezedusenge
  Date: 2/4/20
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
<style type="text/css">@import url("<c:url value="/resources/css/homestyle.css"/>");</style>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>

<body>

	<div class="header">

		<img src="<spring:url value='/resource/images/logoApart.png' />" />
		<p style="float: right;color: navy;">Welcome <strong>${userinfo}</strong></p>
		<div class="header-right">
			<a onclick="dashboard();" class="active" href="#"><label><spring:message
						code="menu.home" /></label></a> <a onclick="studentform();" href="#"><label><spring:message
						code="menu.student" /></label></a> <a onclick="building();" href="#"><label><spring:message
						code="menu.building" /></label></a> <a onclick="room();" href="#"><label><spring:message
						code="menu.room" /></label></a> <a onclick="equipment();" href="#"><label><spring:message
						code="menu.equipment" /></label></a> <a onclick="roomEquipment();" href="#"><label><spring:message
						code="menu.roomEquipment" /></label></a>
						 <security:authorize access="isAuthenticated()">
 				<a href="<spring:url  value="/dologout" />" class="btn btn-danger btn-mini pull-right">Logout</a>	
 				</security:authorize>
		</div>
	</div>

	<div style="padding-left: 20px">
		<h1 style="color: navy;">MIU - Apartment MIS</h1>

		<div id="mycontent"></div>
	</div>

	<script>
		function studentform() {
			$("#mycontent").load("studentRegistration.html");
		}

		function building() {
			$("#mycontent").load("addNewBulding.html");
		}
		function room() {
			$("#mycontent").load("addRoom.html");
		}
		function dashboard() {
			$("#mycontent").load("dashboard.html");
		}

		function equipment() {
			$("#mycontent").load("addEquipment.html");
		}

		function roomEquipment() {
			$("#mycontent").load("addRoomEquipment.html");
		}

		$(document).ready(function() {
			$("#mycontent").load("dashboard.html");
		});
	</script>
</body>