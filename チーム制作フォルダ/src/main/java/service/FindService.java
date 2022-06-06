package service;

import entities.RegisterInfo;
import entities.UserData;
import repositories.ShopRepository;

public class FindService {
	ShopRepository shopRepository;
	public FindService() {
		this.shopRepository = new ShopRepository();
	}
	public void FindUserData(UserData userData) {
	}
	public void FindFactory(RegisterInfo registerInfo) {
		
	}
}
