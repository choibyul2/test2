package com.kosa.starrydonuts.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosa.starrydonuts.domain.CommentDTO;

@Repository("commentDAO")
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	private SqlSession sqlSession;

	
	//1. ��� �ۼ��ϱ�
	@Override
	public boolean commentInsert(CommentDTO comment) throws Exception {
	  int success = sqlSession.insert("mapper.comment.commentInsert", comment);
      
      System.out.println("dao.CommentDAOImpl.commentInsert() invoked. starrydonuts");
      System.out.println("����ۼ� �������� : " + success);
      
      return success == 1;
	}

	//2. ��� ���
	@Override
	public List<CommentDTO> commentList(CommentDTO comment) throws Exception {
      List<CommentDTO> list = sqlSession.selectList("mapper.comment.commentList", comment);
      System.out.println("��۸�� : " + list);
      
      return list;
	}

	@Override
	public boolean commentUpdate(CommentDTO comment) throws Exception {
	  int success = sqlSession.update("mapper.comment.commentUpdate", comment);
      
      System.out.println("dao.CommentDAOImpl.commentUpdate() invoked. starrydonuts");
      System.out.println("��ۼ��� �������� : " + success);
      
      return success == 1;
	}

	@Override
	public boolean commentDelete(CommentDTO comment) throws Exception {
	  int success = sqlSession.delete("mapper.comment.commentDelete", comment);
	      
	  System.out.println("dao.CommentDAOImpl.commentDelete() invoked. starrydonuts");
	  System.out.println("��ۻ��� �������� : " + success);
	      
	  return success == 1;
	}

}
