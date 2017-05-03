<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List,document.MyFile"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description"
	content="A simple search engine with Lucene 4.3 for SGML files">
<meta name="author" content="mmaguero">
<link rel="icon"
	href="https://lucene.apache.org/core/2_9_4/images/favicon.ico">

<title>A simple search engine with Lucene 4.3 for SGML Files</title>

<!-- Bootstrap core CSS -->
<link
	href="https://v4-alpha.getbootstrap.com/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="https://v4-alpha.getbootstrap.com/examples/jumbotron/jumbotron.css"
	rel="stylesheet">
</head>

<body>

	<nav class="navbar navbar-light bg-faded">
		<br>
		<form action="searchForm" method="post">
			<div class="input-group">
				<a class="navbar-brand" href="Home.html">Home</a> <input
					name="inputText" type="search" class="form-control col-md-8"
					placeholder="Input text..."> <span class="input-group-btn">
					<button class="btn btn-secondary" type="submit">Go!</button>
				</span>
			</div>

		</form>
	</nav>

	<div class="container">
		<!-- Example row of columns -->
		<div class="row">

			<%
				String error = (String) request.getAttribute("aError");
				if (error.equals("OK")) {
			%>

			<%
				String message = (String) request.getAttribute("aMessage");
			%>

			<p>
				<span class="badge badge-pill badge-info">Info</span> <small><%=message%></small>
			</p>

			<%
				List<MyFile> results = (List<MyFile>) request.getAttribute("aList");
					int j = 0;
					for (MyFile i : results) {
						j++;
			%>
			<div class="col-md-10">
				<a class="btn btn-link bd-title" href="#" role="button"
					data-toggle="modal" data-target=".bd-example-modal-lg<%=j%>"><%=i.getTitle()%>
					&raquo; </a>
				<p>
					<small><%=(i.getText().length() > 250 ? i.getText().substring(0, 250) + " ..." : i.getText())%></small>
				</p>
				<!-- <p>
					<a class="btn btn-secondary" href="#" role="button">View
						details &raquo;</a>
				</p>-->
			</div>

			<!-- Large modal -->
			<div class="modal fade bd-example-modal-lg<%=j%>" tabindex="-1"
				role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel"><%=i.getTitle()%></h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<%=i.getText()%>
						</div>
					</div>
				</div>
			</div>

			<%
				if (j == 699) // exit when show 700, because 1000 indexes is costose
							break;
					}
			%>

			<%
				} else {
			%>

			<br>
			<div class="alert alert-danger" role="alert">
				<h4 class="alert-heading">Oh error!</h4>
				<p><%=error%></p>
			</div>

			<%
				}
			%>

		</div>

		<!-- <br>
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Previous</span>
				</a></li>
				<li class="page-item active"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">4</a></li>
				<li class="page-item"><a class="page-link" href="#">5</a></li>
				<li class="page-item"><a class="page-link" href="#">6</a></li>
				<li class="page-item"><a class="page-link" href="#">7</a></li>
				<li class="page-item"><a class="page-link" href="#">8</a></li>
				<li class="page-item"><a class="page-link" href="#">9</a></li>
				<li class="page-item"><a class="page-link" href="#">10</a></li>
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
						class="sr-only">Next</span>
				</a></li>
			</ul>
		</nav> -->

		<hr>

		<footer>
			<p>
				&copy; <a href="https://github.com/mmaguero">@mmaguero</a> 2017
			</p>
		</footer>
	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery.min.js"
		type="text/javascript"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
		type="text/javascript"></script>
	<script
		src="https://v4-alpha.getbootstrap.com/dist/js/bootstrap.min.js"
		type="text/javascript"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="https://v4-alpha.getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"
		type="text/javascript"></script>
</body>
</html>
