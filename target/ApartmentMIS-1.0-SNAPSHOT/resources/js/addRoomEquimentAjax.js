$(document).ready(function(){
	fetchRoom();
	fetchEquipment();
});





var contextRoot = "/" + window.location.pathname.split( '/' )[1];
		
	function RoomequipmentSubmit() {
	    var dataToSend = JSON.stringify(serializeObject($('#addEqipmentForm')));
	    $.ajax({
	        type: 'POST',
	        url: contextRoot + '/addRoomEquipment',
	        dataType: "json",           // Accept header
	        data: dataToSend,
	        contentType: 'application/json',   // Sends - Content-type
	        success: function (data) {
				alert("Done successfully");
	        	$('#errors').html("");
	 			$("#result").append( '<H3 align="center">' +data.equipmentName +' Saved!! <H3>');  
	        },

	        error: function (errorObject) {
	        	alert("some Errors");
	            if (errorObject.responseJSON.errorType == "ValidationError") {
	                $('#result').html("");
	                $('#errors').html("");
	                $('#errors').append('<span> Errors <span>');
	                $("#errors").append( '<p>');
					$("#errors").show();
					$("#result").show();
	                var errorList = errorObject.responseJSON.errors;
	                $.each(errorList,  function(i,error) {
	                    $("#errors").append( error.message + '<br>');
	                });
	                $("#errors").append( '</p>');
	                $("#result").show();
	            }
	            else {
	                alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
	            }
	        }
	    });
	}


function equipmentSearch(){
   	var dataToSend =$('#eqid').val();
   	
   	 $.ajax({
		type: 'GET',
		url: contextRoot + '/getEquipmentById/'+dataToSend,
		dataType: "json",           // Accept header
 		contentType: 'application/json',   // Sends - Content-type
		success: function(equipment){
			$('#equipname').val(equipment.equipmentName)
			$('#desc').val(equipment.description)
			$('#charges').val(equipment.equipmentDamageCharge)
		},
 
		error: function (errorObject) {
          
        }
	});
}





function fetchRoom(){
	var contextRoot = "/" + window.location.pathname.split('/')[1];

			$.ajax({
				url : contextRoot + '/roomList',
				type : 'GET',
				dataType : "json",
				contentType : 'application/json', // Sends
				success : function(data) {
					$.each(data,function(i, d){

						$("#roomlist").append("<option value="+d.roomNo+">"+d.building.buildingName+' - Room No.'+d.roomCode+"</option>");
						 
						});
				},

				error : function(e) {
					alert(contextRoot);
				}

			});
}



function fetchEquipment(){
	var contextRoot = "/" + window.location.pathname.split('/')[1];

			$.ajax({
				url : contextRoot + '/getEquipmentList',
				type : 'GET',
				dataType : "json",
				contentType : 'application/json', // Sends
				success : function(data) {

					$.each(data,function(i, d){
//						equipmentName

						$("#equipmentList").append("<option value="+d.equipmentId+">"+d.equipmentName+"</option>");
						 
						
						 
						});
				},

				error : function(e) {
					alert(contextRoot);
				}

			});
}






// Translate form to array
// Then put in JSON format
 function serializeObject (form)
{
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function() {
         	jsonObject[this.name] = this.value;
    });
    return jsonObject;

};
