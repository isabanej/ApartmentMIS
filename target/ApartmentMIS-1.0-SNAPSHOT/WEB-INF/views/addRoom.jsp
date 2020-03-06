<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <%--    <script type="text/javascript" src="<spring:url value="/resource/js/cart.js"/>"></script>--%>
    <style type="text/css">@import url("<c:url value="/resources/css/styles.css"/>");</style>
    <script type="text/javascript" src="<spring:url value="/resources/js/buildingAjax.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/resources/js/roomAjax.js"/>"></script>
</head>
<body>


<div class="container">
    <p style="color:gold"><strong><spring:message code="addNewBuilding"/></strong></p>
    <div class="halfdiv">
        <div class="row">
            <div id="results"></div>
        </div>
        <div class="row">
            <div id="errors" >
            </div>

        </div>
        <p style="color:navy"><strong>Room </strong></p> <hr/>
       <form id="roomForm">
				<div class="row">
					<div class="col-25">
						<label for="roomCode"><spring:message
								code="room.form.roomCode" /></label>
					</div>
					<div class="col-75">
						<input type="text" id="roomCode" name="roomCode"
							placeholder="Enter Room Number..">
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="roomCost"><spring:message
								code="room.form.roomCost" /></label>
					</div>
					<div class="col-75">
						<input type="text" id="roomCost" name="roomCost"
							placeholder="Enter Room Cost">
					</div>
				</div>
				<%-- <div class="row">
					<div class="col-25">
						<label for="roomStatus"><spring:message
								code="room.form.roomStatus" /> </label>
					</div>
					 <div class="col-75">
						<select id="roomStatus" name="roomStatus">
							<option value="Available">Available</option>
							<option value="Occupied">Occupied</option>
						</select>
					</div> 
				</div>
 --%>
				<div class="row">
					<div class="col-25">
						<label for="building"> <spring:message
								code="room.form.bid" />
						</label>
					</div>
					<div class="col-75">
						<select id="building" name="bid">

						</select>
					</div>
				</div>
 
				<div class="row">
					<!--  <input type="submit" value="Submit"> -->
					<input type="button" id="btnid" value="Add New Room" onclick="AddingRoom();">
				</div>
			</form>
    </div>

    <div class="halfdiv">
        <p style="color:navy"> <strong><spring:message code="roomList"/></strong></p>
        <hr/>
        <div class="fulldiv">
            <table id="rooms">
                <thead>
                <tr>
                 <th> Room Number</th>
                    <th> <spring:message code="room.form.roomCode"/></th>
                    <th><spring:message code="room.form.roomCost"/></th>  
                    <th><spring:message code="room.form.roomStatus"/></th> 
                    <th><spring:message code="room.form.bid"/></th> 
                    <th><spring:message code="actions"/></th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
