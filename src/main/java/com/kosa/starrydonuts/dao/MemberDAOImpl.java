package com.kosa.starrydonuts.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosa.starrydonuts.domain.MemberDTO;

@Repository("MemberDAO")
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSession sqlSession;

	
	//1. ȸ������
	@Override
	public boolean memberInsert(MemberDTO member) {
		int member1 = sqlSession.insert("mapper.member.memberInsert", member);
		
		System.out.println("dao.memberDAOImpl.memberInsert() invoked. starrydonuts");
		System.out.println("dao.memberDAOImpl.memberInsert.member1 : " + member1);
		
		return member1 == 1;
	}

	//1-2. ���̵� �ߺ� �˻�
	@Override
	public boolean isExistUid(MemberDTO member) {
		return sqlSession.selectOne("mapper.member.isExistUid", member);
	}	
	
	//2. �α���
	@Override
	public MemberDTO memberLogin(MemberDTO member) {
		MemberDTO member1 = sqlSession.selectOne("mapper.member.memberLogin", member);
		
		System.out.println("dao.memberDAOImpl.memberLogin() invoked. starrydonuts");
		System.out.println(member1);

		return member1;
		
//		System.out.println(member);
	}

	//3. ȸ�� ��ü��ȸ 
	@Override
	public List<MemberDTO> memberList() {
		return sqlSession.selectList("mapper.member.memberLogin");
	}

	//4. ����ȸ
	@Override
	public MemberDTO memberGet(String id) {
		return sqlSession.selectOne("mapper.member.memberLogin", id);
	}

	//5. ȸ������
	@Override
	public boolean memberUpdate(MemberDTO member) {
		
		int member1 = sqlSession.insert("mapper.member.memberUpdate", member);
		
		System.out.println("dao.memberDAOImpl.memberUpdate() invoked. starrydonuts");
		System.out.println("dao.memberDAOImpl.memberUpdate.member1 : " + member1);
		
		return member1 == 1;
	}

	//6. ȸ��Ż��
	@Override
	public boolean memberDelete(MemberDTO member) {
		int member1 = sqlSession.delete("mapper.member.memberDelete", member);
		
		System.out.println("dao.memberDAOImpl.memberDelete() invoked. starrydonuts");
		System.out.println("dao.memberDAOImpl.memberDelete.member1 : " + member1);
		
		return member1 == 1;
	}

	
	//7. ���̵�ã��
	@Override
	public MemberDTO memberFindId(MemberDTO member) {
		MemberDTO idFind = sqlSession.selectOne("mapper.member.memberFindId", member);
		System.out.println(idFind);
		
		return idFind;
	}

	//8. ��й�ȣã��
	@Override
	public MemberDTO memberFindPwd(MemberDTO member) {
		MemberDTO pwdFind = sqlSession.selectOne("mapper.member.memberFindPwd", member);
		System.out.println(pwdFind);
		
		return pwdFind;
	}

	
} // end class
