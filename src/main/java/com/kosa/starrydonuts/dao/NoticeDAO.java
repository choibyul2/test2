package com.kosa.starrydonuts.dao;

import java.util.List;

import com.kosa.starrydonuts.domain.NoticeDTO;

public interface NoticeDAO {

	//1. �������� ���
	public List<NoticeDTO> noticeList() throws Exception;
	
	//2. �������� �󼼺���
	public NoticeDTO noticeGet(int noticeid) throws Exception;
	
	//3. �������� �۾���
	public boolean noticeInsert(NoticeDTO notice) throws Exception; 
	
	//4. �������� �����ϱ�
	public boolean noticeUpdate(NoticeDTO notice) throws Exception;

	//5. �������� �����ϱ�
	public boolean noticeDelete(NoticeDTO notice) throws Exception;
	
	//6. ���ο� TOP5 ����ϱ�
	public List<NoticeDTO> noticeTop5() throws Exception;
	
	//7. ��ȸ�� ����
	public int viewCount(int noticeid) throws Exception;
	
	//8. üũ�ڽ��� �Խñ� ����
	public boolean noticesDelete(NoticeDTO notice) throws Exception;

	//9. [����¡]�˻��� ��ü �Ǽ� ��´�
	//	 �������� �� ����
	public int getTotalCount(NoticeDTO notice) throws Exception;
	// 	 �������� ���(�Ķ���Ͱ� notice��!)
	public List<NoticeDTO> noticePagingList(NoticeDTO notice) throws Exception ;
	
	//10. �Խñ� ���� �� �ٽ� 10������ ������ִ� �޼���
	public List<NoticeDTO> noticeListBoforeN(NoticeDTO notice, int length) throws Exception;

	
} // end class
