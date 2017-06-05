
$(document).ready(function() {
	$("#tcontent div#tab1").hide(); // Initially hide all content
	$("#tcontent div#tab2").hide(); // Initially hide all content
	$("#tcontent div#tab3").hide(); // Initially hide all content
	$("#tabs li:first").attr("id","current"); // Activate first tab
	$("#tcontent div:first").fadeIn(); // Show first tab content
    
    $('#tabs a').click(function(e) {
        e.preventDefault();        
        $("#tcontent div#tab1").hide(); //Hide all content
        $("#tcontent div#tab2").hide(); //Hide all content
        $("#tcontent div#tab3").hide(); //Hide all content
        $("#tabs li").attr("id",""); //Reset id's
        $(this).parent().attr("id","current"); // Activate this
        $('#' + $(this).attr('title')).fadeIn(); // Show content for current tab
   });
});
