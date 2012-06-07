package net.jroulette.web.service.test;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

import org.gnu.stealthp.rsslib.RSSException;
import org.gnu.stealthp.rsslib.RSSItem;

import net.jroulette.service.rss.RSSService;
import junit.framework.TestCase;

public class RSSServiceTestCase extends TestCase{
	
	public void testGetRSSContent() throws RSSException, MalformedURLException, UnsupportedEncodingException{
		RSSService service = new RSSService();
		String content = service.getRSSHTMLContent("news");
		assertNotNull("content is null, check URI or path/file is correct", content);
		List<RSSItem> list = service.getRSSItemList("strategy");
		assertNotNull("RSSItem list is null, check URI or path/file is correct", list);
	}

}
