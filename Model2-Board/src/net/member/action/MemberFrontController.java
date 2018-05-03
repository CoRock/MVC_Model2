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
			
			forward.setRedirect(true);				// 1. ������ �ѱ�� ��� ����
			forward.setPath("./MemberLogin.me");	// 2. �������� ���� �ѱ� �� ��� ����

		} else if (command.equals("/MemberLogin.me")) {		// ó�� �α��� ȭ�� ����
			
			forward = new ActionForward();			
			forward.setRedirect(false);
			forward.setPath("./member/loginForm.jsp");
			
		} else if (command.equals("/MemberJoin.me")) {		// ȸ������ ��ư ������ �� ����
			
			forward = new ActionForward();			
			forward.setRedirect(false);
			forward.setPath("./member/joinForm.jsp");
			
		} else if (command.equals("/MemberJoinAction.me")) {	// ȸ������ ��û �� �׼� Ŭ���� ����
			
			// sendRedirect ������� �����ڴ�
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
			   action  = new BoardAddAction();//sendRedirect ������� �����ڴ�
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
		   // ���, DB ��� ���� ����
		   /*********************************************************/
		   // �並 � ������� �ѷ��� ���� ����
		   
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