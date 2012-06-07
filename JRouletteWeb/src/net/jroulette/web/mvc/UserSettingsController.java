package net.jroulette.web.mvc;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jroulette.web.domain.JRouletteWebUser;
import net.jroulette.web.util.JRouletteWebUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class UserSettingsController extends AbstractController {
	
	private static final String CLASS_NAME = UserSettingsController.class.getName();
	
	private static final Logger LOG = Logger.getLogger(CLASS_NAME);
	
	private static final String VIEW = "settings";

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.info("in handleRequestInternal");
		ModelAndView mv = new ModelAndView(VIEW);
		
		JRouletteWebUser user = (JRouletteWebUser) request.getSession().getAttribute(JRouletteWebUtil.JROULETTE_USER);
		LOG.info(user == null ? "did not find JRouletteWebUser object in session attributes" : user.toString());
		
		LOG.info("exiting handleRequestInternal");
		return mv;
	}

}
