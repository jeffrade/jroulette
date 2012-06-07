package net.jroulette.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import net.jroulette.dao.JRouletteDAO;
import net.jroulette.web.domain.JRouletteWebUser;

public class JRouletteServiceImpl implements JRouletteService {
	
	private static final String CLASS_NAME = JRouletteServiceImpl.class.getName();
	
	private static final Logger LOG = Logger.getLogger(CLASS_NAME);
	
	private JRouletteDAO jrouletteDAO;
	
	private JavaMailSenderImpl mailSender;
	
	private SimpleMailMessage welcomeMessage;
	
	private SimpleMailMessage forgotPasswordMessage;
	
	private SimpleMailMessage changedPasswordMessage;
	
	private boolean DEV;
	
	private static final String USER_NAME_TOKEN = "@USERNAME@";
	
	private static final String USER_USERNAME_TOKEN = "@USERUSERNAME@";
	
	private static final String USER_EMAIL_TOKEN = "@USEREMAIL@";
	
	private static final String USER_PASSWORD_TOKEN = "@PASSWORD@";

	private static final String SPACE = " ";

	@Override
	public String addNewUser(JRouletteWebUser user){
		String retVal = null;
		boolean userAdded = false;
		
		try{
			LOG.info("looking for user in db:" + user.getEmail() + "," + user.getUserName());
			JRouletteWebUser userByEmail = jrouletteDAO.findUserByEmail(user.getEmail());
			JRouletteWebUser userByUserName = jrouletteDAO.findUserByUserName(user.getUserName());
			
			LOG.finest("userByEmail == null:" + (userByEmail == null) + ", userByUserName == null:" + (userByUserName == null));
			
			if(userByEmail == null && userByUserName == null){
				userAdded = jrouletteDAO.addUser(user);
			} else {
				retVal = userByEmail != null ? "A user with that email already exists|" : "";
				retVal += userByUserName != null ? "A user with that user name already exists" : "";
			}
		} catch (Exception e){
			e.printStackTrace();
			LOG.logp(Level.INFO, CLASS_NAME, "addNewUser", "something went wrong when trying to add user:" + user.toString());
		} finally{
				SimpleMailMessage message = new SimpleMailMessage(welcomeMessage);
				message.setTo(welcomeMessage.getTo()[0].replaceAll(USER_NAME_TOKEN, user.getFirstName() + SPACE + user.getLastName()).replaceAll(USER_EMAIL_TOKEN, user.getEmail()));
				message.setText(welcomeMessage.getText().replaceAll(USER_PASSWORD_TOKEN, user.getPassword()).replaceAll(USER_USERNAME_TOKEN, user.getUserName()));
				message.setSentDate(new Date());
				LOG.info("Message To=" + message.getTo()[0]);
				LOG.info("Message Text=" + message.getText());
			if(userAdded && !DEV){
				mailSender.send(message);
			}
		}
		
		return retVal;
	}

	@Override
	public JRouletteWebUser findUserByEmail(String email) {
		return jrouletteDAO.findUserByEmail(email);
	}

	@Override
	public JRouletteWebUser findUserByUserName(String userName) {
		return jrouletteDAO.findUserByUserName(userName);
	}

	@Override
	public boolean isEmailUnique(String email) {
		return jrouletteDAO.isEmailUnique(email);
	}

	@Override
	public boolean isUserNameUnique(String userName) {
		return jrouletteDAO.isUserNameUnique(userName);
	}	

	@Override
	public boolean updateUserLastLogin(long userId, Timestamp time) {
		return jrouletteDAO.updateUserLastLogin(userId, time);
	}
	
	public boolean emailPasswordToUser(String email){
		String password = null;
		
		password = jrouletteDAO.findPasswordByEmail(email);
		
		if(password != null){
			SimpleMailMessage message = new SimpleMailMessage(forgotPasswordMessage);
			message.setTo(forgotPasswordMessage.getTo()[0].replaceAll(USER_EMAIL_TOKEN, email));
			message.setText(forgotPasswordMessage.getText().replaceAll(USER_PASSWORD_TOKEN, password));
			LOG.info("message To=" + message.getTo());
			LOG.info("message Text=" + message.getText());
			message.setSentDate(new Date());
			if(!DEV){
				mailSender.send(message);
			}
		}
		
		return password != null;
	}

	@Override
	public JRouletteWebUser findUserByEmailValidatePassword(String email, String password) {
		JRouletteWebUser user = null;
		
		user = jrouletteDAO.findUserByEmailValidatePassword(email, password);
		
		return user;
	}

	@Override
	public boolean changeUserPassword(final long id, final String newPassword, final String email) {
		boolean retVal = false;
		
		retVal = jrouletteDAO.updateUserPasswordById(id, newPassword);
		
		if(newPassword != null && retVal){
			SimpleMailMessage message = new SimpleMailMessage(changedPasswordMessage);
			message.setTo(forgotPasswordMessage.getTo()[0].replaceAll(USER_EMAIL_TOKEN, email));
			message.setText(forgotPasswordMessage.getText().replaceAll(USER_PASSWORD_TOKEN, newPassword));
			message.setSentDate(new Date());
			LOG.info("message To=" + message.getTo());
			LOG.info("message Text=" + message.getText());
			if(!DEV){
				mailSender.send(message);
			}
		}
		
		return retVal;
	}

	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}

	public void setWelcomeMessage(SimpleMailMessage welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}
	
	public void setForgotPasswordMessage(SimpleMailMessage forgotPasswordMessage) {
		this.forgotPasswordMessage = forgotPasswordMessage;
	}
	
	public void setChangedPasswordMessage(SimpleMailMessage changedPasswordMessage) {
		this.changedPasswordMessage = changedPasswordMessage;
	}

	public JRouletteDAO getJrouletteDAO() {
		return jrouletteDAO;
	}

	public void setJrouletteDAO(JRouletteDAO jrouletteDAO) {
		this.jrouletteDAO = jrouletteDAO;
	}

	public void setDEV(boolean dEV) {
		if(dEV){
			LOG.info("############### DEV=" + dEV + " ###############");
		}
		DEV = dEV;
	}

	@Override
	public boolean changeActiveUserAccount(long id, boolean active) {
		boolean retVal = false;
		
		retVal = jrouletteDAO.setActiveUserById(id, active);
		
		return retVal;
	}

	@Override
	public boolean changeActiveUserAccount(String email, boolean active) {
		boolean retVal = false;
		
		retVal = jrouletteDAO.setActiveUserById(email, active);
		
		return retVal;
	}

	@Override
	public JRouletteWebUser findUserById(long id) {
		return jrouletteDAO.queryUserById(id);
	}

	@Override
	public boolean changeUserEmailPreference(long id, boolean sendEmail) {
		return jrouletteDAO.updateUserEmailPreferenceById(id, sendEmail);
	}

	@Override
	public boolean getActiveUserEmailsByEmailPreference(boolean sendEmail) {
		return getActiveUserEmailsByEmailPreference(sendEmail);
	}
	
}