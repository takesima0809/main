package entities;


public class RegisterInfo {
	private final String registrationDate;
	private final int depositNumber;
	
	public RegisterInfo(String registrationDate,int depositNumber) {
		this.registrationDate = registrationDate;
		this.depositNumber = depositNumber;
	}
	public String getregistrationDate() {
		return this.registrationDate;
	}
	public int getdepositNumber() {
		return this.depositNumber;
		
	}
}
