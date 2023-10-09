package com.kosa.starrydonuts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.starrydonuts.dao.CommentDAO;
import com.kosa.starrydonuts.domain.CommentDTO;

@Service
public class CommentService {

   @Autowired
   private CommentDAO commentDAO;
   
   //1. ��� �ۼ��ϱ�
   public boolean commentInsert(CommentDTO comment) throws Exception {
      System.out.println("service.commentInsert invoked(). ����ۼ�");
      boolean success = commentDAO.commentInsert(comment);
      System.out.println("���� ��� ��Ͽ��� : " + success);
      
      return success;
   
   } //commentInsert
   
   
   //2. ��� ���
   public List<CommentDTO> commentList(CommentDTO comment) throws Exception {
      System.out.println("service.commentList invoked(). ����ۼ�");
      List<CommentDTO> list = commentDAO.commentList(comment);
      System.out.println("���� ��� ��� : " + list);
      
      return list;
   
   } //commentList
   
   
   //3. ��� �����ϱ�
   public boolean commentUpdate(CommentDTO comment) throws Exception {
      System.out.println("service.commentUpdate invoked(). ����ۼ�");
      boolean success = commentDAO.commentUpdate(comment);
      System.out.println("���� ��� �������� : " + success);
      
      return success;
      
   } //commentUpdate
   
   
   //4. ��� �����ϱ�
   public boolean commentDelete(CommentDTO comment) throws Exception {
      System.out.println("service.commentDelete invoked(). ����ۼ�");
      boolean success = commentDAO.commentDelete(comment);
      System.out.println("���� ��� �������� : " + success);
      
      return success;
      
   } //commentDelete
   
   
}