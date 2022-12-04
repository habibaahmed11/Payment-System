package balance;

import java.sql.ResultSet;
import java.sql.SQLException;

import application.User;
import db.DBConnection;

public abstract class BalanceManagerInterface {
    
    DBConnection balanceObject = DBConnection.getDB();
    public int setBalance(int balance, String username) {
        balance += Integer.parseInt(balanceObject.getBalance(username));
        balanceObject.setBalance(balance, username);
        return balance;
        
    }
    
    public int getBalance(String username) {
        return Integer.parseInt(balanceObject.getBalance(username));
    }
    

    public boolean checkCredit(String cardNumber, int pin) {
        if(cardNumber.length() == 16) {
            return true;
        }
        return false;
    }
    public String consumeBalance(float amount,  User user, String serviceName, String cardNumber, int pin) {
            return consumeMoney(user, amount, cardNumber, pin, serviceName);        
    }
    
    public abstract String consumeMoney(User user, float amount, String cardNumber, int pin, String serviceName);
    public void transaction(String userName, float amount, String serviceName) {
        
        balanceObject.insertTransaction(userName, amount, serviceName);
        
      
    }
    
    public ResultSet getTransactions(String username) throws SQLException {
    	return balanceObject.getTransactions(username);
    }
}