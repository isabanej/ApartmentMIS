<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Welcome</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
			
			 <security:authorize access="isAnonymous()">
 				  <!-- WHICH ONE? depends on basic form OR CUSTOM -->
    					<!--a href="<spring:url value='/spring_security_login' />" class="btn btn-default pull-right"> Login</a-->
    					<a href="<spring:url value='/login' />" class="btn btn-default pull-right"> Login</a>
				</security:authorize>
	
 				 <p> <security:authorize access="isAuthenticated()">
 				<a href="<spring:url  value="/dologout" />" class="btn btn-danger btn-mini pull-right">Logout</a>	
 				</security:authorize>  
 				
 				<a href="?language=rw_RW" class="btn btn-default btn-mini pull-right">
						<span class="glyphicon glyphicon-home glyphicon"></span> Kinyarwanda
					</a>
 				
 				 <a href="?language=en" class="btn btn-default btn-mini pull-right">
						<span class="glyphicon glyphicon-home glyphicon"></span> English 
					</a>

					
 				
 				
		<!-- 	<a href="?language=en" >English</a>  |  <a href="?language=rw_RW" >Kinyarwanda</a>	 -->				
				</br>
				
				<img src="<spring:url value='/resource/images/logoApart.png' />" />
			<center>	<h1 style="color:navy;"> <spring:message code="welcomeMessage"></spring:message> </h1>
				 </center>
			</div>	 
 
 <div class="container">
	
<img src="<spring:url value='/resource/images/mansion_small.jpg' />" />
 	
				</div>	  
		</div>	
	</section>
	
</body>
</html>
