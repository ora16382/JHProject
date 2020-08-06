package com.myspring.pro29.ex01;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	static Logger logger = LoggerFactory.getLogger(TestController.class);
	@RequestMapping("/member")
	public Map<Integer, MemberVO> member(){
		Map<Integer, MemberVO> list = new HashMap<Integer, MemberVO>();
		for(int i=0; i<10; i++) {
		MemberVO vo = new MemberVO();
		vo.setId("hong"+i);
		vo.setPwd("1234");
		vo.setName("홍길동"+i);
		vo.setEmail("hong@test.com");
		list.put(i,vo);
		}
		return list;
	}
	
	 @RequestMapping("/member2")
	  public MemberVO member2() {
	    MemberVO vo = new MemberVO();
	    vo.setId("hong");
	    vo.setPwd("1234");
	    vo.setName("홍길동");
	    vo.setEmail("hong@test.com");
	    return vo;
	  } 	
	 
	@RequestMapping(value="/notice/{num}", method=RequestMethod.GET)
	public int notice(@PathVariable("num") int num) {
		return num;
	}
	
	@RequestMapping(value="/info", method=RequestMethod.POST)
	public ResponseEntity<String> modify(/*@RequestBody MemberVO vo, */HttpServletRequest req, HttpServletResponse res) throws Exception {
		//logger.info(vo.toString());
		//res.getWriter().print(vo.getEmail());
		req.setCharacterEncoding("utf-8");
		System.out.println(req.getParameter("param"));
		HttpHeaders responseHeaers = new HttpHeaders();
		responseHeaers.add("Content-type","text/plain; charset=utf-8");
	//	return new ResponseEntity<String>("한글이야", responseHeaers,HttpStatus.OK);
	return new ResponseEntity<String>("한글이야",HttpStatus.OK);
	}
	
	@RequestMapping(value="/test", method= {RequestMethod.POST,RequestMethod.GET})
	public String test(@ModelAttribute MemberVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(vo.toString());
		//HttpHeaders responseHeaers = new HttpHeaders();
		//responseHeaers.add("Content-type","text/html; charset=utf-8");
		//return new ResponseEntity<String>("한글이야", responseHeaers,HttpStatus.OK);
		
		return "한글";
	}
	
	@RequestMapping("/membersList2")
	public ResponseEntity<List<MemberVO>> listMembers2(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		for(int i=0; i<10; i++) {
			MemberVO vo = new MemberVO();
			vo.setId("hong"+i);
			vo.setPwd("1234");
			vo.setName("홍길동"+i);
			vo.setEmail("hong@test.com");
			list.add(i,vo);
			}
		
		
		return new ResponseEntity<List<MemberVO>>(list,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value="/res3")
	public ResponseEntity res3() {
		HttpHeaders responseHeaers = new HttpHeaders();
		responseHeaers.add("Content-type","text/html; charset=utf-8");
		String message = "<body>test</body>";
		return new ResponseEntity(message,responseHeaers,HttpStatus.CREATED);
	}
}