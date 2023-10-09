<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


        <div id="slideShow">
            <div id="slides">
                <img src="/project10/images/main1.jpg" alt="">
                <img src="/project10/images/main2.jpg" alt="">
                <button id="prev">&lang;</button>
                <button id="next">&rang;</button>
            </div>
        </div>
        <div id="contents">
            <div id="tabMenu">
                <input type="radio" id="tab1" name="tabs" checked>
                <label for="tab1">공지사항</label>
                <input type="radio" id="tab2" name="tabs">
                <label for="tab2">게시판</label>

                <div id="notice" class="tabContent">
                    <h2>공지사항</h2>
                    <ul>
			            <c:forEach var="notice" items="${noticeTop5}">
			              <li><a href="#" onclick="notice_dialogDetail(${notice.noticeid})">${notice.title}</a></li>
			            </c:forEach>
                    </ul>
                </div>
                <div id="gallery" class="tabContent">
                    <h2>회원 게시판</h2>
                    <ul>
                        <c:forEach var="board" items="${boardTop5}">
			              <li><a href="#" onclick="board_dialogDetail(${board.boardid})">${board.title}</a></li>
			            </c:forEach>
                    </ul>
                </div>
            </div>
            <div id="links">
                <ul>
                    <li>
                        <a href="#">
                            <span id="quick-icon1"></span>
                            <p>BEST</p>
                            <
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <span id="quick-icon2"></span>
                            <p>NEW</p>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <span id="quick-icon3"></span>
                            <p>GOODS</p>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        
        
		<div id="notice_detail" title="글 상세보기" >
			<div class="notice_detail2">
			  	<input type="hidden" name="noticeid" id="noticeid2" value="${notice.noticeid}"/> 
		      	<h3 id="title2">[  ] </h3>
		      	<hr>
			      <br>
			      <div class="meta-info" id="info2"">
			  		작성자 :  <span id="writer_uid2">${notice.writer_uid}</span>  |　 작성날짜 :  <span id="reg_date2">${notice.reg_date}</span>　 |　 조회수 :  <span id="view_count2">${notice.view_count}</span>
				  </div>
			      <div class="contents" id="contents2">
			    	${notice.contentsHTML}
				  </div>
				  
			</div>
		</div> 

		<!-- 회원게시판 글 상세보기 -->
 		<div id="board_detail" title="글 상세보기" >
			<div class="board_detail2">
			  	<input type="hidden" name="boardid" id="boardid3" value="${board.boardid}"/> 
		      	<h3 id="title3">[  ] </h3>
		      	<hr>
			      <br>
			      <div class="meta-info" id="info3"">
			  		작성자 :  <span id="writer_uid3">${board.writer_uid}</span>  |　 작성날짜 :  <span id="reg_date3">${board.reg_date}</span>　 |　 조회수 :  <span id="view_count3">${board.view_count}</span>
				  </div>
			      <div class="contents" id="contents3">
			    	${board.contentsHTML}
				  </div>
			</div>
		</div> 

		
<!-- ---------------------------------------------------------------------------------------------------- -->

<script src="<c:url value='/resources/js/slideshow.js'/>"></script>
<script type="text/javascript">

/* 공지사항 상세 */
$(document).ready(function() {
	$("#notice_detail").dialog({
	    autoOpen: false,
	    modal: true,
	    width: 800,
	    height: 500,
	    buttons: {
	        Close: function() {
	            $(this).dialog("close");
	        }
	    }
	});
});

/* 글 상세 패치 코드 */
function notice_dialogDetail(noticeid) {
	alert("공지사항 상세보기");
 	const noticeid2 = document.querySelector("#noticeid2");
	const title2 = document.querySelector("#title2");
	const contents2 = document.querySelector("#contents2");
	const writer_uid2 = document.querySelector("#writer_uid2");
	const reg_date2 = document.querySelector("#reg_date2");
	const view_count2 = document.querySelector("#view_count2");


	
	const param = {
	        noticeid: noticeid
	      };

	      fetch("<c:url value='/notice/detail.do'/>", {
	        method: "POST",
	        headers: {
	          "Content-Type": "application/json; charset=UTF-8",
	        },
	        body: JSON.stringify(param),
	      })
	      .then((response) => response.json())
	      .then((json) => {
	    	   noticeid2.innerText = json.detail.noticeid;  
	    	   title2.innerText = json.detail.title;  
	    	   contents2.innerText = json.detail.contents;  
	    	   writer_uid2.innerText = json.detail.writer_uid;  
	    	   reg_date2.innerText = json.detail.reg_date;  
	    	   view_count2.innerText = json.detail.view_count;  
	       	   $("#notice_detail").dialog("open");
	      });
	
	return false;
	
}	

/* ========================================================================== */	
	
/* 회원게시판 상세 패치 코드 */
$(document).ready(function() {
	$("#board_detail").dialog({
	    autoOpen: false,
	    modal: true,
	    width: 800,
	    height: 500,
	    buttons: {
	        Close: function() {
	            $(this).dialog("close");
	        }
	    }
	});
});

/* 글 상세 패치 코드 */
function board_dialogDetail(boardid) {
	alert("회원게시판 상세보기");
 	const boardid3 = document.querySelector("#boardid3");
	const title3 = document.querySelector("#title3");
	const contents3 = document.querySelector("#contents3");
	const writer_uid3 = document.querySelector("#writer_uid3");
	const reg_date3 = document.querySelector("#reg_date3");
	const view_count3 = document.querySelector("#view_count3");

	
	const param = {
			boardid: boardid
	      };

	      fetch("<c:url value='/board/detail.do'/>", {
	        method: "POST",
	        headers: {
	          "Content-Type": "application/json; charset=UTF-8",
	        },
	        body: JSON.stringify(param),
	      })
	      .then((response) => response.json())
	      .then((json) => {
	    	   boardid3.innerText = json.detail2.noticeid;  
	    	   title3.innerText = json.detail2.title;  
	    	   contents3.innerText = json.detail2.contents;  
	    	   writer_uid3.innerText = json.detail2.writer_uid;  
	    	   reg_date3.innerText = json.detail2.reg_date;  
	    	   view_count3.innerText = json.detail2.view_count;  
	       	   $("#board_detail").dialog("open");
	      });
	
	return false;
	
}	
	
</script>		
