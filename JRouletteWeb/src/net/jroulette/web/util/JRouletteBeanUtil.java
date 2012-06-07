package net.jroulette.web.util;

import net.jroulette.web.domain.JRouletteWebUser;
import net.jroulette.web.domain.RoulettePlayer;

import com.rade.jeff.main.Casino;
import com.rade.jeff.main.data.JRouletteBean;
import com.rade.jeff.main.data.RandomNumberGeneratorImpl;
import com.rade.jeff.main.data.RouletteWheel;
import com.rade.jeff.main.player.Player;
import com.rade.jeff.main.player.PlayerBank;

public class JRouletteBeanUtil {
	
	private static final String GUEST = "Guest";
	
	private static final int DEFAULT_MONEY = 1000;
	
	private static final int DEFAULT_TABLE = RouletteWheel.AMERICAN_NUMBERS;

	private static final String CLASS_NAME = JRouletteBeanUtil.class.getName();
	
	public static JRouletteBean createJRouletteBean(){
		JRouletteBean bean = new JRouletteBean();
		bean.setCasino(new Casino());
		Player player = new Player();
		player.setName(GUEST);
		player.setPlayerBank(new PlayerBank(DEFAULT_MONEY));
		bean.setPlayer(player);
		bean.setNumberWheelCount(DEFAULT_TABLE);
		bean.getCasino().setRouletteWheel(new RouletteWheel(new RandomNumberGeneratorImpl(), bean.getNumberWheelCount()));
		return bean;
	}

	public static JRouletteBean createJRouletteBean(final JRouletteWebUser user, final String money, final boolean isAmericanTable) {
		JRouletteBean bean = new JRouletteBean();
		bean.setCasino(new Casino());
		Player player = new Player();
		player.setName(user.getUserName());
		player.setPlayerBank(new PlayerBank(Integer.valueOf(money)));
		bean.setPlayer(player);
		bean.setNumberWheelCount(isAmericanTable ? RouletteWheel.AMERICAN_NUMBERS : RouletteWheel.EUROPEAN_NUMBERS);
		bean.getCasino().setRouletteWheel(new RouletteWheel(new RandomNumberGeneratorImpl(), bean.getNumberWheelCount()));
		
		System.out.println(CLASS_NAME + ": name=" + bean.getPlayer().getName());
		
		return bean;
	}

	public static JRouletteBean createJRouletteBean(final String userName) {
		JRouletteBean bean = new JRouletteBean();
		bean.setCasino(new Casino());
		Player player = new Player();
		player.setName(userName);
		player.setPlayerBank(new PlayerBank(DEFAULT_MONEY));
		bean.setPlayer(player);
		bean.setNumberWheelCount(DEFAULT_TABLE);
		bean.getCasino().setRouletteWheel(new RouletteWheel(new RandomNumberGeneratorImpl(), bean.getNumberWheelCount()));
		return bean;
	}
	
}
