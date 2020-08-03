package com.spring.ex02;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
public class LoginController {
	
	 public LoginController() {
	System.out.println("»ý¼ºµÊ");
	}
	@RequestMapping(value= {"/test/loginForm.do", "/test/loginForm2.do"}, method=RequestMethod.GET)
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginForm");
		return mav;
	}
	
	@RequestMapping(value= {"/test/login.do"}, method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		String userID = request.getParameter("userID");
		String userName = request.getParameter("userName");
		mav.addObject("userID", userID);
		mav.addObject("userName", userName);
		return mav;
	}
	
	
	
	@RequestMapping(value= {"/test/login2.do"}, method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login2(@RequestParam("userID") String userID, @RequestParam("userName") String userName,
			@RequestParam(value="email", required=false) String email ,HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		//String userID = request.getParameter("userID");
		//String userName = request.getParameter("userName");
		System.out.println(userID);
		System.out.println(userName);
		System.out.println(email);
		mav.addObject("userID", userID);
		mav.addObject("userName", userName);
		return mav;
	}
	
	@RequestMapping(value= {"/test/login3.do"}, method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login3(@RequestParam Map<String, String> info,HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		//String userID = request.getParameter("userID");
		//String userName = request.getParameter("userName");
		System.out.println(info);
		mav.addObject("info",info);
		return mav;
	}
	
	@RequestMapping(value= {"/test/login4.do"}, method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login4(@ModelAttribute("info") LoginVO loginVO,HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		System.out.println(loginVO.getUserID());
		System.out.println(loginVO.getUserName());
		return mav;
	}
	
	@RequestMapping(value= {"/test/login5.do"}, method= {RequestMethod.GET,RequestMethod.POST})
	public String login5(Model model,HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		model.addAttribute("userID", "hong");
		model.addAttribute("userName", "È«±æµ¿");
		return "result";
	}
}
