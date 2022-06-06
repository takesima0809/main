package userValues;

public class PhoneNumber {
	private final String phoneNumber;
	public PhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int toInt(){
		return Integer.parseInt(this.phoneNumber);
	}
	
	public String toStr() {
		return this.phoneNumber;
	}
}
