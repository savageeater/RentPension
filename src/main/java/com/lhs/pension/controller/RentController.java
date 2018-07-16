package com.lhs.pension.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lhs.pension.dao.RentPensionIDao;
import com.lhs.pension.dao.RentReserveIDao;
import com.lhs.pension.dto.RentPension;
import com.lhs.pension.dto.RentReserve;
import com.lhs.pension.dto.ReserveView;

@Controller
public class RentController {
	
	@Autowired
	private SqlSession sqlSession;
	private HttpSession session;

	@RequestMapping("/ReserveView")
	public String reserveView(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		RentReserveIDao dao = sqlSession.getMapper(RentReserveIDao.class);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); 
		
		session = request.getSession();
		System.out.println(session.getAttribute("id"));
		
		if(session.getAttribute("id")==null) {
			out.println("<script>alert('로그인 후 이용가능합니다.'); location.href='Login';</script>");
			out.flush();
			return null;
		}else {
			session = request.getSession();
			String id = (String)session.getAttribute("id");		
			List<ReserveView> list = dao.selectAllView(id);
			model.addAttribute("list", list);
			return "Main.jsp?center=ReserveView";
		}
	}
	@RequestMapping("/Delete")
	public String delete(Model model, HttpServletRequest request, HttpServletResponse response) {
		return "Main.jsp?center=Delete";
	}
	@RequestMapping("/DeleteConfirm")
	public String deleteConfirm(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int regno = (int) (session.getAttribute("deleteNum"));
		RentReserveIDao dao = sqlSession.getMapper(RentReserveIDao.class);
		dao.delete(regno);
		return "redirect:ReserveView";
	}
	
	@RequestMapping("/Adjust")
	public String adjust(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int regno = Integer.parseInt(request.getParameter("regno"));
		RentReserveIDao dao = sqlSession.getMapper(RentReserveIDao.class);
		model.addAttribute("dto", dao.selectVO(regno));
		return "Main.jsp?center=Adjust";
	}
	
	@RequestMapping("/AdjustProc")
	public String adjustProc(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		RentReserveIDao dao = sqlSession.getMapper(RentReserveIDao.class);
		RentReserve dto = new RentReserve();
		dto.setNo(Integer.parseInt(request.getParameter("no")));
		dto.setRday(request.getParameter("rday"));
		dto.setDday(Integer.parseInt(request.getParameter("dday")));
		dto.setQty(Integer.parseInt(request.getParameter("qty")));

		dto.setWifi(Integer.parseInt(request.getParameter("wifi")));

		dto.setRegno(Integer.parseInt(request.getParameter("regno")));
		dto.setMemid(request.getParameter("memid"));
		
		model.addAttribute("dto", dao.update(dto));
		return "redirect:ReserveView";
	}
	
	@RequestMapping("/PensionReserveMain")
	public String carReserveMain(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		RentPensionIDao dao = sqlSession.getMapper(RentPensionIDao.class);
		model.addAttribute("allcount", dao.allcount());
		model.addAttribute("list", dao.selectAll());
		return "Main.jsp?center=Pension/PensionReserveMain";
	}
	
	@RequestMapping("/PensionReserveInfo")
	public String carReserveInfo(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		RentPensionIDao dao = sqlSession.getMapper(RentPensionIDao.class);
		int no = Integer.parseInt(request.getParameter("no"));
		model.addAttribute("dto", dao.selectVo(no));
		return "Main.jsp?center=Pension/PensionReserveInfo";
	}
	@RequestMapping("/PensionOptionSelect")
	public String carOptionSelect(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		RentPensionIDao dao = sqlSession.getMapper(RentPensionIDao.class);
		int no = Integer.parseInt(request.getParameter("no"));
		model.addAttribute("dto", dao.selectVo(no));
		return "Main.jsp?center=Pension/PensionOptionSelect";
	}
	
	@RequestMapping("/PensionReserveResult")
	public String carReserveResult(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException, ParseException, IOException {
		RentPensionIDao dao = sqlSession.getMapper(RentPensionIDao.class);
		RentReserveIDao dao2 = sqlSession.getMapper(RentReserveIDao.class);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); 
		
		int no = Integer.parseInt(request.getParameter("no"));
		int dday = Integer.parseInt(request.getParameter("dday"));
		String rday = request.getParameter("rday");

		int wifi = Integer.parseInt(request.getParameter("wifi"));

		int qty = Integer.parseInt(request.getParameter("qty"));
		HttpSession session = request.getSession();
		String memid = (String)session.getAttribute("id");
		
		if(rday.isEmpty() || rday.equals("")) {
			out.println("<script>alert('��¥�� �Է����ּ���.'); location.href='PensionReserveInfo?no="+no+"';</script>");
			out.flush();
			return null;
		}
			
		RentPension dto = dao.selectVo(no);
		RentReserve dto2 = new RentReserve();
		

		dto2.setDday(dday);

		dto2.setMemid(memid);
		dto2.setNo(no);
		dto2.setQty(qty);

		dto2.setRday(rday);
		dto2.setWifi(wifi);
		
		Date d1 = new Date();
		Date d2 = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		d1 = sdf.parse(rday);
		d2 = sdf.parse(sdf.format(d2));
		
		int res = d1.compareTo(d2);// -1,0,1
		if(res == -1) {
			out.println("<script>alert('���� ���� ��¥�� �����Ϸ� ����� �� �����ϴ�.'); location.href='PensionReserveInfo?no="+no+"';</script>");
			out.flush();
			return null;
		}else if(memid==null || memid.equals("")) {
			out.println("<script>alert('�α��� �� �̿����ּ���.'); location.href='Login';</script>");
			out.flush();
			return null;
		}
		
		dao2.insert(dto2);
		//dto2.setRegno(dao2.getCurrval());
		
		model.addAttribute("dto", dto);
		model.addAttribute("dto2", dto2);
		
		return "Main.jsp?center=Pension/PensionReserveResult";
	}
	@RequestMapping("/PensionCategoryList")
	public String carCategoryList(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		RentPensionIDao dao = sqlSession.getMapper(RentPensionIDao.class);
		int category = Integer.parseInt(request.getParameter("category"));
		
		model.addAttribute("category", dao.selectKey(category));

		return "Main.jsp?center=Pension/CategoryList";
	}
	
	@RequestMapping("/PensionAllList")
	public String carAllList(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		RentPensionIDao dao = sqlSession.getMapper(RentPensionIDao.class);
		model.addAttribute("list", dao.selectAll());

		return "Main.jsp?center=Pension/PensionAllList";
	}
	
	
}
