package net.jroulette.web.mvc;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jroulette.web.domain.JRouletteWebUser;
import net.jroulette.web.util.JRouletteBeanUtil;
import net.jroulette.web.util.JRouletteWebUtil;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.rade.jeff.main.JRouletteGame;
import com.rade.jeff.main.data.JRouletteBean;

public class PlayControllerNew extends AbstractCommandController {

	private static final String CLASS_NAME = PlayControllerNew.class.getName();
	
	private static final Logger LOG = Logger.getLogger(CLASS_NAME);

	private static final String PAGE_VIEW = "table_new";

	private static final String BEAN = "bean";

	private static final String GAME = "game";

	private static final String MODEL_MAP = "modelMap";

	private static final String NEW_GAME = "new";
	
	private JRouletteGame game;
	
	public PlayControllerNew(){
		super();
	}
	
	@Override
	protected ModelAndView handle(HttpServletRequest req, HttpServletResponse res, Object arg2, BindException arg3) throws Exception {
		LOG.logp(Level.FINER, CLASS_NAME, "handle", "entering handle() method: [host:port,user] = [" + req.getRemoteHost() + ":" + req.getRemotePort() + "," + req.getRemoteUser() + "]");
		
		boolean newGame = false;
		if(req.getParameter("g") != null){
			newGame = req.getParameter("g").toString().equalsIgnoreCase(NEW_GAME) ? true : false;
			LOG.logp(Level.FINER, CLASS_NAME, "handle", " new game requested ? " + newGame);
		}
		
		ModelAndView mv = new ModelAndView();
		Map modelMap = null;
		if(!newGame && req.getSession() != null && req.getSession().getAttribute("modelMap") != null){
			modelMap = (Map) req.getSession().getAttribute("modelMap");
			LOG.logp(Level.FINER, CLASS_NAME, "handle", " found session, got modelMap object");
		} else {
			modelMap = new HashMap();
			LOG.logp(Level.FINER, CLASS_NAME, "handle", "session or modelMap obj is null, instantiate new modelMap object");
		}
		
		JRouletteBean bean = null;
		if(!newGame && modelMap.get("bean") != null){
			bean = (JRouletteBean) modelMap.get("bean");
			LOG.logp(Level.FINER, CLASS_NAME, "handle", " found bean: " + bean.getPlayer().getName());
		} else if(newGame && req.getSession().getAttribute("isRegistered") != null && req.getSession().getAttribute("isRegistered").toString().equalsIgnoreCase("1")){
			final String userName = ((JRouletteWebUser) req.getSession().getAttribute(JRouletteWebUtil.JROULETTE_USER)).getUserName();
			bean = JRouletteBeanUtil.createJRouletteBean(userName);
			LOG.logp(Level.FINER, CLASS_NAME, "handle", " new game requested but session is registered: " + userName);
		} else {
			bean = JRouletteBeanUtil.createJRouletteBean();
			LOG.logp(Level.FINER, CLASS_NAME, "handle", "had to create a default bean");
		}
		
		//TODO what is the purpose of the ModelAndView object?  Read the Spring Javadocs.
		mv.addObject(BEAN, bean);
		mv.addObject(GAME, game);
		mv.setViewName(PAGE_VIEW);
		
		req.getSession().setAttribute(GAME, game);
		req.getSession().setAttribute(BEAN, bean);
		req.getSession().setAttribute(MODEL_MAP, mv.getModelMap());
		
		return mv;
	}	

	public void setGame(JRouletteGame game){
		this.game = game;
	}
	
	public JRouletteGame getGame(){
		return game;
	}

}