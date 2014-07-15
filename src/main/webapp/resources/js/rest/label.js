/**
 * @author naty
 *
 */
var labels = [];
var labelsMap = {};

/**
 * Ready function
 */
$(document).ready(function() {
	list();
});

/**
 * List Labels
 */
function list() {
	
	$.getJSON('/web-json-spring-hibernate/rest/label', function(data) {
		labels = data;
		createLabelsMap();
		renderList();
	});
}

/**
 * Create Label map
 */
function createLabelsMap() {
	var totalLabels = labels.length;
	for (var i=0;i<totalLabels;i++) {
		var label = labels[i]; 
		labelsMap[label.id] = label;
	}
}

/**
 * Render list
 */
function renderList() {
	var html = ich.list_template({labels: labels}, true);
	$("#list").html(html);
	$('#dataTables-example').dataTable();
}

/**
 * Edit
 * @param id
 */
function editLabel(id) {
	
	console.error("id is %s", id);
	var label = labelsMap[id];
	
	$("#label_name").val(label.name);
	$("#label_website").val(label.website);
	$("#label_id").val(label.id);
	
	$("#label_form_submit").html("Edit Label");
	$("#myModalLabel").html("Edit Label " + label.name);
	$("#myModal").modal();
}

/**
 * New Label
 */
function newLabel() {

	$("#label_form")[0].reset();
	$("#label_id").val("");
	$("#label_form_submit").html("Add Label");
	$("#myModalLabel").html("New Label");
	$("#myModal").modal();
}

/**
 * Create or update
 */
function saveOrUpdateLabel() {
	
	var json = {
		name: $("#label_name").val(),
		website: $("#label_website").val()
	}
	
	var label_id = $("#label_id").val();
	if (label_id) {
		json.id = parseInt(label_id);
	}
		
	$.ajax({
		  type: "POST",
		  url: "/web-json-spring-hibernate/rest/label",
		  data: JSON.stringify(json),
		  contentType: 'application/json',
		  success: function(data) {
			  list();
		  },
		  error:function(data,status,er) {
		      $("#error").show();
		  }
	});
}
