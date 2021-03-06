<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Care2Share&trade;</title>

    <!-- Bootstrap Core CSS -->
    <link href="/Care2Share/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/Care2Share/resources/css/clean-blog.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-custom navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <c:if test="${sessionScope.anonymousUser}">
	                <spring:url value="/" var="mainUrl" htmlEscape="true"/>
	 				<a class="navbar-brand" href="${mainUrl}">Care2Share&trade;</a>
	 			</c:if>
	 			<c:if test="${!sessionScope.anonymousUser}">
	                <spring:url value="/user/posts" var="userPostsUrl" htmlEscape="true"/>
	 				<a class="navbar-brand" href="${userPostsUrl}">Care2Share&trade;</a>
	 			</c:if>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                	<c:if test="${sessionScope.inBlogger}">
	                	 <li>
	                	 	<a href="${postsUrl}">Posts by ${blogger.firstName}</a>
	                    </li>
	                    <li>
	 						<a href="${aboutUrl}">About ${blogger.firstName}</a>
	                    </li>
	                    <li>
	                	 	<a href="${contactUrl}">Contact ${blogger.firstName}</a>
	                    </li>
	                    <c:if test="${sessionScope.anonymousUser}">
		                    <li>
		                    	<spring:url value="/user/login" var="loginUrl" htmlEscape="true"/>
		                    	<a href="${loginUrl}">Login</a>
		                    </li>
		                </c:if>
						<c:if test="${!sessionScope.anonymousUser}">
		                    <li>
		                    	<a href="/Care2Share/j_spring_security_logout">Logout</a>
		            		</li>
		            	</c:if>
	            	</c:if>
	            	<c:if test="${!sessionScope.inBlogger}">
	                    <c:if test="${sessionScope.anonymousUser}">
		                    <li>
		                    	<spring:url value="/user/login" var="loginUrl" htmlEscape="true"/>
		                    	<a href="${loginUrl}">Login</a>
		                    </li>
		                </c:if>
						<c:if test="${!sessionScope.anonymousUser}">
		                    <li>
		                    	<a href="/Care2Share/j_spring_security_logout">Logout</a>
		            		</li>
		            	</c:if>
	            	</c:if>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>