package net.jroulette.web.mvc;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jroulette.service.JRouletteService;
import net.jroulette.web.domain.JRouletteWebUser;
import net.jroulette.web.util.JRouletteWebUtil;

import org.springframework.web.servlet.ModelAndView;

public class ActivateAccountController  extends org.springframework.web.servlet.mvc.BaseCommandController {
	
	private static final String CLASS_NAME = ActivateAccountController.class.getName();
	
	private static final Logger LOG = Logger.getLogger(CLASS_NAME);

	private static final String ACTIVATED_MESSAGE = "Your account has been activated!";

	private static final String DEACTIVATED_MESSAGE = "Your account has been deactivated!";
	
	private JRouletteService jrouletteService;
	
	private String successView;
	
	private String failedView;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.info("enetering handleRequestInternal");
		ModelAndView mv = new ModelAndView();
		final JRouletteWebUser user = (JRouletteWebUser) request.getSession().getAttribute(JRouletteWebUtil.JROULETTE_USER);
		final String email = request.getParameter("email");
		final String activeParameter = request.getParameter("active");
		boolean updated = false;
		boolean active = activeParameter != null && activeParameter.equals("1");
		
		if(email != null){
			updated = jrouletteService.changeActiveUserAccount(email, active);
		} else if(user != null){
			updated = jrouletteService.changeActiveUserAccount(user.getId(), active);
		} else{
			LOG.info("ERROR, could not activate account: Tried email=" + email + ", tried user=" + user);
		}
		
		if(updated){
			user.setIsActive(active);
			request.setAttribute("MESSAGE", active ? ACTIVATED_MESSAGE : DEACTIVATED_MESSAGE);
			mv.setViewName(getSuccessView());
		} else {
			request.setAttribute("MESSAGE", "Sorry, there was a problem processing your request. Please try again later.");
			mv.setViewName(getFailedView());
		}
		
		LOG.info("exiting handleRequestInternal");
		return mv;
	}

	public void setJrouletteService(JRouletteService jrouletteService) {
		this.jrouletteService = jrouletteService;
	}

	public String getSuccessView() {
		return successView;
	}

	public void setSuccessView(String successView) {
		this.successView = successView;
	}

	public String getFailedView() {
		return failedView;
	}

	public void setFailedView(String failedView) {
		this.failedView = failedView;
	}

}
