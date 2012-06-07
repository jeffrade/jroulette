package net.jroulette.service.util;

import java.util.TimerTask;
import java.util.logging.Logger;

import net.jroulette.dao.JRouletteDAO;

public class PingDBTimerTask extends TimerTask {
	
	private static final String CLASS_NAME = PingDBTimerTask.class.getName();
	
	private static final Logger LOG = Logger.getLogger(CLASS_NAME);
	
	private JRouletteDAO jrouletteDAO;

	@Override
	public void run() {
		try{
			jrouletteDAO.pingDatabase();
		} catch (Exception e){
			LOG.info("Problem running scheduled timer task");
			e.printStackTrace();
		}
	}

	public void setJrouletteDAO(JRouletteDAO jrouletteDAO) {
		this.jrouletteDAO = jrouletteDAO;
	}
}