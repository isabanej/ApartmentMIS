<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <%--    <script type="text/javascript" src="<spring:url value="/resource/js/cart.js"/>"></script>--%>
    <style type="text/css">@import url("<c:url value="/resources/css/styles.css"/>");</style>
    <script type="text/javascript" src="<spring:url value="/resources/js/buildingAjax.js"/>"></script>
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
        <p style="color:navy"><strong>Building </strong></p> <hr/>
       	<form id="buildingForm">
			<div class="row">
				<div class="col-25">
					<label for="buildingName"><spring:message code="building.form.buildingName"/></label>
				</div>
				<div class="col-75">
					<input type="text" id="buildingName" name="buildingName"
						placeholder="Enter Building Name..">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="buildingDescription"><spring:message code="building.form.buildingDescription"/></label>
				</div>
				<div class="col-75">
					<input type="text" id="buildingDescription"
						name="buildingDescription" placeholder="Building Description..">
				</div>
			</div>


			<div class="row">
				<!--  <input type="submit" value="Submit"> -->
				<input type="button" id="btnid" value="Add new Building" onclick="makeAjaxCall();">
			</div>
		</form>
    </div>

    <div class="halfdiv">
        <p style="color:navy"><strong><strong><spring:message code="buildingList"/></strong></p>
        <hr/>
        <div class="fulldiv">
            <table id="buildings">
                <thead>
                <tr>
                    <th> <spring:message code="building.form.buildingName"/></th>
                    <th><spring:message code="building.form.buildingDescription"/></th>  
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
