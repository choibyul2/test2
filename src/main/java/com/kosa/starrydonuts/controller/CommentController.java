package com.kosa.starrydonuts.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kosa.starrydonuts.domain.CommentDTO;
import com.kosa.starrydonuts.service.CommentService;

@Controller
public class CommentController {

   @Autowired
   private CommentService service;
   
   
   //1. ��� �ۼ��ϱ�
   @ResponseBody
   @RequestMapping("/comment/register.do")
   public Map<String, Object> register(@RequestBody CommentDTO comment) throws Exception {
      System.out.println("comment.controller.register() invoked.");
      
      Map<String, Object> result = new HashMap<>();
      boolean status = service.commentInsert(comment);
      
      if(status) {      
         result.put("status", true);
         result.put("message", "����� ��ϵǾ����ϴ�.");
      }else {
         result.put("status", false);
         result.put("message", "����� ��ϵ��� �ʾҽ��ϴ�.");   
      }
      
      System.out.println("status : "+status);
      
      return result;
      
   } //register
   
   
   //2. ��� ��Ϻ���
   @ResponseBody
   @RequestMapping("/comment/list.do")
   public Map<String, Object> list(@RequestBody CommentDTO comment) throws Exception {
      System.out.println("comment.controller.list() invoked.");
      
      Map<String, Object> result = new HashMap<>();
      boolean status = service.commentList(comment) != null;
      
      if(status) {      
         result.put("status", true);
         result.put("message", "����Ʈ ��µ�");
      }else {
         result.put("status", false);
         result.put("message", "����Ʈ ��¾ȵ�");   
      }
      
      System.out.println("status : "+status);
      
      return result;
   
   } //list
   
   
   //3. ��� �����ϱ�
   @ResponseBody
   @RequestMapping("/comment/modify.do")
   public Map<String, Object> modify(@RequestBody CommentDTO comment) throws Exception {
      System.out.println("comment.controller.modify() invoked.");
      
      Map<String, Object> result = new HashMap<>();
      boolean status = service.commentUpdate(comment);
      
      if(status) {      
         result.put("status", true);
         result.put("message", "����� �����Ǿ����ϴ�.");
      }else {
         result.put("status", false);
         result.put("message", "����� �������� �ʾҽ��ϴ�.");   
      }
      
      System.out.println("status : "+status);
      
      return result;
   
   } //modify
   
   //4. ��� �����ϱ�
   @ResponseBody
   @RequestMapping("/comment/remove.do")
   public Map<String, Object> remove(@RequestBody CommentDTO comment) throws Exception {
      System.out.println("comment.controller.remove() invoked.");
      
      Map<String, Object> result = new HashMap<>();
      boolean status = service.commentDelete(comment);
      
      if(status) {      
         result.put("status", true);
         result.put("message", "����� �����Ǿ����ϴ�.");
      }else {
         result.put("status", false);
         result.put("message", "����� �������� �ʾҽ��ϴ�.");   
      }
      
      System.out.println("status : "+status);
      
      return result;
   
   } //remove
   
} // end class