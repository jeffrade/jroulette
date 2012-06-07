package net.jroulette.web.mvc;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jroulette.web.domain.JRouletteWebUser;
import net.jroulette.web.util.JRouletteWebUtil;

import org.springframework.web.servlet.ModelAndView;

public class SettingsController  extends org.springframework.web.servlet.mvc.BaseCommandController {
	
	private static final String CLASS_NAME = SettingsController.class.getName();
	
	private static final Logger LOG = Logger.getLogger(CLASS_NAME);
	
	private String successView;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.info("enetering handleRequestInternal");
		ModelAndView mv = new ModelAndView(getSuccessView());
		final JRouletteWebUser user = (JRouletteWebUser) request.getSession().getAttribute(JRouletteWebUtil.JROULETTE_USER);
		request.setAttribute("IS_ACTIVE", user != null && user.isActive() ? "1" : "0");
		request.setAttribute("SEND_EMAILS", user != null && user.isSendEmails() ? "1" : "0");
		LOG.info("exiting handleRequestInternal");
		return mv;
	}
	
	public String getSuccessView() {
		return successView;
	}

	public void setSuccessView(String successView) {
		this.successView = successView;
	}
}