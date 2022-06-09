package entities;


public class RegisterInfo {
	private final String registrationDate;
	private final int depositNumber;
	private final int totalPrice;
	
	public RegisterInfo(String registrationDate,int depositNumber,int totalPrice) {
		this.registrationDate = registrationDate;
		this.depositNumber = depositNumber;
		this.totalPrice=totalPrice;
	}
	public String getregistrationDate() {
		return this.registrationDate;
	}
	public int getdepositNumber() {
		return this.depositNumber;
	}
	public int getTotalPrice() {
		return this.totalPrice;
	}
}
