package com.exam.spring01;



import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exam.spring01.Dao.iDao;
import com.exam.spring01.Dao.iDaoImpl;
import com.exam.spring01.Dto.join_DB_Dto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
    private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	@Autowired
	JdbcTemplate template;

	private join_DB_Dto dto;

	private SqlSessionFactory sqlSessionFactory;
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		return "main";
	}
	@RequestMapping("main.do")
	public String main(Model model) {

		return "main";
	}
	
	
	@RequestMapping("login.do")
	public String login_login(HttpServletRequest request, Model model){
		
		
		
		return "login/login";
	}

	@RequestMapping("login-DB.do")
	public String login_login_view(HttpServletRequest request) {

		HashMap map2 = new HashMap();

		Map map3 = new HashMap();

		
		
		
		
		HashMap<Comparable, String> pHm = new HashMap();
		String Comparable = "ffffffff";
		try{
			join_DB_Dto dto1 = null;
	        pHm = new HashMap();
	        map2.put(1, "사과");
	        map3.put("1", "과일");
	        map2.put(dto1.getUserid(), "과일");
	        
	        
	        System.out.println(pHm.get(1));
	        System.out.println(pHm.get("1"));
	        System.out.println(pHm.get(dto.getUserid()) + "ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
	        Comparable = (String) map2.get(dto1.getUserid());
		}catch (Exception e) {
			// TODO: handle exception
		}
		pHm.put(1, "사과");
        pHm.put("1", "과일");
		sqlSession.select(".login", "", null);
        System.out.println(map2.get(1));
        System.out.println(map3.get("1"));
        System.out.println(Comparable);
        
		
		String url = "main";
		int customercode = 1;
		String userid = request.getParameter("userid");
		String pass = request.getParameter("pass");
		iDao dao = sqlSession.getMapper(iDao.class);
		
		System.out.println("22222222222222222222222222222222");
		System.out.println(customercode);
		

		System.out.println("22222222222222222222222222222222");

		 // HashMap parameter 넘겨서 단일 행 가져오기
        pHm.put(1, "사과");
        pHm.put("1", "과일");
        pHm.put(dto.getUserid(), "과일");
        
        System.out.println(pHm.isEmpty());
        System.out.println(pHm.containsKey(pass));
        System.out.println(pHm.values());
        if(pHm.values() != null){
        	System.out.println("성공");
        }else{
        	System.out.println("실패");
        }
        System.out.println(pHm.get(1));
        System.out.println(pHm.get("1"));
        System.out.println(pHm.get(dto.getUserid()) + "ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
        System.out.println(pHm.equals(1));
        System.out.println(pHm.equals(userid));
		

        Hashtable h = new Hashtable(); //객체생성
        h.put("name", new String("홍길동")); //데이터 삽입
        String name = (String)h.get("1"); //키를 이용한 데이터 추출(다운캐스팅 필요)
        System.out.println(h);
        System.out.println(name);
        
		
		
		dao.login(userid, pass, customercode);
//		System.out.println("444444444444444444444444444");
//		if(userid.equals(dto.getUserid()) && pass.equals(dto.getPass())){
//			System.out.println("로그인 성공");
//			url = "login/login";
//		}else{
//			url = "main";
//		}
//		System.out.println("33333333333333333333333333");
//		
//		Map<String, Object> parameters = new HashMap<String, Object>();
//		parameters.put("userid", dto.getUserid());
//		System.out.println(parameters.get("userid")+" ㅋㅋ");
		
		System.out.println("222222");
		System.out.println(userid);
		System.out.println(pass);


		return url;

	}
	
	
	@RequestMapping("join.do")
	public String login_join_view(HttpServletRequest request, Model model) {
		
		return "login/join";
	}
	@RequestMapping("join-DB.do")
	public String login_join(HttpServletRequest request){
		System.out.println(request.getParameter("userid"));
		iDao dao = sqlSession.getMapper(iDao.class);
		dao.JoinDao(request.getParameter("userid"),request.getParameter("pass"),request.getParameter("name"),
				Integer.parseInt(request.getParameter("phone")),Integer.parseInt(request.getParameter("jumin")),request.getParameter("email"));
		
		return "login/login";
	}
	
	@RequestMapping("id_find.do")
	public String login_id_find(HttpServletRequest request, Model model){
		
		return "login/id_find";
	}
	
	@RequestMapping("pass_find.do")
	public String login_pass_find(HttpServletRequest request, Model model){
		
		return "login/pass_find";
	}
	
	
	
	
	@RequestMapping("event.do")
	public String event(HttpServletRequest request, Model model){
		
		return "占쏙옙占쏙옙/event";
	}

	@RequestMapping("inquiry.do")
	public String inquiry(HttpServletRequest request, Model model){
		
		return "占쏙옙占쏙옙/inquiry";
	}
	
	@RequestMapping("notice.do")
	public String notice(HttpServletRequest request, Model model){
		
		return "占쏙옙占쏙옙/notice";
	}
	
	@RequestMapping("oft_question.do")
	public String oft_question(HttpServletRequest request, Model model){
		
		return "占쏙옙占쏙옙/oft_question";
	}
	
	@RequestMapping("service_intro.do")
	public String service_intro(HttpServletRequest request, Model model){
		
		return "占쏙옙占쏙옙/service_intro";
	}



}
