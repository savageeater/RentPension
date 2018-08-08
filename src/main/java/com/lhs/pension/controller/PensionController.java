package com.lhs.pension.controller;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lhs.pension.common.RentPensionParsing;
import com.lhs.pension.dao.PMemberIDao;
import com.lhs.pension.dao.RentPensionIDao;
import com.lhs.pension.dto.PMember;
import com.lhs.pension.dto.RentPension;

@Controller
public class PensionController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/BatchForm")
	public String batchForm(Model model, HttpServletRequest request) throws SQLException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		PMemberIDao dao = sqlSession.getMapper(PMemberIDao.class);
		String adpw = (String)dao.getPassWord(id);
		model.addAttribute("adpw", adpw);
		return "Main.jsp?center=Pension/BatchForm";
	}
	
	@RequestMapping("/BatchProc")
	public String batchProc(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");	 
		PrintWriter out = response.getWriter(); 
		RentPensionIDao dao = sqlSession.getMapper(RentPensionIDao.class);
		RentPension dto = new RentPension();
		dto.setName(request.getParameter("name"));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		dto.setImg(request.getParameter("img"));
		dto.setInfo(request.getParameter("info"));
		dto.setMinp(Integer.parseInt(request.getParameter("minp")));
		dto.setMaxp(Integer.parseInt(request.getParameter("maxp")));
		dto.setRegion(Integer.parseInt(request.getParameter("region")));
		dto.setSpa(Integer.parseInt(request.getParameter("spa")));
		dto.setPool(Integer.parseInt(request.getParameter("pool")));
		dto.setToilet(Integer.parseInt(request.getParameter("toilet")));
		dto.setRoom(Integer.parseInt(request.getParameter("room")));
		dto.setBreakfast(Integer.parseInt(request.getParameter("breakfast")));
		dto.setWifi(Integer.parseInt(request.getParameter("wifi")));
		
		dao.insert(dto);
		/*
		String content = request.getParameter("content");
		String[] contents = content.split("#");
		for(String x : contents) {
			if(x==null) continue;
			dao.insert(RentPensionParsing.parsing(x));
		}
		*/
		
		out.println("<script>alert('등록에 성공했습니다.'); location.href='Main';</script>");
		out.flush();
		return "Main";
	}
	
	@RequestMapping("/UpdateList")
	public String updateList(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		RentPensionIDao dao = sqlSession.getMapper(RentPensionIDao.class);
		model.addAttribute("num", dao.allcount());
		model.addAttribute("carlist", dao.selectAll());
		return "Main.jsp?center=Pension/UpdateList";
	}
	
	@RequestMapping("/PensionProcess")
	public String carProcess(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "Main.jsp?center=Pension/PensionProcess";
	}
	
	@RequestMapping("/UpdatePensionInfo")
	public String updateCarInfo(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		RentPensionIDao dao = sqlSession.getMapper(RentPensionIDao.class);
		int no = Integer.parseInt(request.getParameter("No"));
		model.addAttribute("dto", dao.selectVo(no));
		return "Main.jsp?center=Pension/UpdatePensionInfo";
	}
	
	@RequestMapping("/UpdateCancel")
	public String updateCancel(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int backPage = Integer.parseInt(session.getAttribute("currentPage")+"");
		int backBlock = Integer.parseInt(session.getAttribute("currentBlock")+"");
		return "redirect:Pension/UpdateList?pageNum="+backPage+"&pageBlock="+backBlock;
	}
	
	@RequestMapping("/UpdatePensionInfoProc")
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
		
		return "redirect:Pension/UpdateList?pageNum="+backPage+"&pageBlock="+backBlock;
	}

	
	@RequestMapping("/PensionCategoryList")
	public String pensionCategoryList(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		RentPensionIDao dao = sqlSession.getMapper(RentPensionIDao.class);
		int category = Integer.parseInt(request.getParameter("category"));
		
		model.addAttribute("category", dao.selectKey(category));

		return "Main.jsp?center=Pension/PensionCategoryList";
	}
	
	@RequestMapping("/PensionAllList")
	public String pensionAllList(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		RentPensionIDao dao = sqlSession.getMapper(RentPensionIDao.class);
		model.addAttribute("list", dao.selectAll());
		return "Main.jsp?center=Pension/PensionAllList";
	}
}
