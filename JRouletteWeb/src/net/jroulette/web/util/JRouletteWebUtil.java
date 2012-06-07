package net.jroulette.web.util;

import java.sql.Timestamp;
import java.util.logging.Logger;

import net.jroulette.web.domain.JRouletteWebUser;

public class JRouletteWebUtil {
	
	private static final String CLASS_NAME = JRouletteWebUtil.class.getName();
	
	private static final Logger LOG = Logger.getLogger(CLASS_NAME);
	
	public static final String JROULETTE_USER = "JROULETTE_USER";

	public static final String SESSION_EXPIRED_MESSAGE = "Your session has expired, please sign in again";

	public static JRouletteWebUser createJRouletteWebUser(final long id, final String userName, final String firstName, final String lastName, final String email, final boolean sendEmails, final boolean isActive, final String password, final Timestamp registered, final Timestamp lastLogin) {
		JRouletteWebUser user = new JRouletteWebUser();
		LOG.info(id + ", " + userName + ", " + firstName + ", " + lastName + ", " + email + ", " + isActive + ", " + sendEmails + ", " + password + ", " + registered + ", " + lastLogin);
		user.setId(id);
		user.setUserName(userName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setIsActive(isActive);
		user.setSendEmails(sendEmails);
		user.setPassword(password);
		user.setRegistered(registered);
		user.setLastLogin(lastLogin);
		
		return user;
	}

}