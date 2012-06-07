package net.jroulette.dao;

import java.sql.Timestamp;
import java.util.List;

import net.jroulette.web.domain.JRouletteWebUser;

public interface JRouletteDAO {
	
	boolean addUser(JRouletteWebUser user);
	
	boolean updateUserById(JRouletteWebUser user);
	
	boolean updateUserByEmail(JRouletteWebUser user);
	
	JRouletteWebUser findUserByUserName(String userName);
	
	JRouletteWebUser findUserByEmail(String email);
	
	boolean isEmailUnique(String email);
	
	boolean isUserNameUnique(String userName);

	boolean updateUserLastLogin(long userId, Timestamp time);
	
	String findPasswordByEmail(String email);

	JRouletteWebUser findUserByEmailValidatePassword(String email, String password);

	boolean updateUserPasswordById(long id, String newPassword);
	
	boolean setActiveUserById(long id, boolean active);

	boolean setActiveUserById(String email, boolean active);

	void pingDatabase();

	JRouletteWebUser queryUserById(long id);

	boolean updateUserEmailPreferenceById(long id, boolean sendEmail);
	
	List<String> queryActiveUserEmailsByEmailPreference(boolean sendEmail);
	
	public boolean insertUserAuthority(long userId, String userRole);

}
