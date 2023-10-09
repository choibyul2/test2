package com.kosa.starrydonuts.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
	
	private String id;			// ���̵�
	private String pwd;			// ��й�ȣ
	private String uname;		// �̸�
	private String birth;		// ����
	private String gender;		// ����
	private String phone;		// �ڵ�����ȣ
	private String email;		// �̸���
	
	
	// �α��� - ��й�ȣ ��ġ����
	public boolean isEqualsPwd(MemberDTO member) {
		return pwd.equals(member.getPwd());
	}

}