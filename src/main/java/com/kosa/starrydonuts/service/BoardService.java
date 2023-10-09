package com.kosa.starrydonuts.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.starrydonuts.dao.BoardDAO;
import com.kosa.starrydonuts.dao.CommentDAO;
import com.kosa.starrydonuts.domain.BoardDTO;
import com.kosa.starrydonuts.domain.CommentDTO;
import com.kosa.starrydonuts.domain.NoticeDTO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	@Autowired
	private CommentDAO commentDAO;
	
	//1. 게시판 목록
	public List<BoardDTO> boardList() throws Exception {
		System.out.println("service.boardList() invoked.");
		
		return boardDAO.boardList();
	}
	
	//2. 게시판 상세보기
	public BoardDTO boardGet(int boardid) throws Exception {
		System.out.println("service.boardGet() invoked.");
//		Map<String, Object> result = new HashMap<>();
		
		// 조회수 증가
		boardDAO.viewCount(boardid);
		
		// 게시판 상세보기
//		BoardDTO boardDTO = boardDAO.boardGet(boardid);
		
		// 댓글 출력하기
//		List<CommentDTO> commentList = commentDAO.commentList(comment);
//		
//		result.put("board", boardDTO);
//		result.put("comment", commentList);
		
		return boardDAO.boardGet(boardid);
	}
	
	
	//3. 게시판 글쓰기
	public boolean boardInsert(BoardDTO board) throws Exception {
		System.out.println("service.boardInsert() invoked.");
		
		return boardDAO.boardInsert(board);
	} 
	
	
	//4. 게시판 수정하기
	public boolean boardUpdate(BoardDTO board) throws Exception {
		System.out.println("service.boardUpdate() invoked.");
		
		return boardDAO.boardUpdate(board);
	}

	
	//5. 게시판 삭제하기
	public boolean boardDelete(BoardDTO board) throws Exception {
		System.out.println("service.boardDelete() invoked.");
		
		return boardDAO.boardDelete(board);
	}
	
	
	//6. 메인에 TOP5 출력하기
	public List<BoardDTO> boardTop5() throws Exception {
		System.out.println("service.boardTop5() invoked.");

		return boardDAO.boardTop5();
	}
	
	
	//7. 조회수 증가
	public int viewCount(int boardid) throws Exception {
		System.out.println("service.viewCount() invoked.");
		
		return boardDAO.viewCount(boardid);
	}
	

	//8. 체크박스 게시글 삭제하기
	public boolean boardsDelete(String[] boardids) throws Exception {
		System.out.println("service.boardsDelete() invoked.");
		System.out.println("boardIds.toString() : " + Arrays.toString(boardids));
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("list", boardids);
		return 0 != boardDAO.boardsDelete(params);
	} // deleteBoards
	
	
	//9. 더보기 출력하기
//	public List<BoardDTO> boardList2(BoardDTO board) throws Exception {
//		System.out.println("board.service.getBoardList2() 함수 호출됨 -> " + board);
//		
//		return boardDAO.boardList2(board);
//	} // getBoardList2
	
	
	
	//10. 게시판 페이징 목록(파라미터값 notice임!)
	public Map<String, Object> noticePageList(BoardDTO board) throws Exception {
		System.out.println("notice.service.getNoticeList() 페이징 목록 함수 호출됨");

		//1. 전체 건수를 얻는다
		board.setTotalCount(boardDAO.getTotalCount(board));
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("board", board);
		result.put("list", boardDAO.boardPagingList(board));
		
		return result;
		
	} // getNoticeList
	
	
	//10. 게시글 10개씩 돌아오게하는 메서드
	public List<BoardDTO> boardListBoforeN(BoardDTO board) throws Exception {
		System.out.println("service.boardListBoforeN() invoked.");
		
		return boardDAO.boardListBoforeN(board);
	}

	
	//11. 답글 추가하기
	public int reply(BoardDTO board) {
		System.out.println("service.reply() invoked.");
		
		return boardDAO.reply(board);
	}


}
