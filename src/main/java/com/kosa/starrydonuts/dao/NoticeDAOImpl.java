package com.kosa.starrydonuts.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosa.starrydonuts.domain.NoticeDTO;

@Repository("NoticeDAO")
public class NoticeDAOImpl implements NoticeDAO {

	@Autowired
	private SqlSession sqlSession;

	//1. �������� ���
	@Override
	public List<NoticeDTO> noticeList() throws Exception {
		System.out.println("dao.noticeDAOImpl.noticeList() �������� ��� ȣ��");

		return sqlSession.selectList("mapper.notice.noticeList");
	}

	
	//2. �������� �󼼺���
	@Override
	public NoticeDTO noticeGet(int noticeid) throws Exception {
		System.out.println("dao.noticeDAOImpl.noticeGet() �������� �󼼺��� ȣ��");
		
		return sqlSession.selectOne("mapper.notice.noticeGet", noticeid);
	}

	
	//3. �������� �۾���
	@Override
	public boolean noticeInsert(NoticeDTO notice) throws Exception {
		System.out.println("dao.noticeDAOImpl.noticeInsert() �������� ��� ȣ��");
		
		return  0 != sqlSession.insert("mapper.notice.noticeInsert", notice);
	}

	
	//4. �������� �����ϱ�
	@Override
	public boolean noticeUpdate(NoticeDTO notice) throws Exception {
		System.out.println("dao.noticeDAOImpl.noticeUpdate() �������� ���� ȣ��");
		
		return  0 != sqlSession.update("mapper.notice.noticeUpdate", notice);
	}

	
	//5. �������� �����ϱ�
	@Override
	public boolean noticeDelete(NoticeDTO notice) throws Exception {
		System.out.println("dao.noticeDAOImpl.noticeDelete() �������� ���� ȣ��");
		int result = sqlSession.delete("mapper.notice.noticeDelete", notice);
		System.out.println("noticeid -> " + notice.getNoticeid());
		System.out.println("������� : " + result);
		
		return result != 0 ;
	}

	
	//6. ���ο� TOP5 ����ϱ�
	@Override
	public List<NoticeDTO> noticeTop5() throws Exception {
		System.out.println("dao.noticeDAOImpl.noticeTop5() �������� TOP5 ȣ��");
		
		return sqlSession.selectList("mapper.notice.noticeTop5");
	}

	
	//7. ��ȸ�� ����
	@Override
	public int viewCount(int noticeid) throws Exception {
		System.out.println("dao.noticeDAOImpl.viewCount() �������� ��ȸ�� ���� ȣ��");
		
		return sqlSession.update("mapper.notice.viewCount", noticeid);
	}

	
	//8. üũ�ڽ��� �Խñ� ����
	@Override
	public boolean noticesDelete(NoticeDTO notice) throws Exception {
		System.out.println("dao.noticeDAOImpl.noticesDelete() �������� üũ�ڽ� �ߺ� ���� ȣ��");
		
		return  0 != sqlSession.update("mapper.notice.noticesDelete", notice);
	}

	
	//9. [����¡]�˻��� ��ü �Ǽ� ��´�
	@Override
	public int getTotalCount(NoticeDTO notice) throws Exception {
		System.out.println("dao.noticeDAOImpl.getTotalCount() �Խñ� �� ���� ȣ��");
		
		Map<String, Object> map = new HashMap<>();
		map.put("searchTitle",notice.getSearchTitle());
		
		return sqlSession.selectOne("mapper.notice.getTotalCount", map);
	}


	//10. ����¡ ���
	@Override
	public List<NoticeDTO> noticePagingList(NoticeDTO notice) throws Exception {
		System.out.println("dao.noticeDAOImpl.noticePagingList() �������� ���(����¡) ȣ��");
		Map<String, Object> map = new HashMap<>();
		map.put("noticeid", notice.getNoticeid());
		map.put("startNo",notice.getStartNo());
		map.put("endNo", notice.getEndNo());
		map.put("searchTitle",notice.getSearchTitle());
		List<NoticeDTO> notice2 = sqlSession.selectList("mapper.notice.noticePagingList", map);
		
		System.out.println("notice2 : " + notice2); 
		return notice2;
	}

	
	//10. �Խñ� ���� �� �ٽ� 10������ ������ִ� �޼���
	@Override
	public List<NoticeDTO> noticeListBoforeN(NoticeDTO notice, int length) throws Exception {
		System.out.println("dao.noticeDAOImpl.noticeListBoforeN() �������� ���(10�� �޼���) ȣ��");
		
		return sqlSession.selectList("mapper.notice.noticeListBoforeN");
	}



} // end class
