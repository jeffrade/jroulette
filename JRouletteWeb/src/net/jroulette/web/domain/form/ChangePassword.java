package net.jroulette.web.domain.form;

public class ChangePassword {
	
		private String userName;

		private String password;
		
		private String newPassword;
		
		private String verifyNewPassword;
		
		public ChangePassword(){
			super();
		}
		
		public ChangePassword(String userName, String password, String newPassword, String verifyNewPassword){
			this();
			this.userName = userName;
			this.password = password;
			this.newPassword = newPassword;
			this.verifyNewPassword = verifyNewPassword;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getNewPassword() {
			return newPassword;
		}

		public void setNewPassword(String newPassword) {
			this.newPassword = newPassword;
		}

		public String getVerifyNewPassword() {
			return verifyNewPassword;
		}

		public void setVerifyNewPassword(String verifyNewPassword) {
			this.verifyNewPassword = verifyNewPassword;
		}
}