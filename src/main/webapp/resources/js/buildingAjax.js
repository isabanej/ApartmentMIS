$(document).ready(function(){
	fetchBuildings();
	 
});
function makeAjaxCall() {
	var sendToSend = JSON.stringify(serializeObject($('#buildingForm')));
	var contextRoot = "/" + window.location.pathname.split('/')[1];

			$.ajax({
				url : contextRoot + '/addNewBuilding',
				type : 'POST',
				dataType : "json",
				data : sendToSend,
				contentType : 'application/json', // Sends
				success : function(building) {
					
					$('#formInput').html("");
					$("#formInput").append('<H3 align="center"> New Building Information <H3>');
					$('#formInput').append("<H4 align='center'>Building Name:  "+ building.buildingName + "</h4>");
					$('#formInput').append("<H4 align='center'>Building Description: "
									+ building.buildingDescription + "</h4>");
					$("#formInput")
							.append(
									'<h4 align="center"> <a href="#" onclick="resetForm(\'buildingForm\');make_hidden(\'formInput\');"><b>EXIT</b> </a> </h4>');
					$('#formInput').show();
					$('#errors').hide();
					fetchBuildings();
				},

				error : function(errorObject) {
					if (errorObject.responseJSON.errorType == "ValidationError") {
		                $('#errors').html("");
		                $('#errors').append('<span> Errors <span>');
		                $("#errors").append( '<p>');

		                var errorList = errorObject.responseJSON.errors;
		                $.each(errorList,  function(i,error) {
		                    $("#errors").append( error.message + '<br>');
		                });
		                $("#errors").append( '</p>');
		                $("#errors").show();
		            }
		            else {
		                alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
		            }
				}

			});
}

function testingFunction(){
	var contextRoot = "/" + window.location.pathname.split('/')[1];

			$.ajax({
				url : contextRoot + '/hello',
				type : 'GET',
				dataType : "json",
				contentType : 'application/json', // Sends
				success : function(msg) {
					alert("emino is a "+msg.country);
					
				},

				error : function(e) {
					alert(contextRoot);
				}

			});
}



/*============================================================*/

function fetchBuildings() {
    var contextRoot = "/" + window.location.pathname.split('/')[1];

    $.ajax({
        url: contextRoot + '/buildingList',
        type: 'GET',
        dataType: "json",
        contentType: 'application/json', // Sends
        success: function (data) {
			$('#buildings tbody').html("");
            $.each(data, function (i, d) {
				$('#buildings tbody').append('<tr><td>' + d.buildingName + '</td><td>' + d.buildingDescription + '</td><td> <button onclick="fetchOne('+d.buildingId+');" style="background-color: darksalmon;color:white; border:none; width: 60px; cursor: pointer;">Edit</button></td></tr>');
            });
        },

        error: function (e) {
            alert(contextRoot);
        }

    });
}


function fetchOne(buildingId) {
	var contextRoot = "/" + window.location.pathname.split('/')[1];
	$.ajax({
		url: contextRoot + '/getBuilding/'+buildingId,
		type: 'GET',
		dataType: "json",
		contentType: 'application/json', // Sends
		success: function (data) {
			$('#buildingName').val(data.buildingName);
			$('#buildingDescription').val(data.buildingDescription); 
			$('#btnid').val("Update Building");
		},

		error: function (e) {
			alert(contextRoot);
		}

	});
}
/*===============================================================*/

make_hidden = function(id) {
	var e = document.getElementById(id);
	e.style.display = 'none';
}

resetForm = function(id) {
	var e = document.getElementById(id);
	$(e)[0].reset();

}

// Translate form to array
// Then put in JSON format
function serializeObject(form) {
	var jsonObject = {};
	var array = form.serializeArray();
	$.each(array, function() {
		jsonObject[this.name] = this.value;
	});
	return jsonObject;

};

