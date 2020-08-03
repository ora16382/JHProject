package com.myspring.pro27.member.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.pro27.member.service.MemberService;
import com.myspring.pro27.member.vo.MemberVO;

@Controller("memberController")
public class MemberControllerImpl implements MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class);
	@Autowired
	 private MemberService memberService;
	
	@Autowired
	private MemberVO memberVO;

	@Override
	@RequestMapping(value="/member/listMembers.do", method=RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//String viewName = getViewName(request);
		String viewName = (String)request.getAttribute("viewName");
		logger.info("info 레벨 : viewName = "+viewName);
		logger.debug("debug 레벨 : viewName = "+viewName);
		List<MemberVO> membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList",membersList);
		
		return mav;
	}

	@Override
	@RequestMapping(value="/member/addMember.do", method=RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member,HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		int result=0;
		result = memberService.addMember(member);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}


	@Override
	@RequestMapping(value="/member/removeMember.do", method=RequestMethod.GET)
	public ModelAndView removeMember(@RequestParam("id") String id,HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}

	@Override
	@RequestMapping(value="/member/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") MemberVO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception {
	System.out.println("왜 안되냐 시발");
	ModelAndView mav = new ModelAndView();
	memberVO = memberService.login(member);
	if(memberVO != null) {
		    HttpSession session = request.getSession();
		    session.setAttribute("member", memberVO);
		    session.setAttribute("isLogOn", true);
		    mav.setViewName("redirect:/member/listMembers.do");
	}else {
		   rAttr.addFlashAttribute("result","loginFailed2");
		    mav.setViewName("redirect:/member/loginForm.do");
	}
	return mav;
	}

	@Override
	@RequestMapping(value="/member/logout.do", method =  RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/member/listMembers.do");
		return mav;
	}	

	@RequestMapping(value = "/member/*Form.do", method =  RequestMethod.GET)
	private ModelAndView form(
						       HttpServletRequest request, 
						       HttpServletResponse response) throws Exception {
		//String viewName = getViewName(request);
		
		String viewName = (String)request.getAttribute("viewName");
		System.out.println("실행됨"+viewName);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	

	
}
