
$( window ).load(function() {
	$( ".star_rating a" ).click(function() {
	     $(this).parent().children("a").removeClass("on").removeClass("half");
	     $(this).addClass("on").prevAll("a").addClass("on");
	     return false;
	});
});
