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

	
	//1. 댓글 작성하기
	@Override
	public boolean commentInsert(CommentDTO comment) throws Exception {
	  int success = sqlSession.insert("mapper.comment.commentInsert", comment);
      
      System.out.println("dao.CommentDAOImpl.commentInsert() invoked. starrydonuts");
      System.out.println("댓글작성 성공여부 : " + success);
      
      return success == 1;
	}

	//2. 댓글 목록
	@Override
	public List<CommentDTO> commentList(CommentDTO comment) throws Exception {
      List<CommentDTO> list = sqlSession.selectList("mapper.comment.commentList", comment);
      System.out.println("댓글목록 : " + list);
      
      return list;
	}

	@Override
	public boolean commentUpdate(CommentDTO comment) throws Exception {
	  int success = sqlSession.update("mapper.comment.commentUpdate", comment);
      
      System.out.println("dao.CommentDAOImpl.commentUpdate() invoked. starrydonuts");
      System.out.println("댓글수정 성공여부 : " + success);
      
      return success == 1;
	}

	@Override
	public boolean commentDelete(CommentDTO comment) throws Exception {
	  int success = sqlSession.delete("mapper.comment.commentDelete", comment);
	      
	  System.out.println("dao.CommentDAOImpl.commentDelete() invoked. starrydonuts");
	  System.out.println("댓글삭제 성공여부 : " + success);
	      
	  return success == 1;
	}

}
