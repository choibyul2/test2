package com.kosa.starrydonuts.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.starrydonuts.dao.NoticeDAO;
import com.kosa.starrydonuts.domain.NoticeDTO;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;


	
	//1. �������� ���
	public List<NoticeDTO> noticeList(NoticeDTO notice) throws Exception {
		System.out.println("service.noticeList() invoked.");
		
		//�Խñ� �� ����
		
		
		noticeDAO.getTotalCount(notice);
		
		return noticeDAO.noticeList();
	}
	
	
	//2. �������� �󼼺���
	public NoticeDTO noticeGet(int noticeid) throws Exception {
		System.out.println("service.noticeGet() invoked.");
		
		//��ȸ�� ����
		noticeDAO.viewCount(noticeid);

		return noticeDAO.noticeGet(noticeid);
	}
	
	
	//3. �������� �۾���
	public boolean noticeInsert(NoticeDTO notice) throws Exception {
		System.out.println("service.noticeInsert() invoked.");
		
		return noticeDAO.noticeInsert(notice);
	} 
	
	
	//4. �������� �����ϱ�
	public boolean noticeUpdate(NoticeDTO notice) throws Exception {
		System.out.println("service.noticeUpdate() invoked.");
		
		return noticeDAO.noticeUpdate(notice);
	}

	
	//5. �������� �����ϱ�
	public JSONObject noticeDelete(NoticeDTO notice) throws Exception {
		System.out.println("service.noticeDelete() invoked.");
		
		JSONObject jsonResult = new JSONObject();
		
		if (noticeDAO.noticeDelete(notice) == true) {
			jsonResult.put("status", true);
			jsonResult.put("message", "������");
			
		} else {
			jsonResult.put("status", false);
			jsonResult.put("message", "�����ȴ�");
		}
		
		return jsonResult;
	}
	
	
	//6. ���ο� TOP5 ����ϱ�
	public List<NoticeDTO> noticeTop5() throws Exception {
		System.out.println("service.noticeTop5() invoked.");
		
		return noticeDAO.noticeTop5();
	}
	
	
	//7. ��ȸ�� ����
	public int viewCount(int noticeid) throws Exception {
		System.out.println("service.viewCount() invoked.");
		
		return noticeDAO.viewCount(noticeid);
	}
	
	
	//8. üũ�ڽ��� �Խñ� ����
	public boolean noticesDelete(NoticeDTO notice) throws Exception {
		System.out.println("service.noticesDelete() invoked.");
		
		return noticeDAO.noticesDelete(notice);
	}

	
	//9. [����¡]�˻��� ��ü �Ǽ� ��´�
	//	 �������� �� ����
	/*
	 * public int getTotalCount(NoticeDTO notice) throws Exception {
	 * System.out.println("service.noticesDelete() invoked.");
	 * 
	 * return noticeDAO.getTotalCount(notice); }
	 */
	
	// 	 �������� ���(�Ķ���Ͱ� notice��!)
	public Map<String, Object> noticePageList(NoticeDTO notice) throws Exception {
		System.out.println("notice.service.getNoticeList() ����¡ ��� �Լ� ȣ���");

		//1. ��ü �Ǽ��� ��´�
		notice.setTotalCount(noticeDAO.getTotalCount(notice));
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("notice", notice);
		result.put("list", noticeDAO.noticePagingList(notice));
		
		return result;
		
	} // getNoticeList
	
	
	//10. �Խñ� ���� �� �ٽ� 10������ ������ִ� �޼���
	public List<NoticeDTO> noticeListBoforeN(NoticeDTO notice, int length) throws Exception {
		System.out.println("service.noticeListBoforeN() invoked.");
		
		return noticeDAO.noticeListBoforeN(notice, length);
	}
	



}
