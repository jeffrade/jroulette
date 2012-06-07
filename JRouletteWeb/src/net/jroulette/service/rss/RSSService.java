package net.jroulette.service.rss;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

import org.gnu.stealthp.rsslib.RSSChannel;
import org.gnu.stealthp.rsslib.RSSException;
import org.gnu.stealthp.rsslib.RSSHandler;
import org.gnu.stealthp.rsslib.RSSItem;
import org.gnu.stealthp.rsslib.RSSParser;

public class RSSService {
	
	private static final String GMT_STRING = "GMT";
	
	private static final String EMPTY_STRING = "";

	private static final String NEWS = "news";
	
	private static final String STRATEGY = "strategy";

	private static final String DEFAULT_FILE = "";

	public String getRSSHTMLContent(String type) throws RSSException, MalformedURLException, UnsupportedEncodingException{
		String retVal = null;
		StringBuilder sb = new StringBuilder();
		LinkedList<RSSItem> list = retrieveRSSItems(type);
		
		int itemKey = 1;
		for(RSSItem item : list){
			if(item.getTitle() != null && !item.getTitle().isEmpty()){
				sb.append("<div id='item-" + itemKey + "' class='item'>");
				sb.append("<div id='title-" + itemKey + "' class='item-title'><b><a href='");
				sb.append(item.getLink());
				sb.append("' target='_new'>");
				sb.append(item.getTitle());
				sb.append("</a></b></div>");
				sb.append("<div id='description-" + itemKey + "' class='item-description'>");
				sb.append(item.getDescription() == null ? "" : item.getDescription());
				sb.append("</div>");
				sb.append("<div id='pubdate-" + itemKey + "' class='item-date'>");
				sb.append(item.getPubDate() == null ? "" : item.getPubDate().replaceAll(GMT_STRING, EMPTY_STRING));
				sb.append("</div>");
				//sb.append("	<div id='author-" + itemKey + "' class='item-author'>");
				//sb.append(item.getAuthor());
				//sb.append("	</div>");
				sb.append("</div>");
				sb.append("<br/><br/><br/>");
				itemKey++;
			}
		}
		
		//retVal = URLDecoder.decode(sb.toString(), "UTF-8");
		retVal = sb.toString();
		return retVal;
	}
	
	public LinkedList<RSSItem> getRSSItemList(String type) throws MalformedURLException, RSSException{
		return retrieveRSSItems(type);
	}
	
	private LinkedList<RSSItem> retrieveRSSItems(String type) throws MalformedURLException, RSSException{
		RSSHandler handler = new RSSHandler();
		boolean validating = true;
		String newsFile = "/home/jrade/workspace_play/JRouletteWeb/src/net/jroulette/web/resources/rss/casinogamblingweb.com-casino-gambling-news.xml";
		String strategyFile = "/home/jrade/workspace_play/JRouletteWeb/src/net/jroulette/web/resources/rss/gamblingteachers.com-Gambling-Teachers.xml";
		URL newsUrl = new URL("http://www.casinogamblingweb.com/casino-gambling-news.xml");
		URL strategyUrl = new URL("http://www.gamblingteachers.com/Gambling-Teachers.xml");
		
		String filename = null;
		URL url = null;
		
		if(type.equalsIgnoreCase(NEWS)){
			filename = newsFile;
			url = newsUrl;
		} else if (type.equalsIgnoreCase(STRATEGY)){
			filename = strategyFile;
			url = strategyUrl;
		} else {
			filename = DEFAULT_FILE;
			url = null;
		}
		
		boolean useRemoteUrl = true;
		try {
			url.openConnection().getContent();
		} catch (IOException e) {
			e.printStackTrace();
			useRemoteUrl = false; //RSS feed down, or no internet connection available
		} finally{
			if(useRemoteUrl){
				RSSParser.parseXmlFile(url, handler, validating);
			} else { //use local file
				RSSParser.parseXmlFile(filename, handler, validating);
			}
		}
		
		//File f = new File(filename);
		//System.out.println("can read file? " + f.canRead())
		
		RSSChannel channel = handler.getRSSChannel();
		return channel.getItems();
	}
}
