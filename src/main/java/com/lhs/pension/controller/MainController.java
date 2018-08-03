package com.lhs.pension.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/Main")
	public String main(Model model, HttpServletRequest request) {
		return "Main";
	}
	@RequestMapping("/Login")
	public String login(Model model, HttpServletRequest request) throws SQLException {
		return "Main.jsp?center=Login";
	}
	@RequestMapping("/Delete")
	public String delete(Model model, HttpServletRequest request, HttpServletResponse response) {
		return "Main.jsp?center=Delete";
	}

}
