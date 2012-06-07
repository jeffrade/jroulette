package net.jroulette.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import net.jroulette.web.domain.JRouletteWebUser;
import net.jroulette.web.util.JRouletteWebUtil;

public class JRouletteDAOImpl extends SimpleJdbcDaoSupport implements JRouletteDAO {
	
	private static final String INSERT_USER_SQL = "INSERT INTO jroulette_user (user_name, first_name, last_name, email, password, send_emails, active, registered, last_login) VALUES (?,?,?,?,?,?,?,?,?)";
	
	private static final String INSERT_USER_AUTHORITY_SQL = "INSERT INTO authorities (juser_id, authority) VALUES (?,?)";
	
	private static final String SELECT_BY_USER_NAME_SQL = "SELECT * from jroulette_user WHERE user_name = ?";
	
	private static final String SELECT_BY_ID_SQL = "SELECT * from jroulette_user WHERE id = ?";
	
	private static final String SELECT_BY_EMAIL_SQL = "SELECT * from jroulette_user WHERE email = ?";
	
	private static final String SELECT_EMAIL_BY_EMAIL = "SELECT email from jroulette_user where email = ?";
	
	private static final String SELECT_USERNAME_BY_USERNAME = "SELECT email from jroulette_user where user_name = ?";
	
	private static final String SELECT_PASSWORD_BY_EMAIL = "SELECT password from jroulette_user where email = ?";
	
	private static final String UPDATE_USER_TO_BE_ADDED = "UPDATE jroulette_user SET first_name = ?, last_name = ?, password = ?, active = 1, send_emails = ?, registered = ?, last_login = ? WHERE user_name = ?";
	
	private static final String UPDATE_USER_LAST_LOGIN_BY_ID = "UPDATE jroulette_user SET last_login = ? WHERE id = ?";
	
	private static final String UPDATE_PASSWORD_BY_ID = "UPDATE jroulette_user SET password = ? WHERE id = ?";
	
	private static final String UPDATE_SET_ACTIVE_FOR_USER_BY_ID = "UPDATE jroulette_user SET active = ? WHERE id = ?";
	
	private static final String UPDATE_SET_ACTIVE_FOR_USER_BY_EMAIL = "UPDATE jroulette_user SET active = ? WHERE email = ?";
	
	private static final String UPDATE_SEND_EMAILS_BY_ID = "UPDATE jroulette_user SET send_emails = ? WHERE id = ?";
	
	private static final String SELECT_ACTIVE_USER_EMAILS = "SELECT email FROM jroulette_user WHERE active = 1";
	
	private static final String SELECT_ACTIVE_USER_EMAILS_WHERE_SEND_EMAIL = "SELECT email FROM jroulette_user WHERE active = 1 AND send_email = ?";
	
	private static final String DESC_JROULETTE_USER_TABLE = "desc jroulette_user";
	
	private static final String ID_COL = "id";
	
	private static final String USER_NAME_COL = "user_name";
	
	private static final String FIRST_NAME_COL = "first_name";
	
	private static final String LAST_NAME_COL = "last_name";
	
	private static final String EMAIL_COL = "email";
	
	private static final String PASSWORD_COL = "password";
	
	private static final String SEND_EMAILS_COL = "send_emails";
	
	private static final String ACTIVE_COL = "active";
	
	private static final String REGISTERED_COL = "registered";
	
	private static final String LAST_LOGIN_COL = "last_login";
	
	private static final String TINY_INT_TRUE_VALUE = "true";

	private static final String CLASS_NAME = JRouletteDAOImpl.class.getName();
	
	private static final Logger LOG = Logger.getLogger(CLASS_NAME);

	@Override
	public boolean addUser(JRouletteWebUser user) {
		if(user != null){
			LOG.fine("Will try to add user: " + "," + user.getUserName() + "," + user.getFirstName() + "," + user.getLastName() + "," + user.getEmail() + "," + user.getPassword() + "," + user.isSendEmails() + "," + user.isActive() + "," + user.getRegistered() + "," + user.getLastLogin());
			boolean retVal = 0 != getSimpleJdbcTemplate().update(INSERT_USER_SQL, user.getUserName(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.isSendEmails(), user.isActive(), user.getRegistered(), user.getLastLogin());
			
			//TODO check if user was added. If so, then get the PK of that user and add entry in authorities table (i.e. insertUserAuthority())  
			
			return retVal;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateUserById(JRouletteWebUser user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public JRouletteWebUser findUserByEmail(String email){
		JRouletteWebUser user = null;
		List<Map<String, Object>> rs = null;
		
		rs = getSimpleJdbcTemplate().queryForList(SELECT_BY_EMAIL_SQL, email);
		
		if(rs != null && !rs.isEmpty()){
			user = JRouletteWebUtil.createJRouletteWebUser(Long.valueOf(rs.get(0).get(ID_COL).toString()).longValue(), rs.get(0).get(USER_NAME_COL).toString(), rs.get(0).get(FIRST_NAME_COL).toString(), rs.get(0).get(LAST_NAME_COL).toString(), rs.get(0).get(EMAIL_COL).toString(), TINY_INT_TRUE_VALUE.equals(rs.get(0).get(SEND_EMAILS_COL).toString()), TINY_INT_TRUE_VALUE.equals(rs.get(0).get(ACTIVE_COL).toString()), rs.get(0).get(PASSWORD_COL).toString(), (Timestamp) rs.get(0).get(REGISTERED_COL), (Timestamp) rs.get(0).get(LAST_LOGIN_COL));
		} else {
			LOG.info(CLASS_NAME + ": user not found with email=" + email);
		}
		
		return user;
	}
	
	@Override
	public JRouletteWebUser findUserByUserName(String userName){
		JRouletteWebUser user = null;
		List<Map<String, Object>> rs = null;
		
		rs = getSimpleJdbcTemplate().queryForList(SELECT_BY_USER_NAME_SQL, userName);
		
		if(rs != null && !rs.isEmpty()){
			user = JRouletteWebUtil.createJRouletteWebUser(Long.valueOf(rs.get(0).get(ID_COL).toString()).longValue(), rs.get(0).get(USER_NAME_COL).toString(), rs.get(0).get(FIRST_NAME_COL).toString(), rs.get(0).get(LAST_NAME_COL).toString(), rs.get(0).get(EMAIL_COL).toString(), rs.get(0).get(SEND_EMAILS_COL).toString().equals("1"), rs.get(0).get(ACTIVE_COL).toString().equals("1"), rs.get(0).get(PASSWORD_COL).toString(), (Timestamp) rs.get(0).get(REGISTERED_COL), (Timestamp) rs.get(0).get(LAST_LOGIN_COL));
		} else{
			LOG.info("User not found with userName = " + userName);
		}
		
		return user;
	}

	@Override
	public boolean isEmailUnique(String email) {
		boolean retVal = false;
		List<Map<String, Object>> results = getSimpleJdbcTemplate().queryForList(SELECT_EMAIL_BY_EMAIL, email);
		
		/*
		for(Map<String, Object> map : results){
			for(String key : map.keySet()){
				Object value = map.get(key);
				System.out.println(CLASS_NAME + ": [key:value]=" + key + ":" + value);
			}
		}
		*/
		
		retVal = results.isEmpty();
		return retVal;
	}

	@Override
	public boolean isUserNameUnique(String userName) {
		return getSimpleJdbcTemplate().queryForList(SELECT_USERNAME_BY_USERNAME, userName).isEmpty();
	}

	@Override
	public boolean updateUserByEmail(JRouletteWebUser user) {
		return getSimpleJdbcTemplate().update(UPDATE_USER_TO_BE_ADDED, user.getFirstName(), user.getLastName(), user.getPassword(), user.isSendEmails(), user.getRegistered(), user.getLastLogin(), user.getUserName()) == 1;
	}

	@Override
	public boolean updateUserLastLogin(long userId, Timestamp time) {
		return getSimpleJdbcTemplate().update(UPDATE_USER_LAST_LOGIN_BY_ID, time, userId) == 1;
	}

	@Override
	public String findPasswordByEmail(String email) {
		String password = null;
		
		List<Map<String,Object>> rs = getSimpleJdbcTemplate().queryForList(SELECT_PASSWORD_BY_EMAIL, email);
		
		if(rs != null && !rs.isEmpty()){
			password = rs.get(0).get("password").toString();
		}
		
		return password;
	}

	@Override
	public JRouletteWebUser findUserByEmailValidatePassword(String email, String password) {
		JRouletteWebUser user = findUserByEmail(email);
		boolean isPasswordValid = false;
		
		if(user != null){
			isPasswordValid = user.getPassword().equals(password);
			LOG.info(CLASS_NAME + " [comparing passwords]: user.getPassword()=" + user.getPassword() + ", password=" + password);
		} else{
			LOG.info(CLASS_NAME + ": user was null, could not find user by email");
		}
		
		LOG.info(CLASS_NAME + ": is password correct? " + isPasswordValid);
		
		return isPasswordValid ? user : null;
	}

	@Override
	public boolean updateUserPasswordById(final long id, final String newPassword) {
		return getSimpleJdbcTemplate().update(UPDATE_PASSWORD_BY_ID, newPassword, id) > 0;
	}

	@Override
	public boolean setActiveUserById(final long id, final boolean active) {
		return getSimpleJdbcTemplate().update(UPDATE_SET_ACTIVE_FOR_USER_BY_ID, active, id) > 0;
	}

	@Override
	public boolean setActiveUserById(String email, boolean active) {
		return getSimpleJdbcTemplate().update(UPDATE_SET_ACTIVE_FOR_USER_BY_EMAIL, active, email) > 0;
	}

	@Override
	public void pingDatabase() {
		LOG.finest("entering pingDatabase()");
		getSimpleJdbcTemplate().queryForList(DESC_JROULETTE_USER_TABLE);
		LOG.finest("exiting pingDatabase()");
	}
	
	@Override
	public JRouletteWebUser queryUserById(final long id){
		JRouletteWebUser user = null;
		List<Map<String, Object>> rs = null;
		
		rs = getSimpleJdbcTemplate().queryForList(SELECT_BY_ID_SQL, id);
		
		if(rs != null && !rs.isEmpty()){
			user = JRouletteWebUtil.createJRouletteWebUser(Long.valueOf(rs.get(0).get(ID_COL).toString()).longValue(), rs.get(0).get(USER_NAME_COL).toString(), rs.get(0).get(FIRST_NAME_COL).toString(), rs.get(0).get(LAST_NAME_COL).toString(), rs.get(0).get(EMAIL_COL).toString(), rs.get(0).get(SEND_EMAILS_COL).toString().equals("1"), rs.get(0).get(ACTIVE_COL).toString().equals("1"), rs.get(0).get(PASSWORD_COL).toString(), (Timestamp) rs.get(0).get(REGISTERED_COL), (Timestamp) rs.get(0).get(LAST_LOGIN_COL));
		} else{
			LOG.info("User not found with userName = " + id);
		}
		
		return user;
	}

	@Override
	public boolean updateUserEmailPreferenceById(long id, boolean sendEmail) {
		return getSimpleJdbcTemplate().update(UPDATE_SEND_EMAILS_BY_ID, sendEmail, id) > 0;
	}

	@Override
	public List<String> queryActiveUserEmailsByEmailPreference(boolean sendEmail) {
		List<String> retVal = null;
		List<Map<String, Object>> rs = getSimpleJdbcTemplate().queryForList(SELECT_ACTIVE_USER_EMAILS_WHERE_SEND_EMAIL, sendEmail);
		
		if(rs != null){
			retVal = new ArrayList<String>();
			for(Map<String, Object> map : rs){
				retVal.add(map.get(EMAIL_COL).toString());
			}
		}
		
		return retVal;
	}
	
	@Override
	public boolean insertUserAuthority(long userId, String userRole){
		return getSimpleJdbcTemplate().update(INSERT_USER_AUTHORITY_SQL, userId, userRole) == 1;
	}
}