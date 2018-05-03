package net.member.action;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberLoginAction implements Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberDAO memDao = new MemberDAO();
		MemberBean memBean = new MemberBean();
		ActionForward forward = new ActionForward();
   		
/*		HttpSession session = null;*/
		
		boolean result = false;
   		
   		try {
   			
   			request.setCharacterEncoding("UTF-8");
   			
   			String requestID = request.getParameter("REQUEST_ID");
   			String requestPW = request.getParameter("REQUEST_PW");
   			
   			memBean.setMEMBER_ID(requestID);
   			memBean.setMEMBER_PW(requestPW);

	   		result = memDao.memberVerify(memBean);
	   		
			if (result == false) {
				System.out.println("ID or PW 불일치");
				
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('login fail!');");
				script.println("location.href='./MemberLogin.me'");
				script.println("</script>");
				return null;
				/*forward.setRedirect(true);
				forward.setPath("./MemberLogin.me");
				
				return forward;*/
			}
			System.out.println("로그인 성공!");

			// 세션에 로그인 정보를 담는다.
			request.getSession().setAttribute("successID", requestID);
			
			forward.setRedirect(true);
			forward.setPath("./BoardList.bo");
						
			return forward;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}  	
}