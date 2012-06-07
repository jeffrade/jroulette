package net.jroulette.service;

import java.sql.Timestamp;

import net.jroulette.web.domain.JRouletteWebUser;

public interface JRouletteService {
	
	String addNewUser(JRouletteWebUser user);
	
	JRouletteWebUser findUserByEmail(String email);
	
	JRouletteWebUser findUserByUserName(String userName);
	
	boolean isEmailUnique(String email);
	
	boolean isUserNameUnique(String userName);

	boolean updateUserLastLogin(long userId, Timestamp time);
	
	boolean emailPasswordToUser(String email);

	JRouletteWebUser findUserByEmailValidatePassword(String email, String password);

	boolean changeUserPassword(long id, String password, String email);
	
	boolean changeActiveUserAccount(long id, boolean active);

	boolean changeActiveUserAccount(String email, boolean active);

	JRouletteWebUser findUserById(long id);

	boolean changeUserEmailPreference(long id, boolean sendEmail);
	
	boolean getActiveUserEmailsByEmailPreference(boolean sendEmail);

}
