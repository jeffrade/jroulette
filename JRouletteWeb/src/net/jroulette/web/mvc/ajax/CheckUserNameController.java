package net.jroulette.web.mvc.ajax;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jroulette.service.JRouletteService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.BaseCommandController;

public class CheckUserNameController extends BaseCommandController{
	
	private static final String CLASS_NAME = CheckUserNameController.class.getName();
	
	private static final Logger LOG = Logger.getLogger(CLASS_NAME);
	
	private static final String USER_NAME_PARAM = "userName";
		
	private static final String RESPONSE_CONTENT_TYPE = "text/html";
	
	private JRouletteService jrouletteService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.finer("in handleRequestInternal()");
		final String userName = request.getParameter(USER_NAME_PARAM).toString();
		final boolean isUserNameAvailable = jrouletteService.isUserNameUnique(userName);
		
		response.setContentType(RESPONSE_CONTENT_TYPE);
		response.getWriter().print(isUserNameAvailable);
		
		LOG.finer("exiting handleRequestInternal(): " + isUserNameAvailable);
		return null;
	}
	
	public void setJrouletteService(JRouletteService jrouletteService) {
		this.jrouletteService = jrouletteService;
	}

}