<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="../../../_template/head.jsp"/>
<style>
	#error {
		display: none;
	}
</style>
<body>

	<c:import url="../../../_template/header.jsp"/>
	<c:import url="../../../_template/menu.jsp"/>
	
	<div id="page-wrapper">
           <div class="row">
               <div class="col-lg-12">
                   <h1 class="page-header">Titles</h1>
               </div>
           </div>
           <div class="row">
               <div class="col-lg-12">
                   <div class="panel panel-default">
                       <div class="panel-heading">Titles</div>
                       <div class="panel-body">
                           <div class="table-responsive" id="list">
                               
                           </div>
						   <button class="btn btn-success" onclick="newTitle()">New Title</button>
                       </div>
                   </div>
               </div>
           </div>
		</div> 
		
		<script type="text/html" id="list_template">
			<table class="table table-striped table-bordered table-hover" id="dataTables-example">
				<thead>
					<tr>
						<th>Name</th>
						<th>Year</th>
						<th>Label</th>
						<th>Artist</th>
						<th>Recording</th>
						<th>Update</th>
					</tr>
				</thead>
				<tbody>
					{{#titles}}
						<tr class="odd gradeX">
							<td>{{name}}</td>
							<td>{{year}}</td>
							<td>{{label.name}}</td>
							<td>{{artist.name}}</td>
							<td>{{recording.name}}</td>
							<td class="center" width="10%"><a href="#" onclick="editTitle({{id}});"><i class="fa fa-edit fa-fw"></i></a></td>
						</tr>
					{{/titles}}    
				</tbody>
			</table>
		</script>
		
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">Title</h4>
		                <div id="error">Error</div>
		            </div>
		            <div class="modal-body">
			            <form action="saveTitle" id="title_form" method="post" role="form">
			            	<input type="hidden" id="title_id"/>
					        <div class="form-group">
					            <label for="name">Name:</label>
					            <input type="text" name="name" id="title_name" class="form-control">
					        </div>
					        <div class="form-group">
					            <label for="year">Year:</label>
					            <input name="year" name="year" id="title_year" class="form-control"/>
					        </div>
 					        <div class="form-group">
								<label for="labels">Label:</label>
                                <select name="labels" class="form-control" id="title_label_combo">
                                </select>
							</div> 
 					        <div class="form-group">
								<label for="artists">Artist:</label>
                                <select name="artists" class="form-control" id="title_artist_combo">
                                </select>
							</div> 
 					        <div class="form-group">
								<label for="recordings">Recording:</label>
                                <select name="recordings" class="form-control" id="title_recording_combo">
                                	<option value="LIVE">Live</option>
                                	<option value="STUDIO">Studio</option>
                                </select>
							</div> 
					    </form>
		            </div>
		            <div class="modal-footer">
		            	<button type="button" id="title_form_submit" class="btn btn-success" onclick="saveOrUpdateTitle();" data-dismiss="modal"></button>
					    <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
		            </div>
		        </div>
		    </div>
		</div>
		
		<c:import url="../../../_template/footer.jsp"/>
		<script src="resources/js/rest/title.js"></script>
</body>
</html>