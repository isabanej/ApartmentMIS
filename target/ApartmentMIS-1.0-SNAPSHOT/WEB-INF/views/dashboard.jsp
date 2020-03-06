<%--
  Created by IntelliJ IDEA.
  User: jeandelapaixdukomezedusenge
  Date: 2/4/20
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        .card {
            box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
            transition: 0.3s;
            width: 30%;
            border-radius: 10px;
            margin: 5px;
            float: left;
        }

        .card:hover {
            box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
        }

        .myheading{
            width: 100%;

            color: navy;
            padding: 5px;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }

        .dashboard-container{
            padding: 5px;
            margin: 10px;
        }

        #card-container{
            width: 100%;
        }
    </style>
</head>
<body>

<div id="card-container">
<div class="card">
    <div class="myheading" style="background-color: cornsilk;">
        <h2><strong>Total Number of Students</strong></h2>
        <hr/>
    </div>

    <div class="dashboard-container" >
        <p>Current Entry: <strong> August-2019</strong></p>
        <p>Compro Students: <strong>20</strong></p>
        <p>Data Science Students: <strong>150</strong></p>
        <p>Software Eng Students: <strong>500</strong></p>
    </div>
</div>

<div class="card">
    <div class="myheading" style="background-color: darksalmon;">
        <h2><strong>Building and Rooms</strong></h2>
        <hr/>
    </div>

    <div class="dashboard-container">
        <p>Current Entry: <strong> August-2019</strong></p>
        <p>Compro Students: <strong>20</strong></p>
        <p>Data Science Students: <strong>150</strong></p>
        <p>Software Eng Students: <strong>500</strong></p>
    </div>
</div>
</div>
</body>
</html>
