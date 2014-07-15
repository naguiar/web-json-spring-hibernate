/**
 * @author naty
 *
 */
var titles = [];
var titlesMap = {};

/**
 * Ready function
 */
$(document).ready(function() {
	list();
});

/**
 * List Titles
 */
function list() {
	
	$.getJSON('/web-json-spring-hibernate/rest/title', function(data) {
		titles = data;
		createTitlesMap();
		renderList();
	});
}

/**
 * Create Title map
 */
function createTitlesMap() {
	var totalTitles = titles.length;
	for (var i=0;i<totalTitles;i++) {
		var title = titles[i]; 
		titlesMap[title.id] = title;
	}
}

/**
 * Render list
 */
function renderList() {
	var html = ich.list_template({titles: titles}, true);
	$("#list").html(html);
	$('#dataTables-example').dataTable();
}

/**
 * List Labels
 */
function listLabels(callback) {	
	
	$.getJSON('/web-json-spring-hibernate/rest/title/labels', function(data) {
		renderLabelsCombo(data);
		callback(data);
	});
}

/**
 * Render Labels
 */
function renderLabelsCombo(data) {
	
	$("#title_label_combo").empty();
	$("#title_label_combo").append(new Option("Choose", ""));
	
	for (var i=0;i<data.length;i++) {
		var label = data[i];
		$("#title_label_combo").append(new Option(label.name, label.id));
	}
}

/**
 * List Artists
 */
function listArtists(callback) {	
	
	$.getJSON('/web-json-spring-hibernate/rest/title/artists', function(data) {
		renderArtistsCombo(data);
		callback(data);
	});
}

/**
 * Render Artists
 */
function renderArtistsCombo(data) {
	
	$("#title_artist_combo").empty();
	$("#title_artist_combo").append(new Option("Choose", ""));
	
	for (var i=0;i<data.length;i++) {
		var artist = data[i];
		$("#title_artist_combo").append(new Option(artist.name, artist.id));
	}
}

/**
 * Edit Title
 * @param id
 */
function editTitle(id) {
	
	var title = titlesMap[id];

	$("#title_id").val(title.id);
	$("#title_name").val(title.name);
	$("#title_year").val(title.description);
	$("#title_form_submit").html("Edit Title");
	$("#myModalLabel").html("Edit Title " + title.name);
	$("#myModal").modal();
	
	listLabels(function(data) {
		selectComboByValue('title_label_combo', title.label.id);
	});
	
	listArtists(function(data) {
		selectComboByValue('title_artist_combo', title.artist.id);
	});
	
	listArtists(function(data) {
		selectComboByValue('title_recording_combo', title.recording.name);
	});
	
}

function selectComboByValue(comboId, value) {
	$('#'+comboId+'>option:eq('+value+')').prop('selected', true);
}

/**
 * New Title
 */
function newTitle() {

	$("#title_form")[0].reset();
	$("#title_id").val("");
	$("#title_form_submit").html("Add Title");
	$("#myModalLabel").html("New Title");
	$("#myModal").modal();
	
	listLabels();
	
	listArtists();
}

/**
 * Create or update 
 */
function saveOrUpdateTitle() {
	
	var json = {
		name: $("#title_name").val(),
		year: $("#title_year").val(),
		label: {
			id: $("#title_label_combo").val()
		},
		artist: {
			id: $("#title_artist_combo").val()
		}
	}
	
	var title_id = $("#title_id").val();
	if (title_id) {
		json.id = parseInt(title_id);
	}
	
	$.ajax({
		  type: "POST",
		  url: "/web-json-spring-hibernate/rest/title",
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
