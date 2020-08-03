package com.myspring.pro29.ex02;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.pro29.ex01.MemberVO;

@Controller
public class ResController {
	
	@ResponseBody
	@RequestMapping(value="/res1")
	public Map<String,Object> res1(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "hong");
		map.put("name", "È«±æµ¿");
		return map;
	}
	
	@RequestMapping(value="/res2")
	public ModelAndView res() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/res3", method= {RequestMethod.POST,RequestMethod.GET})
	public void test( HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getParameter("name"));
		//vo.setName(request.getParameter("name"));
		//System.out.println(vo.toString());
		response.setContentType("text/html; charset=utf-8");  // ÇØµµ ¤¿¤¤µÊ
		
	}
}
