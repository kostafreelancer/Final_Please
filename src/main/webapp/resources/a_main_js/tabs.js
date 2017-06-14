
$(document).ready(function() {
	$("#tcontent div#tab1").hide(); // Initially hide all content
	$("#tcontent div#tab2").hide(); // Initially hide all content
	$("#tcontent div#tab3").hide(); // Initially hide all content
	$("#tcontent div#tab4").hide(); // Initially hide all content
	$("#tcontent div#tab5").hide();
	$("#tcontent div#tab6").hide();

	var tabnum = $('#tabnum').text();
	if(tabnum == ""){
		$("#tabs li:first").attr("id","current"); // Activate first tab
	}else{
		tabnum = tabnum - 1;
		$('#tabs li').eq(tabnum).attr("id", "current");
	}
	$('#tcontent div.tab').eq(tabnum).fadeIn(); // Show first tab content
	
    
    
    $('#tabs a').click(function(e) {
        e.preventDefault();        
        $("#tcontent div#tab1").hide(); //Hide all content
        $("#tcontent div#tab2").hide(); //Hide all content
        $("#tcontent div#tab3").hide(); //Hide all content
        $("#tcontent div#tab4").hide(); //Hide all content
        $("#tcontent div#tab5").hide();
        $("#tcontent div#tab6").hide();

        $("#tabs li").attr("id",""); //Reset id's
        $(this).parent().attr("id","current"); // Activate this
        $('#' + $(this).attr('title')).fadeIn(); // Show content for current tab
   });
});
