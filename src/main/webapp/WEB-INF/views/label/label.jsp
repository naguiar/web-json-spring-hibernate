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
                   <h1 class="page-header">Labels</h1>
               </div>
           </div>
           <div class="row">
               <div class="col-lg-12">
                   <div class="panel panel-default">
                       <div class="panel-heading">Labels</div>
                       <div class="panel-body">
                           <div class="table-responsive" id="list">
                               
                           </div>
						   <button class="btn btn-success" onclick="newLabel()">New Label</button>
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
						<th>Website</th>
						<th>Update</th>
					</tr>
				</thead>
				<tbody>
					{{#labels}}
						<tr class="odd gradeX">
							<td>{{name}}</td>
							<td><button type="button" onClick="window.open('{{website}}');" class="btn btn-link" >{{website}}</button></td>
							<td class="center" width="10%"><a href="#" onclick="editLabel({{id}});"><i class="fa fa-edit fa-fw"></i></a></td>
						</tr>
					{{/labels}}    
				</tbody>
			</table>
		</script>
		
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">Label</h4>
		                <div id="error">Error</div>
		            </div>
		            <div class="modal-body">
			            <form action="saveLabel" id="label_form" method="post" role="form">
			            	<input type="hidden" id="label_id"/>
					        <div class="form-group">
					            <label for="name">Name:</label>
					            <input type="text" name="name" id="label_name" class="form-control">
					        </div>
					        <div class="form-group">
					            <label for="website">Website:</label>
					            <input type="text" name="website" id="label_website" class="form-control">
					        </div>
					    </form>
		            </div>
		            <div class="modal-footer">
		            	<button type="button" id="label_form_submit" class="btn btn-success" onclick="saveOrUpdateLabel();" data-dismiss="modal"></button>
					    <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
		            </div>
		        </div>
		    </div>
		</div>
		
		<c:import url="../../../_template/footer.jsp"/>
		<script src="resources/js/rest/label.js"></script>
</body>
</html>