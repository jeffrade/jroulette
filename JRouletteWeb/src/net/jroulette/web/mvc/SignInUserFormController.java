package net.jroulette.web.mvc;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jroulette.service.JRouletteService;
import net.jroulette.web.domain.JRouletteWebUser;
import net.jroulette.web.util.JRouletteWebUtil;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class SignInUserFormController extends SimpleFormController {
	
	private static final String CLASS_NAME = SignInUserFormController.class.getName();
	
	private static final Logger LOG = Logger.getLogger(CLASS_NAME);

	private static final int MIN_PASSWORD_LENGTH = 6;
	
	private static final int MIN_EMAIL_LENGTH = 5;
	
	private String failedView = "signin";
	
	private JRouletteService jrouletteService;
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		LOG.info("Entering " + CLASS_NAME + ".onSubmit()");
		ModelAndView mv = new ModelAndView();
		JRouletteWebUser user = null;
		final String email = request.getParameter("email").toString();
		
		if(inValidParameters(email, request.getParameter("password").toString())){
			LOG.info("request has inValid email and/or password parameters");
		} else{
			user = jrouletteService.findUserByEmailValidatePassword(email, request.getParameter("password").toString());
			
			boolean updated = false;
			if(user != null){
				Timestamp now = new Timestamp(Calendar.getInstance().getTime().getTime());
				user.setLastLogin(now);
				updated = jrouletteService.updateUserLastLogin(user.getId(), now);
			} else {
				LOG.info(CLASS_NAME + ": user was not found with email = " + email + " or password = " + request.getParameter("password").toString() +" was incorrect");
			}
			
			if(!updated && user != null){
				LOG.info(CLASS_NAME + ": user last_login was not posted to database; " + request.getParameter("email").toString());
			}
		}
		
		request.getSession().setAttribute(JRouletteWebUtil.JROULETTE_USER, user);
		request.getSession().setAttribute("isRegistered", user != null ? "1" : "0");
		request.setAttribute("failedLoginAttempt", user == null ? "1" : "0");
		request.setAttribute("email", email);
		mv.setViewName(user == null ? getFailedView() : getSuccessView());
		LOG.info("Exiting " + CLASS_NAME + ".onSubmit()");
		return mv;
	}
	
	private boolean inValidParameters(String email, String password) {
		boolean retVal = false;
		
		if(password == null || password.length() < MIN_PASSWORD_LENGTH){
			retVal = true;
		} else if(email == null || email.length() < MIN_EMAIL_LENGTH){
			retVal = true;
		}
		
		return retVal;
	}

	public JRouletteService getJrouletteService() {
		return jrouletteService;
	}

	public void setJrouletteService(JRouletteService jrouletteService) {
		this.jrouletteService = jrouletteService;
	}

	public String getFailedView() {
		return failedView;
	}

	public void setFailedView(String failedView) {
		this.failedView = failedView;
	}
}
