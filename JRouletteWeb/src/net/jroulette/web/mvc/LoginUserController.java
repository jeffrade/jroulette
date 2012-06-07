package net.jroulette.web.mvc;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.BaseCommandController;

public class LoginUserController extends BaseCommandController {
	
	private static final String CLASS_NAME = LoginUserController.class.getName();
	
	private static final Logger LOG = Logger.getLogger(CLASS_NAME);

	private static final String SUCCESS_PAGE = "loginProcess";
	
	private static final String FAILURE_PAGE = "login";

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.info("Entering " + CLASS_NAME + ".handleRequestInternal()");
		//j_spring_security_check?j_username=support%40jroulette.net&j_password=admin
		final String userName = request.getParameter("j_username");
		final String password = request.getParameter("j_password");
		final String failedLoginAttempt = request.getParameter("failedLoginAttempt");
		LOG.info("[userName,password,failedLoginAttempt]: [" + userName + "," + password + "," + failedLoginAttempt + "]");
		
		final boolean isLoginFailed = failedLoginAttempt != null && failedLoginAttempt.equals("1");
		ModelAndView mv = new ModelAndView(isLoginFailed ? FAILURE_PAGE : SUCCESS_PAGE);
		
		LOG.info("Exiting " + CLASS_NAME + ".handleRequestInternal()");
		return mv;
	}

}
