package net.jroulette.web.mvc;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jroulette.service.JRouletteService;
import net.jroulette.web.domain.JRouletteWebUser;
import net.jroulette.web.util.JRouletteWebUtil;

import org.springframework.web.servlet.ModelAndView;

public class ChangePasswordPageController extends org.springframework.web.servlet.mvc.BaseCommandController {
	
private static final String CLASS_NAME = ChangePasswordPageController.class.getName();
	
	private static final Logger LOG = Logger.getLogger(CLASS_NAME);
	
	private JRouletteService jrouletteService;
	
	private String formView;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.info("in onSubmit");
		ModelAndView mv = new ModelAndView(formView);
		JRouletteWebUser user = (JRouletteWebUser) request.getSession().getAttribute(JRouletteWebUtil.JROULETTE_USER);

		if(user != null){
			request.setAttribute("userName", user.getUserName());
		}
		
		LOG.info("exiting onSubmit");
		return mv;
	}
	
	public void setJrouletteService(JRouletteService jrouletteService) {
		this.jrouletteService = jrouletteService;
	}
	
	public void setFormView(String formView){
		this.formView = formView;
	}

	public String getFormView(){
		return this.formView;
	}

}