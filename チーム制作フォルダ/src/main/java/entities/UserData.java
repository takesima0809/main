package entities;

import userValues.PhoneNumber;
import userValues.UserId;
import userValues.UserName;

public class UserData {
	private final PhoneNumber phoneNumber;
	private final UserId userId;
	private final UserName userName;
	public UserData(PhoneNumber phoneNumber,UserId userId,UserName userName) {
		this.phoneNumber = phoneNumber;
		this.userId = userId;
		this.userName = userName;
	}
	public PhoneNumber getPhoneNumber() {
		return this.phoneNumber;
	}
	public UserId getUserId() {
		return this.userId;
	}
	public UserName getUserName() {
		return this.userName;
	}
}
