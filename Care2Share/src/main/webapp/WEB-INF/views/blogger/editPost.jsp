	<%@include file="/WEB-INF/views/include/headerUser.jsp" %>
		
	<!-- Page Header -->
    <!-- Set your background image for this header on the line below. -->
    <header class="intro-header" style="background-image: url('/Care2Share/resources/img/user-bg.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <div class="page-heading">
                        <h1>Polish It or ...</h1>
                        <hr class="small">
                        <span class="subheading">Refine it or be an anti-Care2Share&trade;, it's your choice.</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Main Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <form action="../posts/${post.id}" method="post">
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Title</label>
                            <input type="text" name="title" class="form-control" placeholder="Title" id="title" value="${post.title}" required data-validation-required-message="Please enter post's title.">
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Sub Title</label>
                            <input type="text" name="subTitle" class="form-control" placeholder="Sub Title" id="subTitle" value="${post.subTitle}" required data-validation-required-message="Please enter post's sub-title.">
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Content</label>
                            <textarea rows="5" name="content" class="form-control" placeholder="Content" id="content" required data-validation-required-message="Please enter post's content.">${post.content}</textarea>
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="form-group col-xs-12">
                            <button type="submit" class="btn btn-default">Update Publish</button>
                        </div>
                    </div>
                </form>
                <form action="delete?postId=${post.id}" method="post">
	                <div class="row">
						<div class="form-group col-xs-12">
							<button type="submit" class="btn btn-default">Delete Publish</button>
						</div>
					</div>
				</form>
            </div>
        </div>
    </div>

	<%@include file="/WEB-INF/views/include/footer.jsp" %>
