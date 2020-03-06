var contextRoot = "/" + window.location.pathname.split('/')[1];
var sidd = 0;
$(document).ready(function(){
	fetchStudents();
    fetchRooms();
    $('#errors').hide();
    $('#errors_entry').hide();
    $('#errors_studentRoom').hide();
	$('#btnid').click(function(){
        var act = $('#btnid').val();
		if(act==="Create Student"){
			createStudent();
		}else{
			updateStudent();
		}
	});

	$('#saveEntry').click(function (){
        createEntry();
    });

    $('#saveStudentRoom').click(function (){
        assignToRoom();
    });
});
function createStudent() {
    var dataToSend = JSON.stringify(serializeObject($('#studentForm')));
    $.ajax({
        type: 'POST',
        url: contextRoot + '/registerStudent',
        dataType: "json",           // Accept header
        data: dataToSend,
        contentType: 'application/json',   // Sends - Content-type
        success: function (data) {
            $("#results").html("");
            $("#results").append('<div class="isa_success"> <i class="fa fa-check"></i>' + data.studentFirstName + ' ' + data.studentLastName + ' Saved Successfully </div>');
            fetchStudents();
        },

        error: function (errorObject) {
            if (errorObject.responseJSON.errorType == "ValidationError") {
                $('#results').html("");
                $('#errors').html("");
                $('#errors').append('<i class="fa fa-times-circle"></i><span> Errors <span>');
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



//Entry Creation

function createEntry() {
    var dataToSend = JSON.stringify(serializeObject($('#entryForm')));
    $.ajax({
        type: 'POST',
        url: contextRoot + '/createEntry',
        dataType: "json",           // Accept header
        data: dataToSend,
        contentType: 'application/json',   // Sends - Content-type
        success: function (data) {
            $("#results_entry").html("");
            $("#results_entry").append('<div class="isa_success"> <i class="fa fa-check"></i>' + data.entryName + ' Saved Successfully </div>');

        },

        error: function (errorObject) {
            if (errorObject.responseJSON.errorType == "ValidationError") {
                $('#results_entry').html("");
                $('#errors_entry').html("");
                $('#errors_entry').append('<i class="fa fa-times-circle"></i><span> Errors <span>');
                $("#errors_entry").append( '<p>');

                var errorList = errorObject.responseJSON.errors;
                $.each(errorList,  function(i,error) {
                    $("#errors_entry").append( error.message + '<br>');
                });
                $("#errors_entry").append( '</p>');
                $("#errors_entry").show();
            }
            else {
                alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
            }
        }
    });
}

function fetchStudents() {
    var contextRoot = "/" + window.location.pathname.split('/')[1];

    $.ajax({
        url: contextRoot + '/getStudentList',
        type: 'GET',
        dataType: "json",
        contentType: 'application/json', // Sends
        success: function (data) {
			$('#students tbody').html("");
            $.each(data, function (i, d) {
				$('#students tbody').append('<tr><td>' + d.studentFirstName + '</td><td>' + d.studentLastName + '</td><td>' + d.studentEmail + '</td><td>' + d.programEntry.entryName + '</td><td><button onclick="fetchOne('+d.studentId+');" style="background-color: darksalmon;color:white; border:none; width: 60px; cursor: pointer;">Edit</button></td><td><button onclick="assignToRoomF('+d.studentId+');" style="background-color: blue;color:white; border:none; width: 60px; cursor: pointer;">Assign</button></td></tr>');
            });
        },

        error: function (e) {
            alert(contextRoot);
        }

    });
}

function fetchOne(sid) {
	var contextRoot = "/" + window.location.pathname.split('/')[1];
	$.ajax({
		url: contextRoot + '/getStudent/'+sid,
		type: 'GET',
		dataType: "json",
		contentType: 'application/json', // Sends
		success: function (data) {
			$('#fname').val(data.studentFirstName);
			$('#lname').val(data.studentLastName);
			$('#country').val(data.country);
			$('#gender').val(data.studentGender);
			$('#ssn').val(data.studentSSN);
			$('#program').val(data.program);
			$('#email').val(data.studentEmail);
			$('#btnid').val("Update Student");
		},

		error: function (e) {
			alert(contextRoot);
		}

	});
}

function assignToRoomF(siddd) {
    var contextRoot = "/" + window.location.pathname.split('/')[1];
    document.getElementById('id02').style.display = 'block';
    sidd = siddd;
}
function assignToRoom() {
    var contextRoot = "/" + window.location.pathname.split('/')[1];
  // document.getElementById('id02').style.display='block';

   $("#myStudentId").val(sidd);
    var dataToSend = JSON.stringify(serializeObject($('#studentroom')));
    $.ajax({
        type: 'POST',
        url: contextRoot + '/assignToRoom',
        dataType: "json",           // Accept header
        data: dataToSend,
        contentType: 'application/json',   // Sends - Content-type
        success: function (data) {
            $("#results_studentRoom").html("");
            $("#results_studentRoom").append('<div class="isa_success"> <i class="fa fa-check"></i>Done Successfully </div>');

        },

        error: function (errorObject) {
            if (errorObject.responseJSON.errorType == "ValidationError") {
                $('#results_studentRoom').html("");
                $('#errors_studentRoom').html("");
                $('#errors_studentRoom').append('<i class="fa fa-times-circle"></i><span> Errors <span>');
                $("#errors_studentRoom").append( '<p>');

                var errorList = errorObject.responseJSON.errors;
                $.each(errorList,  function(i,error) {
                    $("#errors_studentRoom").append( error.message + '<br>');
                });
                $("#errors_studentRoom").append( '</p>');
                $("#errors_studentRoom").show();
            }
            else {
                alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
            }
        }

    });
}

function fetchRooms(){
    var contextRoot = "/" + window.location.pathname.split('/')[1];

    $.ajax({
        url : contextRoot + '/roomList',
        type : 'GET',
        dataType : "json",
        contentType : 'application/json', // Sends
        success : function(data) {
            $.each(data,function(i, d){

                $("#roomlisting").append("<option value="+d.roomNo+">"+d.building.buildingName+' - Room No.'+d.roomCode+"</option>");

            });
        },

        error : function(e) {
            alert(contextRoot);
        }

    });
}
function serializeObject(form) {
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function () {
        jsonObject[this.name] = this.value;
    });
    return jsonObject;

};


 