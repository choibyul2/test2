package com.kosa.starrydonuts.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosa.starrydonuts.domain.BoardDTO;
import com.kosa.starrydonuts.domain.NoticeDTO;


@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private  SqlSession sqlSession;

	//1. �Խ��� ���
	@Override
	public List<BoardDTO> boardList() throws Exception {
		System.out.println("dao.boardDAOImpl.boardList() �Խ��� ��� ȣ��");
		
		return sqlSession.selectList("mapper.board.boardList");
	}

	
	//2. �Խ��� �󼼺���
	@Override
	public BoardDTO boardGet(int boardid) throws Exception {
		System.out.println("dao.boardDAOImpl.boardGet() �Խ��� ��� ȣ��");
		
		return sqlSession.selectOne("mapper.board.boardGet", boardid);
	}

	
	//3. �Խ��� �۾���
	@Override
	public boolean boardInsert(BoardDTO board) throws Exception {
		System.out.println("dao.boardDAOImpl.boardInsert() �Խ��� ��� ȣ��");
		
		return 0 != sqlSession.insert("mapper.board.boardInsert", board);
	}

	
	//4. �Խ��� �����ϱ�
	@Override
	public boolean boardUpdate(BoardDTO board) throws Exception {
		System.out.println("dao.boardDAOImpl.boardUpdate() �Խ��� ���� ȣ��");
		
		return 0 != sqlSession.update("mapper.board.boardUpdate", board);
	}

	
	//5. �Խ��� �����ϱ�
	@Override
	public boolean boardDelete(BoardDTO board) throws Exception {
		System.out.println("dao.boardDAOImpl.boardDelete() �Խ��� ���� ȣ��");
		
		return 0 != sqlSession.delete("mapper.board.boardDelete", board);
	}

	
	//6. ���ο� TOP5 ����ϱ�
	@Override
	public List<BoardDTO> boardTop5() throws Exception {
		System.out.println("dao.boardDAOImpl.boardTop5() �Խ��� TOP5 ȣ��");
		System.out.println(sqlSession.selectList("mapper.board.boardTop5"));
		return sqlSession.selectList("mapper.board.boardTop5");
	}

	
	//7. ��ȸ�� ����
	@Override
	public int viewCount(int boardid) throws Exception {
		System.out.println("dao.boardDAOImpl.viewCount() �Խ��� ��ȸ�� ���� ȣ��");
		
		return sqlSession.update("mapper.board.viewCount", boardid);
	}

	
	//8. üũ�ڽ��� �Խñ� ����
	/*
	 * ������ ��  �Խù����̵�� �迭�� �����Ͽ� list��� �̸����� ���� �Ѵ� 
	 */
	@Override
	public int boardsDelete(Map<String, Object> params) throws Exception {
		System.out.println("dao.boardDAOImpl.boardsDelete() �Խ��� üũ�ڽ� ȣ��");
		
		return sqlSession.delete("mapper.board.deleteBoards", params);
	}

	
//	//9. ������ �����
//	@Override
//	public List<BoardDTO> boardList2(BoardDTO board) throws Exception {
//		System.out.println("dao.boardDAOImpl.boardList2() �Խ��� ������ ��� ȣ��");
//		
//		return sqlSession.selectList("mapper.board.boardList2", board);
//	}

	
	//10. �Խñ� �����ص� �ٽ� �� 10���� ���̰� �ϴ� �޼���
	@Override
	public List<BoardDTO> boardListBoforeN(BoardDTO board) throws Exception {
		System.out.println("dao.boardDAOImpl.boardListBoforeN() �Խ��� ���(10�� �޼���) ȣ��");
		
		return sqlSession.selectList("mapper.board.boardListBoforeN", board);
	}

	
	//11. ��� �����
	@Override
	public int reply(BoardDTO board) {
		System.out.println("dao.boardDAOImpl.reply() �Խ��� ��� ȣ��");
		
		return sqlSession.insert("mapper.board.insertBoardReply", board);
	}


	@Override
	public int getTotalCount(BoardDTO board) throws Exception {
		System.out.println("dao.noticeDAOImpl.getTotalCount() �Խñ� �� ���� ȣ��");
		
		Map<String, Object> map = new HashMap<>();
		map.put("searchTitle",board.getSearchTitle());
		
		return sqlSession.selectOne("mapper.board.getTotalCount", map);
	}


	@Override
	public List<BoardDTO> boardPagingList(BoardDTO board) throws Exception {
		System.out.println("dao.noticeDAOImpl.boardPagingList() �Խ��� ���(����¡) ȣ��");
		Map<String, Object> map = new HashMap<>();
		map.put("boardid", board.getBoardid());
		map.put("startNo",board.getStartNo());
		map.put("endNo", board.getEndNo());
		map.put("searchTitle",board.getSearchTitle());
		List<BoardDTO> board2 = sqlSession.selectList("mapper.board.boardPagingList", map);
		
		System.out.println("board2 : " + board2); 
		return board2;
	}


} // end class