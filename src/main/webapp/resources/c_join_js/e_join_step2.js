function jsSubmit() {
          if (document.lawchkform.chk_law.checked == false || document.lawchkform.chk_law2.checked == false) {
              alert('회원약관 및 개인정보 보호정책, 개인정보 수집에 동의하셔야 합니다.');
              return;
          }else{
              var form1 = document.form1;
              form1.action = "e_join_step3";
              form1.submit();
          }

      }

      $( document ).ready( function() {
        $( '.check-all' ).click( function() {
          $( '.ab' ).prop( 'checked', this.checked );
        } );
      } );