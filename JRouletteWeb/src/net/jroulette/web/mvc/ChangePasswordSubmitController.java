package net.jroulette.web.mvc;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jroulette.service.JRouletteService;
import net.jroulette.web.domain.JRouletteWebUser;
import net.jroulette.web.util.JRouletteWebUtil;

import org.springframework.web.servlet.ModelAndView;

public class ChangePasswordSubmitController extends org.springframework.web.servlet.mvc.BaseCommandController {
	
	private static final String CLASS_NAME = ChangePasswordSubmitController.class.getName();
	
	private static final Logger LOG = Logger.getLogger(CLASS_NAME);
	
	private JRouletteService jrouletteService;
	
	private String successView;
	
	private String failedView;
	
	private static final int MIN_PASSWORD_LENGTH = 6;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.info("in onSubmit");
		ModelAndView mv = new ModelAndView(successView);
		String errorMessages = null;
		JRouletteWebUser user = (JRouletteWebUser) request.getSession().getAttribute(JRouletteWebUtil.JROULETTE_USER);
		
		if(user == null){
			LOG.info("user == null");
			mv.setViewName(failedView);
			errorMessages = JRouletteWebUtil.SESSION_EXPIRED_MESSAGE;
		} else if (inValidParameters(request.getParameter("password").toString(), request.getParameter("newPassword").toString(), request.getParameter("verifyNewPassword").toString())){
			//FIXME this is a workaround since Javascript validation doesn't always execute
			LOG.info("inValidParameters(");
			mv.setViewName(failedView);
			errorMessages = "Password fields must be 6 characters and fields must match";
		} else {
			LOG.info("else{");
			JRouletteWebUser validUser = jrouletteService.findUserByEmailValidatePassword(user == null ? "" : user.getEmail(), request.getParameter("password").toString());
			boolean updated = false;
			
			if(validUser != null){
				updated = jrouletteService.changeUserPassword(user.getId(), request.getParameter("newPassword").toString(), user.getEmail());			
				if(!updated){
					mv.setViewName(failedView);
					errorMessages = "Sorry, there was an error while trying to update your account - please try again later.";
					LOG.info("SOMETHING WRONG IN DAO - tried updating user password by id, but zero rows were updated");
				}
			} else{
				mv.setViewName(failedView);
				errorMessages = "Password was incorrect for user with email " + user.getEmail();
			}
		}
		
		request.setAttribute("ERROR_MESSAGES", errorMessages);
		request.setAttribute("userName", user == null ? null : user.getUserName());
		
		LOG.info("exiting onSubmit");
		return mv;
	}
	
	private boolean inValidParameters(String password, String newPassword, String verifyNewPassword) {
		boolean retVal = false;
		
		if(password == null || password.length() < MIN_PASSWORD_LENGTH){
			retVal = true;
		} else if(newPassword == null || newPassword.length() < MIN_PASSWORD_LENGTH){
			retVal = true;
		} else if(newPassword == null || !newPassword.equals(verifyNewPassword)){
			retVal = true;
		}
		
		return retVal;
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