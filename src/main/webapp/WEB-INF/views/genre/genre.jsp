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
                   <h1 class="page-header">Genres</h1>
               </div>
           </div>
           <div class="row">
               <div class="col-lg-12">
                   <div class="panel panel-default">
                       <div class="panel-heading">Genres</div>
                       <div class="panel-body">
                           <div class="table-responsive" id="list">
                               
                           </div>
						   <button class="btn btn-success" onclick="newGenre()">New Genre</button>
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
						<th>Description</th>
						<th>Update</th>
					</tr>
				</thead>
				<tbody>
					{{#genres}}
						<tr class="odd gradeX">
							<td>{{name}}</td>
							<td>{{description}}</td>
							<td class="center" width="10%"><a href="#" onclick="editGenre({{id}});"><i class="fa fa-edit fa-fw"></i></a></td>
						</tr>
					{{/genres}}    
				</tbody>
			</table>
		</script>
		
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">Genre</h4>
		                <div id="error">Error</div>
		            </div>
		            <div class="modal-body">
			            <form action="saveGenre" id="genre_form" method="post" role="form">
			            	<input type="hidden" id="genre_id"/>
					        <div class="form-group">
					            <label for="name">Name:</label>
					            <input type="text" name="name" id="genre_name" class="form-control">
					        </div>
					        <div class="form-group">
					            <label for="description">Description:</label>
					            <textarea name="description" id="genre_description" class="form-control" rows="3"></textarea>
					        </div>
					    </form>
		            </div>
		            <div class="modal-footer">
		            	<button type="button" id="genre_form_submit" class="btn btn-success" onclick="saveOrUpdateGenre();" data-dismiss="modal"></button>
					    <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
		            </div>
		        </div>
		    </div>
		</div>
		
		<c:import url="../../../_template/footer.jsp"/>
		<script src="resources/js/rest/genre.js"></script>
</body>
</html>