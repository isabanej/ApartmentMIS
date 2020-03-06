	// pathname is contextRoot/path/path/ so we want to get [1] 
    // that is where contextRoot is
	// [0] has "" as a result of split 
	var contextRoot = "/" + window.location.pathname.split( '/' )[1];
		
	function equipmentSubmit() {
	    var dataToSend = JSON.stringify(serializeObject($('#EqipmentForm')));
	    $.ajax({
	        type: 'POST',
	        url: contextRoot + '/registerEquipment',
	        dataType: "json",           // Accept header
	        data: dataToSend,
	        contentType: 'application/json',   // Sends - Content-type
	        success: function (data) {
	        	alert("Done successfully");
	        	$('#errors').html("");
	 			$("#result").append( '<H3 align="center">' +data.equipmentName +' Saved!! <H3>');  
	        },

	        error: function (errorObject) {
	            if (errorObject.responseJSON.errorType == "ValidationError") {
	                $('#results').html("");
	                $('#errors').html("");
	                $('#errors').append('<span> Errors <span>');
	                $("#errors").append( '<p>');

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


 