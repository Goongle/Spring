function Validate()
   {
           var form = document.Signup_form;

                  //아이디에서 입력 필수 조건문
                  if (form.username.value == "")
                  {
                          alert("아이디를 입력해야 합니다!");
                          form.txtID.focus();//포커스를 id박스로 이동.
                          return;
                  }

                  //아이디 입력 문자수를 4~12자로 제한하는 조건문

                  if (form.username.value.length < 4 || form.username.value.length > 12)
                  {
                   alert("아이디는 4~12자 이내로 입력 가능합니다!");

                   form.username.select();//입력한 문자를 선택 상태로 만듬.
                   return;
                  }

            //입력된 문자의 길이만큼 루프를 돌면서 검사

            for (i=0; i<form.username.value.length; i++)
            {
                   var ch = form.username.value.charAt(i);//문자를 반환(정수형), 범위 검사 가능

                   //입력된 문자를 검사

                   if ( ( ch < "a" || ch > "z") && (ch < "A" || ch > "Z") && (ch < "0" || ch > "9" ) )
                   {
                    alert("아이디는 영문 소문자로만 입력 가능 합니다!");
                    form.txtID.select();
                    return;
                   }
            }

            //입력된 첫번째 문자가 숫자인지 검사하는 조건문

            if (!isNaN(form.username.value.substr(0,1)))

            {
                 alert("아이디는 숫자로 시작할 수 없습니다!");
                 form.txtID.select();
                 return;
            }



//패스워드 검사 -------------------------------------------------------------------------

            if (form.password.value == "")
            {
                 alert("패스워드를 입력 해야 합니다!");
                 form.password.focus();//포커스를 Password박스로 이동.
                 return;
            }



            if (form.password.value.length < 4 || form.password.value.length > 12)
            {
                 alert("비밀번호는 4~12자 이내로 입력 가능 합니다!");

                 form.password.select();
                 return;
            }
            $.ajax({
            type: "GET",
            url: "/verifyCode",
            data: JSON.stringify(json_value),
            contentType : "application/json",
            dataType  : "json",
            beforeSend : function(xhr)
            form.submit();
}

function Send()
   {

           var token = $("input[name='_csrf']").val();
           var header = "X-CSRF-TOKEN";

           var form2 = document.Sending_Form;
                  //아이디에서 입력 필수 조건문
                  if (form2.email_ID.value == "")
                  {
                          alert("이메일을 입력하세요.");
                          form2.email_ID.focus();//포커스를 id박스로 이동.
                          return;
                  }

            if (!isNaN(form2.email_ID.value.substr(0,1)))

            {
                 alert("이메일은 숫자로 시작할 수 없습니다!");
                 form2.email_ID.select();
                 return;
            }

            var json_value  = {"email_ID" : form2.email_ID.value};
                $.ajax({
                    type: "POST",
                    url: "/mail",
                    data: JSON.stringify(json_value),
                    contentType : "application/json",
                    dataType  : "json",
                beforeSend : function(xhr)
                {
                xhr.setRequestHeader(header, token);
                }
                ,
                               success : function(data) {
                                if (data.status == "200"){
                                    console.log("Success");
                                } else {
                                    console.log(response.message);
                                }
                                },
                                error : function(response)
                                {
                                console.log(response.message);

                                }
        });
            alert("이메일이 전송 되었습니다. 이메일을 확인해주세요.");
            form2.email_ID.disabled = 'true';
}

function Verify()
   {

           var token = $("input[name='_csrf']").val();
           var header = "X-CSRF-TOKEN";

           var form3 = document.Verifying_Form;
                  if (form3.verify_id.value == "")
                  {
                          alert("");
                          form3.verify_id.focus();//포커스를 id박스로 이동.
                          return;
                  }

            var json_value  = {"verifyCode" : form3.verify_id.value};
                $.ajax({
                    type: "POST",
                    url: "/verifyCode",
                    data: JSON.stringify(json_value),
                    contentType : "application/json",
                    dataType  : "json",
                beforeSend : function(xhr)
                {
                xhr.setRequestHeader(header, token);
                },
                success : function(data) {
                         console.log(data.result)
                        if (data.result == "1"){
                          console.log("Success");
                          alert("인증 되었습니다.");
                          form3.verify_id.disabled = 'true';
                          } else {
                             console.log("Fail");
                             alert("인증 번호가 틀립니다.");
                             form3.verify_id.focus();
                             return;
                             }
                                },
                               error : function(data)
                                {
                                console.log(data.status);

                                }
        });
           // form3.email_ID.disabled = 'true';
}