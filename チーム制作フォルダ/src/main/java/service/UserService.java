package service;

import entities.DepositDataList;
import repositories.ShopRepository;

public class UserService {
	ShopRepository shopRepository;
	public UserService() {
		this.shopRepository =new ShopRepository();
	}
	public DepositDataList UserFindAll() {
		return null;
	}
	public DepositDataList UserAdd() {
		return null;
	}
}
