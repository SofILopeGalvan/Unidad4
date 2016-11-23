<%@page language="java" contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<title>Boot Sample | Home</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/style.css">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-task">New Task</a></li>
				<!-- 	<li><a href="all-tasks">All tasks</a></li>  --> 
					<li><a href="new-proyect">New Proyect</a></li>
					<li><a href="all-proyects">All Proyects</a></li>
					
					<li><a href="new-garment">New Garment</a></li>
					<li><a href="all-garments">All Garments</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='MODE_HOME'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to Task Manager</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_TASKS'}">
			<div class="container text-center" id="tasksDiv">
				<h3>My Tasks</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Description</th>
								<th>Date created</th>
								<th>Finished</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="task" items="${tasks}">
								<tr>
									<td>${task.id}</td>
									<td>${task.name}</td>
									<td>${task.description}</td>
									<td><fmt:formatDate pattern="dd-MM-yyyy"
											value="${task.dateCreated}" /></td>
									<td>${task.finished==true?"YES":"NO"}</td>
									<td><a href="update-task?id=${task.id}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-task?id=${task.id}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_NEW' || mode=='MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Manage Task</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-task">
					<input type="hidden" name="id" value="${task.id}" />
					<div class="form-group">
						<label class="control-label col-sm-3">Name:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="name"
								value="${task.name}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Description:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="description"
								value="${task.description}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Finished:</label>
						<div class="col-sm-7">
							<input type="radio" class="col-sm-1" name="finished"
								value="true" />
								<div class="col-sm-2">YES</div>
							<input type="radio" class="col-sm-1" name="finished"
								value="false" checked="checked"/>
								<div class="col-sm-2">NO</div>
						</div>
					</div>
					
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>

				</form>
			</div>
		</c:when>
		
		<c:when test="${mode=='MODE_PROYECTS'}">
			<div class="container text-center" id="proyectsDiv">
				<h3>My Proyects</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Schedule</th>
								<th>Presentation</th>
								<th>Start time</th>
								<th>End Time</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="proyect" items="${proyects}">
								<tr>
									<td>${proyect.id}</td>
									<td>${proyect.schedule}</td>
									<td>${proyect.presentation}</td>
									<td>${proyect.start_time}</td>
									<td>${proyect.end_time}</td>
									<td><a href="update-proyect?id=${proyect.id}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-proyect?id=${proyect.id}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_NEW_PROYECT' || mode=='MODE_UPDATE_PROYECT'}">
			<div class="container text-center">
				<h3>Manage Proyect</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-proyect">
					<input type="hidden" name="id" value="${proyect.id}" />
					<div class="form-group">
						<label class="control-label col-sm-3">Schedule:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="schedule"
								value="${proyect.schedule}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Presentation:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="presentation"
								value="${proyect.presentation}" />
						</div>
					</div>

	<div class="form-group">
						<label class="control-label col-sm-3">Starte Time:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="start_time"
								value="${proyect.start_time}" />
						</div>
					</div>



					<div class="form-group">
						<label class="control-label col-sm-3">End Time:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="end_time"
								value="${proyect.end_time}" />
						</div>
					</div>

					</div>
					
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>

				</form>
			</div>
		</c:when>
		
		
		
		
		
		
		
		<c:when test="${mode=='MODE_GARMENTS'}">
			<div class="container text-center" id="garmentsDiv">
				<h3>Garments</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>color</th>
								<th>size</th>
								<th>type</th>
							
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="garment" items="${garments}">
								<tr>
									<td>${garment.id}</td>
									<td>${garment.color}</td>
									<td>${garment.size}</td>
									<td>${garment.type}</td>
									<td>${proyect.end_time}</td>
									<td><a href="update-garment?id=${garment.id}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-garment?id=${garment.id}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_NEW_GARMENT' || mode=='MODE_UPDATE_GARMENT'}">
			<div class="container text-center">
				<h3>Manage Garment</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-garment">
					<input type="hidden" name="id" value="${garment.id}" />
					<div class="form-group">
						<label class="control-label col-sm-3">color:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="color"
								value="${garment.color}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">size:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="size"
								value="${garment.size}" />
						</div>
					</div>

	<div class="form-group">
						<label class="control-label col-sm-3">Type :</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="type"
								value="${garment.type}" />
						</div>
					</div>



				

					</div>
					
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>

				</form>
			</div>
		</c:when>
		
		
		
		
		
		
		
	</c:choose>
	<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</body>
</html>
