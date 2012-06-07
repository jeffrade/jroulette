package net.jroulette.service.ajax;

import net.jroulette.service.JRouletteService;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class JRouletteBeanContextServiceImpl {
/*	
	private static final String CLASS_NAME = JRouletteBeanContextServiceImpl.class.getName();

	//TODO put this in a properties file
	//private static final String CONTEXT_FILE_PATH_NAME = "/home/jrade/workspace_play/JRouletteWeb/WebContent/WEB-INF/jroulette-servlet.xml";
	private static final String CONTEXT_FILE_PATH_NAME = "/home/jrade/workspace_play/JRouletteWeb/WebContent/WEB-INF/jroulette-servlet.xml";
	
	private static final JRouletteBeanContextServiceImpl SINGLETON = new JRouletteBeanContextServiceImpl();
	
	private static final BeanFactory FACTORY = new XmlBeanFactory(new FileSystemResource(CONTEXT_FILE_PATH_NAME)); //p.13 SpringInAction
	
	private static final JRouletteService SERVICE = (JRouletteService) FACTORY.getBean("JRouletteService");
	
	private JRouletteBeanContextServiceImpl(){
		super();
	}
	
	public static JRouletteBeanContextServiceImpl getInstance(){
		return SINGLETON;
	}
	
	public boolean isEmailUnique(String email){
		return SERVICE.isEmailUnique(email);
	}
	
	public boolean isUserNameUnique(String userName){
		return SERVICE.isUserNameUnique(userName);
	}
*/
}
