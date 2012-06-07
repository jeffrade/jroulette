package net.jroulette.web.mvc;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jroulette.service.JRouletteService;
import net.jroulette.web.domain.JRouletteWebUser;
import net.jroulette.web.domain.form.ChangePassword;
import net.jroulette.web.util.JRouletteWebUtil;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class ChangePasswordFormController extends SimpleFormController{
	
	private static final String CLASS_NAME = ChangePasswordFormController.class.getName();
	
	private static final Logger LOG = Logger.getLogger(CLASS_NAME);
	
	private JRouletteService jrouletteService;
	
	private String failedView;
	
	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		return super.formBackingObject(request);
	}
	
	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {
		LOG.logp(Level.INFO, CLASS_NAME, "refernceData()", "");
    	Map data = new HashMap();
    	JRouletteWebUser user = (JRouletteWebUser) request.getSession().getAttribute(JRouletteWebUtil.JROULETTE_USER);
    	
    	if(user != null){
    		data.put("userName", user.getUserName());
    		//data.put("email", user.getEmail());
    	} else {
    		LOG.logp(Level.INFO, CLASS_NAME, "refernceData()", "user from session was null");
    		data.put("userName", "error?");
    		//data.put("email", "error?");
    	}
    	
    	return data;
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {			
		LOG.info("in onSubmit");
		ModelAndView mv = new ModelAndView(getSuccessView());
		String errorMessages = null;
		JRouletteWebUser user = (JRouletteWebUser) request.getSession().getAttribute(JRouletteWebUtil.JROULETTE_USER);
		ChangePassword commObj = (ChangePassword) command;
		
		LOG.info(command.getClass().getName());
		
		JRouletteWebUser validUser = jrouletteService.findUserByEmailValidatePassword(user == null ? "" : user.getEmail(), commObj.getPassword());
		
		if(validUser != null){
			//TODO add update password in jrouletteService
			LOG.info("TODO add update password in jrouletteService");
		} else{
			mv.setViewName(failedView);
			errorMessages = "Password was incorrect for user with email " + user.getEmail();
		}

		request.setAttribute("ERROR_MESSAGES", errorMessages);
		request.setAttribute("user2", commObj);
		request.setAttribute("userName", user.getUserName());
		
		LOG.info("exiting onSubmit");
		return mv;
	}
	
	public void setJrouletteService(JRouletteService jrouletteService) {
		this.jrouletteService = jrouletteService;
	}
	
	public void setFailedView(String failedView){
		this.failedView = failedView;
	}

}
