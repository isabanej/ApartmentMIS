<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Equipment</title>
<script type="text/javascript" src="<spring:url value="/resources/js/equipmentAjax.js"/>"></script>
<link rel="stylesheet"	href="<spring:url value="/resource/css/styles2.css"/>">

</head>
<body>
	<h2>Equipment adding Form</h2>

	<div id="result" style="display:none">
		<div id="success" > 
    
    	</div> 
    	<div id="errors" > 
    		
    	</div>
	
	</div>
	

<div class="container">
<div id="searchform">
    <form id="EquipmentSearch">
    	<div class="row">
            <div class="col-75">
               <input type="text" id="eqid" name="equipmentId" placeholder="Search BY ID" >
            </div>
            <div class="col-25">
               <input type="button" value="Search" onclick="equipmentSearch();" style="float:left; margin-left:1px;">
            </div>
           
            
            </div>
            </form>
        </div>

    <form id="EqipmentForm" >
        <div class="row">
            <div class="col-25">
                <label for="fname"><spring:message code="equipment.form.equipmentName"/></label>
            </div>
            <div class="col-75">
                <input type="text" id="equipname" name="equipmentName" placeholder="equipment Name">
            </div>
            <div id="errorEquipmentName">
            
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="lname"><spring:message code="equipment.form.description"/></label>
            </div>
            <div class="col-75">
                <input type="text" id="desc" name="description" placeholder="Your last name..">
            </div>
            <div id="errorEquipmentDesc">
            
            </div>
        </div>
        
        <div class="row">
            <div class="col-25">
                <label for="gender"><spring:message code="equipment.form.equipmentDamageCharge"/></label>
            </div>
            <div class="col-75">
             <input type="text" id="charges" name="equipmentDamageCharge" placeholder="Damage charges">
               
            </div>
        </div>
                  
        <div class="row">
            <input type="button" value="Submit" onclick="equipmentSubmit();">
             <input type="button" value="Update" onclick="equipmentSubmit();" style="display:none">
        </div>
    </form>
    
    	
   
    </div>
</body>
</html>