package net.jroulette.web.mvc;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jroulette.service.JRouletteService;
import net.jroulette.web.domain.JRouletteWebUser;
import net.jroulette.web.util.JRouletteWebUtil;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class RegisterUserFormController extends SimpleFormController {
	
	private static final String CLASS_NAME = RegisterUserFormController.class.getName();
	
	private static final Logger LOG = Logger.getLogger(CLASS_NAME);

	private static final String PIPE = "\\|";

	private static final String HTML_BREAK_TAG = "<br/>";
	
	private JRouletteService jrouletteService;
	
	private String failedView;
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
    	LOG.logp(Level.FINER, CLASS_NAME, "formBackingObject()", "");
		return super.formBackingObject(request);
	}
	
	protected Map referenceData(HttpServletRequest request, Object command, Errors errors) throws Exception {
    	LOG.logp(Level.INFO, CLASS_NAME, "refernceData()", "");
    	return super.referenceData(request, command, errors);
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {			
		ModelAndView mv = new ModelAndView(getSuccessView());
		JRouletteWebUser user = (JRouletteWebUser) command;
		user.setIsActive(true);
		Timestamp now = new Timestamp(Calendar.getInstance().getTime().getTime());
		user.setRegistered(now);
		user.setLastLogin(now);
		
		String errorMessages = jrouletteService.addNewUser(user);
		LOG.info("### New User: " + user.toString());
		LOG.info("### Is new user added? " + (errorMessages == null));
		
		if(errorMessages != null){
			errorMessages = errorMessages.replaceAll(PIPE, HTML_BREAK_TAG);
			mv.setViewName(failedView);
			LOG.info(CLASS_NAME + ": A new JRouletteWebUser was not added to the database! Error Messages: " + errorMessages);
		}
		
		request.getSession().setAttribute(JRouletteWebUtil.JROULETTE_USER, user);
		request.getSession().setAttribute("isRegistered", errorMessages == null ? "1" : "0");
		request.setAttribute("ERROR_MESSAGES", errorMessages);
		request.setAttribute("user", user);
		
		return mv;
	}
	
	public JRouletteService getJrouletteService() {
		return jrouletteService;
	}

	public void setJrouletteService(JRouletteService jrouletteService) {
		this.jrouletteService = jrouletteService;
	}
	
	public void setFailedView(String failedView){
		this.failedView = failedView;
	}
}
