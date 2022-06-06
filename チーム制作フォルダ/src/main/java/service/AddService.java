package service;

import entities.UserData;
import repositories.ShopRepository;
import userValues.PhoneNumber;
import userValues.UserName;


public class AddService {
	ShopRepository shopRepository;
	public AddService() {
		this.shopRepository = new ShopRepository();
	}
	//ユーザー登録
	public void UserSignUp(String name,String PhoneNamber) {
		UserName username = new UserName(name);
		PhoneNumber usernamber = new PhoneNumber(PhoneNamber);
		UserData userData = new UserData(usernamber, null, username);

		this.shopRepository.witeUserDatas(userData);
	}
}
