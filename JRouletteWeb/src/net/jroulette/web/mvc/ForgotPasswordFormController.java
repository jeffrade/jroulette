package net.jroulette.web.mvc;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jroulette.service.JRouletteService;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class ForgotPasswordFormController extends SimpleFormController{
	
	private static final String CLASS_NAME = ForgotPasswordFormController.class.getName();
	
	private static final Logger LOG = Logger.getLogger(CLASS_NAME);
	
	private static final String EMAIL_NOT_FOUND_MESSAGE = "Sorry, but that email was not found in our system.";

	private static final String EMAIL_SENT_PREFIX_MESSAGE = "An email has been sent to ";
	
	private JRouletteService jrouletteService;
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {			
		ModelAndView mv = new ModelAndView(getSuccessView());
		String message = null;
		
		final String userEmail = request.getParameter("email").toString();
		final boolean isEmailSent = jrouletteService.emailPasswordToUser(userEmail);		
		
		if(isEmailSent && userEmail != null){
			message = EMAIL_SENT_PREFIX_MESSAGE + userEmail;
		} else{
			message = EMAIL_NOT_FOUND_MESSAGE;
		}
		
		request.setAttribute("message", message);
		
		return mv;
	}
	
	public void setJrouletteService(JRouletteService jrouletteService) {
		this.jrouletteService = jrouletteService;
	}

}
