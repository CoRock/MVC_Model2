package net.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MemberFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());

		ActionForward forward = null;
		Action action = null;
		   
		System.out.println(command);
		if (command == null || command.equals("/")) {

			forward = new ActionForward();
			
			forward.setRedirect(true);				// 1. 페이지 넘기는 방식 설정
			forward.setPath("./MemberLogin.me");	// 2. 페이지를 어디로 넘길 지 경로 설정

		} else if (command.equals("/MemberLogin.me")) {		// 처음 로그인 화면 맵핑
			
			forward = new ActionForward();			
			forward.setRedirect(false);
			forward.setPath("./member/loginForm.jsp");
			
		} else if (command.equals("/MemberJoin.me")) {		// 회원가입 버튼 눌렀을 시 맵핑
			
			forward = new ActionForward();			
			forward.setRedirect(false);
			forward.setPath("./member/joinForm.jsp");
			
		} else if (command.equals("/MemberJoinAction.me")) {	// 회원가입 신청 시 액션 클래스 맵핑
			
			// sendRedirect 방식으로 보내겠다
			action  = new MemberJoinAction();
			
			try { forward = action.execute(request, response); }
			catch (Exception e) { e.printStackTrace(); }
			
		} else if (command.equals("/MemberLoginAction.me")) {
			action = new MemberLoginAction();
			
			try { forward = action.execute(request, response); }
			catch (Exception e) { e.printStackTrace(); }
		}
	
		
		
		/*else if (command.equals("/BoardReplyAction.bo")) {
			action = new BoardReplyView();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BoardDelete.bo")) { // 3
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./board/qna_board_delete.jsp");
		}else if(command.equals("/BoardModify.bo")){
			   action = new BoardModifyView();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
	 	   }else if(command.equals("/BoardAddAction.bo")){
			   action  = new BoardAddAction();//sendRedirect 방식으로 보내겠다
			   try {
				   forward=action.execute(request, response);
			   } catch (Exception e) {
				   e.printStackTrace();
			   }
		   }else if(command.equals("/BoardReplyView.bo")){
			   action = new BoardReplyAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/BoardModifyAction.bo")){
			   action = new BoardModifyAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/BoardDeleteAction.bo")){
			   action = new BoardDeleteAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/BoardList.bo")){
			   action = new BoardListAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/BoardDetailAction.bo")){
			   action = new BoardDetailAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }*/
		   // 경로, DB 사용 유무 결정
		   /*********************************************************/
		   // 뷰를 어떤 방식으로 뿌려줄 건지 결정
		   
		   if (forward.isRedirect()){
			   response.sendRedirect(forward.getPath());
		   } else { 
			   RequestDispatcher dispatcher=
				   request.getRequestDispatcher(forward.getPath());
			   dispatcher.forward(request, response);
		   }
	 }
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		doProcess(request,response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		doProcess(request,response);
	}   	  	    
}