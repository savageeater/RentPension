package com.lhs.pension.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lhs.pension.common.RentPensionParsing;
import com.lhs.pension.dao.RentPensionIDao;
import com.lhs.pension.dto.RentPension;

@Controller
public class PensionController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/BatchForm")
	public String batchForm(Model model, HttpServletRequest request) {
		return "Main.jsp?center=BatchForm";
	}
	
	@RequestMapping("/BatchProc")
	public String batchProc(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");	 
		PrintWriter out = response.getWriter(); 
		RentPensionIDao dao = sqlSession.getMapper(RentPensionIDao.class);
		String content = request.getParameter("content");
		String[] contents = content.split("#");
		for(String x : contents) {
			if(x==null) continue;
			dao.insert(RentPensionParsing.parsing(x));
		}
		out.println("<script>alert('�����ϵǾ����ϴ�.'); location.href='Main';</script>");
		out.flush();
		return "Main";
	}
	
	@RequestMapping("/UpdateList")
	public String updateList(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		RentPensionIDao dao = sqlSession.getMapper(RentPensionIDao.class);
		model.addAttribute("num", dao.allcount());
		model.addAttribute("carlist", dao.selectAll());
		return "Main.jsp?center=UpdateList";
	}
	
	@RequestMapping("/CarProcess")
	public String carProcess(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "Main.jsp?center=CarProcess";
	}
	
	@RequestMapping("/UpdateCarInfo")
	public String updateCarInfo(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		RentPensionIDao dao = sqlSession.getMapper(RentPensionIDao.class);
		int no = Integer.parseInt(request.getParameter("No"));
		model.addAttribute("dto", dao.selectVo(no));
		return "Main.jsp?center=UpdateCarInfo";
	}
	
	@RequestMapping("/UpdateCancel")
	public String updateCancle(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int backPage = Integer.parseInt(session.getAttribute("currentPage")+"");
		int backBlock = Integer.parseInt(session.getAttribute("currentBlock")+"");
		return "redirect:UpdateList?pageNum="+backPage+"&pageBlock="+backBlock;
	}
	
	@RequestMapping("/UpdateCarInfoProc")
	public String UpdateCarInfoProc(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int backPage = Integer.parseInt(session.getAttribute("currentPage")+"");
		int backBlock = Integer.parseInt(session.getAttribute("currentBlock")+"");
		
		RentPensionIDao dao = sqlSession.getMapper(RentPensionIDao.class);
		RentPension dto = new RentPension();
		
		dto.setNo(Integer.parseInt(request.getParameter("no")));
		dto.setName(request.getParameter("name"));

		dto.setPrice(Integer.parseInt(request.getParameter("price")));

		dto.setImg(request.getParameter("img"));
		dto.setInfo(request.getParameter("info"));
		
		dao.update(dto);
		
		return "redirect:UpdateList?pageNum="+backPage+"&pageBlock="+backBlock;
	}
}
