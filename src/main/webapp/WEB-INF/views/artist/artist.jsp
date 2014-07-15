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
                   <h1 class="page-header">Artists</h1>
               </div>
           </div>
           <div class="row">
               <div class="col-lg-12">
                   <div class="panel panel-default">
                       <div class="panel-heading">Artists</div>
                       <div class="panel-body">
                           <div class="table-responsive" id="list">
                               
                           </div>
						   <button class="btn btn-success" onclick="newArtist()">New Artist</button>
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
						<th>Origin</th>
						<th>Genre</th>
						<th>Website</th>
						<th>Update</th>
					</tr>
				</thead>
				<tbody>
					{{#artists}}
						<tr class="odd gradeX">
							<td>{{name}}</td>
							<td>{{origin}}</td>
							<td>{{genre.name}}</td>
							<td><button type="button" onClick="window.open('{{website}}');" class="btn btn-link" >{{website}}</button></td>
							<td class="center" width="10%"><a href="#" onclick="editArtist({{id}});"><i class="fa fa-edit fa-fw"></i></a></td>
						</tr>
					{{/artists}}    
				</tbody>
			</table>
		</script>
		
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">Artist</h4>
		                <div id="error">Error</div>
		            </div>
		            <div class="modal-body">
			            <form action="saveArtist" id="artist_form" method="post" role="form">
			            	<input type="hidden" id="artist_id"/>
					        <div class="form-group">
					            <label for="name">Name:</label>
					            <input type="text" name="name" id="artist_name" class="form-control">
					        </div>
					        <div class="form-group">
					            <label for="description">Description:</label>
					            <textarea name="description" id="artist_description" class="form-control" rows="3"></textarea>
					        </div>
					        <div class="form-group">
					            <label for="origin">Origin:</label>
					            <input type="text" name="origin" id="artist_origin" class="form-control">
					        </div>
					        <div class="form-group">
					            <label for="website">Website:</label>
					            <input type="text" name="website" id="artist_website" class="form-control">
					        </div>
 					        <div class="form-group">
								<label for="genres">Genre:</label>
                                <select name="genres" class="form-control" id="artist_genre_combo">
                                </select>
							</div> 
					    </form>
		            </div>
		            <div class="modal-footer">
		            	<button type="button" id="artist_form_submit" class="btn btn-success" onclick="saveOrUpdateArtist();" data-dismiss="modal"></button>
					    <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
		            </div>
		        </div>
		    </div>
		</div>
		
		<c:import url="../../../_template/footer.jsp"/>
		<script src="resources/js/rest/artist.js"></script>
</body>
</html>