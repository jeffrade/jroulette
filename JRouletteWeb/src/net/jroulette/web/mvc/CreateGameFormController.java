package net.jroulette.web.mvc;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jroulette.web.domain.JRouletteWebUser;
import net.jroulette.web.domain.RoulettePlayer;
import net.jroulette.web.util.JRouletteBeanUtil;
import net.jroulette.web.util.JRouletteWebUtil;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.rade.jeff.main.data.JRouletteBean;
import com.rade.jeff.main.data.RandomNumberGeneratorImpl;
import com.rade.jeff.main.data.RouletteWheel;

public class CreateGameFormController extends SimpleFormController {

    private static final String CLASS_NAME = CreateGameFormController.class.getName();
    
    private static final Logger LOG = Logger.getLogger(CLASS_NAME);
    
    private static final String AMERICAN = "AMERICAN";

	private static final String MONEY = "money";
    
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
    	LOG.logp(Level.INFO, CLASS_NAME, "formBackingObject()", "");
		return super.formBackingObject(request);
	}
    
    protected Map referenceData(HttpServletRequest request, Object command, Errors errors) throws Exception {
    	LOG.logp(Level.INFO, CLASS_NAME, "refernceData()", "");
    	Map data = new HashMap();
    	JRouletteWebUser user = (JRouletteWebUser) request.getSession().getAttribute(JRouletteWebUtil.JROULETTE_USER);
    	RoulettePlayer player = null;
    	
    	if(user != null){
    		player = new RoulettePlayer();
    		player.setUserName(user.getUserName());
    		player.setEmail(user.getEmail());
    		data.put("userName", player.getUserName());
    		data.put("email", player.getEmail());
    	} else {
    		LOG.logp(Level.INFO, CLASS_NAME, "refernceData()", "user from session was null");
    		data.put("userName", "error?");
    		data.put("email", "error?");
    	}

		data.put("playerBean", player);
    	
    	return data;
	}

	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
    	LOG.logp(Level.INFO, CLASS_NAME, "onSubmit()", "");
    	
		ModelAndView mv = new ModelAndView(getSuccessView());
		JRouletteWebUser user = (JRouletteWebUser) request.getSession().getAttribute(JRouletteWebUtil.JROULETTE_USER);
		RoulettePlayer player = new RoulettePlayer();
		player.setUserName(user.getUserName());
		player.setEmail(user.getEmail());
		
		JRouletteBean bean = JRouletteBeanUtil.createJRouletteBean(user, request.getParameter(MONEY), request.getParameter("table").equalsIgnoreCase(AMERICAN));
		bean.getCasino().setRouletteWheel(new RouletteWheel(new RandomNumberGeneratorImpl(), bean.getNumberWheelCount()));
		
		mv.addObject("bean", bean); //TODO Need this?
		request.getSession().setAttribute("bean", bean);
		request.getSession().setAttribute("modelMap", mv.getModelMap());
		request.setAttribute("playerBean", player);
		
		System.out.println(CLASS_NAME + ": name=" + bean.getPlayer().getName());
		
		return mv;
    }
}
