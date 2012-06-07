package net.jroulette.web.mvc;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jroulette.service.rss.RSSService;

import org.gnu.stealthp.rsslib.RSSException;
import org.gnu.stealthp.rsslib.RSSItem;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.BaseCommandController;

public class RSSItemDisplayController extends BaseCommandController{
	
	private static final String CLASS_NAME = RSSItemDisplayController.class.getName();
	
	private static final String NEWS = "news";
	
	private static final String STRATEGY = "strategy";

	private static final String NEWS_TITLE = "News";

	private static final String STRATEGY_TITLE = "Strategy";
	
	private RSSService rssService = new RSSService();

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("In " + CLASS_NAME + ": type=" + request.getParameter("type").toString());
		String type = request.getParameter("type").toString();
		String content = null;
		String headerValue = null;
		//List<RSSItem> list = null;
		
		if(type.equalsIgnoreCase(NEWS)){
			headerValue = NEWS_TITLE;
		} else if(type.equalsIgnoreCase(STRATEGY)){
			headerValue = STRATEGY_TITLE;
		} else {
			System.out.println("ERROR, should not be here");
		}
		
		try {
			content = getRSSContent(type);
			//list = getRSSItemList();
			//System.out.println("time:0755");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RSSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView("itemsPage");
		//mv.addObject("content", content); //this encodes the html elements
		//mv.addObject("items", list);
		
		request.setAttribute("content", content);
		mv.addObject("headerValue", headerValue);
		System.out.println("Exiting " + CLASS_NAME);
		return mv;
	}
	
	private String getRSSContent(String type) throws RSSException, MalformedURLException, UnsupportedEncodingException{
		String retVal = null;
		
		retVal = rssService.getRSSHTMLContent(type);
		
		return retVal;
	}
	
	private List<RSSItem> getRSSItemList()throws RSSException, MalformedURLException{
		List<RSSItem> retVal = null;
		
		retVal = rssService.getRSSItemList("strategy");
		
		return retVal;
	}

	public RSSService getRssService() {
		return rssService;
	}

	public void setRssService(RSSService rssService) {
		this.rssService = rssService;
	}

}
