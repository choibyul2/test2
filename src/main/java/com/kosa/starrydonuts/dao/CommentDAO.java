package com.kosa.starrydonuts.dao;

import java.util.List;

import com.kosa.starrydonuts.domain.CommentDTO;

public interface CommentDAO {

	  //1. ��� �ۼ��ϱ�
	  public boolean commentInsert(CommentDTO comment) throws Exception;
	  
	  //2. ��� ���
	  public List<CommentDTO> commentList(CommentDTO comment) throws Exception;
	  
	  //3. ��� �����ϱ�
	  public boolean commentUpdate(CommentDTO comment) throws Exception;
	  
	  //4. ��� �����ϱ�
	  public boolean commentDelete(CommentDTO comment) throws Exception;

}
