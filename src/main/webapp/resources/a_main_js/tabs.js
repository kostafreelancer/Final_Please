
$(document).ready(function() {
	$("#tcontent div#tab1").hide(); // Initially hide all content
	$("#tcontent div#tab2").hide(); // Initially hide all content
	$("#tcontent div#tab3").hide(); // Initially hide all content
	$("#tcontent div#tab4").hide(); // Initially hide all content
	$("#tcontent div#tab5").hide();
	$("#tcontent div#tab6").hide();

	var $tabnum = $('#tabnum');
	var tabnumValue = 0;
	if($tabnum.text() == ""){
		$("#tabs li:first").attr("id","current"); // Activate first tab
	}else{
		tabnumValue = $tabnum.text() - 1;
		$('#tabs li').eq(tabnumValue).attr("id", "current");
	}
	$('#tcontent div.tab').eq(tabnumValue).fadeIn(); // Show first tab content
	
    
    
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

function getTabnum(){
	return $('#tabnum').text();
}
