package com.kosa.starrydonuts.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.starrydonuts.dao.MemberDAO;
import com.kosa.starrydonuts.domain.MemberDTO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	//1. ȸ������
	public JSONObject memberInsert(MemberDTO member) {
		System.out.println("service.memberInsert() ȸ������ ���� ����");
		
		JSONObject jsonResult = new JSONObject();
		if (memberDAO.memberInsert(member) == true) {
			jsonResult.put("status", true);
		} else {
			jsonResult.put("status", false);

		}
		return jsonResult;
	}
	
	
	//1-2. ���̵� �ߺ� �˻�
	public boolean isExistUId(MemberDTO member) throws Exception {
		  System.out.println("service.isExistUId() ���̵� �ߺ� Ȯ�� ���� ����");
	    
	      return memberDAO.isExistUid(member);
	}
	
		
	//2. �α���
	public JSONObject memberLogin(MemberDTO member, HttpSession session) {
		  System.out.println("service.memberLogin() �α��� ���� ����");
		  
		  JSONObject jsonResult = new JSONObject();
		  MemberDTO loginMember = memberDAO.memberLogin(member);
		  if (loginMember != null) {
				session.setAttribute("loginMember", loginMember);
				jsonResult.put("loginMember", loginMember);
				jsonResult.put("status", true);
				
				System.out.println("�α��� ����~~! service");
		  } else {
				System.out.println("�α��� ����!");
				jsonResult.put("status", false);

		  }
		  
		
	      return jsonResult;
	}
	

	//3. ȸ�� ��ü��ȸ
	public List<MemberDTO> memberList() throws Exception {
		  System.out.println("service.memberList() ȸ�� ��ü ��ȸ ���� ����");
		  
	      return memberDAO.memberList();
	}
	
	
	//4. ����ȸ
	public MemberDTO memberGet(String id) throws Exception {
		  System.out.println("service.memberGet() ȸ�� �� ��ȸ ���� ����");
		  
		  return memberDAO.memberGet(id);
	}
	
	
	//5. ȸ������
	public JSONObject memberUpdate(MemberDTO member) throws Exception {
		  System.out.println("service.memberUpdate() ȸ�� ���� ���� ����");
		 
		  JSONObject jsonResult = new JSONObject();
		  
			if (memberDAO.memberUpdate(member) == true) {
				jsonResult.put("status", true);
			} else {
				jsonResult.put("status", false);
			}

	      return jsonResult;
	}
	
	
	//6. ȸ��Ż��
	public JSONObject memberDelete(MemberDTO member) throws Exception {
		  System.out.println("service.memberDelete() ȸ�� Ż�� ���� ����");
		 
		  JSONObject jsonResult = new JSONObject();
		  
			if (memberDAO.memberDelete(member) == true) {
				jsonResult.put("status", true);
			} else {
				jsonResult.put("status", false);
			}

	      return jsonResult;
	}
	
	
	//7. ���̵�ã��
	public MemberDTO memberFindId(MemberDTO member) throws Exception {
		  System.out.println("service.memberFindId() ���̵� ã�� ���� ����");

	      return memberDAO.memberFindId(member);
	}
	
	
	//8. ��й�ȣã��
	public MemberDTO memberFindPwd(MemberDTO member) throws Exception {
		  System.out.println("service.memberFindPwd() ��й�ȣ ã�� ���� ����");

	      return memberDAO.memberFindPwd(member);
	}
	
	
} // end class
