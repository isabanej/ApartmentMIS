<%--
  Created by IntelliJ IDEA.
  User: jeandelapaixdukomezedusenge
  Date: 2/3/20
  Time: 9:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"/>
    <%--    <script type="text/javascript" src="<spring:url value="/resource/js/cart.js"/>"></script>--%>
    <style type="text/css">@import url("<c:url value="/resources/css/styles.css"/>");</style>
    <script type="text/javascript" src="<spring:url value="/resources/js/studentAjaxService.js"/>"></script>
    <style>
        .entryFormCSS{
            width: 100%;
            display: block;
        }
        .entryFormCSS input[type=text],input[type=date]{
            width: 100% !important;
            padding: 10px !important;
            margin: 5px !important;
        }
        button{
            margin: auto;
            width: 200px;
            border: none;
            background-color: navy;
            color: white;
            border-radius: 10px;
            cursor: pointer;
        }


    </style>
</head>
<body>


<div class="container">
    <p style="color:gold"><strong> <spring:message code="studentRegistrationForm"></spring:message></strong> &nbsp; &nbsp; <span><a style="color: navy !important;" onclick="document.getElementById('id01').style.display='block'" href="#">Entry Settings</a></span> </p>
    <div class="halfdiv">
        <div class="row">
            <div id="results"></div>
        </div>
        <div class="row">
            <div id="errors" class="isa_error">
                <i class="fa fa-times-circle"></i>
            </div>

        </div>
        <form id="studentForm">
            <input type="hidden" id="sidupdate"/>
            <div class="row">
                <div class="col-25">
                    <label for="fname"><spring:message code="firstName"></spring:message> </label>
                </div>
                <div class="col-75">
                    <input type="text" id="fname" name="studentFirstName" placeholder="Your first name..">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="lname"><spring:message code="lastName"></spring:message></label>
                </div>
                <div class="col-75">
                    <input type="text" id="lname" name="studentLastName" placeholder="Your last name..">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="country"><spring:message code="student.form.country"></spring:message></label>
                </div>

                <div class="col-75">
                    <input type="text" id="country" name="country" placeholder="Your Country..">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="gender"><spring:message code="student.form.studentGender"></spring:message></label>
                </div>
                <div class="col-75">
                    <select id="gender" name="studentGender">
                        <option value="Male"><spring:message code="Male"></spring:message></option>
                        <option value="Female"><spring:message code="Female"></spring:message></option>
                    </select>
                </div>
            </div>

            <div class="row">
                <div class="col-25">
                    <label for="ssn"><spring:message code="student.form.studentSSN"></spring:message></label>
                </div>
                <div class="col-75">
                    <input type="text" id="ssn" name="studentSSN" placeholder="SSN..">
                </div>

            </div>
            <div class="row">
                <div class="col-25">
                    <label for="program"><spring:message code="student.form.program"></spring:message></label>
                </div>
                <div class="col-75">
                    <input type="text" id="program" name="studentProgram" placeholder="Program..">
                </div>

            </div>
            <div class="row">
                <div class="col-25">
                    <label for="email"><spring:message code="email"></spring:message></label>
                </div>
                <div class="col-75">
                    <input type="email" id="email" name="studentEmail" placeholder="Your Email..">
                </div>
            </div>
            <br/>
            <div class="row">

                <input type="button" id="btnid"  value="Create Student">
            </div>


        </form>
    </div>

    <div class="halfdiv">
        <p style="color:navy"><strong><spring:message code="StudentList"></spring:message></strong></p>
        <hr/>
        <div class="fulldiv">
            <table id="students">
                <thead>
                <tr>
                    <th><strong><spring:message code="firstName"></spring:message></th>
                    <th><strong><spring:message code="lastName"></spring:message></th>
                    <th><strong><spring:message code="email"></spring:message></th>
                    <th><strong><spring:message code="entrytable"></spring:message></th>
                    <th colspan="2"><strong><spring:message code="action"></spring:message></th>

                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Entry Modal -->

<div id="id01" class="w3-modal w3-animate-opacity" >
    <div class="w3-modal-content w3-card-4">
        <header  >
        <span onclick="document.getElementById('id01').style.display='none'"
              class="w3-button w3-large w3-display-topright">&times;</span>
            <h2><spring:message code="entry.form.label"/></h2>
        </header>
        <div class="w3-container">

            <div class="row">
                <div id="results_entry"></div>
            </div>

                <div id="errors_entry" class="isa_error">
                    <i class="fa fa-times-circle"></i>
                </div>

            <form id="entryForm" class="entryFormCSS">
            <label><spring:message code="entry.form.label.entryname"/></label><br/>
            <div >
                <input type="text" name="entryName" placeholder="<spring:message code="entry.form.label.entryname"/>">
            </div>

            <label><spring:message code="entry.form.label.start_date"/></label><br/>
            <div >
                <input type="date" name="entryStartDate" placeholder="<spring:message code="entry.form.label.start_date"/>">
            </div>

            <label><spring:message code="entry.form.label.end_date"/></label><br/>
            <div>
                <input type="date" name="entryEndDate" placeholder="<spring:message code="entry.form.label.end_date"/>">
            </div>
                <br/>
                <div >
                    <button id="saveEntry" type="button" >Submit</button>
                </div>
            </form>



        </div>

    </div>
</div>


<!-- Assign Student to Room -->

<div id="id02" class="w3-modal w3-animate-opacity" >
    <div class="w3-modal-content w3-card-4">
        <header  >
        <span onclick="document.getElementById('id02').style.display='none'"
              class="w3-button w3-large w3-display-topright">&times;</span>
            <h2><spring:message code="entry.form.studentRoom.header"/></h2>
        </header>
        <div class="w3-container">

            <div class="row">
                <div id="results_studentRoom"></div>
            </div>

            <div id="errors_studentRoom" class="isa_error">
                <i class="fa fa-times-circle"></i>
            </div>

            <form id="studentroom" class="entryFormCSS">

                <input type="hidden" id="myStudentId" name="myStudentId" />
                <label><spring:message code="entry.form.label.studentRoom"/></label><br/>
                <div >

                        <select id="roomlisting" name="myRoomId" class="inputs" >

                        </select>

                </div>

                <br/><br/>
                <div >
                    <button id="saveStudentRoom" type="button" >Submit</button>
                </div>
            </form>



        </div>

    </div>
</div>

</body>
</html>
