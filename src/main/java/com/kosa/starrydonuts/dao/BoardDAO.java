package com.kosa.starrydonuts.dao;

import java.util.List;
import java.util.Map;

import com.kosa.starrydonuts.domain.BoardDTO;
import com.kosa.starrydonuts.domain.NoticeDTO;

public interface BoardDAO {
	
	//1. �Խ��� ���
	public List<BoardDTO> boardList() throws Exception;
	
	//2. �Խ��� �󼼺���
	public BoardDTO boardGet(int boardId) throws Exception;
	
	//3. �Խ��� �۾���
	public boolean boardInsert(BoardDTO board) throws Exception; 
	
	//4. �Խ��� �����ϱ�
	public boolean boardUpdate(BoardDTO board) throws Exception;

	//5. �Խ��� �����ϱ�
	public boolean boardDelete(BoardDTO board) throws Exception;
	
	//6. ���ο� TOP5 ����ϱ�
	public List<BoardDTO> boardTop5() throws Exception;
	
	//7. ��ȸ�� ����
	public int viewCount(int boardid) throws Exception;
	
	//8. üũ�ڽ��� �Խñ� ����
	public int boardsDelete(Map<String, Object> params) throws Exception;
		
	//9. ������ �����
//	public List<BoardDTO> boardList2(BoardDTO board) throws Exception;
	
	//9. [����¡]�˻��� ��ü �Ǽ� ��´�
	//	 �������� �� ����
	public int getTotalCount(BoardDTO board) throws Exception;
	// 	 �������� ���(�Ķ���Ͱ� notice��!)
	public List<BoardDTO> boardPagingList(BoardDTO board) throws Exception ;
	
	
	//10. �Խñ� 10���� ���ƿ����ϴ� �޼���
	public List<BoardDTO> boardListBoforeN(BoardDTO board) throws Exception;

	//11. ��� �߰��ϱ�
	public int reply(BoardDTO board);

	
} // end class
