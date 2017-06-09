function open_win()
{
 window.open('/verification/verificationPop.jsp','popup', 
		 'width=300, height=200, left=0, top=0, toolbar=no, location=no, directories=no, status=no, menubar=no, resizable=no, scrollbars=no, copyhistory=no');
}  

$(document).ready(function(){
	  $('#e_mail_select1').change(function(){
	      var e_mail = $(this).val();
	      if(e_mail == ""){
	         $('#e_mail_2_1').removeAttr('readonly');
	      }else{
	         $('#e_mail_2_1').attr('readonly', 'true')
	      }
	      $('#e_mail_2_1').val(e_mail);
	   });	  
	  
	  $('#e_mail_select2').change(function(){
		  var e_mail = $(this).val();
		  if(e_mail == ""){
			  $('#e_mail_2_2').removeAttr('readonly');
		  }else{
			  $('#e_mail_2_2').attr('readonly', 'true')
		  }
		  $('#e_mail_2_2').val(e_mail);
	  });	  
  });



function openbtn(evt, btn) {
    // Declare all variables
    var i, tabcontent, tablinks;

    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Get all elements with class="tablinks" and remove the class "active" 
    tablinks = document.getElementsByClassName("tablinks");
    
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    // Show the current tab, and add an "active" class to the button that opened the tab
     document.getElementById(btn).style.display = "block";
    evt.currentTarget.className += " active";
}
