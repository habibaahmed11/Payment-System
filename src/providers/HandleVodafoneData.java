package providers;

import java.util.Vector;

import application.User;

public class HandleVodafoneData implements HandleData{
	String phoneNumber;
	int amount;
	public String handleUserData(Vector<String> inputFields, User user, String serviceName, int paymentMethod, String cardNumber, int pin) {
		System.out.println("Handling vodafone data");
		
		phoneNumber = inputFields.get(0);
		amount = Integer.parseInt(inputFields.get(1));
		if(phoneNumber.substring(0,3).equals(010) && phoneNumber.length() == 11) {
			return user.consumeBalance(amount, serviceName, paymentMethod, cardNumber, pin);
		} else if (phoneNumber.length() < 11){
			return "Wrong phone number";
		} else if (!(phoneNumber.substring(0,3).equals(010))) {
			return "Not Vodafone Number";
		}
		return null;
		
		
		//Check amount with wallet or Credit card 
		//User balance charged with the amount of payment
		
		//Send money to the user optional 
	}
	
	
}
