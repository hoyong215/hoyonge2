package com.exam.spring01.Dao;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.security.core.userdetails.User;

import com.exam.spring01.Dto.join_DB_Dto;

public class iDaoImpl implements iDao{
	@Autowired
	JdbcTemplate template;
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	@Inject
	iDao dao;
	private join_DB_Dto dto;
	@Autowired
    private SqlSession sqlSession;
	public SqlSession getSqlSession() {
		return sqlSession;
	}
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}



	@Override
	public void JoinDao(String userid, String pass, String name, int phone, int jumin, String email) {}



	@Override
	public join_DB_Dto login(String userid, String pass, int customercode) {
		
		com.exam.spring01.Dto.join_DB_Dto article = getSqlSession().selectOne("com.exam.spring01.Dao.iDao.login", customercode);
		
		return article;
	}







	
	
//	@Override
//	public boolean logincheck(join_DB_Dto dto, HttpSession session) {
//		boolean result = dao.logincheck(dto, session);
//		if(result){
//			join_DB_Dto dto2 = login(dto);
//            session.setAttribute("userId", dto2.getUserid());
//            session.setAttribute("pass", dto2.getPass());
//		}
//		return result;
//	}
//
//	@Override
//	public join_DB_Dto login(join_DB_Dto dto) {
//		// TODO Auto-generated method stub
//		return dao.login(dto);
//	}
	
}
