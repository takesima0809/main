package entities;

import userValues.PhoneNumber;
import userValues.UserId;
import userValues.UserName;

public class UserData {
	private final PhoneNumber phoneNumber;
	private final UserId userId;
	private final UserName UserName;
	public UserData(PhoneNumber phoneNumber,UserId userId,UserName UserName) {
		this.phoneNumber = phoneNumber;
		this.userId = userId;
		this.UserName = UserName;
	}
	public PhoneNumber getPhoneNumber() {
		return this.phoneNumber;
	}
	public UserId getUserId() {
		return userId;
	}
	public UserName getUserName() {
		return UserName;
	}
}
