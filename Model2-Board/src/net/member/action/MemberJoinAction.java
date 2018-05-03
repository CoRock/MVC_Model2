package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberJoinAction implements Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberDAO memDao = new MemberDAO();
		MemberBean memBean = new MemberBean();
		ActionForward forward = new ActionForward();
   		
		boolean result = false;
   		
   		try{
   			request.setCharacterEncoding("UTF-8");
   			
   			memBean.setMEMBER_ID(request.getParameter("MEMBER_ID"));
   			memBean.setMEMBER_PW(request.getParameter("MEMBER_PW"));
   			memBean.setMEMBER_PW2(request.getParameter("MEMBER_PW2"));
   			memBean.setMEMBER_EAMIL(request.getParameter("MEMBER_EMAIL"));
   			memBean.setMEMBER_NAME(request.getParameter("MEMBER_NAME"));
   			memBean.setMEMBER_SSN(request.getParameter("MEMBER_SSN"));
   			memBean.setMEMBER_BIRTH(request.getParameter("MEMBER_BIRTH"));
   			memBean.setMEMBER_INTEREST(request.getParameter("MEMBER_INTEREST"));
   			memBean.setMEMBER_INTRO(request.getParameter("MEMBER_INTRO"));   		

	   		result = memDao.memberInsert(memBean);
	   		
			if (result == false) {
				System.out.println("회원 가입 실패!");
				return null;
			}
			System.out.println("회원 가입 완료!");

			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");
			
			return forward;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}  	
}