<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html lang="en" >
<head>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

    <!-- Bootstrap -->
    <link href="${contextPath}/resources/assets/css/bootstrap.css" rel="stylesheet">
	<link href="${contextPath}/resources/assets/css/bootstrap-theme.css" rel="stylesheet">

    <!-- siimple style -->
    <link href="${contextPath}/resources/assets/css/style.css" rel="stylesheet">
    
    <!-- =======================================================
        Theme Name: Siimple
        Theme URL: https://bootstrapmade.com/free-bootstrap-landing-page/
        Author: BootstrapMade
        Author URL: https://bootstrapmade.com
    ======================================================= -->
  </head>

  <body>

    <!-- Fixed navbar -->
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.html">Gettin Hitched</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
			<li><a href="signups">Sign up � </a></li>
			<li><a href="login">Login � </a></li>
			<li><a href="applications">Browse Reviews � </a></li>																
			<li><a href="about">About Us � </a></li>																
			<li><a href="contact">Contact Us � </a></li>	
			
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

	<div id="header">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<h1 style="color: darkorange">Gettin Hitched Wedding App Rater</h1>
					<h2 class="subtitle" style="color: darkorange">Please feel
						free to browse our wedding app ratings and reviews. You must
						signup and login to actually enter a rating.</h2>
					<form class="form-inline applications" action="applications" method="post">
						<div class="form-group">
						</div>
						<button type="submit" class="btn btn-theme">browse
							reviews</button>
					</form>
					<br>
					<%-- <form class="form-inline signups" action="/signups" method="post">
						<div class="form-group"></div>
						<button type="submit" class="btn btn-theme">Signup</button>
					</form> --%>
				</div>
				<div class="col-lg-6 col-md-offset-2">
					<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					  <ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						<li data-target="#carousel-example-generic" data-slide-to="3"></li>
						<li data-target="#carousel-example-generic" data-slide-to="4"></li>
						<li data-target="#carousel-example-generic" data-slide-to="5"></li>
						<li data-target="#carousel-example-generic" data-slide-to="6"></li>
						<li data-target="#carousel-example-generic" data-slide-to="7"></li>
						<li data-target="#carousel-example-generic" data-slide-to="8"></li>
						<li data-target="#carousel-example-generic" data-slide-to="9"></li>
						<li data-target="#carousel-example-generic" data-slide-to="10"></li>
					  </ol>					
					  <!-- slides -->
					  <div class="carousel-inner">
						<div class="item active">
						  <img src="${contextPath}/resources/assets/img/wedding1.jpg" alt="">
						</div>
						<div class="item">
						  <img src="${contextPath}/resources/assets/img/wedding2.jpg" alt="">
						</div>
						<div class="item">
						  <img src="${contextPath}/resources/assets/img/wedding3.jpg" alt="">
						</div>
						<div class="item">
						  <img src="${contextPath}/resources/assets/img/wedding4.jpg" alt="">
						</div>
						<div class="item">
						  <img src="${contextPath}/resources/assets/img/wedding5.png" alt="">
						</div>
						<div class="item">
						  <img src="${contextPath}/resources/assets/img/wedding6.jpg" alt="">
						</div>
						<div class="item">
						  <img src="${contextPath}/resources/assets/img/wedding7.jpg" alt="">
						</div>
						<div class="item">
						  <img src="${contextPath}/resources/assets/img/wedding8.jpg" alt="">
						</div>
						<div class="item">
						  <img src="${contextPath}/resources/assets/img/wedding9.jpg" alt="">
						</div>
						<div class="item">
						  <img src="${contextPath}/resources/assets/img/wedding10.jpg" alt="">
						</div>
					  </div>
					</div>		
				</div>
				
			</div>
		</div>
	</div>
	<div id="footer">
	<div class="container">
		<div class="row">
            <div class="col-md-6">
					<div>
						Thank you for visiting Gettin Hitched.
					</div>
					<div>
						Website designed and brought to you by: Brian Groom via Claim Academy.
					</div>
            </div>
		</div>		
	</div>	
	</div>

    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="${contextPath}/resources/assets/js/bootstrap.min.js"></script>
    
</body>
</html>
