
$(document).ready(function(){
	fetchBuilding();
	fetchingRooms();
});

function AddingRoom() {
	var sendToSend = JSON.stringify(serializeObject($('#roomForm')));
	var contextRoot = "/" + window.location.pathname.split('/')[1];

			$.ajax({
				url : contextRoot + '/addRoom',
				type : 'POST',
				dataType : "json",
				data : sendToSend,
				contentType : 'application/json', // Sends
				success : function(room) {
					alert("Done Successfully");
					$('#formInput').html("");
					$("#formInput").append('<H3 align="center"> New Building Information <H3>');
					$('#formInput').append("<H4 align='center'>Room Code:  "+ room.roomCode + "</h4>");
					$('#formInput').append("<H4 align='center'>Room Status: "+ room.roomStatus + "</h4>");
					$('#formInput').append("<H4 align='center'>Room Cost: "+ room.roomCost + "</h4>");
					$('#formInput').append("<H4 align='center'>Building: "+ room.building.buildingName + "</h4>");
					$("#formInput")
							.append(
									'<h4 align="center"> <a href="#" onclick="resetForm(\'roomForm\');make_hidden(\'formInput\');"><b>EXIT</b> </a> </h4>');
					$('#formInput').show();
					$('#errors').hide();
					fetchingRooms();
				},

				error : function(e) {
					alert("Check the validation");
				}

			});
}


function fetchBuilding(){
	var contextRoot = "/" + window.location.pathname.split('/')[1];

			$.ajax({
				url : contextRoot + '/buildingList',
				type : 'GET',
				dataType : "json",
				contentType : 'application/json', // Sends
				success : function(data) {
					$.each(data,function(i, d){

						$("#building").append("<option value="+d.buildingId+">"+d.buildingName+"</option>");
						 
						});
				},

				error : function(e) {
					alert(contextRoot);
				}

			});
}
/*===================================================================================*/
function fetchingRooms() {
    var contextRoot = "/" + window.location.pathname.split('/')[1];

    $.ajax({
        url: contextRoot + '/roomList',
        type: 'GET',
        dataType: "json",
        contentType: 'application/json', // Sends
        success: function (data) {
			$('#rooms tbody').html("");
            $.each(data, function (i, d) {
				$('#rooms tbody').append('<tr><td>' + d.roomNo + '</td><td>' + d.roomCode + '</td><td>' + d.roomCost + '</td><td>' + d.roomStatus + '</td><td>' + d.building.buildingName + '</td><td> <button onclick="fetchOne('+d.roomNo+');" style="background-color: darksalmon;color:white; border:none; width: 60px; cursor: pointer;">Edit</button></td></tr>');
            });
        },

        error: function (e) {
            alert(contextRoot);
        }

    });
}


function fetchOne(roomNo) {
	var contextRoot = "/" + window.location.pathname.split('/')[1];
	$.ajax({
		url: contextRoot + '/getRoom/'+roomNo,
		type: 'GET',
		dataType: "json",
		contentType: 'application/json', // Sends
		success: function (data) {
			$('#roomCode').val(data.roomCode);
			$('#roomCost').val(data.roomCost); 
			$('#building').val(data.building.buildingName);
			$("#building").val("<option value="+data.buildingId+">"+data.building.buildingName+"</option>");
			$('#btnid').val("Update Room");
		},

		error: function (e) {
			alert(contextRoot);
		}

	});
}
/*===================================================================================*/
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

