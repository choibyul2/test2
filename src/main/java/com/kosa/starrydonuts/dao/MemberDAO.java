package com.kosa.starrydonuts.dao;

import java.util.List;

import com.kosa.starrydonuts.domain.MemberDTO;

public interface MemberDAO {
	
	//1. ȸ������
	public boolean memberInsert(MemberDTO member);
	
	//1-2. ���̵� �ߺ� �˻�
	public boolean isExistUid(MemberDTO member);
		
	//2. �α���
	public MemberDTO memberLogin(MemberDTO member);
	
	//3. ȸ�� ��ü��ȸ 
	public List<MemberDTO> memberList();
	
	//4. ����ȸ
	public MemberDTO memberGet(String id);
	
	//5. ȸ������
	public boolean memberUpdate(MemberDTO member);
	
	//6. ȸ��Ż��
	public boolean memberDelete(MemberDTO member);
	
	//7. ���̵�ã��
	public MemberDTO memberFindId(MemberDTO member);
	
	//8. ��й�ȣã��
	public MemberDTO memberFindPwd(MemberDTO member);



	
} // end class
