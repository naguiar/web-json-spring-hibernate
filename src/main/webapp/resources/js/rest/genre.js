/**
 * @author naty
 *
 */
var genres = [];
var genresMap = {};

/**
 * Ready function
 */
$(document).ready(function() {
	list();
});

/**
 * List Genres
 */
function list() {
	
	$.getJSON('/web-json-spring-hibernate/rest/genre', function(data) {
		genres = data;
		createGenresMap();
		renderList();
	});
}

/**
 * Create Genre map
 */
function createGenresMap() {
	var totalGenres = genres.length;
	for (var i=0;i<totalGenres;i++) {
		var genre = genres[i]; 
		genresMap[genre.id] = genre;
	}
}

/**
 * Render list
 */
function renderList() {
	var html = ich.list_template({genres: genres}, true);
	$("#list").html(html);
	$('#dataTables-example').dataTable();
}

/**
 * Edit
 * @param id
 */
function editGenre(id) {
	
	console.error("id is %s", id);
	var genre = genresMap[id];
	
	$("#genre_name").val(genre.name);
	$("#genre_description").val(genre.description);
	$("#genre_id").val(genre.id);
	
	$("#genre_form_submit").html("Edit Genre");
	$("#myModalLabel").html("Edit Genre " + genre.name);
	$("#myModal").modal();
}

/**
 * New Genre
 */
function newGenre() {

	$("#genre_form")[0].reset();
	$("#genre_id").val("");
	$("#genre_form_submit").html("Add Genre");
	$("#myModalLabel").html("New Genre");
	$("#myModal").modal();
}

/**
 * Create or update
 */
function saveOrUpdateGenre() {
	
	var json = {
		name: $("#genre_name").val(),
		description: $("#genre_description").val()
	}
	
	var genre_id = $("#genre_id").val();
	if (genre_id) {
		json.id = parseInt(genre_id);
	}
		
	$.ajax({
		  type: "POST",
		  url: "/web-json-spring-hibernate/rest/genre",
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
