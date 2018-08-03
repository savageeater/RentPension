package com.lhs.pension.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.lhs.pension.dao.PBoardIDao;
import com.lhs.pension.dto.PBoard;
import com.lhs.pension.dto.ReserveView;

/**
 * Servlet implementation class BoardFrontController
 */

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private SqlSession sqlSession;

	
	@RequestMapping("/BoardList")
	public String Boardlist(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		System.out.println("BoardList()");
		PBoardIDao dao = sqlSession.getMapper(PBoardIDao.class);
		int num = dao.getAllCount();
		model.addAttribute("BoardList", dao.selectAll());
		model.addAttribute("num", num);
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter(); 
		HttpSession session;
		session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id==null) {
			out.println("<script>alert('로그인 후 이용 가능합니다.'); location.href='Login';</script>");
			out.flush();
		}
		
		
		return "Main.jsp?center=Board/BoardList";
	}
	
	@RequestMapping("/BoardWriteForm")
	public String boardwriteForm(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException { // 게시글 작성 폼으로 이동
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		return "Main.jsp?center=Board/BoardWriteForm";
	}
	
	@RequestMapping("/BoardWriteProc") // 게시물 작성
	public String boardwriteProc(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); 

		HttpSession session = request.getSession();
		String writer = (String) session.getAttribute("id");
		
		String subject = request.getParameter("subject");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		String score = request.getParameter("score");
		
		PBoardIDao dao = sqlSession.getMapper(PBoardIDao.class);
		
		if(writer.equals("")||subject.equals("")||email.equals("")||password.equals("")||content.equals("")) {
			out.println("<script>alert('입력 칸을 모두 채워주세요.'); location.href='BoardWriteForm';</script>");
			out.flush();
			return null;
		}
		
		
		dao.insert(writer, email, subject, password, content,score);
		System.out.println("write()");
		return "redirect:BoardList";
	}
	
	@RequestMapping("/BoardInfo") // 게시물보기
	public String boardInfo(Model model, HttpServletRequest request) throws SQLException {
		PBoardIDao dao = sqlSession.getMapper(PBoardIDao.class);
		String key = request.getParameter("num");
		dao.upreadcnt(Integer.parseInt(request.getParameter("num")));
		model.addAttribute("dto", dao.select(key));
		return "Main.jsp?center=Board/BoardInfo";
	}
	
	@RequestMapping("/BoardDeleteForm")
	public String boardDeleteForm(Model model, HttpServletRequest request) {
		return "Main.jsp?center=Board/BoardDeleteForm";
	}
	
	@RequestMapping("/BoardDeleteProc")
	public String boardDeleteProc(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		PBoardIDao dao = sqlSession.getMapper(PBoardIDao.class);
		response.setContentType("text/html; charset=UTF-8");	 
		PrintWriter out = response.getWriter(); 
		String xpwd = request.getParameter("xpwd");
		String num = request.getParameter("num");
		PBoard dto = dao.select(num);
		HttpSession session = request.getSession();
		PBoard dto2 = new PBoard();
		String id = dto.getWriter();
		String getid = (String)session.getAttribute("id");
		
		if(id.equals(getid)&&dto.getPassword().equals(xpwd)) {
			dao.delete(Integer.parseInt(num));
			System.out.println("삭제완료");
			return "redirect:BoardList";
		}else {
			out.println("<script>alert('작성자가 다르거나 비밀번호가 틀립니다.'); location.href='BoardDeleteForm?num="+num+"';</script>");
			out.flush();
			return null;
		}
		

		
	}
	
	@RequestMapping("/BoardUpdateForm")
	public String boardUpdateForm(Model model, HttpServletRequest request) throws SQLException {
		PBoardIDao dao = sqlSession.getMapper(PBoardIDao.class);
		String num = request.getParameter("num");
		model.addAttribute("dto", dao.select(num));
		return "Main.jsp?center=Board/BoardUpdateForm";
	}
	
	@RequestMapping("/BoardUpdateProc")
	public String boardUpdateProc(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		PBoardIDao dao = sqlSession.getMapper(PBoardIDao.class);
		response.setContentType("text/html; charset=UTF-8");	 
		PrintWriter out = response.getWriter(); 
		
		String password = request.getParameter("password");
		String num = request.getParameter("num");
		PBoard dto = dao.select(num);
		
		if(dto.getPassword().equals(password)) {
			dao.update(request.getParameter("subject"), request.getParameter("content"), num);
			return "redirect:Board/BoardInfo?num="+num;
		}else {
				out.println("<script>alert('수정할 수 없습니다.'); location.href='BoardUpdateForm?num="+num+"';</script>");
				out.flush();
				return null;
		}
	}
	
	@RequestMapping("/BoardReWriteForm")
	public String boardReWriteForm(Model model, HttpServletRequest request) throws SQLException {
		PBoardIDao dao = sqlSession.getMapper(PBoardIDao.class);
		String num = request.getParameter("num");
		model.addAttribute("dto", dao.select(num));
		return "Main.jsp?center=Board/BoardReWriteForm";
	}
	
	@RequestMapping("/BoardReWriteProc")
	public String boardReWriteProc(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		PBoardIDao dao = sqlSession.getMapper(PBoardIDao.class);
		HttpSession session = request.getSession();
		String ref = request.getParameter("ref");
		String re_step = request.getParameter("re_step");
		String re_level = request.getParameter("re_level");
		
		String writer = (String) session.getAttribute("id");
		String subject = request.getParameter("subject");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		
		
		int backPage = Integer.parseInt(session.getAttribute("currentPage")+"");
		int backBlock = Integer.parseInt(session.getAttribute("currentBlock")+"");
		
		dao.re_level_up(ref, re_level);
		
		dao.insert_reply(writer, email, subject, password, Integer.parseInt(ref), Integer.parseInt(re_step)+1, Integer.parseInt(re_level)+1, content);
	
		return "redirect:Board/BoardList";
		//?pageNum="+backPage+"&pageBlock="+backBlock

	}
}
