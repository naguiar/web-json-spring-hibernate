/**
 * @author naty
 *
 */
var artists = [];
var artistsMap = {};

/**
 * Ready function
 */
$(document).ready(function() {
	list();
});

/**
 * List Artists
 */
function list() {
	
	$.getJSON('/web-json-spring-hibernate/rest/artist', function(data) {
		artists = data;
		createArtistsMap();
		renderList();
	});
}

/**
 * Create Artist map
 */
function createArtistsMap() {
	var totalArtists = artists.length;
	for (var i=0;i<totalArtists;i++) {
		var artist = artists[i]; 
		artistsMap[artist.id] = artist;
	}
}

/**
 * Render list
 */
function renderList() {
	var html = ich.list_template({artists: artists}, true);
	$("#list").html(html);
	$('#dataTables-example').dataTable();
}

/**
 * List Genres
 */
function listGenres(callback) {	
	
	$.getJSON('/web-json-spring-hibernate/rest/artist/genre', function(data) {
		renderGenresCombo(data);
		callback(data);
	});
}

/**
 * Render Genres combo
 */
function renderGenresCombo(data) {
	
	$("#artist_genre_combo").empty();
	$("#artist_genre_combo").append(new Option("Choose", ""));
	
	for (var i=0;i<data.length;i++) {
		var genre = data[i];
		$("#artist_genre_combo").append(new Option(genre.name, genre.id));
	}
}

/**
 * Edit Artist
 * @param id
 */
function editArtist(id) {
	
	listGenres(function(data) {
		
		console.error("id is %s", id);
		var artist = artistsMap[id];
		
		$("#artist_id").val(artist.id);
		$("#artist_name").val(artist.name);
		$("#artist_description").val(artist.description);
		$("#artist_origin").val(artist.origin);
		$("#artist_website").val(artist.website);
		
		$('#artist_genre_combo>option:eq('+artist.genre.id+')').prop('selected', true);
		
		$("#artist_form_submit").html("Edit Artist");
		$("#myModalLabel").html("Edit Artist " + artist.name);
		$("#myModal").modal();
		
	});
}

/**
 * New Artist
 */
function newArtist() {

	$("#artist_form")[0].reset();
	$("#artist_id").val("");
	$("#artist_form_submit").html("Add Artist");
	$("#myModalLabel").html("New Artist");
	$("#myModal").modal();
	
	listGenres();
}

/**
 * Create or update Artist
 */
function saveOrUpdateArtist() {
	
	var json = {
		name: $("#artist_name").val(),
		description: $("#artist_description").val(),
		origin: $("#artist_origin").val(),
		website: $("#artist_website").val(),
		genre: {
			id: $("#artist_genre_combo").val()
		}
	}
	
	var artist_id = $("#artist_id").val();
	if (artist_id) {
		json.id = parseInt(artist_id);
	}
	
	$.ajax({
		  type: "POST",
		  url: "/web-json-spring-hibernate/rest/artist",
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