package com.exam.spring01.Dao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.User;

import com.exam.spring01.Dto.join_DB_Dto;

public interface iDao {

	public void JoinDao(String userid, String pass, String name, int phone, int jumin, String email);
	public join_DB_Dto login(String userid, String pass, int customercode);


	
}
