package com.spring.lsy0911;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 연습용, url  맵핑 주소도 동일하게 사용할 예정.
@WebServlet("/mem2.do")
public class MemberServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		// 만약, 마이바티스라는 디비 프레임 워크를 사용을 안하게 되면, 
		// 여기에, 1)디비에 연결하는 코드, 2) 디비를 불러오는 sql 3) 닫는 코드 
		
		// member.xml 에서 사용하는 sql id를 재사용하는데, 기존 복사해서, 끝 2만 변경.
		//원본
		List<MemberVO> membersList = dao.selectAllMemberList();
		// 과제
		List<MemberVO> membersList2 = dao.selectAllMemberList2();
		//List<HashMap<String, String>> membersList = dao.selectAllMemberList();
		//원본
		request.setAttribute("membersList", membersList);
		// 과제 
		request.setAttribute("membersList2", membersList2);
		RequestDispatcher dispatch = request.getRequestDispatcher("test01/listMembersLsy0911.jsp");
		dispatch.forward(request, response);
	}
}
