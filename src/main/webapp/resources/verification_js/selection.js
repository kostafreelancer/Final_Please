$(document).ready(function(){
	  $('#e_mail_select').change(function(){
	      var e_mail = $(this).val();
	      if(e_mail == ""){
	         $('#e_mail_2').removeAttr('readonly');
	      }else{
	         $('#e_mail_2').attr('readonly', 'true')
	      }
	      $('#e_mail_2').val(e_mail);
	   });	  
  });