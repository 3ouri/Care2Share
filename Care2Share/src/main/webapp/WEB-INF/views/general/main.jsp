	<%@include file="/WEB-INF/views/include/header.jsp" %>

    <!-- Page Header -->
    <!-- Set your background image for this header on the line below. -->
    <c:if test="${sessionScope.inBlogger}">
		<header class="intro-header" style="background-image: url('/Care2Share/resources/img/blogger-bg.jpg')">
	</c:if>
	<c:if test="${!sessionScope.inBlogger}">
		<header class="intro-header" style="background-image: url('/Care2Share/resources/img/home-bg.jpg')">
	</c:if>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <div class="site-heading">
                    	<c:if test="${sessionScope.inBlogger}">
                        	<h1>${blogger.firstName}'s Share</h1>
                        </c:if>
                        <c:if test="${!sessionScope.inBlogger}">
                        	<h1>Care 2 Share</h1>
                        </c:if>
                        <hr class="small">
                        <span class="subheading">Experience his thoughts to others</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Main Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
            	<c:forEach var="post" items="${posts}">
	                <div class="post-preview">
	               		<c:if test="${!sessionScope.inBlogger}">
	                    	<a href="posts/${post.id}">
	                    </c:if>
	                    <c:if test="${sessionScope.inBlogger}">
	                    	<a href="../posts/${post.id}">
	                    </c:if>
	                        <h2 class="post-title">
	                            ${post.title}
	                        </h2>
	                        <h3 class="post-subtitle">
	                            ${post.subTitle}
	                        </h3>
	                    </a>
	                    <p class="post-meta">Posted by <strong>${post.blogger.fullName}</strong> on ${post.publishedDate}</p>
	                </div>
                	<hr>
                </c:forEach>
                <!-- Pager -->
                <ul class="pager">
                    <li class="next">
                        <a href="#">Older Posts &rarr;</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <%@include file="/WEB-INF/views/include/footer.jsp" %>