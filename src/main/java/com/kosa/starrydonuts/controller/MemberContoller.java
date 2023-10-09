package com.kosa.starrydonuts.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kosa.starrydonuts.domain.MemberDTO;
import com.kosa.starrydonuts.service.MemberService;

@Controller
public class MemberContoller {

	@Autowired
	private MemberService memberService;
	
//	ȸ������ =====================================================================================

	
	// ȸ������
	@ResponseBody
	@RequestMapping(value="/member/join.do", method = RequestMethod.POST)
	public String join(@RequestBody MemberDTO member, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		System.out.println("controller.insert() invoked.");
		System.out.println(member);
		
		JSONObject jsonResult = memberService.memberInsert(member);

		return jsonResult.toString();
	} // join
	
	
	// ���̵� �ߺ�Ȯ��
	public String isExistUId(MemberDTO member, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		System.out.println("isExistUId() invoked.");

		JSONObject jsonResult = new JSONObject();
		if(memberService.isExistUId(member)) {
			jsonResult.put("status", true);
			jsonResult.put("message", "���̵� ��� �Ұ��� �մϴ�");
		} else {
			jsonResult.put("status", false);
			jsonResult.put("message", "���̵� ��밡���մϴ�");
		}
		
		return jsonResult.toString();
	} // isExistUId
	
	
//	�α��� & �α׾ƿ� =====================================================================================
	

	// �α���
	@ResponseBody
	@RequestMapping(value="/member/login.do", method = RequestMethod.POST)
	public String login(@RequestBody MemberDTO member, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		HttpSession session = request.getSession();
		System.out.println("controller.member.controller.login() invoked.");
		
		JSONObject member2 = memberService.memberLogin(member, session);
		session.setAttribute("loginMember", member2.get("loginMember"));
		
		System.out.println("controller.session : " + session.getAttribute("loginMember"));
		System.out.println("controller.member2 : " + member2);
		
		
		return member2.toString();
	} // login
	
	
	// �α׾ƿ�
	@RequestMapping(value="/member/logout.do", method = RequestMethod.POST)
	public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		System.out.println("logout() invoked.");

		session.invalidate();
		System.out.println("logout2() invoked. ����");
	} // logout
	

//	���̵� & ��й�ȣ ã�� =====================================================================================
	

	// ���̵� ã��
	@ResponseBody
	@RequestMapping(value="/member/idFind.do", method = RequestMethod.POST)
	public Map<String, Object> idFind (@RequestBody MemberDTO member) throws Exception {
		
		Map<String, Object> result = new HashMap<>();
		
		MemberDTO findId = memberService.memberFindId(member);
		
		if(findId != null) {
			String id = findId.getId();			
			result.put("status", true);
			result.put("message", "���̵� ã�ҽ��ϴ�. \n ȸ������ ���̵�� '" + id + "'�Դϴ�.");
		}else {
			result.put("status", false);
			result.put("message", "�̸� �Ǵ� ��ȭ��ȣ�� �߸� �Է��߽��ϴ�.");	
		}
		 
		return result;
	} // idFind
		

	// ��й�ȣ ã��
	@ResponseBody
	@RequestMapping(value="/member/pwdFind.do", method = RequestMethod.POST)
	public Map<String, Object> pwdFind (@RequestBody MemberDTO member) throws Exception {
		System.out.println("controller.pwdFind() invoked.");
		
		Map<String, Object> result = new HashMap<>();
		
		MemberDTO findPwd = memberService.memberFindPwd(member);
		
		if (findPwd != null) {
			String pwd = findPwd.getPwd();
			result.put("status", true);
			result.put("message", "��й�ȣ�� ã�ҽ��ϴ�. \n ȸ������ ���̵�� '" + pwd + "'�Դϴ�.");
		} else {
			result.put("status", false);
			result.put("message", "��й�ȣ ã�� ����");
		}

		return result;
	} // pwdFind
	

//	ȸ������ =====================================================================================
	
	
	// ȸ�� ��ü��� â
	public String list (HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("list() invoked.");
		
		try { 
			request.setAttribute("member", memberService.memberList());
        } catch (Exception e) { 
        	e.printStackTrace();
        }
		
		System.out.println(memberService.memberList());
		return "member/memberList.jsp";
	} // list

	
	// ȸ�� ����
	@ResponseBody
	@RequestMapping(value="/member/update.do", method = RequestMethod.POST)
	public String update (@RequestBody MemberDTO member, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("controller.update() invoked.");

		JSONObject jsonResult = memberService.memberUpdate(member);
		HttpSession session = request.getSession();
		System.out.println("controller member : "+ member);
		session.setAttribute("loginMember", member);
		
		return jsonResult.toString();
	} // update
	

	// ȸ�� Ż��
	@ResponseBody
	@RequestMapping(value="/member/delete.do", method = RequestMethod.POST)
	public String delete (@RequestBody MemberDTO member, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("controller.delete() invoked.");
		System.out.println("controller.member : " + member);
		
		HttpSession session = request.getSession();
		JSONObject jsonResult = memberService.memberDelete(member);
		session.invalidate();
		
		return jsonResult.toString();
	} // delete
	
} // end class
