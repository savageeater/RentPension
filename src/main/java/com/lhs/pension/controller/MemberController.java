package com.lhs.pension.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.lhs.pension.dao.PMemberIDao;

import com.lhs.pension.dto.PMember;

@Controller
public class MemberController {

	@Autowired
	private SqlSession sqlSession;
	private HttpSession session;

	@RequestMapping("/MemberJoin")
	public String memberJoin(Model model, HttpServletRequest request) {
		return "Main.jsp?center=Member/MemberJoin";
	}

	@RequestMapping("/JoinProc")
	public String joinProc(Model model, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		PMember dto = new PMember();
		dto.setId(request.getParameter("id"));
		dto.setPass(request.getParameter("pass"));
		dto.setEmail(request.getParameter("email"));
		dto.setAge(Integer.parseInt(request.getParameter("age")));
		dto.setTel(request.getParameter("tel"));
		dto.setRegion(request.getParameter("region"));

		PMemberIDao dao = sqlSession.getMapper(PMemberIDao.class);
		dao.insert(dto);

		return "redirect:Main";
	}



	@RequestMapping("/LoginProc")
	public String loginProc(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PMemberIDao dao = sqlSession.getMapper(PMemberIDao.class);
		PrintWriter out = response.getWriter(); 
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		session = request.getSession();
		
		Map<String,String> map = new HashMap();
		map.put("id",id);
		map.put("pass",pass);
		int res = dao.login(map);
		if(res==1) {
			session.setAttribute("id", id);
			session.setAttribute("pass", pass);
			return "redirect:Main";
		}else {	 
			out.println("<script>alert('아이디와 비밀번호가 일치하지 않습니다.'); location.href='Login';</script>");
			out.flush();
			return null;
		}
	}
	
	@RequestMapping("/Logout")
	public String logout(Model model, HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		if(session != null) {		
			session.invalidate();
		}
		return "redirect:Main";
	}
	
	@RequestMapping("/MemberList")
	public String memberList(Model model, HttpServletRequest request) throws SQLException {
		PMemberIDao dao = sqlSession.getMapper(PMemberIDao.class);
		int num = dao.getAllCount();
		model.addAttribute("MemberList", dao.selectAll());
		model.addAttribute("num", num);
		return "Main.jsp?center=Member/MemberList";
	}
	
	@RequestMapping("/MemberInfo")
	public String memberInfo(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		PMemberIDao dao = sqlSession.getMapper(PMemberIDao.class);
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter(); 
		session = request.getSession();
		
	String id = (String)session.getAttribute("id");
		if(id==null) {
			out.println("<script>alert('로그인 후 이용 가능합니다.'); location.href='Login';</script>");
			out.flush();
			return "Main";
		}
		
		
		model.addAttribute("dto", dao.select(id));
		return "Main.jsp?center=Member/MemberInfo";
	}
	@RequestMapping("/MemberDeleteForm")
	public String memberDeleteForm(Model model, HttpServletRequest request) throws SQLException {
		PMemberIDao dao = sqlSession.getMapper(PMemberIDao.class);
		String id = request.getParameter("id");
		model.addAttribute("dto", dao.select(id));
		return "Main.jsp?center=Member/MemberDeleteForm";
	}
	
	@RequestMapping("/MemberDeleteProc")
	public String memberDeleteProc(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		PMemberIDao dao = sqlSession.getMapper(PMemberIDao.class);
		response.setContentType("text/html; charset=UTF-8");	 
		PrintWriter out = response.getWriter(); 
		
		String xpwd = request.getParameter("pass");
		String id = request.getParameter("id");
		PMember dto = dao.select(id);
		
		
		if(dto.getPass().equals(xpwd)) {
			session.invalidate();
			dao.delete(id);
			return "redirect:Main";
		}else {
			out.println("<script>alert('비밀번호가 맞지 않습니다.'); location.href='MemberDeleteForm?id="+id+"';</script>");
			out.flush();
			return "Main";
		}
	}
	
	@RequestMapping("/MemberUpdateForm")
	public String memberUpdateForm(Model model, HttpServletRequest request) throws SQLException {
		PMemberIDao dao = sqlSession.getMapper(PMemberIDao.class);
		String id = request.getParameter("id");
		model.addAttribute("dto", dao.select(id));
		return "Main.jsp?center=Member/MemberUpdateForm";
	}
	
	@RequestMapping("/MemberUpdateProc")
	public String memberUpdateProc(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		PMemberIDao dao = sqlSession.getMapper(PMemberIDao.class);
		response.setContentType("text/html; charset=UTF-8");	 
		PrintWriter out = response.getWriter(); 
		
		String pass = request.getParameter("pass");
		String id = request.getParameter("id");
		

		PMember dto = dao.select(id);
		
		//JSPMember_Dto dto2 = new JSPMember_Dto();
		dto.setEmail(request.getParameter("email"));
		dto.setTel(request.getParameter("tel"));
		dto.setRegion(request.getParameter("region"));
		dto.setId(id);
		if(dto.getPass().equals(pass)) {
			dao.update(dto);
			return "redirect:Member/MemberInfo?id="+id;
		}else {
			out.println("<script>alert('비밀번호가 맞지 않습니다.'); location.href='MemberUpdateForm?id="+id+"';</script>");
			out.flush();
			return null;
		}
	}

}
