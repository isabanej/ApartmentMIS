<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<spring:url value="/resources/js/addRoomEquimentAjax.js"/>"></script>
<meta charset="ISO-8859-1">
<title>Room Equipment</title>
<style> 
  #row1{

 background-color: #f2f2f2;
 width:100%;
 hight:auto;
 padding:0px;
}

.inputs,[type=email], select, textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
            margin-bottom:20px;
        }

        label {
            padding: 12px 12px 12px 0;
            display: inline-block;
        }
        
        #savebtn{
        
        	 background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

#roomequip{
	 padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
           margin-left:75%;
}

#searchBut{
		 background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            
           
	}
	
	#container{
		width:100%
		padding:0px;
	
	}
	
	#cardSub1{
		width:30%;
		float:left;
	
	}
	
		
	
	#cardSub2{
	width:50%;
		float:left;
		margin-left:10%;
	}
	
	
	
	#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
	
	

</style>
</head>
<body>
	<h2>Room Equipment Form</h2>
	<div id="row1">
		<form action="">
		 <input type="text" id="roomequip" name="room.roomNo" placeholder="Search BY ID" >
		 <input type="button" id="searchBut"value="Search" onclick="equipmentSearch();" >
		</form>
	</div>
	<div id="result" style="display:none">
		<div id="success" > 
    
    	</div> 
    	<div id="errors" > 
    		
    	</div>
	
	</div>
	
	<div id="container">
	<div id="cardSub1">
	<form id="addEqipmentForm" >
	
	<div class="row">
            
            <div class="col-75">
            <select id="equipmentList" name="inputEquipment" class="inputs" >
                    <option value="none"><spring:message code="equipment.form.equipmentName"/></option>
                    
             </select>
                         
            </div>
        </div>
	
        
        <div class="row">
            
            <div class="col-75">
                <input type="text"  class="inputs" id="statuseqip" name="roomEquipmentStatus" 
                placeholder="<spring:message code="roomEquipment.form.roomEquipmentStatus"/>">
            </div>
            
        </div>
        
       
        
        <div class="row">
            
            <div class="col-75">
            <select id="roomlist" name="myRoomId" class="inputs" >
                    <option value="none"><spring:message code="room.form.roomCode"/></option>
                    
             </select>
                         
            </div>
        </div>
                  
        <div class="row">
            <input type="button" value="Submit" onclick="RoomequipmentSubmit();" id="savebtn">
             <input type="button" value="Update" onclick="equipmentSubmit();" style="display:none">
        </div>
    </form>
	</div>
	
	
	
	<div id="cardSub2">
	<table id="customers">
  <tr>
    <th>Room Equipment ID</th>
    <th>Name</th>
    <th>Status</th>
    <th>Room ID</th>
    <th>Action</th>
  </tr>

  </table>
	</div>
	
	</div>
	
</body>
</html>