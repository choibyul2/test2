package com.kosa.starrydonuts.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kosa.starrydonuts.domain.AttacheFileDTO;
import com.kosa.starrydonuts.domain.BoardDTO;
import com.kosa.starrydonuts.domain.CommentDTO;
import com.kosa.starrydonuts.domain.NoticeDTO;
import com.kosa.starrydonuts.service.BoardService;
import com.kosa.starrydonuts.service.CommentService;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@Autowired
	private CommentService cservice;
	
	private static final String CURR_IMAGE_REPO_PATH = "C:\\file_repo";

	
//	게시판 목록 =====================================================================================
	
	// 1. 게시판 전체 목록 페이지
//	public String list(HttpServletRequest req, HttpServletResponse res) throws Exception {
//    	System.out.println("board.controller.list() invoked.");
//
//    	try { 
//        	req.setAttribute("board", boardService.getBoardList());
//        } catch (Exception e) { 
//        	e.printStackTrace();
//        }
//		
//		return "board/boardList.jsp";
//		
//	} // list
	
	// 1. 게시판 전체 목록 페이지[더보기]
//	@RequestMapping("/board/list.do")
//	public String list(BoardDTO board, Model model) throws Exception {
//    	System.out.println("board.controller.list() invoked.");
//
//    	try { 
//    		model.addAttribute("boardList", service.boardList());
//        } catch (Exception e) { 
//        	e.printStackTrace();
//        }
//		
//		return "board/list";
//		
//	} // list
	
	
	// 2. [페이징]게시판 전체 목록 페이지
	@RequestMapping("/board/list2.do")
	public String list2(BoardDTO board, HttpServletRequest req, HttpServletResponse res, String searchTitle) throws Exception {
    	System.out.println("notice.controller.list2() invoked.");
    	
    	Map<String, Object> plist = service.noticePageList(board);
		req.setAttribute("plist", plist);
		System.out.println("plist : " +plist);
		
		
		return "board/list2";
	}
	
	
	// 1-2. 게시판 전체 목록 페이지 [ajax로 더보기 출력]
//	@ResponseBody
//	@RequestMapping(value="/board/ajaxList.do", method = RequestMethod.POST)
//	public Map<String, Object> ajaxList(@RequestBody BoardDTO board, HttpServletRequest req, HttpServletResponse res) throws Exception {
//    	System.out.println("board.controller.ajaxlist()-> ajax invoked.");
//    	Map<String, Object> result = new HashMap<String, Object>();
//    	
//		try { 
//			List<BoardDTO> boardList = service.boardList2(board);
//        	result.put("status", true);
//        	result.put("list", boardList);
//        } catch (Exception e) { 
//        	result.put("status", false);
//        	result.put("message", "서버에 오류 발생");
//        	e.printStackTrace();
//        }
//		System.out.println(result);
//		return result;
//		
//	} // list
	

	
//	게시판 상세 =====================================================================================
	
	// 2. 게시판 상세 페이지
	@ResponseBody
	@RequestMapping(value="/board/detail.do", method = RequestMethod.POST)
	public Map<String, Object> detail(@RequestBody BoardDTO board,  Model model) throws Exception {
		System.out.println("board.controller.detail() invoked.");

		Map<String, Object> map = new HashMap<>();
		BoardDTO detail = service.boardGet(board.getBoardid());
    	
		map.put("detail", detail);
    	System.out.println("detail : " + detail);
    	
		return map;
		
	} // detail
	
//	@ResponseBody
//	@RequestMapping(value="/board/detail.do", method = RequestMethod.POST)
//	public String detail(@RequestBody BoardDTO board, Model model) throws Exception {
//		System.out.println("board.controller.detail() invoked.");
//		System.out.println("board " + board);
//		
//		try {
//			model.addAttribute("status", true);
//			BoardDTO boardView = service.boardGet(board.getBoardid());
//			System.out.println("bordView = " + boardView);
//			model.addAttribute("board", boardView);
//        } catch (Exception e) { 
//        	model.addAttribute("status", false);
//        	model.addAttribute("message", "서버에 오류 발생");
//        	e.printStackTrace();
//        }
//
//		return "board/detail";
//	} // detail
	
	
	// 2. 게시판 상세 페이지
//	@RequestMapping(value="/board/reply.do", method = RequestMethod.POST)
//	public String replyForm(BoardDTO board, Model model) throws Exception {
//		System.out.println("board.controller.detail() invoked.");
//		System.out.println("board " + board);
//		
//		try {
//			model.addAttribute("status", true);
//			BoardDTO boardView = service.boardGet(board.getBoardid());
//			System.out.println("bordView = " + boardView);
//			model.addAttribute("board", boardView);
//        } catch (Exception e) { 
//        	model.addAttribute("status", false);
//        	model.addAttribute("message", "서버에 오류 발생");
//        	e.printStackTrace();
//        }
//
//		return "board/reply";
//	} // detail
	
	
//	@ResponseBody
//	@RequestMapping(value="/board/reply.do", method = RequestMethod.POST)
//	public String reply(BoardDTO board, Model model,
//			MultipartHttpServletRequest multipartRequest
//			) throws Exception {
//		System.out.println("board.controller.detail() invoked.");
//		System.out.println("board " + board);
//		
//		multipartRequest.setCharacterEncoding("utf-8");
//		Map map = new HashMap();
//		Enumeration enu=multipartRequest.getParameterNames();
//		while(enu.hasMoreElements()){
//			String name=(String)enu.nextElement();
//			String value=multipartRequest.getParameter(name);
//			//System.out.println(name+", "+value);
//			map.put(name,value);
//		}
//		
//		board.setAttacheFileList(fileProcess(multipartRequest));
//		
//		try {
//			model.addAttribute("status", true);
//			board.setWriter_uid("bbb");
//			service.reply(board);
//        } catch (Exception e) { 
//        	model.addAttribute("status", false);
//        	model.addAttribute("message", "서버에 오류 발생");
//        	e.printStackTrace();
//        }
//
//		return "redirect:list.do";
//	} // detail
	
	
	// 4. 회원게시판 답글 등록
	@ResponseBody
	@RequestMapping(value="/board/reply.do", method = RequestMethod.POST)
	public String reply(@RequestBody BoardDTO board, HttpServletRequest req, HttpServletResponse res) throws Exception {
    	System.out.println("board.controller.reply() invoked.");
    	
    	JSONObject result = new JSONObject();
    	int status = service.reply(board);

    	System.out.println("회원게시판 답글 성공여부 : " + status);
    	
    	if(status == 1) {
    		result.put("status", true);
    		result.put("message", "회원게시판 답글이 등록되었습니다.");
    	} else {
    		result.put("status", false);
    		result.put("message", "회원게시판 답글이 등록되지 않았습니다.");
    	}

    	System.out.println(result.toString());
		return result.toString();
	}
	
	
	private List<AttacheFileDTO> fileProcess(MultipartHttpServletRequest multipartRequest) throws Exception{
		List<AttacheFileDTO> fileList = new ArrayList<>();
		Iterator<String> fileNames = multipartRequest.getFileNames();
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("\\yyyy\\MM\\dd");
		
		while(fileNames.hasNext()){
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			String fileNameOrg = mFile.getOriginalFilename();
			String realFolder = sdf.format(now.getTime());
			
			File file = new File(CURR_IMAGE_REPO_PATH + realFolder);
			if (file.exists() == false) {
				file.mkdirs();
			}

			String fileNameReal = UUID.randomUUID().toString();
			
			//파일 저장 
			mFile.transferTo(new File(file, fileNameReal)); //임시로 저장된 multipartFile을 실제 파일로 전송

			fileList.add(
					AttacheFileDTO.builder()
					.fileNameOrg(fileNameOrg)
					.fileNameReal(realFolder + "\\" + fileNameReal)
					.length((int) mFile.getSize())
					.contentType(mFile.getContentType())
					.build()
					);
		}
		return fileList;
	}	
	
//	게시판 글쓰기 =====================================================================================

	// 3-1. 게시판 글쓰기 페이지
	/*
	 * public String insertForm(HttpServletRequest req, HttpServletResponse res)
	 * throws Exception {
	 * System.out.println("board.controller.insertForm() invoked.");
	 * 
	 * return "board/boardInsert.jsp";
	 * 
	 * } // insertForm
	 */	
	
	// 3-2. 게시판 글쓰기
	@ResponseBody
	@RequestMapping(value="/board/insert.do", method = RequestMethod.POST)
	public String insert(BoardDTO board, HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("board.controller.insert() invoked.");
		JSONObject jsonResult = new JSONObject();
		boolean status = service.boardInsert(board);
		
		jsonResult.put("status", status);
		jsonResult.put("message", status ? "글이 등록되었습니다" : "오류가 발생하였습니다. 다시 시도해주세요.");
		
		return jsonResult.toString();
	
	} // insert

	
//	게시판 글 삭제 =====================================================================================

	// 4-1. 게시판 글 삭제
	@ResponseBody
	@RequestMapping(value="/board/delete.do", method = RequestMethod.POST)
	public String delete(BoardDTO board, HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("board.controller.delete() invoked.");
		JSONObject jsonResult = new JSONObject();
		boolean status = service.boardDelete(board);
		
		jsonResult.put("status", status);
		jsonResult.put("message", status ? "글이 삭제되었습니다" : "오류가 발생하였습니다. 다시 시도해주세요.");
		
		return jsonResult.toString();
		
	} // delete
	
	
	// 4-2. 체크박스 글 삭제
	public String deleteBoards(String[] boardids, HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("board.controller.deleteBoards() invoked.");
		JSONObject jsonResult = new JSONObject();
		boolean status = service.boardsDelete(boardids);
		
		jsonResult.put("status", status);
		jsonResult.put("message", status ? "글이 삭제되었습니다" : "오류가 발생하였습니다. 다시 시도해주세요.");
		
		return jsonResult.toString();
	
	}

	
//	게시판 글 수정 =====================================================================================
	
	// 5. 게시판 글 수정 페이지
	/*
	 * public String updateForm(BoardDTO board, HttpServletRequest req,
	 * HttpServletResponse res) throws Exception {
	 * System.out.println("board.controller.updateForm() invoked.");
	 * 
	 * return "board/boardUpdate.jsp";
	 * 
	 * } // updateForm
	 */	
	
	// 5-1. 게시판 글 수정
	
	public String update(BoardDTO board, HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("board.controller.update() invoked.");
		
		JSONObject jsonResult = new JSONObject();
		boolean status = service.boardUpdate(board);
		
		jsonResult.put("status", status);
		jsonResult.put("message", status ? "글이 수정되었습니다." : "오류가 발생하였습니다. 다시 시도해주세요.");
		
		return jsonResult.toString();
		
	} // update

	
}
