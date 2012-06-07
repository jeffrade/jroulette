package net.jroulette.web.mvc;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jroulette.service.JRouletteService;
import net.jroulette.web.domain.JRouletteWebUser;
import net.jroulette.web.util.JRouletteWebUtil;

import org.springframework.web.servlet.ModelAndView;

public class ToggleUserEmailPrefController  extends org.springframework.web.servlet.mvc.BaseCommandController {
	
	private static final String CLASS_NAME = ToggleUserEmailPrefController.class.getName();
	
	private static final Logger LOG = Logger.getLogger(CLASS_NAME);

	private static final String ACTIVATED_MESSAGE = "Thank you for joining our email list.  You will periodically receive deals from our real live casino partners.";

	private static final String DEACTIVATED_MESSAGE = "You have been removed from our email list.  Check back later as live online casinos distribute deals on our site.";
	
	private JRouletteService jrouletteService;
	
	private String successView;
	
	private String failedView;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.info("enetering handleRequestInternal");
		ModelAndView mv = new ModelAndView();
		final JRouletteWebUser user = (JRouletteWebUser) request.getSession().getAttribute(JRouletteWebUtil.JROULETTE_USER);
		final String sendEmailParameter = request.getParameter("se");
		boolean updated = false;
		boolean sendEmail = sendEmailParameter != null && sendEmailParameter.equals("1");
		
		if(user != null){
			updated = jrouletteService.changeUserEmailPreference(user.getId(), sendEmail);
			user.setSendEmails(sendEmail);  //TODO test this
			LOG.info("sendEmail=" + sendEmail + ", user.isSendEmails()=" + user.isSendEmails() + ", sendEmailParameter=" + sendEmailParameter);
			request.setAttribute("SEND_EMAILS", user.isSendEmails() ? "1" : "0");
		} else{
			LOG.info("ERROR, could not find user in session object: Tried user=" + user);
		}
		
		if(updated){
			user.setIsActive(sendEmail);
			request.setAttribute("MESSAGE", sendEmail ? ACTIVATED_MESSAGE : DEACTIVATED_MESSAGE);
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
