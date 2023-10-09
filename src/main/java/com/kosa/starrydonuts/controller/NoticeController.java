package com.kosa.starrydonuts.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.kosa.starrydonuts.domain.CommentDTO;
import com.kosa.starrydonuts.domain.NoticeDTO;
import com.kosa.starrydonuts.service.CommentService;
import com.kosa.starrydonuts.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	
//	��� & �� =====================================================================================
	
	
	// 1. �������� ��ü ��� ������
	@RequestMapping(value="/notice/list.do", method = RequestMethod.GET)
	  public List<NoticeDTO> list(NoticeDTO notice, HttpServletRequest req, HttpServletResponse res) throws Exception {
		  System.out.println("notice.controller.list() invoked. starrydonuts");
		  
		  List<NoticeDTO> list = noticeService.noticeList(notice);
		  req.setAttribute("list", list);
		  System.out.println("list : " +list);
	  
		  return list;
	  } // list
	 
	
	// 2. [����¡]�������� ��ü ��� ������
	@RequestMapping("/notice/list2.do")
	public String list2(NoticeDTO notice, HttpServletRequest req, HttpServletResponse res, String searchTitle) throws Exception {
    	System.out.println("notice.controller.list2() invoked.");
    	
    	Map<String, Object> plist = noticeService.noticePageList(notice);
		req.setAttribute("plist", plist);
		System.out.println("plist : " +plist);
		
		
		return "notice/list2";
	}
	
	
	// 3. �������� �� ������
	@ResponseBody
	@RequestMapping(value="/notice/detail.do", method = RequestMethod.POST)
	public Map<String, Object> detail(@RequestBody NoticeDTO notice,HttpServletRequest req, HttpServletResponse res) throws Exception {
    	System.out.println("notice.controller.detail() invoked.");
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	NoticeDTO detail = noticeService.noticeGet(notice.getNoticeid());
    	
    	map.put("detail", detail);
    	System.out.println("result : " +map);
    	return map;
    	
	} // detail
	

	
//	��� =====================================================================================
	

	
	// 4. �������� ���
	@ResponseBody
	@RequestMapping(value="/notice/insert.do", method = RequestMethod.POST)
	public String insert(@RequestBody NoticeDTO notice, HttpServletRequest req, HttpServletResponse res) throws Exception {
    	System.out.println("notice.controller.insert() invoked.");
    	
    	JSONObject result = new JSONObject();
    	boolean status = noticeService.noticeInsert(notice);
    	
    	
    	System.out.println("�������׵�� �������� : " + status);
    	
    	if(status == true) {
    		result.put("status", status);
    		result.put("message", "���������� ��ϵǾ����ϴ�.");
    	} else {
    		result.put("status", status);
    		result.put("message", "���������� ��ϵ��� �ʾҽ��ϴ�.");
    	}

    	System.out.println(result.toString());
		return result.toString();
	}
	

	
	
//	���� =====================================================================================
	
	
	// 5. �������� �� ����
	@ResponseBody
	@RequestMapping(value="/notice/delete.do", method = RequestMethod.POST)
	public String delete(@RequestBody NoticeDTO notice, HttpServletRequest req, HttpServletResponse res) throws Exception {
    	System.out.println("notice.controller.delete() invoked.");
    	System.out.println("jsp���� �Ѿ�� notice���� : " + notice);

    	JSONObject jsonResult = noticeService.noticeDelete(notice);
    	System.out.println("jsonResult : " + jsonResult);

		return jsonResult.toString();
	}
	
	// 6. �������� �� ���� ����
	@ResponseBody
	@RequestMapping(value="/notice/deletes.do", method = RequestMethod.POST)
	public String deletes(@RequestBody NoticeDTO notice, HttpServletRequest req, HttpServletResponse res) throws Exception {
    	System.out.println("notice.controller.deletes() ");
    	JSONObject jsonResult = new JSONObject();
    	boolean status = noticeService.noticesDelete(notice);
    	
    	jsonResult.put("status", status);
    	jsonResult.put("message", status ? "�������� �� ���� �Ǿ����ϴ�" : "�������� �� ������ ������ �߻��Ͽ����ϴ�");
    	if (status) {
        	jsonResult.put("noticeList", noticeService.noticesDelete(notice));
    	}
    	
    	
		return jsonResult.toString();
	} // deletes
	
	
//	���� =====================================================================================
	
	

	// 7. �������� ����
	@ResponseBody
	@RequestMapping(value="/notice/update.do", method = RequestMethod.POST)
	public String update(@RequestBody NoticeDTO notice, HttpServletRequest req, HttpServletResponse res) throws Exception {
    	System.out.println("notice.controller.update() invoked.");
    	
    	JSONObject result = new JSONObject();
    	
    	boolean status = noticeService.noticeUpdate(notice);
    	
    	result.put("status", status);
    	result.put("message", status ? "�������� ���� �����Ǿ����ϴ�" : "�������� �� ���� �� ������ �߻��Ͽ����ϴ�");
		
    	return result.toString();
	} // update

} // end class
