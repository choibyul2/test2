package com.kosa.starrydonuts.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	
	@RequestMapping("admin/main.do")
	public String main(HttpServletRequest req, HttpServletResponse res) throws Exception {
    	System.out.println("admin.main() invoked. starrynodnuts");
		
//		try { 
//			
//			List<NoticeDTO> noticeTop5 = noticeService.noticeTop5();
//        	req.setAttribute("noticeTop5", noticeTop5);
//        	
//        	List<BoardDTO> boardTop5 = boardService.boardTop5();
//        	req.setAttribute("boardTop5", boardTop5);
//        	
//        } catch (Exception e) { 
//        	e.printStackTrace();
//        }

		return "admin/main";
		
	} // list
	
} // end class
