<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Caprasimo&family=Lato:wght@100&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

  <header>
          <div id="logo">
              <a href="<c:url value='/main.do' />">
                  <h1>starry donuts</h1>
              </a>
          </div>
          <nav>
              <ul id="topMenu">
                  <li><a href="#">HELP <span>▼</span></a>
                      <ul>
                          <li><a href="<c:url value='/notice/list2.do' />">공지사항</a></li>
                          <li><a href="<c:url value='/board/list2.do' />">회원 게시판</a></li>
                          <c:if test="${loginMember.id=='admin'}">
                          	<li><a href="<c:url value='/member/list.do' />">회원 전체 조회</a></li>
                          </c:if>
                      </ul>
                  </li>
                  <li>
                      <a href="#">MENU <span>▼</span></a>
                      <ul>
                          <li><a href="#">이달의 도넛</a></li>
                          <li><a href="#">클래식 도넛</a></li>
                          <li><a href="#">디럭스 도넛</a></li>
                          <li><a href="#">팬시 도넛</a></li>
                          <li><a href="#">프리미엄 도넛</a></li>
                      </ul>
                  </li>
                  <li><a href="#">BRAND </a></li>
				

				<!-- 로그인 X -->
				<c:if test="${loginMember == null}">
					<li id="login" ><a href="#" id="dialogLogin">LOGIN</a></li>
					<li id="join" ><a href="#" id="dialogJoin">JOIN</a></li>
				</c:if>
			
				<!-- 로그인 O -->
				<c:if test="${loginMember != null}">
					<li id="myPage"><a href="#" id="dialogMyPage">MY PAGE</a></li>
					<li id="logout"><a href="#" onclick="dlogout()">LOGOUT</a></li>
				</c:if>
		
			
             </ul>
        </nav>

</header>
 <!-- ---------------------------------------- 회원관리 다이얼로그용 html --------------------------------------- --> 
		
		<!-- 로그인 -->
		<div id="dlogin" title="로그인">
			<div class="dialogLogin">
				아이디 : <input type="text" id="login_id" name="id" >
				비밀번호 : <input type="password" id="login_pwd" name="pwd" ><br>
			</div>
		</div>
		
		
		<!-- 회원가입 -->
		<div id="djoin" title="회원가입">
			<div class="dialogJoin">
		  		<div class="form-group">
			        <label for="uid">아이디</label>
			        <input type="text" id="join_id" name="id" placeholder="아이디를 입력해주세요.">
		      	</div>
		      	<div class="form-group">
			        <label for="pwd">비밀번호</label>
			        <input type="password" id="join_pwd" name="pwd" placeholder="비밀번호를 입력해주세요.">
		     	</div>
			    <div class="form-group">
			        <label for="pwd-confirm">비밀번호 확인</label>
			        <input type="password" id="join_pwd2" name="pwd2" placeholder="비밀번호를 다시 입력해주세요.">
			    </div>
		      	<div class="form-group">
			        <label for="uname">이름</label>
			        <input type="text" id="join_uname" name="uname" placeholder="이름을 입력해주세요.">
		      	</div>
			    <div class="form-group">
			        <label for="birth">생년월일</label>
			        <input type="text" id="join_birth" name="birth" placeholder="생년월일을 입력해주세요.  ex)940614">
			    </div>
			   	<div class="gender">
				   	<input type="radio" id="join_gender" name="gender" value="남성" id="gender1">남성
				   	<input type="radio" id="join_gender" name="gender" value="여성" id="gender2">여성
				</div>
				<div class="form-group">
					<label for="phone">휴대전화번호</label>
					<input type="text" id="join_phone" name="phone" placeholder="전화번호를 입력해주세요.  ex)01053282794">
				</div>
				<div class="form-group">
					<label for="email">이메일</label>
					<input type="text" id="join_email" name="email" placeholder="이메일을 입력해주세요.  ex)star@naver.com">
				</div>
			</div>
		</div>
		
		<!-- 마이페이지 -->
		<div id="dmypage">
			<div id="dialogMyPage">
				<h1 id="text">나의 회원 정보</h1>	
				<h3>아이디 : <input type="text" id="mypage_id" name="id" value="${loginMember.id}" readonly></h3>
	            <h3>이름 : <input type="text" id="mypage_uname" name="uname" value=" ${loginMember.uname}" readonly></h3>
	            <h3>전화번호 : <input type="text" id="mypage_phone" name="phone" value=" ${loginMember.phone}" readonly></h3>
	            <h3>생일 : <input type="text" id="mypage_birth" name="birth" value=" ${loginMember.birth}" readonly></h3>
	            <h3>성별 : <input type="text" id="mypage_gender" name="gender" value=" ${loginMember.gender}" readonly></h3>
	            <h3 id="id3">이메일 : <input type="text" id="mypage_email" name="email" value=" ${loginMember.email}" readonly></h3>
           </div>
		</div>
		

		<!-- 회원수정 -->
		<div id="dupdate">
			 <div id="dialogUpdate">
				<div class="form-group">
			      <label for="uid">아이디</label>
			      <input type="text" id="update_id" name="id" value="${loginMember.id}" readonly>
			   	</div>
			   	<div class="form-group">
			      <label for="pwd">비밀번호</label>
			      <input type="password" id="update_pwd" name="pwd" placeholder="변경할 비밀번호">
			  	</div>
			  <div class="form-group">
			      <label for="pwd-confirm">비밀번호 확인</label>
			      <input type="password" id="update_pwd2" name="pwd2" placeholder="변경할 비밀번호 확인">
			  </div>
			   	<div class="form-group">
			      <label for="name">이름</label>
			      <input type="text" id="update_uname" name="uname" value="${loginMember.uname}" placeholder="변경할 이름">
			   	</div>
			  <div class="form-group">
			      <label for="birth">생년월일</label>
			      <input type="text" id="update_birth" name="birth" value="${loginMember.birth}" placeholder="변경할 생년월일 ex)940614">
			   </div>
			  	<div class="gender">
			  	<label for="gender">성별</label>
			   	<input type="radio" id="update_gender" name="gender" value="남성" class="gender">남성
			   	<input type="radio" id="update_gender" name="gender" value="여성" class="gender" checked>여성
			</div>
			<div class="form-group">
				<label for="phone">휴대전화번호</label>
				<input type="text" id="update_phone" name="phone" value="${loginMember.phone}" placeholder="변경할 휴대전화번호 ex)01053282794">
			</div>
			<div class="form-group">
				<label for="email">이메일</label>
				<input type="text" id="update_email" name="email" value="${loginMember.email}" placeholder="변경할 이메일 ex)01053282794">
			</div>
			</div>
		</div>
		    
		       
		<!-- 회원탈퇴 -->    
		<div id="ddelete">
			<h1 id="text">회원 탈퇴</h1>
		      <h1 id="text2">본인인증</h1>
		      <h1 id="uid1">
		        <input type="hidden" id="delete_id" name="id" value="${loginMember.id}">
		      </h1>
		      <br>
		      <h1 id="pwd1">
		        <input type="password" id="delete_pwd" name="pwd" placeholder="  비밀번호를 입력하세요">
		      </h1>
		</div>
		
		
		<!-- 회원 아이디 찾기 -->    
		<div id="didfind">
		    <h1 id="text2">아이디 찾기</h1>
		    <h1 id="name1">
	    		<input type="text" id="idFind_uname" name="uname" placeholder="  이름을 입력하세요">
	    	</h1>
	    	<br>
		    <h1 id="pwd1">
		    	<input type="text" id="idFind_phone" name="phone" placeholder="  휴대전화번호를 입력하세요">
		    </h1>
	    </div>
	    
	    
	    <!-- 회원 비밀번호 찾기 -->    
   		<div id="dpwdfind">
   			<h1 id="text2">비밀번호 찾기</h1>
		    <h1 id="name1">
		        <input type="text" id="pwdFind_id" class="id" name="id" placeholder="  아이디를 입력하세요">
		    </h1>
		    <br>
		    <h1 id="pwd1">
		    	<input type="text" id="pwdFind_uname" class="uname" name="uname" placeholder="  이름을 입력하세요">
		    </h1>
	    </div>
	    
		
<!-- ---------------------------------------------------------------------------------------------------- -->

<script src="<c:url value='/resources/js/slideshow.js'/>"></script>
<script>
$(document).ready(function() {

	
	/* ---------------------------------------- 다이얼로그 창 띄우기 ------------------------------------------ */
	$("#dialogLogin").on("click", () => {
		alert("로그인 창");
		$("#dlogin").dialog("open");
	});
	
	 
	$("#dialogJoin").on("click", () => {
		alert("회원가입 창");
		$("#djoin").dialog("open");
	});
	
	
	$("#dialogMyPage").on("click", () => {
		alert("마이페이지 창");
		$("#dmypage").dialog("open");
	});
	
	$("#dialogUpdate").on("click", () => {
		$("#dupdate").dialog("open");
	});
	
	
	$("#dialogDelete").on("click", () => {
		alert("탈퇴페이지 창");
		$("#ddelete").dialog("open");
	});
	
	$("#dialogIdFind").on("click", () => {
		alert("아이디찾기 창");
		$("#didfind").dialog("open");
	});
	
	$("#dialogPwdFind").on("click", () => {
		alert("비밀번호찾기 창");
		$("#dpwdfind").dialog("open");
	});
	
	 
	/* --------------------------- 다이얼로그 창  --------------------------- */
	/* 로그인 */
	$("#dlogin").dialog({
	    autoOpen: false,
	    modal: true,
	    width: 500,
	    height: 700,
	    buttons: {
	       'login': function() {
	            const id = $("#login_id").val();
	            const pwd = $("#login_pwd").val();
	            
	            
	            
	            if (id === "") {
	                alert("아이디를 입력해주세요.");
	                $("#login_id").focus();
	                return false;
	            }
	            
	            if (pwd === "") {
	                alert("비밀번호를 입력해주세요");
	                $("#login_pwd").focus();
	                return false;
	            }
	    
	            const param = {
	                id: id,
	                pwd: pwd
	            };
	            
	            fetch("<c:url value='/member/login.do'/>", {
	                method: "POST",
	                headers: {
	                    "Content-Type": "application/json; charset=UTF-8",
	                },
	                body: JSON.stringify(param),
	            })
	            .then((response) => response.json())
	            .then((json) => {
	                if (json.status) {
	                    alert("로그인 성공!");
	                    location.href = "<c:url value='/main.do'/>";
	                } else {
	                    alert("로그인 실패!");
	                }
	            });
	    
	            return false;
	        }, /* 로그인 버튼 */
	        "아이디 찾기": function() {
	    		$("#didfind").dialog("open");
	        }, /* 이거 close 창 */
	        "비밀번호 찾기": function() {
	    		$("#dpwdfind").dialog("open");
	        }, /* 이거 close 창 */
	        'Close': function() {
	            $(this).dialog("close");
	        } /* 이거 close 창 */
	        
	       
	    },
	    
	    closeText:'Close',
	    closeOnEscape: true
	    
	});
	
	
	/* 회원가입 */
	$("#djoin").dialog({
	    autoOpen: false,
	    modal: true,
	    width: 700,
	    height: 500,
	    buttons: {
	        join: function() {
	            const id = $("#join_id").val();
	            const pwd = $("#join_pwd").val();
	            const pwd2 = $("#join_pwd2").val();
	            const uname = $("#join_uname").val();
	            const birth = $("#join_birth").val();
	            const gender = $("#join_gender").val();
	            const phone = $("#join_phone").val();
	            const email = $("#join_email").val();
	            
	            if (pwd !== pwd2) {
	                alert("비밀번호가 일치하지 않습니다.");
	                $("#join_pwd").focus();
	                return false;
	            }
	    
	            const param = {
	                id: id,
	                pwd: pwd,
	                uname: uname,
	                birth: birth,
	                gender: gender,
	                phone: phone,
	                email: email
	            };
	            
	            fetch("<c:url value='/member/join.do'/>", {
	                method: "POST",
	                headers: {
	                    "Content-Type": "application/json; charset=UTF-8",
	                },
	                body: JSON.stringify(param),
	            })
	            .then((response) => response.json())
	            .then((json) => {
	                    if (json.status) {
	                        alert("회원가입 성공!");
	                        location.href = "<c:url value='/main.do'/>";
	                    } else {
	                        alert("회원가입 실패!");
	                    }
	            });
	    
	            return false;
	        }, /* 로그인 버튼 */
	        Close: function() {
	            $(this).dialog("close");
	        } /* 이거 close 창 */
	    }
	});
	
	
	
	/* 마이페이지 */
	$("#dmypage").dialog({
	    autoOpen: false,
	    modal: true,
	    width: 500,
	    height: 700,
	    buttons: {
	    	"수정": function() {
	    		$("#dupdate").dialog("open");
	        }, /* 마이페이지 버튼 */
	        Close: function() {
	            $(this).dialog("close");
	        } /* 이거 close 창 */
	    }
	});
	
	
	/* 수정페이지 */
	$("#dupdate").dialog({
	    autoOpen: false,
	    modal: true,
	    width: 500,
	    height: 700,
	    buttons: {
	    	update: function() {
	    		
	            const id = $("#update_id").val();
	            const pwd = $("#update_pwd").val();
	            const pwd2 = $("#update_pwd2").val();
	            const uname = $("#update_uname").val();
	            const birth = $("#update_birth").val();
	            const gender = $("input[name='gender']:checked").val();
	            const phone = $("#update_phone").val();
	            const email = $("#update_email").val();
	    	    
	    	    const param = {
	    	        id: id,
	    	        pwd: pwd,
	    	        pwd2: pwd2,
	    	        uname: uname,
	    	        birth: birth,
	    	        gender: gender,
	    	        phone: phone,
	    	        email: email
	    	    };
	    	    
	    	    alert(param);
	    	    fetch("<c:url value='/member/update.do'/>", {
	    	        method: "POST",
	    	        headers: {
	    	            "Content-Type": "application/json; charset=UTF-8",
	    	        },
	    	        body: JSON.stringify(param)
	    	    })
	    	    .then(response => response.json())
	    	    .then(data => {
	    	        if (data.status) {
	    	            // 수정이 성공한 경우에 업데이트된 내용을 화면에 반영
	    	            $("#update_pwd").val(pwd);
	    	            $("#update_uname").val(uname);
	    	            $("#update_birth").val(birth);
	    	            $("#update_gender").prop(gender);
	    	            $("#update_phone").val(phone);
	    	            $("#update_email").val(email);
	                    alert("수정 성공!");
	                    location.href = "<c:url value='/main.do'/>";
	    	            // editDialog 열고 닫는 코드 (확인 필요)
	    	            editDialog.dialog("close");
	    	        } else {
	    	        	alert("수정 성공!");
	    	        }
	    	    });
	        }, /* 마이페이지 버튼 */
	    	"탈퇴": function() {
	    		$("#ddelete").dialog("open");
	        }, /* 마이페이지 버튼 */
	        Close: function() {
	            $(this).dialog("close");
	        } /* 이거 close 창 */
	    }
	});
	
	
	/* 탈퇴 */
	$("#ddelete").dialog({
	    autoOpen: false,
	    modal: true,
	    width: 500,
	    height: 700,
	    buttons: {
	    	"탈퇴": function() {
	    		
	            const id = $("#delete_id").val();
	            const pwd = $("#delete_pwd").val();
	    		
	    		const param = {
	    				id: id,
	    				pwd: pwd
	    		      };
	
	    		      fetch("<c:url value='/member/delete.do'/>", {
	    		        method: "POST",
	    		        headers: {
	    		          "Content-Type": "application/json; charset=UTF-8",
	    		        },
	    		        body: JSON.stringify(param),
	    		      })
	    		      .then((response) => response.json())
	    		      .then((json) => {
	    		          if (json.status) {
	    		        	  alert('탈퇴되었습니다.');
	    		        	  location.href = "<c:url value='/main.do'/>"; 
	    		          }
	    		      });
	    		
	    		return false;
	    		
	        }, /* 탈퇴페이지 버튼 */
	        Close: function() {
	            $(this).dialog("close");
	        } /* 이거 close 창 */
	    }
	});
	
	
	/* 아이디찾기 */
	$("#didfind").dialog({
	    autoOpen: false,
	    modal: true,
	    width: 500,
	    height: 700,
	    buttons: {
	    	"아이디찾기": function() {
	    		
	            const uname = $("#idFind_uname").val();
	            const phone = $("#idFind_phone").val();
	
	    	    const param = {
	    		        uname: uname,
	    		        phone: phone
	    		      };
	
	    		      fetch("<c:url value='/member/idFind.do'/>", {
	    		        method: "POST",
	    		        headers: {
	    		          "Content-Type": "application/json; charset=UTF-8",
	    		        },
	    		        body: JSON.stringify(param),
	    		      })
	    		      .then((response) => response.json())
	    		      .then((json) => {
	    		    	  alert(json.message);
	    		          if (json.status) {
	    		        	  location.href = "<c:url value='/main.do'/>"; 
	    		          }
	    		      });
	    		
	    		return false;
	    		
	        }, /* 마이페이지 버튼 */
	        Close: function() {
	            $(this).dialog("close");
	        } /* 이거 close 창 */
	    }
	    
	});
	
	
	/* 비밀번호찾기 */
	$("#dpwdfind").dialog({
	    autoOpen: false,
	    modal: true,
	    width: 500,
	    height: 700,
	    buttons: {
	    	"비밀번호 찾기": function() {
	    		
	            const id = $("#pwdFind_id").val();
	            const uname = $("#pwdFind_uname").val();
	
	    	    const param = {
	    	    		id: id,
	    	    		uname: uname
	    		      };
	
	    		      fetch("<c:url value='/member/pwdFind.do'/>", {
	    		        method: "POST",
	    		        headers: {
	    		          "Content-Type": "application/json; charset=UTF-8",
	    		        },
	    		        body: JSON.stringify(param),
	    		      })
	    		      .then((response) => response.json())
	    		      .then((json) => {
	    		    	  alert(json.message);
	    		          if (json.status) {
	    		        	  location.href = "<c:url value='/main.do'/>"; 
	    		          }
	    		      });
	    		
	    		return false;
	    		
	        }, /* 마이페이지 버튼 */
	        Close: function() {
	            $(this).dialog("close");
	        } /* 이거 close 창 */
	    }
	    
	});

});
</script>	




 
<script>	
/* 비동기 로그아웃 */
function dlogout() {
    // AJAX를 사용하여 POST 요청을 보냅니다.
    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/starrydonuts/member/logout.do', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                // 로그아웃이 성공했을 때의 처리
                alert('로그아웃 되었습니다.');
                // 여기에서 필요한 리다이렉션 또는 다른 동작을 수행하세요.
                location.href = "<c:url value='/main.do'/>";
            } else {
                // 로그아웃에 실패했을 때의 처리
            	alert('로그아웃에 실패했습니다.');
            }
        }
    };
    xhr.send();
}


</script>		
