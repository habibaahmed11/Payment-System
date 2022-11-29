package application;

import java.sql.ResultSet;

public class Admin extends AppUser{
	RefundManager rman = new RefundManager();
	private DBConnection authObj = new DBConnection();

	public Admin(String email, String username, String password, String permission) {
		super(email, username, password, permission);
		// TODO Auto-generated constructor stub
	}
	
	public ResultSet listRefunds(){
		ResultSet res = rman.getRef();
		return res;
	}
	
	public void changeState(String newState, String refundID)
	{
		rman.setNewRefundState(newState, refundID);
	}

}

